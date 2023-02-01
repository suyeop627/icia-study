import React, { useState } from "react";
const MyInput2 = () => {
  //두 입력값을 함께 저장하는 state
  const [form, setForm] = useState({
    uname: "",
    msg: "",
  });
  //uname 과 msg가 개별적으로 사용될 때는 구조분해할당
  const { uname, msg } = form;

  const onch = (e) => {
    const newForm = {
      ...form, //기존의 form의 내용이 그대로 복제(newForm 에 uname 과 msg의 공간 생성)
      [e.target.name]: e.target.value, //입력이 들어온 input 요소의 value를 변경하는 코드 +)객체안에서 키를 []로 감싸면 그 안에넣은 레퍼런스가 가르키는 실제값이 key값으로 사용된다
    };
    setForm(newForm); //입력받은 값이 저장된 newForm을 form에 덮어씀
  };
  const onck = () => {
    alert(`name : ${uname}, msg : ${msg}`);
    setForm({
      uname: "",
      msg: "",
    });
  };

  return (
    <div>
      <h1>이벤트 연습</h1>
      {/* input의 value속성의 username을 useState로 변경 */}
      <input
        type="text"
        name="uname"
        placeholder="사용자 이름"
        value={uname}
        onChange={onch}
      />
      <input
        type="text"
        name="msg"
        placeholder="아무거나 입력"
        value={msg}
        onChange={onch}
      />
      <button onClick={onck}>확인</button>
    </div>
  );
};

export default MyInput2;
