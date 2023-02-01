import React, { useCallback, useMemo, useState } from "react";

const getAverage = (numbers) => {
  console.log("평균값 계산중..");
  if (numbers.length === 0) {
    return 0;
  }
  const sum = numbers.reduce((a, b) => a + b);
  return sum / numbers.length;
};
const MyMemo = () => {
  const [number, setNumber] = useState(""); //input으로 입력받은 값은 문자열.
  const [list, setList] = useState([]);

  //입력 태그의 onChange 이벤트 처리
  const onch = (e) => {
    setNumber(e.target.value);
  }; //number나 list가 변경될때만 실행.

  const onck = useCallback(
    (e) => {
      const newList = list.concat(parseInt(number)); //산술 연산을 하기 위해 숫자로 변환
      setList(newList);
      setNumber("");
    },
    [number, list]
  ); //number나 list가 변경될 때만 실행.

  const avg = useMemo(() => getAverage(list), [list]);
  //const avg = getAverage(list);

  return (
    <>
      <input value={number} onChange={onch} />
      <button onClick={onck}>등록</button>
      <ul>
        {list.map((value, index) => (
          <li key={index}>{value}</li>
        ))}
      </ul>
      <div>
        <b>평균값 : </b> {avg}
      </div>
    </>
  );
};

export default MyMemo;
