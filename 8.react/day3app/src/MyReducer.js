import React, { useReducer } from "react";

//리듀서는 함수 밖에 만듦
function reducer(state, action) {
  switch (action.type) {
    case "INC": //+1 버튼 처리
      return { value: state.value + 1 };
    case "DEC": //-1 버튼 처리
      return { value: state.value - 1 };
    default:
      //아무것도 해당되지 않을 때 기존 상태 반환
      return state;
  }
}
const MyReducer = () => {
  const [state, dispatch] = useReducer(reducer, { value: 0 });
  return (
    <div>
      <p>
        현재 카운터 값은 <b>{state.value}</b> 입니다.
      </p>
      <button onClick={() => dispatch({ type: "INC" })}>+1</button>
      <button onClick={() => dispatch({ type: "DEC" })}>-1</button>
    </div>
  );
};

export default MyReducer;
