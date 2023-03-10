/* 마트 운영
새로운 DB 공간을 만들어서 사용해 주세요.(shopdb)
회원 : 아이디(기본키), 패스워드, 이름, 주소, 연락처, 충전금액(기본값 0)
상품 : 상품번호(자동증가, 기본키), 상품명, 가격, 수량(기본값 0)

구입 : 회원과 상품 다대 다 관계. 
    구입번호(자동증가, 기본키), 구입일자(기본값 입력날짜), 
	구입시간(기본값 입력시간), 구입수량, 
    구입가격, 구분(기본값 정상/취소).
		
회원제로 운영하는 마트임.
회원은 충전금액으로만 상품을 구입할 수 있음.
모든 컬럼은 필수 입력 요소로 가정한다.
충전금액 또는 수량 차감 시 음수가 되는 상황은 상정하지 않는다.
회원 등록 쿼리.
각 회원별 충전 쿼리.
상품 등록 쿼리.

-- 구매 시나리오 
-- 1. buytbl에 상품 구매 내역을 입력
-- 2. membertbl에 금액에 따라 충전금액 차감
-- 3. producttbl에 상품 수량을 차감

-- 반품 시나리오
-- 1. buytbl에 구분를 '취소'로 변경
-- 2. membertbl에 충전금액 증가
-- 3. producttbl에 상품 수량 증가

위 제시된 내용을 처리하기 위한 SQL 쿼리문을 작성하세요~
CREATE TABLE, INSERT, UPDATE 쿼리문 작성.
날짜별 판매량과 판매금액, 제품별 판매량과 판매금액 산정용 쿼리.
*/
