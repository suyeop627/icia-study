import React, { useState } from "react";

const CafeMenu2 = () => {
  //메뉴 항목을 가지고 있는 state
  const [items, setItems] = useState([
    { id: 1, menu: "아메리카노" },
    { id: 2, menu: "카페라떼" },
    { id: 3, menu: "녹차라떼" },
  ]);

  //항목 삭제 처리(onDoubleClick 이벤트)
  //더블클릭된 항목만을 선택하기 위해서 id를 parameter로 받음
  //id로 구분된 삭제할 항목을 제거한 새 목록을 작성하여 setItems 처리(새 목록 저장)
  const removeItem = (id) => {
    const afterList = items.filter((item) => item.id !== id);
    setItems(afterList);
  };

  //더블 클릭 시 해당 메뉴를 삭제하기 위한 (onDoubleClick이벤트를 포함해서 생성)
  const menuList = items.map(
    (
      item //forEach 써도 되긴 하는데, 배열을 새로 만들어주진 않는다.  arr.map으로 한번에 처리하는 게 편함
    ) => (
      <li key={item.id} onDoubleClick={() => removeItem(item.id)}>
        {item.menu}
      </li>
      //onDoubleClick{removeItem(item.id)}로 작성하면, 이벤트가 발생하기 전에 removeItem 함수가 실행된다.
      //이벤트를 처리하기 위해 속성으로 함수를 넣을 때는, 실행할 함수를 익명함수로 실행하도록 처리한다.
    )
  );

  //input태그로 입력받는 값을 저장할 state
  const [inMenu, setInMenu] = useState("");

  //id값을 처리하기 위한 state(기존 id다음에 붙일 값이라서 3 +1);
  const [newId, setNewId] = useState(4);

  //입력 값에 따라 inMenu를 업데이트 하는 함수   // input에 값이 입력될때마다 onch 함수가 실행되고, 입력된 값은 inMenu에 저장된다.
  const onch = (e) => setInMenu(e.target.value);

  //추가 버튼을 누를 때 메뉴 목록에 새 메뉴 추가
  const onck = () => {
    //메뉴 목록을 업데이트 하기 위한 새 목록작성(사용자의 입력값(inMenu)과 새 아이디(newId) 필요.)
    //기존 목록 + 새 아이템
    const newMenu = items.concat({
      id: newId,
      menu: inMenu,
    });
    //새 메뉴목록(newMenu)로 메뉴 목록 state를 덮어쓰기
    setItems(newMenu);
    //다음 입력값에 사용할 새 id준비
    setNewId(newId + 1);
    //입력태그 초기화
    setInMenu("");
  };

  return (
    <>
      <input value={inMenu} onChange={onch} />
      <button onClick={onck}>추가</button>
      <ul>{menuList}</ul>
    </>
  );
};

export default CafeMenu2;
