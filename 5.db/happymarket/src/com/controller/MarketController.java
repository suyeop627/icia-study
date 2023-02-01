package com.controller;

import com.dto.MemberInfo;
import com.dto.OrderInfo;
import com.dto.ProductInfo;
import com.view.InOutClass;

import java.lang.reflect.Member;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MarketController {
    private InOutClass io = new InOutClass();
    ArrayList<MemberInfo> member = new ArrayList<>();
    ArrayList<ProductInfo> product = new ArrayList<>();
    ArrayList<OrderInfo> order = new ArrayList<>();

    //주문 코드에 날짜 추가
    Date d = new Date();
    SimpleDateFormat si = new SimpleDateFormat("yyMMdd");
    String today = si.format(d);

    //전체 제어 메소드
    public void run() {
        int menu = -1;

        io.twoPrint("< 마트 관리 프로그램 >");
        io.twoPrint("해피마트에 오신걸 환영합니다~!");
        io.twoPrint("==========================");

        while (true) {
            menuShow();

            menu = io.inNum("번호 입력 > ");

            //종료 처리
            if (menu == 0) {
                io.twoPrint("방문해주셔서 감사합니다.");
                io.twoPrint("프로그램 종료");
                break;
            }

            //기능 처리
            switch (menu) {
                case 1:
                    loginData();
                    break;
                case 2:
                    memSearchData();
                    break;
                case 3:
                    memUpdateData();
                    break;
                case 4:
                    memDeleteData();
                    break;
                case 5:
                    pInputData();
                    break;
                case 6:
                    pOutputData();
                    break;
                case 7:
                    pSearchData();
                    break;
                case 8:
                    pUpdateData();
                    break;
                case 9:
                    pDeleteData();
                    break;
                case 10:
                    orderData();
                    break;
                case 11:
                    listData();
                    break;
                case 12:
                    oDeleteData();
                    break;
                default:
                    io.twoPrint("0~12번까지 입력하세요.\n");
            }//switch end
        }//while end
    }//run end

    //메뉴 출력 메소드
    private void menuShow() {
        io.twoPrint("1. 회원 가입");
        io.twoPrint("2. 전체 회원 정보");
        io.twoPrint("3. 회원 정보 수정");
        io.twoPrint("4. 회원 탈퇴");
        io.twoPrint("5. 상품 입력");
        io.twoPrint("6. 상품 출력");
        io.twoPrint("7. 상품 검색");
        io.twoPrint("8. 상품 수정");
        io.twoPrint("9. 상품 삭제");
        io.twoPrint("10. 상품 주문");
        io.twoPrint("11. 주문 내역");
        io.twoPrint("12. 주문 취소");
        io.twoPrint("0. 종료");
    }

    //회원 가입(입력) 메소드
    private void loginData() {
        io.twoPrint("-- 회원 가입 --");
        io.twoPrint("---------------");

        MemberInfo mInfo = new MemberInfo();
        mInfo.setId(io.inStr("아이디 : "));
        mInfo.setPwd(io.inStr("비밀번호 : "));
        mInfo.setName(io.inStr("이름 : "));
        mInfo.setPhone(io.inStr("연락처 : "));
        mInfo.setEmail(io.inStr("이메일 : "));
        mInfo.setBirth(io.inStr("생년월일 : "));
        mInfo.setAdr(io.inStr("주소 : "));
        member.add(mInfo);
        io.twoPrint("가입 완료\n");
    }//loginData end

    //회원 정보(출력) 메소드
    private void memSearchData() {
        //정보 확인
        if (member.size() == 0) {
            io.twoPrint("회원 정보가 없습니다.\n");
            return;
        }
        io.twoPrint("-- 전체 회원 정보 --");
        io.twoPrint("-------------------");
        for (MemberInfo m : member) {
            io.twoPrint("아이디 : " + m.getId());
            io.twoPrint("비밀번호 : " + m.getPwd());
            io.twoPrint("이름 : " + m.getName());
            io.twoPrint("연락처 : " + m.getPhone());
            io.twoPrint("이메일 : " + m.getEmail());
            io.twoPrint("생년월일 : " + m.getBirth());
            io.twoPrint("주소 : " + m.getAdr());
            io.twoPrint("-------------------------");
        }
        io.twoPrint("확인 완료\n");
    }//memSearchData end

    //회원 수정 메소드
    private void memUpdateData() {
        if (member.size() == 0) {
            io.twoPrint("회원 정보가 없습니다.\n");
            return;
        }
        io.twoPrint("-- 회원 수정 --");
        io.twoPrint("---------------");

        //수정할 데이터 검색
        String sid = io.inStr("수정할 아이디 : ");
        int i;
        MemberInfo m = null;
        for (i = 0; i < member.size(); i++) {
            m = member.get(i);
            if (sid.equals(m.getId())) {
                io.twoPrint("비밀번호 : " + m.getPwd());
                io.twoPrint("이름 : " + m.getName());
                io.twoPrint("연락처 : " + m.getPhone());
                io.twoPrint("이메일 : " + m.getEmail());
                io.twoPrint("생년월일 : " + m.getBirth());
                io.twoPrint("주소 : " + m.getAdr());
                io.twoPrint("-------------------------");
                break;
            }//if end
        }//for end
        //검색 결과 없을 경우
        if (i == member.size()) {
            io.twoPrint("검색 결과가 없습니다.\n");
            return;
        }

        //회원 정보 수정
        //입력 X 엔터치면 수정 안함.
        io.twoPrint("수정할 내용이 없으면 엔터를 누르시오.");
        String mstr = io.inStr("비밀번호 : ");
        if (!mstr.equals("")) {
            m.setPwd(mstr);
        }
        mstr = io.inStr("이름 : ");
        if (!mstr.equals("")) {
            m.setName(mstr);
        }
        mstr = io.inStr("연락처 : ");
        if (!mstr.equals("")) {
            m.setPhone(mstr);
        }
        mstr = io.inStr("이메일 : ");
        if (!mstr.equals("")) {
            m.setEmail(mstr);
        }
        mstr = io.inStr("생년월일 : ");
        if (!mstr.equals("")) {
            m.setBirth(mstr);
        }
        mstr = io.inStr("주소 : ");
        if (!mstr.equals("")) {
            m.setAdr(mstr);
        }
        io.twoPrint("수정 완료\n");
    }//memUpdateData end


    //회원 탈퇴(삭제) 메소드
    private void memDeleteData() {
        if (member.size() == 0) {
            io.twoPrint("회원 정보가 없습니다.\n");
            return;
        }
        io.twoPrint("-- 회원 탈퇴 --");
        io.twoPrint("---------------");

        String sid = io.inStr("탈퇴할 아이디 : ");
        int i;
        MemberInfo m = null;
        for (i = 0; i < member.size(); i++) {
            m = member.get(i);
            if (sid.equals(m.getId())) {
                io.twoPrint("아이디 : " + m.getId());
                io.twoPrint("비밀번호 : " + m.getPwd());
                io.twoPrint("이름 : " + m.getName());
                io.twoPrint("연락처 : " + m.getPhone());
                io.twoPrint("이메일 : " + m.getEmail());
                io.twoPrint("생년월일 : " + m.getBirth());
                io.twoPrint("주소 : " + m.getAdr());
                io.twoPrint("-------------------------");
                break;
            }//if end
        }//for end
        //검색 결과 없을 경우
        if (i == member.size()) {
            io.twoPrint("검색 결과가 없습니다.\n");
            return;
        }

        //검색 성공 시 데이터 삭제
        String yn = io.inStr("탈퇴 하시겠습니까?(y/n) : ");

        if (yn.equals("y")) {
            member.remove(m);
            io.twoPrint("탈퇴 완료\n");
            return;
        }
        //"y"가 아니면
        io.twoPrint("탈퇴 취소\n");
    }//memDeleteData end

    //상품 입력 메소드
    private void pInputData() {
        io.twoPrint("-- 상품 입력 --");
        io.twoPrint("---------------");

        ProductInfo pInfo = new ProductInfo();
        pInfo.setpNo(pInfo.index++);
        pInfo.setpName(io.inStr("상품 이름 : "));
        pInfo.setAmount(io.inStr("상품 수량 : "));
        pInfo.setPrice(io.inNum("상품 가격 : "));

        product.add(pInfo);
        io.twoPrint("입력 완료\n");
    }//pInputData end

    //상품 출력 메소드
    private void pOutputData() {
        if (product.size() == 0) {
            io.twoPrint("상품 정보가 없습니다.\n");
            return;
        }
        io.twoPrint("-- 상품 출력 --");
        io.twoPrint("---------------");

        for (ProductInfo p : product) {
            io.twoPrint("상품 코드 : " + "no." + p.getpNo());
            io.twoPrint("상품 이름 : " + p.getpName());
            io.twoPrint("상품 수량 : " + p.getAmount());
            io.twoPrint("상품 가격 : " + p.getPrice());
            io.twoPrint("---------------------");
        }
        io.twoPrint("출력 완료\n");
    }//pOutputData

    //상품 검색 메소드
    private void pSearchData() {
        if (product.size() == 0) {
            io.twoPrint("상품 정보가 없습니다.\n");
            return;
        }
        io.twoPrint("-- 상품 검색 --");
        io.twoPrint("---------------");

        String sname = io.inStr("검색할 상품명 : ");

        for (ProductInfo p : product) {
            if (sname.equals(p.getpName())) {
                io.twoPrint("상품 코드 : " + "no." + p.getpNo());
                io.twoPrint("상품 이름 : " + p.getpName());
                io.twoPrint("상품 수량 : " + p.getAmount());
                io.twoPrint("상품 가격 : " + p.getPrice());
                io.twoPrint("검색 완료\n");
                return;
            }
        }
        io.twoPrint("찾는 상품이 없습니다.\n"); //error
    }//pSearchData end

    //상품 수정 메소드
    private void pUpdateData() {
        if (product.size() == 0) {
            io.twoPrint("상품 정보가 없습니다.\n");
            return;
        }

        io.twoPrint("-- 상품 수정 --");
        io.twoPrint("---------------");

        //수정할 데이터 검색
        String sname = io.inStr("수정할 상품 : ");
        int i;
        ProductInfo p = null;
        for (i = 0; i < product.size(); i++) {
            p = product.get(i);
            if (sname.equals(p.getpName())) {
                io.twoPrint("상품 코드 : " + "no." + p.getpNo());
                io.twoPrint("상품 이름 : " + p.getpName());
                io.twoPrint("상품 수량 : " + p.getAmount());
                io.twoPrint("상품 가격 : " + p.getPrice());
                io.twoPrint("-------------------------");
                break;
            }//if end
        }//for end
        //검색 결과 없을 경우
        if (i == product.size()) {
            io.twoPrint("검색 결과가 없습니다.\n");
            return;
        }

        //회원 정보 수정
        //입력 X 엔터치면 수정 안함.
        io.twoPrint("수정할 내용이 없으면 엔터를 누르시오.");
        String pstr = io.inStr("상품 이름 : ");
        if (!pstr.equals("")) {
            p.setpName(pstr);
        }
        pstr = io.inStr("상품 수량 : ");
        if (!pstr.equals("")) {
            p.setAmount(pstr);
        }
        int a = io.inNum("상품 가격 : ");
        if (a != -1) {
            p.setPrice(a);
        }
        io.twoPrint("수정 완료\n");
    }

    //상품 삭제 메소드
    private void pDeleteData() {
        if (product.size() == 0) {
            io.twoPrint("상품 정보가 없습니다.\n");
            return;
        }
        io.twoPrint("-- 상품 삭제 --");
        io.twoPrint("---------------");

        String sname = io.inStr("삭제할 상품 이름 : ");
        int i;
        ProductInfo p = null;
        for (i = 0; i < product.size(); i++) {
            p = product.get(i);
            if (sname.equals(p.getpName())) {
                io.twoPrint("상품 코드 : " + "no." + p.getpNo());
                io.twoPrint("상품 이름 : " + p.getpName());
                io.twoPrint("상품 수량 : " + p.getAmount());
                io.twoPrint("상품 가격 : " + p.getPrice());
                io.twoPrint("-------------------------");
                break;
            }
        }//for end
        if (i == product.size()) {
            io.twoPrint("검색 결과가 없습니다.");
            return;
        }

        String yn = io.inStr("상품을 삭제할까요??(y/n) ");

        if (yn.equals("y")) {
            product.remove(p);
            io.twoPrint("삭제 완료\n");
            return;
        }
        io.twoPrint("삭제 취소\n");
    }

    //상품 주문 메소드
    private void orderData() {
        if (member.size() == 0) {
            io.twoPrint("회원 정보가 없습니다.\n");
            return;//메소드 종료
        }
        if (product.size() == 0) {
            io.twoPrint("상품 정보가 없습니다.\n");
            return;//메소드 종료
        }

        io.twoPrint("-- 상품 주문 --");
        io.twoPrint("---------------");
        String sid = io.inStr("주문할 아이디 : ");
        String sname = io.inStr("주문할 상품 : ");

        //회원 아이디 일치

        boolean b=false;
        for (MemberInfo m : member){
            if (sid.equals(m.getId())) {
                b =true;
                break;
            }
        }
        if(!b){
            io.twoPrint("확인 문구");
            return;
        }



            else {
            String yn = io.inStr(m.getId()
                    + "님 주문 하시겠습니까?(y/n) ");
            if (yn.equals("n")) {
                io.twoPrint("주문 취소\n");
                return;
            }
            for (ProductInfo p : product) {
                if (sname.equals(p.getpName())) {
                    OrderInfo oInfo = new OrderInfo();
                    oInfo.setoNo(oInfo.on++);
                    oInfo.setoAmount(io.inNum("주문 수량 : "));
                    oInfo.setA(sid);
                    order.add(oInfo);
                    io.twoPrint("주문 완료\n");
                }//if end
                else {
                    io.twoPrint("주문 불가! 상품\n");
                }//else end
            }
            }//for end
        }//for end
    }//orderData end

    //주문 내역 메소드
    private void listData() {
        if (member.size() == 0) {
            io.twoPrint("회원 정보가 없습니다.\n");
            return;//메소드 종료
        }
        if (product.size() == 0) {
            io.twoPrint("상품 정보가 없습니다.\n");
            return;//메소드 종료
        }
        if (order.size() == 0) {
            io.twoPrint("주문 내역이 없습니다.\n");
            return;
        }

        io.twoPrint("-- 주문 내역 출력 --");
        io.twoPrint("-------------------");
        String sid = io.inStr("검색할 아이디 : ");

        for (OrderInfo o : order) {
            if (!sid.equals(o.getA())) {
                io.twoPrint("해당 아이디로 주문한 내역이 없습니다.");
                break;
            }
            io.twoPrint ("주문 코드 : " + today + o.getoNo());
            for (MemberInfo m : member) {
                if (sid.equals(m.getId())) {
                    io.twoPrint("회원 아이디 : " + m.getId());
                }
            }
            for (ProductInfo p : product) {
                io.twoPrint("상품 이름 : " + p.getpName());
            }
            io.twoPrint("주문 수량 : " + o.getoAmount());
            int a = o.getoAmount();
            for (ProductInfo p : product) {
                System.out.println("총 가격 : " + a * p.getPrice());
            }
            io.twoPrint("-------------------");
        }
    }//listData end

    //주문 취소 메소드
    private void oDeleteData() {
        if (order.size() == 0) {
            io.twoPrint("주문 정보가 없습니다.\n");
            return;
        }
        io.twoPrint("-- 주문 취소 --");
        io.twoPrint("------------");

        String sno = io.inStr("취소할 주문 코드 : ");
        int i;
        OrderInfo o = null;
        for (i = 0; i < order.size(); i++) {
            o = order.get(i);
            if (sno.equals(today + o.getoNo())) {
                io.twoPrint("주문 코드 : " + today + o.getoNo());
                for (ProductInfo p : product) {
                    io.twoPrint("상품 이름 : " + p.getpName());
                }
                io.twoPrint("주문 수량 : " + o.getoAmount());
                int a = o.getoAmount();
                for (ProductInfo p : product) {
                    System.out.println("총 가격 : " + a * p.getPrice());
                }
                break;
            }
        }//for end

        if (i == order.size()) {
            io.twoPrint("검색 결과가 없습니다\n");
            return;
        }

        String yn = io.inStr("삭제할까요?(y/n) ");

        if (yn.equals("y")) {
            order.remove(o);
            io.twoPrint("주문 취소 완료\n");
            return;
        }
        io.twoPrint("삭제 취소\n");
    }//oDeleteData end

}
