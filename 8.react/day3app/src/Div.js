import React from "react";
import styled from "styled-components";

const StyledDiv = styled.div`
  width: 300px;
  height: 200px;
  border: 2px dashed darkgreen;
  border-radius: 5px;
  background: green;
`;

const Div = ({ children }) => {
  return <StyledDiv>{children}</StyledDiv>;
};

export default Div;
