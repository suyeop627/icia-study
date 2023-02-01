import React, { useState } from "react";
const CafeMenu = () => {
  const [items, setItems] = useState([
    //id와 menu를 키로 갖는 객체 배열 생성.
    { id: 1, menu: "아메리카노" },
    { id: 2, menu: "카페라떼" },
    { id: 3, menu: "카페모카" },
  ]);

  //사용자의 입력값을 저장할 state 생성
  const [inMenu, setInMenu] = useState("");
  //새로운 항목이 추가될때마다 id로 저장할 state 생성(기존 객체 배열에 id가 3번까지이므로, 그 다음 숫자를 초기값으로 지정.)
  const [newId, setNewId] = useState(4);

  //입력값의 처리는 onChange 이벤트로 한다.
  const onch = (e) => setInMenu(e.target.value); //사용자의 입력값을 inMenu에 넣기

  //새 메뉴를 목록에 추가
  const onck = () => {
    const nextItem = items.concat({
      id: newId,
      menu: inMenu,
    });

    setNewId(newId + 1);
    setItems(nextItem); //새 아이템이 추가된 메뉴로 업데이트
    setInMenu(""); //입력태그 비우기
  };
  const menuList = items.map((item) => <li key={item.id}>{item.menu}</li>);

  return (
    <>
      <input value={inMenu} onChange={onch} />
      <button onClick={onck}>추가</button>
      <ul>{menuList}</ul>
    </>
  );
};

export default CafeMenu;
