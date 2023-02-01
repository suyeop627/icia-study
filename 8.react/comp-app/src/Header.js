import React from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faHouse } from "@fortawesome/free-solid-svg-icons";

const Header = function (props) {
  const HeaderStyle = {
    fontSize: "20px",
    display: "inline",
  };
  const HeaderText = {
    display: "inline",
    textAline: "center",
    marginLeft: "30px",
  };
  return (
    <div>
      <FontAwesomeIcon icon={faHouse} />
      <div style={HeaderStyle}> Logo </div>
      <div style={HeaderText}>{props.children}</div>
    </div>
  );
};

export default Header;
