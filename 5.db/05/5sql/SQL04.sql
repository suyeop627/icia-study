/*
현재 날짜와 시간을 구하는 함수 : now()
date 타입일 경우 날짜를, time 타입일 경우 시간 구할 수 있음.
datetime 타입일 경우 날짜와 시간을 모두 처리.
now()는 데이터 입력 시 사용.(INSERT 문에서 사용)

날짜를 기본값으로 설정하는 방법.(CREATE TABLE 에서)
1) date 타입
	컬럼명 DATE DEFAULT (CURRENT_DATE) 또는
    컬럼명 DATE DEFAULT (curdate())
2) time 타입
	컬럼명 TIME DEFAULT (CURRENT_TIME) 또는
    컬럼명 TIME DEFAULT (curtime())
3) datetime 타입
	컬럼명 DATETIME DEFAULT CURRENT_TIMESTAMP 또는
    컬럼명 DATETIME DEFAULT (CURRENT_TIME) 또는
    컬럼명 DATETIME DEFAULT now()
*/
CREATE TABLE date_test (
	d_no INT AUTO_INCREMENT PRIMARY KEY,
    d_date DATE DEFAULT (curdate()),
    d_time TIME DEFAULT (CURRENT_TIME),
    d_dt DATETIME DEFAULT now()
);

INSERT INTO date_test
VALUES (null, DEFAULT, now(), now());
COMMIT;
SELECT * FROM date_test;


/*
Subquery(서브쿼리)
	하위 질의문. 하나의 쿼리가 여러 쿼리문으로 구성되는 형태.
    이때 내부에 포함되는 쿼리문을 서브쿼리라고 함.
	1) 단일행 서브쿼리 : where 절에 위치함.
		서브쿼리의 실행 결과가 하나의 행임.(컬럼도 한개)
	2) 다중행 서브쿼리 : where 절에 위치함.
		서브쿼리의 실행 결과가 여러 행임.(컬럼은 한개)
	3) 다중컬럼 서브쿼리 : where 절에 위치함.
		서브쿼리의 실행 결과가 여러 행, 여러 컬럼임.
*/
-- 단일행 서브쿼리 예)
-- 사원번호가 7698번인 사원과 같은 직함을 가진 사원 정보.
-- 1) 사원번호가 7698번인 사원의 직함 조회.
SELECT job FROM emp WHERE empno = 7698;
-- 2) 같은 직함을 가진 사원 조회.
SELECT * FROM emp WHERE job = 'MANAGER';
-- 3) 두 쿼리를 합친다.
SELECT *
FROM emp
WHERE job = (
	SELECT job
    FROM emp
    WHERE empno = 7698
);
-- 사원 번호 7566번과 MGR이 같은 사원의 정보를 조회하시오.
-- 1) 사원 번호 7566번의 MGR 조회.
SELECT mgr FROM emp WHERE empno = 7566;
-- 2) MGR로 사원 정보 조회.
SELECT * FROM emp WHERE mgr = 7839;
-- 3) 두 쿼리를 하나로 합침.
SELECT * FROM emp
WHERE mgr = (
	SELECT mgr 
    FROM emp
    WHERE empno = 7566
);

-- 다중행 서브쿼리 예
-- 부서별로 가장 많은 급여를 받는 사원 정보를 조회.
-- 1) 부서별 가장 많은 급여 조회.
SELECT max(sal) FROM emp GROUP BY deptno;
-- 2) 각 급여에 해당하는 사원 정보 조회.
SELECT * FROM emp WHERE sal = 5000 
	OR sal = 3000 OR sal = 2850;
SELECT * FROM emp WHERE sal IN (5000, 3000, 2850);
-- 3) 두 쿼리를 합침.
SELECT * FROM emp
WHERE sal IN (
	SELECT max(sal)
    FROM emp
    GROUP BY deptno
);
-- salesman 보다 많은 급여를 받는 사원의 정보 조회.
SELECT sal FROM emp WHERE job = 'SALESMAN';

SELECT *
FROM emp
WHERE sal > all (
	SELECT sal 
    FROM emp 
    WHERE job = 'SALESMAN'
);
-- any : 서브쿼리의 여러 결과 중 어느 하나의 값만 만족하면
--       결과로 가져오는 연산자.
-- all : 모든 서브쿼리의 결과에 만족하면 결과로 가져오는 연산자.

-- 다중 컬럼 서브쿼리 예)
-- 부서번호가 30번이고, 커미션을 받는 사원과 같은 급여나 부서인
-- 사원의 정보
SELECT sal, deptno
FROM emp
WHERE deptno = 30 
	AND comm IS NOT NULL;

SELECT *
FROM emp
WHERE (sal, deptno) IN (
	SELECT sal, deptno
	FROM emp
	WHERE deptno = 30 
		AND comm IS NOT NULL
);

-- 여러 테이블을 같이 조회할 때 서브쿼리를 많이 사용함.
-- 사원번호가 7654번인 사원의 부서명과 위치를 조회.
SELECT * FROM emp;
SELECT * FROM dept;

-- 1) 7654번 사원의 부서번호 조회
SELECT deptno FROM emp WHERE empno = 7654;
-- 2) 30번 부서의 이름과 위치 조회
SELECT dname, loc FROM dept WHERE deptno = 30;
-- 3) 두 쿼리를 합침.
SELECT dname, loc
FROM dept
WHERE deptno = (
	SELECT deptno
    FROM emp
    WHERE empno = 7654
);
-- RESEARCH 부서의 모든 사원 정보를 출력하시오.
-- 1) RESEARCH 부서의 부서번호 조회
SELECT deptno FROM dept WHERE dname = 'RESEARCH';
-- 2) 부서번호로 사원 정보 조회
SELECT * FROM emp WHERE deptno = 20;
-- 3) 두 쿼리를 합침.
SELECT * FROM emp
WHERE deptno = (
	SELECT deptno FROM dept 
    WHERE dname = 'RESEARCH'
);

/*
Join(조인)
	두 테이블 이상을 하나로 묶어서 조회하는 방법
    기준이 되는 테이블에 다른 테이블의 정보를 붙이는 형태
    - 테이블 병합 작업 후 검색 수행.
    1) 내부 조인(등가 조인)
		기준이 되는 테이블에 존재하는 데이터에 매치되는
        다른 테이블의 정보가 붙는 형태.
    2) 외부 조인
		기준이 되는 테이블에 존지하지 않는 다른 테이블의
        정보도 붙는 형태.(NULL 값이 포함된다.)
*/
-- 사원 정보와 부서명 함께 조회
-- 조인 시 컬럼명을 사용할 때는 앞에 테이블명을 붙인다.
-- 예) 사원번호 : emp.empno, 사원정보 전체 : emp.* 등
SELECT emp.empno, emp.ename, emp.sal, dept.dname
FROM emp INNER JOIN dept
ON emp.deptno = dept.deptno;

SELECT emp.*, dept.*
FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- 테이블 명에 별칭 사용.
use employees;

-- 사원별 급여 출력
-- employees 테이블과 salaries 테이블 조인
SELECT e.emp_no, e.first_name, s.salary
FROM employees e JOIN salaries s
	ON e.emp_no = s.emp_no
WHERE s.to_date LIKE '9999%'
LIMIT 300, 100;

SELECT e.emp_no, e.first_name, s.salary
FROM employees e, salaries s
WHERE e.emp_no = s.emp_no
	AND s.to_date LIKE '9999%'
LIMIT 300, 100;

-- 사원별 부서명을 조회하시오.(3개 테이블 병합)
SELECT e.emp_no, e.first_name, d.dept_name, s.salary
FROM employees e JOIN dept_emp de
	ON e.emp_no = de.emp_no
    JOIN departments d
    ON de.dept_no = d.dept_no
    JOIN salaries s
    ON e.emp_no = s.emp_no
WHERE de.to_date LIKE '9999%'
	AND s.to_date LIKE '9999%'
    AND dept_name = 'Sales';

SELECT count(*) FROM employees;


use devdb;

-- FROM 절에 들어가는 서브쿼리(가상의 테이블)
-- 10번 부서 소속 사원명과 부서명
-- 1) 10번 부서의 부서번호와 부서명 조회
SELECT deptno, dname
FROM dept
WHERE deptno = 10;

SELECT e.ename, d.dname
FROM emp e JOIN (
		SELECT deptno, dname
		FROM dept
		-- WHERE deptno = 10
		) d
	ON e.deptno = d.deptno;
-- from 절에 들어가는 서브쿼리 -> inline view

-- 소속된 사원이 없는 부서를 조회하시오.
select * from emp;
select * from dept;

-- 외부 조인을 사용.(LEFT/RIGHT OUTER JOIN)
SELECT DISTINCT d.deptno 부서, e.deptno 사원
FROM dept d LEFT OUTER JOIN emp e
	ON d.deptno = e.deptno;
    
SELECT DISTINCT d.deptno 부서, e.deptno 사원
FROM emp e RIGHT JOIN dept d
	ON d.deptno = e.deptno;
-- outer는 생략 가능

/*
View(뷰)
  뷰란 데이터베이스에 실존하지 않는 가상의 테이블.
  테이블의 링크로 데이터를 보여주는 역할을 담당.
  뷰는 SELECT를 목적으로 하며, 삽입, 수정, 삭제는 불가.

	특징
    1. 특정 사용자에게 테이블 전체가 아닌 필요한 컬럼만
	   보여주도록 제한.
	2. 복잡한 쿼리를 단순화 할 수 있음.
    3. 쿼리를 재사용할 수 있음.
    
    제한 사항
    1. 한번 정의(생성)한 뷰는 변경이 안됨.(재생성해야 함.)
    2. 삽입, 수정, 삭제 불가.
    
  문법>
  CREATE OR REPLACE VIEW 뷰이름 AS
  SELECT 구문;
  
  제거
  DROP VIEW 뷰이름;
*/
SELECT empno, ename, deptno
FROM emp;

CREATE OR REPLACE VIEW emp_view AS
SELECT empno, ename, deptno
FROM emp;

SELECT * FROM emp_view;

CREATE OR REPLACE VIEW emp_info AS
SELECT e.emp_no, e.first_name, d.dept_name, s.salary
FROM employees e JOIN dept_emp de
	ON e.emp_no = de.emp_no
    JOIN departments d
    ON de.dept_no = d.dept_no
    JOIN salaries s
    ON e.emp_no = s.emp_no
WHERE de.to_date LIKE '9999%'
	AND s.to_date LIKE '9999%'
    AND dept_name = 'Sales';

SELECT * FROM emp_info;


/*
MySQL 내장 함수
DB 관리를 위해 사용하는 MySQL 전용 함수들.
*/
-- 형변환 함수 : CAST(), CONVERT()
SELECT avg(amount) "평균 구매 개수" FROM buytbl;

SELECT CAST(avg(amount) AS SIGNED INTEGER) "평균 개수"
FROM buytbl;

SELECT CONVERT(avg(amount), SIGNED INTEGER) "평균"
FROM buytbl;

SELECT CAST('2022-10-04' AS DATE);

-- 문자열의 결합 : CONCAT(str1, str2, ...)
SELECT first_name, last_name
FROM employees;

SELECT CONCAT(first_name, ' ', last_name) ename
FROM employees;

SELECT concat_ws(' ', first_name, last_name, birth_date)
FROM employees;

-- IF(수식, 참, 거짓)
SELECT IF(100>200, '참이다', '거짓이다');
SELECT ename, IF(sal > 2000, '고연봉', '저연봉') '분류'
FROM emp;

-- IFNULL(수식1, 수식2)
-- 수식1의 값이 null이 아니면 수식1의 값을,
-- null이면 수식2의 값을 출력.
SELECT empno, ename, CAST(IFNULL(comm, 0) AS SIGNED INTEGER) comm
FROM emp;

-- FORMAT(숫자, 소수점 자릿수) -> 문자열로 변환
SELECT FORMAT(123456.123456, 1);

-- 수학함수
-- ceiling(실수), floor(실수), round(실수, 위치)
SELECT ceiling(1.3) 'ceil'; -- 올림
SELECT floor(1.7) 'floor'; -- 내림
SELECT round(1654.35582, -3) 'round'; -- 반올림
-- 뒷자리 수가 양수일 경우 소수점 반올림
-- 뒷자리 수가 음수일 경우 -3이면 100자리 반올림.

-- 날짜 관련 함수
SELECT ename, year(hiredate) 'year',
	month(hiredate) 'month',
    day(hiredate) 'day',
    hiredate
FROM emp;

SELECT now() '현재',
	dayofyear(now()) 'today-year',
    dayofmonth(now()) 'today-month',
    dayofweek(now()) 'today-week',
    monthname(now()) '월이름'
;
-- 요일 : 1-일요일, 7-토요일
SELECT date(now()), time(now());
