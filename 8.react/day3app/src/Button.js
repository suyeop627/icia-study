import React from "react";
import styled, { css } from "styled-components";

// styled.요소
const MyButton = styled.button`
  padding: 6px 12px;
  border-radius: 8px;
  font-size: 16px;
  line-height: 1.5;
  border: 1px solid lightgray;

  color: ${(props) => props.color || "gray"};
  background: ${(props) => props.bg || "white"};

  ${(props) =>
    props.pri &&
    css`
      color: white;
      background: navy;
      board-color: navy;
    `}

  ${(props) =>
    props.sec &&
    css`
      color: black;
      background: yellow;
      border-color: black;
    `}
`;

const Button = ({ children, ...props }) => {
  return <MyButton {...props}>{children}</MyButton>;
};
// const Button = ({ color, bg,  children }) => {
//   return <MyButton color={color} bg={bg}>{children}</MyButton>;
// };

export default Button;
