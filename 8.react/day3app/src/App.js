import "./App.css";
import Button from "./Button";
import Counter from "./Counter";
import Div from "./Div";
import MyEffect from "./MyEffect";
import MyMemo from "./MyMemo";
import MyReducer from "./MyReducer";
import MyRef from "./MyRef";
import Timer from "./Timer";

function App() {
  return (
    <>
      <MyEffect />
      <Counter />
      <Timer />
      <MyReducer />
      <MyMemo />
      <MyRef />
      <MyRef />
      <MyRef />
      <Div>
        <Button>기본버튼</Button>
        <Button color="red">빨간버튼</Button>
        <Button color="yellow" bg="red">
          빨간버튼2
        </Button>
        <Button pri>pri버튼</Button>
        <Button sec>sec버튼</Button>
      </Div>
    </>
  );
}

export default App;
