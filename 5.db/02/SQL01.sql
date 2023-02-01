/*
SQL(Structured Query Language)
구조적 질의(질의) 언어

종류
1. DDL (Data Definition Language) - 정의어
CREATE : 생성(계정, 테이블, DB공간 등을 만들 때 사용) - 데이터적인 관점에서, 데이터베이스 자체에 없는걸 만드는 작업.
DROP : 삭제(계정, 테이블, DB공간 등) (CREATE로 만든건 DROP으로 삭제한다.(CREATE의 역))
ALTER : 수정(ALTER는 테이블같은거의 설정을 바꾸므로, 운영중에 ALTER를 사용하면, DB에 손상이나 이상이 발생할 수도 있다- 데이터가 있을 경우, ALTER로 수정 불가. 만약 데이터가 있다면, 다른 곳에 데이터를 옮겼다가 수정하고 다시 불러오는 식으로 작업해야한다.)



2. DML (Data Manipulation Language) - 조작어

INSERT : 데이터 삽입(Create) - 데이터적인 개념상 생성.?
SELECT : 데이터 선택(Read)
UPDATE : 데이터 수정(Update)
DELETE : 데이터 삭제(Delete)


3. DCL (Data Control Language) - 제어어

GRANT : 권한 부여 
REVOKE : 권한 취소


+)문장의 끝엔 세미콜론(문장을 인식하는 단위)
명령어의 문장마다 실행을 해줘야 한다. ctrl enter -> 커서가 위치한 라인 실행

작성해놓은 문장은 다른 문장에 영향을 미치지 않는다.


*/

-- 사용할 DB 공간 지정 명령어
-- schemas에 공간이 여러개라면, 먼저 지정해놔야 한다. -> 지정하면 해당 db가 볼드체로 바뀜.(또는, 탐색창에서 사용할 공간에 마우스 더블클릭)
USE devdb;


/*테이블 생성*/
/*
CREATE TABLE {테이블명} (
	col_name1 data_type [제약조건1 제약조건2 ...], 
    col_name2 data_type [제약조건1 제약조건2...],
    ......
    col_nameN data_type [제약조건1, 제약조건2...]
);
+)제약조건, 널값을 허용하는지 기본키인지 등의 조건 지정
+)컬럼간의 구분은 쉼표로 한다.

*/

CREATE TABLE testTbl(
t_id VARCHAR(20), 
t_nametesttbl VARCHAR(10),
t_age INT
);


-- 쿼리문은 대문자로, 개발자가 정한 이름을 소문자로 작성하는 것을 권장.
-- 굳이 강제는 아님
-- 실제 값들은 대소문자를 구분한다. 


CREATE TABLE member(
m_id VARCHAR(20),
m_pwd VARCHAR(20),
m_name VARCHAR(20),
m_age INT,
m_job VARCHAR(20),
m_grade VARCHAR(10),
m_point INT
);

CREATE TABLE comment(
c_no INT,
c_title VARCHAR(20),
c_content VARCHAR(100),
c_date INT
);


CREATE TABLE ordertable(
o_no INT,
o_amount INT,
o_location VARCHAR(50),
o_date DATE
);


CREATE TABLE product(
p_name VARCHAR(20),
p_amount INT,
p_price INT,
sp_date DATE,
sp_amount INT
);


CREATE TABLE supplier(
s_name VARCHAR(20),
s_phone VARCHAR(20),
s_location VARCHAR(20),
s_manager VARCHAR(20)
);












