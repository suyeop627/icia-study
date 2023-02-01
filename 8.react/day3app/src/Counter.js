import React, { useEffect, useState } from "react";
const Counter = () => {
  //'+'버튼 클릭 시, Count가 올라가고,
  //* 2 한 값이 출력됨
  const [count, setCount] = useState(0);
  const [cal, setCal] = useState(0);

  useEffect(() => {
    setCal(() => count * 2);
  }, [count]);
  return (
    <>
      <p>Count : {count}</p>
      <button onClick={() => setCount((c) => c + 1)}>+</button>
      {/* setUseState의 인자로 값이나 함수를 받을 수 있는데, 함수로 받을 경우 함수의 인자로 이전 useState 객체가 들어간다. */}
      {/*     
    setCount(function(c){
      return c+1;
    })
    count +1 */}

      <p>X 2 결과 : {cal}</p>
    </>
  );
};

export default Counter;
