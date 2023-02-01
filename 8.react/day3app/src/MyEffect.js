import React, { useEffect, useState } from "react";
const MyEffect = () => {
  const [user, setUser] = useState("");

  const [nickname, setNickname] = useState("");

  useEffect(() => {
    console.log("렌더링");
  }, [user]);

  //사용자 입력을 처리하는 onChange 함수
  const onchUser = (e) => {
    setUser(e.target.value);
  };

  const onchNick = (e) => {
    console.log(e);
    setNickname(e.target.value);
  };

  return (
    <div>
      <div>
        {/* 입력 부분 */}
        <input name="user" value={user} onChange={onchUser} />
        <br />
        <input name="nickname" value={nickname} onChange={onchNick} />
      </div>
      <div>
        {/* 출력부분 */}
        <div>
          <b>이름 : </b> {user}
        </div>
        <div>
          <b>별명 : </b> {nickname}
        </div>
      </div>
    </div>
  );
};
export default MyEffect;
