import React from "react";
import "./MyComp.css"; //css파일을 import

const MyComp = ({ book: b, data, isAdmin, children }) => {
  //props 객체 안의 데이터와 같은 이름을 가진 변수로 값을 가져오게 할 수 있음( 기존 변수명 : 새 변수명 의 형식으로 사용할 변수명을 재정의 할 수 있다.)
  //const MyComp = ({ book: b, data,...props }) => { //필요한 몇개만 구조분해할당을 하고, 나머지는 그냥 사용할 수 있다.

  //스타일을 적용한 객체 생성
  const pStyle = {
    color: "purple",
    fontSize: "20px",
  };

  return (
    <>
      <h1 className="MyComp-style">{b}</h1>
      {/*import한 파일에서 스타일 적용*/}
      <p style={pStyle}>{data}</p> {/*객체로 정의한 스타일 적용*/}
      <p>{children}</p>
      <p>{isAdmin === "true" && "관리자입니다."}</p>
    </>
  );
};

export default MyComp;
