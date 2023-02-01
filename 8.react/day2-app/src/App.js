import logo from "./logo.svg";
import "./App.css";
import MyComp from "./MyComp";
import Header from "./Header";
import MyEvent from "./MyEvent";
import MyInput from "./MyInput";
import MyInput2 from "./MyInput2";
import MyList from "./MyList";
import CafeMenu from "./CafeMenu";
import CafeMenu2 from "./CafeMenu2";

function App() {
  const menu = {
    hoeme: "home",
    menu1: "login",
    menu2: "join",
  };
  return (
    <div>
      <Header title="My Home" nav={menu} />
      <MyComp book="리액트" data="보낸 데이터" isAdmin="true">
        children을 통해서 보낸 데이터
      </MyComp>
      {/* 버튼 요소하나를 가진 컴포넌트 */}
      <MyEvent />
      <MyInput />
      <MyInput2 />
      <MyList />
      <CafeMenu />
      <CafeMenu2 />
    </div>
  );
}

export default App;
