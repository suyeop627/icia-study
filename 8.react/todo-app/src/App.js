import { useCallback, useRef, useState } from 'react';
import './App.css';
import TodoInsert from './components/TodoInsert';
import TodoList from './components/TodoList';
import TodoTemplate from './components/TodoTemplate';

function App() {

  const [todos, setTodos] = useState([
    {
      id: 1,
      text: '리액트의 기초 알아보기',
      checked: true,
    },
    {
      id: 2,
      text: '컴포넌트 스타일링',
      checked: true,
    },
    {
      id: 3,
      text: '일정 관리 앱 만들기',
      checked: false,
    },
  ])

  //고유값인 id 처리는 ref 사용(다음 번호에 해당하는 값으로 초기화)
  const nextId = useRef(4);

  //새 항목의 입력 처리를 위한 insert 함수(TodoInsert.js에서 버튼이 클릭됐을 때 실행돼야 한다.)
  const onInsert = useCallback(text => {//사용자가 입력한 텍스트
    //새 일정이 입력되면(+버튼 클릭 시) 새 일정용 객체 생성
    const todo = { //새로운 일정
      id: nextId.current,
      text,
      checked: false,
    };
    //새일정 객체를 기본 객체 목록 뒤에 붙여서 state 업데이트
    setTodos(todos.concat(todo))
    nextId.current += 1;//다음 아이디에 +1
  }, [todos],//todos가 변경될때만 실행
  )

  //삭제 처리 함수
  const onRemove = useCallback(id => {
    const afterList = todos.filter(todo => todo.id !== id)//배열에 있는 id !== 인자로 받은 id(선택한 id)
    setTodos(afterList);
  }, [todos])//todos가 변경될때만 실행.


  //토글 처리 함수
  const onToggle = useCallback(id => {
    const toggleList = todos.map(todo => (
      todo.id === id ? { ...todo, checked: !todo.checked } : todo
    ));
    setTodos(toggleList)
  }, [todos])


  return (
    <TodoTemplate>
      {/* 자식 컴포넌트에 state를 사용하는 함수를 전달하여, 자식 컴포넌트에서 부모컴포넌트의 state를 변경할 수 있다.*/}
      <TodoInsert onInsert={onInsert} />
      <TodoList todos={todos} onRemove={onRemove} onToggle={onToggle} />
      {/* onRemove라는 이름으로 onRemove 함수를 TodoList -> TodoItem 으로 전달. */}
    </TodoTemplate>
  )
}

export default App;
