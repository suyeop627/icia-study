import React, { useCallback, useState } from "react";
import { MdAdd } from "react-icons/md";
import "./TodoInsert.scss";


const TodoInsert = ({ onInsert }) => {
  const [value, setValue] = useState("");

  //코드 최적화를 위해 useCallback 사용.
  const onch = useCallback(e => {
    setValue(e.target.value);
  }, [])


  //이벤트를 처리할 땐 callback을 사용해서 최적화 한다.
  const onSubmit = useCallback(e => {
    onInsert(value);  //입력받은 값을 onInsert 함수에 전달.
    setValue("");
    //onSubmit 이벤트는 새로고침을 발생시킴
    //이를 방지하기 위한 함수 preventDefault();
    e.preventDefault();
  }, [onInsert, value]);


  return (
    //리액트에서 form은 input 태그를 묶어주는 역할만 담당한다. 데이터를 전송하는 역할은 수행하지 못함.
    <form className="TodoInsert" onSubmit={onSubmit}>
      {/* state의 value와 input의 value 연결  */}
      < input placeholder="할 일을 입력하세요." value={value}
        onChange={onch} />
      <button type="submit">
        {/* //react-icons  */}
        <MdAdd />
      </button>
    </form>
  );
};

export default TodoInsert;