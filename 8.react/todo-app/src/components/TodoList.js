import React from "react";
import "./TodoList.scss";
import TodoListItem from "./TodoListItem";


const TodoList = ({ todos, onRemove, onToggle }) => {// onRemove라는 이름으로 onRemove 함수를 TodoList -> TodoItem 으로 전달.
  return (
    <div className="TodoList">
      {todos.map(todo => (
        //자동으로 생성할 땐, key를 부여해야한다.
        <TodoListItem todo={todo} key={todo.id} onRemove={onRemove} onToggle={onToggle} />
      ))}
    </div>
  );
};


export default TodoList;