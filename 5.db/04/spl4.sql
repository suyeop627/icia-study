


/*
DML (데이터 조작어)
1. INSERT (삽입)
	테이블에 데이터를 삽입하는 명령어
  문법> 
  1)
  INSERT INT {테이블명} (컬럼명1, 컬럼명2, ...)   -- not null을 지정한 컬럼들에 값을 입력할 때 주로 사용한다.
  VALUES('데이터', '데이터', ...)								-- 컬럼명을 나열하는 순서는 상관없지만, 작성한 컬렴영의 순서에 따라서 데이타 명을 작성한다.	
  -- 데이터 배치 순서는 위의 컬럼명 배치 순서대로.
  
  
  2)
  INSERT INTO {테이블명}
  VALUES ('데이터', '데이터', ...);
  -- 데이터 배치 순서는 테이블의 컬럼 순서대로.
*/

DESC board;

INSERT INTO board (b_mid, b_title, b_content, b_date)
-- VALUES ('test02', '그냥..', '아무거나', '2022-09-30');  b_mid는 외래키인데, member테이블에 test02의 값이 없어서 참조하지 못한다. 실행시 에러발생.
VALUES ('test01', '그냥..', '아무거나', '2022-09-30');
COMMIT;

SELECT * FROM board;  -- b_no에 값은 하나인데, 3으로 나옴? -> 넣으려다가 실패한거도 카운팅 되는데, 어차피 순서대로 되니까 상관 없다.

INSERT INTO board
VALUES (null, 'jun01', '그냥2..', null, '2022-09-30');  -- 대부분 이렇게 사용한다. (위의 경우는 여러개의 쿼리중 선택한 컬럼에 따라서 선택해야하므로, 코드가 개별화되어야한다. 번거로움)
COMMIT;


-- select @@autocommit;
-- --- day4-------------------------------------------------------------------------
/*
(insert 가 1이었음)
2. UPDATE(수정)
	테이블에 삽입된 데이터를 수정하는 명령어.
  컬럼 단위로 수정.
  행을 선택하는 조건이 없는 경우, 모든 행을 수정한다.
  
  문법>
  UPDATR{테이블명}
  SET 컬럼명1 = 변경데이터, [컬럼명2, =변경데이터, ...]		-- 하나 또는 그 이상 가능
	
  WHERE 조건
  
  
 
*WHERE 절		-- +)쿼리로 작성하는 걸 구문이라고 하고, 한 키워드로 구성된 문장을 절이라고함. UPDATE절, SET절
	조건을 지정할 때 사용하는 명령어 절
  이 절에서 설정된 조건에 따라 맞는 행만 선별.
  
  세이프 모드 - 한번에 싹 수정하거나 삭제하고 그런거 막아주는 기능. 실습을 위해 해제하고 실습한다.
  edit preference - sql editor 에서 설정
*/
select * from board;

UPDATE board
SET b_date = '2022-09-29'
WHERE b_no = 5 ;				-- '='기호로 대입과 등식 효기를 같이한다.('='사용위치에 따라 의미가 다름) ==기호는 없다.

ROLLBACK;		-- 복구 명령어
COMMIT;			-- 최종 실행(승인)명령어 
/*
Safe Updates : 기본키를 사용하지 않은 UPDATES나 DELETE를 방지하는 기능. WORKBENCH 옵션(edit>preferences)에서 safe updates 체크박스 해제
*/


-- 트랜잭션 명령 : INSERT, UPDATE, DELETE


/*
3. DELETE(삭제)
	테이블에서 데이터를 삭제하는 명령어로, 행단위로 수행된다.
  조건이 없을 경우 모든 행을 삭제한다.alter
  
  문법>
  DELETE FROME {테이블명}
  [WHERE 조건];
  
  +)preference query editor>UPPER CASE 어쩌고 - 키워드 대문자 변환
  
*/

DELETE FROM board
where b_no = 4;

select * from board;

rollback;

commit;



DELETE FROM board
WHERE b_date = '2022-09-30';



DELETE FROM board
where b_mid = 'jun01';

SELECT * FROM member;


-- 상품 구매시 적립금 1% 지급
-- 홍길동이 50000원 상품 구매
UPDATE member
SET m_point = m_point + 50000*0.01
WHERE = m_id = 'honeg-2';

-- 새해가 밝았스비다. 모든 회원의 나이를 1살 더 많이 먹었습니다.
-- 이 사항을 db에 반영해주세요

UPDATE member
SET m_age = m_age +1;

/*

SQL 쿼리문 작성법(권장)
1. SQL문은 대소문자 구분 없음
2. 한 문장은 여러줄로 작성 가능
3. (일반적으로)SQL 키워드는 대문자로, 이름(테이블명, 컬럼명 등)은 소문자로 작성.
4 .문장의 마지막은 ';'를 기술.(필수사항)
5. 이름(테이블명, 컬럼명 등)에 공백 사용 안함. - 공백대신 '_'등을 사용한다. (대소문자 구분이 안되기 때문에, 카멜케이스같은건 안씀)
*/


/*
4. SELECT(선택, 읽어오기)
DQL (Data Query Language, 데이터 질의어)로 분류하기도 한다.
에이블의 데이터를 검색하는 명령어
행 단위로 처리하면 결과에 대한 컬럼을 지정할 수 있음.

문법>
SELECT [DISTINCT] {*, 컬럼명 [별칭], 컬럼명[별칭],...}
FROM {테이블명}
[WHERE 조건]
[ORDER BY {컬럼명} [ASC|DESC];


DISTINCT : 결과 데이터의 중복 제거(대상은 1개의 컬럼) - 하나의 컬럼에서 값을 추출할 때, 값의 중복을 제거. ex, 전체 등급 구간이 아니라, 현재 데이터그룹에 어떤 등급들이 있는지 조회할 때 등급 컬럼에 사용.
* : 모든 컬럼.(테이블에 배치된 순서대로 출력된다)
별칭(Alias) : 컬럼 이름의 별명.
ORDER BY : 특정 컬럼의 데이터로 결과행들을 정렬.
	ASC : 오름차순 정렬.(ascending, 1234)
  DESC : 내림차순 정렬.(decending, 4321)`

*/

SELECT m_id, m_name, m_age
FROM member
WHERE m_age>20
ORDER BY m_age DESC
;

rollback;


/*
WHERE 절의 연산자.
	1. 비교연산자 
		=, !=, >, <, >=, <=
    '=' 연산자의 차이 (Java vs SQL)
			-java의 같다 : ==
      -SQL의 같다 : =	(WHERE 절에서만 사용된다.)
      -Java의 대입 : =
      -SQL의 대입 : =	(UPDATE의 SET절에서만 사용된다.)
      
      
  2. 논리 연산자
		AND, OR, NOT
    BETWEEN a AND b : a와 b 사이의 범위 지정
    IN(list) : list에 찾고자 하는 조건목록을 작성.
    NOT을 조합하여 반대 경우의 조건을 작성.
    
  3. 문자열 검색 연산자
		LIKE - 컬럼의 데이터를 문자열로 검색.
		- 모르는 부분에 대한 처리를 위한 특수 문자.
    1) % : 여러 글자를 대체하여 표현(대체하는 글자의 수는 0개부터)
			LIKE '%대%'; - '대'로 시작하거나, 중간에 '대'가 들어가거나, 마지막에 '대'로 끝나는 데이터
		2)_ : 한글자를 대체하여 표현.
    LIKE '_대'; ->두번째 글자가 '대인 두글자의 단어를 검색.
			예) 3번째 글자가 '대'인 경우의 검색 -> LIKE '_ _ 대'	(_ 두개 이어서 작성)
			예) 전체 글자의 개수는 모르지만, 3번째 글자가 '대'일 경우 검색법 -> LIKE '_ _ 대%'
 4. null 관련 연산자
			IS NULL : 컬럼의 데이터가 null인 행을 검색.
      IS NOT NULL : 컬럼의 데이터가 null이 아닌 행을 검색.
		
  
*/

use employees;

-- ----------employees 테이블 사용-----------------------------------------------------
/*변경이 있을 수도 있으니 수정의 용이성을 위해 아래와 같이 작성하는게 편하다.
SELECT * 
FROM employees
;
*/

-- 사원 전체의 모든 정보
SELECT * 
FROM employees
;
-- 사원 번호와 성
SELECT emp_no, first_name
from employees
;


-- 여사원의 사번과 이름 검색
SELECT emp_no, first_name
FROM employees
WHERE gender = 'F'
;


-- 별칭 설정 
-- 별칭에서 공백 넣을 때, 큰따옴표 사용해서 넣을 수는 있지만, 매번 "를 작성해줘야 편한 방법은 아니다. 
SELECT emp_no "사원 번호", first_name 이름
FROM employees;

-- 고용일 1992년부터 1995년 사이인 사원의 사번과 이름을 검색
SELECT emp_no, first_name, last_name
FROM employees
WHERE hire_date 
BETWEEN '1992-01-01'		
			AND '1995-12-31'
ORDER BY hire_date DESC
;
	-- DATE 타입은 문자 취급한다.
	-- ORDER BY hire_date ASC 는 생략한다.



SELECT emp_no, first_name, last_name, hire_date
FROM employees 
		WHERE hire_date>='1992-01-01'
    AND hire_date<='1995-12-31'
    
    ORDER BY hire_date, first_name DESC		-- 고용일 기준 오름차순 정렬 후 성 기준으로 내림정렬.
    ;
    
    
    
    
    
    
    
    
    SELECT * FROM employees;
    
    
    
	-- 문제 
  -- 1990년 이후에 입사한 직원의 직원번호, 성명을 구하시오
  SELECT emp_no, first_name, last_name
  From employees;
  -- 이름이 'Mark'인 직원의 직원 번호를 구하시오
  SELECT emp_no
  FROM employees
  WHERE first_name = 'mark'
  ;
  -- 이름이 'Jun'이거나 생일이 '1960'이후인 직원의 성과 직원번호를 구하시오.
SELECT emp_no, last_name
FROM employees
WHERE first_name = 'Jun' OR birth_date>='1960-01-01'
;



-- LIKE 사용 예
-- 이름에 'a'가 들어가는 사원의 사번과 이름
-- 숫자형 컬럼에는 사용하지 않는다.
SELECT emp_no, first_name
FROM employees
WHERE BINARY first_name LIKE '%a%'
;

-- 대소문자를 구분하여 검색 결과 구하기 : BINARY - bit(2진값)으로 검색한다.
-- 검색 시 WHERE 절에서 컬럼명 앞에 BINARY 추가
-- 테이블 생성 시 type 다음에 BINARY 추가 (생성할때 BINARY타입을 주기보다는, 검색할때 추가해서 찾는 방식이 더 많이 사용된다.
-- ex, m_name VARCHAR(10) BINARY NOT NULL

-- IN 연산자
-- 복합적 or 연산
-- 이름이 'Mark'이거나 'Elvis'이거나 'Ohad'인 사원의 사번과 생일을 구하시오.
SELECT m_no, first_name, birth_date
From employees
WHERE employees 
OR first_name = 'Mark'
OR first_name='Elvis'
OR first_name ='Ohad'
;
-- ----------졸았음 필기 보충-----------------------------------------------------------
SElect * from employees;

SELECT m_no, first_name, birth_date
From employees
WHERE first_name IN('mark', 'Elvis', 'Ohad')
;


SELECT emp_no, salary
FROM salar
WHERE to_date LIKE '9999%'
;



SELECT emp_no, first_name, last_name, hire_date
FROM employees 
WHERE hire_date>='1992-01-01'
AND hire_date<='1995-12-31'
ORDER BY hire_date, first_name DESC		-- 고용일 기준 오름차순 정렬 후 성씨 기준으로 내림정렬.
;
    
SELECT * FROM employees
Where to_date LIKE '9999%'
;

SELECT MIN(salary)
FROM salaries
WHERE to_date LIKE '9999%'
;
    
SELECT emp_no
FROM salaries
WHERE slary = 38623
;

SELECT *
FROM departments
WHERE dept_no = 'd007'
;
-- --------------------------------------------------------------

-- Sales 부서장은?
SELECT dept_no, emp_no
FROM dept_manager
WHERE dept_no = 'd007'
			AND to_date LIKE '9999%'
;
      
     
SELECT emp_no, first_name
FROM employees
WHERE emp_no = '111133'
;
      

-- DISTINCT : 검생 결과의 중복 제거
SELECT DISTINCT dept_no
FROM dept_emp
;

SELECT dept_no
FROM dept_emp
;
-- 출력 개수 제한 : LIMIT n[, m]
-- n 단독 : 0번부터 n-1번까지의 행 조회(n = 가져오는 데이터의 개수)
-- n과 m의 경우, n : 조회할 행의 시작 번호
-- 						 m : 조회할 행의 개수


SELECT * 
FROM employees
LIMIT 10  -- 10개의 데이터 초회(0번부터~9번까지 조회)
;      
SELECT *
FROM employees
LIMIT 10, 10  -- (10번째부터 19번까지 조회)
;
SELECT * 
FROM employees
LIMIT 0, 10         -- n에 해당하는 숫자(0)만 바꾸면, 프로그램에서 db의 데이터를 10개씩 반복해서 가져오도록 할 수 있다.(paging 페이징) :  db의 정보를 모두 프로그램에서 가져와서 처리하면 너무 무거워지므로, 필요한 만큼만 가져오는 거 / 많은 데이터를 페이지화해서 한페이지씩 보여주는 느낌
;
      

SELECT *
FROM employees
ORDER BY first_name
LIMIT 0, 10
;      
-- -----------------------------------------------
USE devdb;
show tables;
SELECT DISTINCT depthno
FROM emp;

SELECT * FROM emp;
SELECT * FROM dept;
SELECT * FROM salgrade;
      
/*
집계함수 
	행에 대한 산술적인 연산을 수행하는 함수. 주로 숫자타입의 컬럼에서만 사용(count 제외, sum이나 avg같은거)
	1) count(컬럼) - 전체 또는 특정 컬럼의 값이 있는 행의 개수
				count(*) - 모든 행의 개수	-- (*)모든 컬럼선택은 count에서만 쓸 수 있다.
        count(컬럼명) - 해당 컬럼의 값이 null이 아닌 행의 개수
  2) sum(컬럼) - 해당 컬럼의 모든 행의 합산.
  3) avg(컬럼) - 해당 컬럼의 모든 행의 평균값.
  4) min(컬럼) - 해당 컬럼의 모든 행 중에 가장 작은 값.(DATE type에도 적용 가능.)
  5) max(컬럼) - 해당 컬럼의 모든 행 중에 가장 큰 값.
	6) stdev(컬럼) - 표준편차 함수.
  7) var_samp(컬럼) - 분산.

*/


SELECT count(*)	-- 전체 사원수
FROM emp
;

-- comm을 받는 사원 수
SELECT count(comm)
FROM emp
;

-- 회사의 전체 인건비는 얼마?
SELECT sum(sal)
FROM emp;

-- 회사의 평균 인건비(급여)는 얼마?
SELECT avg(sal)
FROM emp;		

SELECT min(sal), max(sal)
FROM emp;



/*
GROUP BY, HAVING
	행을 그룹으로 묶어주는 역할
  집계 함수를 사용할 수 있음.
  
*/

-- 부서별 인원수를 파악하자.
SELECT count(*)
FROM emp
WHERE deptno = 10;
;


SELECT deptno
FROM emp
GROUP BY deptno;-- distinct 쓴 것과 같은 결과

SELECT deptno, count(*) -- 특정 값마다 몇개의 행이 있는지 카운팅
FROM emp
GROUP BY deptno;

-- 부서별 급여 합계, 평균
SELECT deptno, sum(sal), avg(sal), max(sal), min(sal)
FROM emp
GROUP BY deptno;



-- HAVING  : 그룹화에 대한 조건을 작성하는 구문.
-- +) 집계함수는 WHERE 절에서 사용 불가. -> WHERE대신 HAVING으로
-- 사원 수가 5명 이상인 부서는 ? 
SELECT deptno, count(*)
FROM emp
GROUP BY deptno
HAVING count(*) >= 5;
-- HAVING 절은 GROUP BY 절과 함께 사용. (단독 사용 불가)

-- WITH ROLLUP : 그룹의 중간 합계 및 총합
SELECT deptno, job, sum(sal)
FROM emp
GROUP BY deptno, job
WITH ROLLUP;		-- 합계가





-- -------------------------------------------------------------------------------
-- 실습문제
-- 직함별 평균 급여를 조회하시오.
SELECT job, avg(sal)
from emp
GROUP BY job
;

-- 직함별 최대 급여, 최소 급여를 조회하시오.
SELECT job, max(sal), min(sal)
from emp
GROUP BY job;
-- 직함별 인원수를 조회하시오
SELECT job, count(*)
FROM emp
GROUP BY job
;
SELECT * from emp;
-- 부서별 사원수와 커미션을 받는 사원들의 수를 조회하시오
SELECT deptno "부서명", count(*) "부서별 \n사원수" ,count(comm) "커미션 받는\n사원수"
FROM emp
GROUP BY deptno;

use devdb;
















