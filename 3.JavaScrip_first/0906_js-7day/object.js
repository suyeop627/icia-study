/*쇼핑몰(상품)
자동차 
  1)정보(변수)
      모델명 :  소나타, 아반떼
      색상 : 빨간색, 회색, 백색, 검정색
      문 개수 : 2, 3, 5
      제조사 : 현대, 기아, BMW, 벤츠, 아우디
      카테고리 : 소형, 준중형, 중형, 대형, SUV
      속도 : 0
  
  2)기능(함수)
      가속(속도) - 주어진 속도만큼 차를 가속 시킨다.
      멈춤() - 즉시 속도 0으로 만든다
      조향(방향) - 주어진 방향에 따라 차의 경로를 변경한다.

*/


//객체 선언
let car = { 
  model : "소나타",   //property (멤버 변수)
  color : "흰색",
  speed : 0,
  accel : function(sp){   //method(멤버 함수)
    this.speed = sp;   //this = 이 객체 안에 있는 것을 가리킬때.(객체 자기 자신을 가리킴)
  }
};


console.log(car)    //object 형식으로 출력
console.log(car.model, car.color)    //값만 출력

car.speed = 100;    //객체에 property 추가

console.log(car)


car.accel(200);     //car objcet의 speed의 값을 200으로 변경하는 함수
console.log(car.speed) 

//문의 개수 저장 변수 추가
car.door = 4;
console.log(car)

car.break = function(){ 
  this.speed = 0;
}

car.break() //json object notation
//한사람의 정보를 저장하는 객체
let person = {
  name : "홍길동",
  age : 25,
  address : "인천시 미추홀구",
  birth : "19900504"
}

/*
let object1 = {
  carS : car,
  personH : person
}
console.log(object1)*/


console.log(person);
//JSON(Javascript Object Notation) : 자바스크립트 객체 표기법
//화면에서 입력받은 데이터를 서버프로그램쪽으로 전달할 때 사용하는  데이터 묶음 방식




//자바스크립트의 객체는 주로 html요소를 객체화 하여 제어할 때 사용.



//개발자도구 ->요소 선택 ->property 보면 요소의 정보들을 볼 수 있음