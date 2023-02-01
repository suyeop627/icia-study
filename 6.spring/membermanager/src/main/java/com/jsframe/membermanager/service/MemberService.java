package com.jsframe.membermanager.service;

import com.jsframe.membermanager.dao.MemberDao;
import com.jsframe.membermanager.dto.MemberDto;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


@Service
@Log
public class MemberService {
  @Autowired
  private MemberDao mDao;
  private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


  //회원가입 처리 메서드
  public String regMember(MemberDto member, RedirectAttributes rttr) {
    log.info("regMember()");
    String msg = null;
    String view = null;


    //비밀번호 암호회 처리
    String cPwd = encoder.encode(member.getM_pwd());
    log.info("암호화된 비밀번호 : " + cPwd);
    log.info("비밀번호 길이 : " + cPwd.length());
    member.setM_pwd(cPwd); //암호화된 비밀번호로 변경

    try {
      mDao.insertMember(member);
      msg = "가입 성공";
      view = "redirect:/"; //첫페이지(로그인)로 이동
    } catch (Exception e) {
      //e.printStackTrace();
      msg = "가입 실패";
      view = "redirect:register";
    }
    rttr.addFlashAttribute("msg", msg);
    return view;
  }

  //아이디 중복 확인
  public String checkId(String id) {
    MemberDto mData = mDao.selectMember(id);
    String msg = null;
    if (mData != null) {
      msg = "사용할 수 없는 아이디";
    } else {
      msg = "사용 가능한 아이디";
    }
    return msg;
  }


  //로그인 처리 메서드
  public String loginProc(MemberDto member, HttpSession session, RedirectAttributes rttr) {
    log.info("loginProc()");
    String msg = null;
    String view = null;
    String cPwd = mDao.selectPwd(member.getM_id());
    if(cPwd!=null){//입력한 회원의 아이디가 있음
      if(encoder.matches(member.getM_pwd(), cPwd)){

        //세션에 로그인 성공 정보 저장
        member = mDao.selectMember(member.getM_id());
        // 비밀번호과 관련된 기능을 수행할때가 아니면, 비밀번호를 불러오는 것을 가능한 자제하는 것이 좋다.
        member.setM_pwd(null);
        session.setAttribute("mem", member);

        msg="로그인 성공";
        view ="redirect:main";  //메인으로 보내는 메서드가 있으니까 그 메서드의 역할을 뺏지 않고, redirect하도록 함.


      }else{//비밀번호가 맞지 않는 경우
        msg="비밀번호가 맞지 않습니다.";
        view="redirect:/";
      }

    }else {//잘못된 아이디
      msg = "해당 아이디가 없습니다.";
      view = "redirect:/";
    }

    rttr.addFlashAttribute("msg", msg);
    return view;
  }


  public String updateMember(MemberDto member, HttpSession session, RedirectAttributes rttr){

    //회원정보를 수정하고, 세션에 로그인 정보 변경
    log.info("updateMember()");
    String msg = null;
    String view = null;


    try{
    mDao.updateMember(member);
      //수정하면, 로그인돼있는 정보도 변경이 돼야하기 때문에, session을 인자로 받아 처리한다.
    session.setAttribute("mem", mDao.selectMember(member.getM_id()));
    msg="수정 성공";
    view = "redirect:main";
    }catch (Exception e){
      //e.printStackTrace();
      msg="수정 실패";
      view = "redirect:main"; //지금은 수정페이지가 따로 없어서 성공이나 실패할때 url이 동일하지만, 성공시, 실패시 의 결과페이지를 다르게 하는 게 일반적이다.
    }

    rttr.addFlashAttribute("msg", msg);
    return view;

  }


//회원 삭제용 메소드(로그인 이전 페이지로 이동, 세션에 저장된 값 삭제(로그아웃)
  public String resignMember(HttpSession session, RedirectAttributes rttr){
    log.info("resignMember()");
    String msg=null;
    String view = null;

    //세션에 저장된 로그인 정보로부터 사용자의 id를 가져온다.+)세션은 화면, 프로그램 모두 에서 사용 가능
    MemberDto member = (MemberDto) session.getAttribute("mem"); //세션에는 자료형의 제한 없이 저장이 되므로, 값을 가져올 때 casting을 해야한다.
    String mId = member.getM_id();
    try{
      mDao.deleteMember(mId);
      session.invalidate();   //or session.removeAttribute 사용
      msg = "탈퇴 성공";
      view = "redirect:/";
    } catch (Exception e) {
      //e.printStackTrace();
      msg = "탈퇴 실패";
      view="redirect:main";
    }

    rttr.addFlashAttribute("msg", msg);
    return view;
  }



}//class end
