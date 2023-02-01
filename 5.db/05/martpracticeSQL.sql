
-- 새로운 DB 공간을 만들어서 사용해 주세요.(shopdb)
USE shopdb;
-- 회원 : 아이디(기본키), 패스워드, 이름, 주소, 연락처, 충전금액(기본값 0)
CREATE TABLE 회원(
아이디 VARCHAR(20) PRIMARY KEY,
패스워드 VARCHAR(10) NOT NULL, 
이름 VARCHAR(10) NOT NULL,
주소 VARCHAR (50) NOT NULL,
연락처 VARCHAR(15) NOT NULL,
충전금액 INT DEFAULT 0
);

-- 상품 : 상품번호(자동증가, 기본키), 상품명, 가격, 수량(기본값 0)
CREATE TABLE 상품(
상품번호 INT PRIMARY KEY AUTO_INCREMENT,
상품명 VARCHAR(20) NOT NULL,
가격 INT NOT NULL,
수량 INT DEFAULT 0
);

/*구입 : 회원과 상품 다대 다 관계. 
구입번호(자동증가, 기본키), 구입일자(기본값 입력날짜), 
구입시간(기본값 입력시간), 구입수량, 
구입가격, 구분(기본값 정상/취소).
*/
CREATE TABLE 구입(
구입번호 INT PRIMARY KEY AUTO_INCREMENT,
구입일자 DATE DEFAULT(CURRENT_DATE) NOT NULL,
구입시간 TIME DEFAULT(CURRENT_TIME) NOT NULL,
구입수량 INT DEFAULT 0 NOT NULL,
구입가격 INT NOT NULL,
구분 VARCHAR(5) DEFAULT '정상'
);
desc 구입;
use shopdb;
ALTER TABLE 구입
ADD COLUMN 구매자 VARCHAR(20);

ALTER TABLE 구입
ADD COLUMN 구매상품 int;

ALTER TABLE 구입
ADD CONSTRAINT 구매자아이디키 FOREIGN KEY (구매자) 
REFERENCES 회원(아이디);

ALTER TABLE 구입
ADD CONSTRAINT 구매상품키 FOREIGN KEY (구매상품) 
REFERENCES 상품(상품번호);


DROP TABLE 상품;


/*
회원제로 운영하는 마트임.
회원은 충전금액으로만 상품을 구입할 수 있음.
-V-모든 컬럼은 필수 입력 요소로 가정한다.
충전금액 또는 수량 차감 시 음수가 되는 상황은 상정하지 않는다.

*/
-- 회원 등록 쿼리.
-- 회원 : 아이디(기본키), 패스워드, 이름, 주소, 연락처, 충전금액(기본값 0)
INSERT INTO 회원
VALUES('aaaa', '1111', '이름1', '인천1', '010-1111-1111', default); 

-- 각 회원별 충전 쿼리.
UPDATE 회원
SET 충전금액 = 충전금액 + 1000
WHERE 아이디 = 'aaaa';
desc 구입;
-- 상품 등록 쿼리.
-- 상품 : 상품번호(자동증가, 기본키), 상품명, 가격, 수량(기본값 0)
INSERT INTO 상품
VALUES(null, '상품1', 500, default); 
select * from 상품;

-- 구매 시나리오 
-- 1. buytbl에 상품 구매 내역을 입력
/*구입 : 회원과 상품 다대 다 관계. 
구입번호(자동증가, 기본키), 구입일자(기본값 입력날짜), 
구입시간(기본값 입력시간), 구입수량, 
구입가격, 구분(기본값 정상/취소).
*/
		insert 구입
    values (null, default, default, 1, 100, default, 'aaaa', 1); 
    
-- 2. membertbl에 금액에 따라 충전금액 차감


-- 3. producttbl에 상품 수량을 차감

-- 반품 시나리오
-- 1. buytbl에 구분를 '취소'로 변경

-- 2. membertbl에 충전금액 증가

-- 3. producttbl에 상품 수량 증가


desc 회원;
select * from 회원;







