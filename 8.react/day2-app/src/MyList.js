// import React from "react";
// const MyList = () => {
//   return (
//     <ul>
//       <li>아메리카노</li>
//       <li>카페라떼</li>
//       <li>카페모카</li>
//       <li>카푸치노</li>
//       <li>딸기라떼</li>
//     </ul>
//   );
// };
// export default MyList;

import React from "react";
const MyList = () => {
  //jsx문법에서, return에는 if문과 for문을 사용할 수 없다.
  const menus = ["아메리카노", "카페라떼", "카페모카", "카푸치노", "딸기라떼"];
  //const menuList = menus.map((menu) => <li>{menu}</li>);
  const menuList = menus.map((menu, index) => <li key={index}>{menu}</li>);
  console.log(menuList);

  return <ul>{menuList}</ul>;
};
export default MyList;
