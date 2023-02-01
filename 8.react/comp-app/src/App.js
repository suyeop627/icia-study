import "./App.css";
import MyComponent from "./MyComponent";
import Header from "./Header";
import MyComp from "./MyComp";

function App() {
  const MyCar = { model: "올랜도", com: "쉐보레" };
  return (
    <>
      <Header logo="MyApp">Header입니다.</Header>
      <MyComponent title="App에서 보낸 값" writer="홍길동" car={MyCar} />
      {/*부모 컴포넌트에서 자식 컴포넌트로 title='리액트'라는 데이터를 전달 */}
      <MyComp name="아무개" fnum={5}>
        내용입니다
      </MyComp>
    </>
  );
}

export default App;
