import './App.css';
import axios from 'axios';
import { useCallback, useState } from 'react';

function App() {
  const [data, setData] = useState(""); //문자열 처리용 state
  const [objdata, setObjdata] = useState(""); // 객체 처리용 state
  const [list, setList] = useState(""); // 목록 처리용 state
  const [sdata, setSdata] = useState("");
  //문자처리용 함수
  const onck1 = () => {
    axios.get("/getData")
      .then(response => {
        console.log(response);
        setData(response.data);
      })
      .catch(error => console.log(error));
  }

  //객체 처리용 함수
  const onck2 = () => {
    axios.get("/getObject")
      .then(response => {
        console.log(response);
        //분해하여 꺼내온 data의 str과 number를 사용해서 문자열 생성
        const { data } = response;
        setObjdata(`${data.str}, ${data.number}`);
      })
      .catch(error => console.log(error))
  }

  //목록 처리용 함수
  const onck3 = () => {
    axios.get("/getList")
      .then(res => {
        console.log(res.data);
        const { data } = res;

        const listItems = data.map(d =>
          <li key={d.number}>{d.str}, {d.number}</li>
        )

        console.log(listItems)
        setList(listItems);
      })
      .catch(err => console.log(err.data));
  }

  //input 처리
  const onch = useCallback(e => {
    setSdata(e.target.value);
  }, []);//렌더링이 될때만 실행되도록 빈 배열을 두번째 parameter로 지정

  const onck4 = () => {
    axios.get("/sendData", {
      params: {
        "data": sdata,
        "second": "두번째 데이터"
      }
    })
      .then(res => console.log(res.data))
      .catch(err => console.log(err))
    setSdata("")
  }

  const onck5 = () => {
    //dto에 작성한 명칭과 동일하게 작성한다
    const sobj = { "str": "리액트", "number": 20000 };
    axios.post("/sendObject", sobj)
      .then(res => console.log(res.data))
      .catch(error => console.log(error));
  }

  return (
    <div>
      <button onClick={onck1}>문자열</button>
      <span>{data}</span><br />

      <button onClick={onck2}>객체</button>
      <span>{objdata}</span><br />

      <button onClick={onck3}>목록</button>
      <ul>{list}</ul>
      <hr />
      <input type="text" onChange={onch} value={sdata} /><br />
      <button onClick={onck4}>문자열 전송</button>
      <hr />
      <button onClick={onck5}>객체 전송</button>
    </div>

  );
}

export default App;