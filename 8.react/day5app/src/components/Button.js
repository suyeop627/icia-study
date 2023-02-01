import classNames from "classnames";
import React from "react";
import "./Button.scss";

const Button = ({ children, size, color, outline }) => {
  return (
    // 단순히 두개 이상의 클래스 명을 나열하는 것으로는 처리가 안되므로, 백틱으로 감싸서 변수로 처리한다.
    //    <button classNam={`Button ${size}`}> 

    //classnames라이브러리 사용                //size와 color는 값이 들어오는데, {outline}은 이 속성이 있다없다로 구분된다.
    <button className={classNames('Button', size, color, { outline })}>
      {children}
    </button>
  );
};
Button.defaultProps = {
  size: "medium",
  color: "blue",
}
export default Button;