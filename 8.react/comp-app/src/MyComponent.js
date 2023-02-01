import React from "react";

const MyComponent = function (props) {
  return (
    <div>
      <div>{props.title}</div>
      <h1>{props.writer}님</h1>
      <p>
        내 차는 {props.car.model}이고, 제조사는 {props.car.com}입니다.
      </p>
    </div>
  );
};

MyComponent.defaultProps = {
  writer: "사용자",
};
export default MyComponent;
