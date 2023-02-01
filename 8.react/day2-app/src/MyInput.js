import React, { useState } from "react";
const MyInput = () => {
  //사용자 이름을 처리하는 useState
  const [username, setUserName] = useState("");
  //메시지를 처리하는 useState
  const [msg, setMsg] = useState("");

  const chName = (e) => setUserName(e.target.value);
  //e.target : input 태그에서 입력을 하면,
  //원래는 value값이 비어있다가 입력값으로 바뀌는데(onChange),
  //해당 이벤트(e)를 받아서 이벤트가 발생된요소(target)의 value를 가리킨다.
  //즉, e.target 은 이벤트가 발생한 요소로, input 태그를 가리킨다.

  const chMsg = (e) => setMsg(e.target.value);
  const onck = () => {
    //데이터 사용
    alert(`이름 : ${username}, 메시지 : ${msg}`);
    //데이터 사용 후 초기화(input의 value 자체를 지우는게 아니라, state를 초기화해서 value에 값을 지우는 순서)
    setUserName("");
    setMsg("");
  };
  return (
    <div>
      <h1>이벤트 연습</h1>
      {/* input의 value속성의 username을 useState로 변경 */}
      <input
        type="text"
        name="username"
        placeholder="사용자 이름"
        value={username}
        onChange={chName}
      />
      <input
        type="text"
        name="msg"
        placeholder="아무거나 입력"
        value={msg}
        onChange={chMsg}
      />
      <button onClick={onck}>확인</button>
    </div>
  );
};
export default MyInput;
