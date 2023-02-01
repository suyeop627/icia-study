import React, { useEffect, useState } from "react";
const Timer = () => {
  const [count, setCount] = useState(0);

  useEffect(() => {
    let tr = setTimeout(() => {
      //1초 후 count +1
      setCount((count) => count + 1);
    }, 1000); //count를 증가시킨 뒤에도 메모리에 남아있음.
    //cleanup 함수
    return () => clearTimeout(tr); //렌더링이 끝나는 시점에서 memory leak 정리
  }, []);

  return <h1>렌더링 횟수 : {count} 번</h1>;
};

export default Timer;
