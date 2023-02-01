import React from "react";
import PropTypes from "prop-types"; //propType사용할 때 import 필요.

//const MyComp = (props) => {
//const { name, children: ch } = props;
const MyComp = ({ name, fnum, children: ch }) => {
  // 구조분해를 하면, props.name, props.children에서 props를 생략하여, 보다 간편하게 작성할 수 있다.
  return (
    <div>
      {name}님이 만든 새 컴포넌트
      <br />
      {ch}!!
      {fnum}
    </div>
  );
};

MyComp.propTypes = {
  name: PropTypes.string,
  fnum: PropTypes.number.isRequired,
};

export default MyComp;
