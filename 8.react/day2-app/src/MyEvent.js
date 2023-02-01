import React, { useState } from "react";

const MyEvent = () => {
  const [name, setName] = useState("");
  const shoot = (msg) => {
    //alert(`${msg} 골!`);
    let n = prompt("누구 골?");
    setName(n);
  };
  return (
    <>
      <button onClick={() => shoot("1")}>슛!</button>
      <p>{name}</p>
    </>
  );
};

export default MyEvent;
