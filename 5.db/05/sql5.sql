/* 

날짜를 기본값으로 설정하는 방법. - 데이터를 입력하는 시간을 기준으로 날짜가 입력된다.
현재 날짜와 시간을 구하는 함수 : now()

date 타입일 경우 날짜를, 
time 타입일 경우 시간을 구할 수 있음.
datetime 타입일 경우, 날짜와 시간을 모두 처리.
now()는 INSERT 문에서 데이터를 입력할 때 사용된다.

날짜를 기본값으로 설정하는 방법.(CREATE TABLE 사용)
1)date 타입(날짜) 
	컬럼명 DATE DEFAULT (CURRENT_DATE) 
  또는 컬럼명 DATE DEFAULT (curdate()) //+) 반드시 괄호 안에 작성한다. 
2)time 타입(시간)
	컬럼명 TIME DEFAULT (CURRENT_TIME)
  또는 컬럼명 TIME DEFAULT (curtime())
3)datetime 타입(날짜+시간)
	컬럼명 DATETIME DEFAULT CURRENT_TIMESTAMP
  또는 컬럼명 DATETIME DEFAULT (CURRENT_TIME)
  또는 DATETIME DEFAULT now()

*/


CREATE TABLE date_test (
	d_no INT AUTO_INCREMENT PRIMARY KEY,
	d_date1 DATE DEFAULT (CURRENT_DATE),
  d_date2 DATE DEFAULT (curdate())	,		-- 괄호 안에 작성해야한다.
  d_time1 TIME DEFAULT (CURRENT_TIME),
  d_time2 TIME DEFAULT (curtime()),
  d_dt1 DATETIME DEFAULT (CURRENT_TIMESTAMP),
  d_dt2 DATETIME DEFAULT (CURRENT_TIME),
  d_dt3 DATETIME DEFAULT now()
  );



select * from date_test;


INSERT INTO date_test
VALUES (null, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
COMMIT;
SELECT * FROM date_test;



/*
Subquery(서브쿼리)

하위 질의문. 하나의 쿼리가 여러 쿼리문으로 구성되는 형태.
이때 내부에 포함되는 쿼리문을 서브쿼리라고 함.
여러 테이블을 같이 조회할 떄 서브쿼리를 많이 사용한다.


1) 단일행 서브쿼리 : where 절에 위치함.
	서브쿼리의 실행 결과가 하나의 행.(컬럼도 한개)
2) 다중행 서브쿼리 : where 절에 위치함.
	서브쿼리의 실행 결과가 여러 행임. (컬럼은 한개)
3) 다중컬럼 서브쿼리 : where 절에 위치함.
	서브쿼리의 실행결과가 여러 행, 여러 컬럼임.

*/

-- 사원 번호가 7698번인 사원과 같은 직함을 가진 사원 정보.
-- 1) 사원번호가 7698번인 사원의 직함.
SELECT job FROM emp WHERE empno = 7698; -- 서브쿼리
-- 2) 같은 직함을 가진 사원 조회.
SELECT * FROM emp WHERE job = 'MANAGER'; -- 외부쿼리
-- 3) 두 쿼리를 합친다.



SELECT *
FROM emp
WHERE job = (				
-- ---------------------서브쿼리
	SELECT job 
  FROM emp
  WHERE empno = 7698
);


-- 단일행 쿼리 ---------------------------------------------
-- 사원 번호 7566번과 MGR이 같은 사원의 정보를 조회하시오
-- 1) 사원 번호 7566번의 MGR 조회(mgr = 7839)
SELECT mgr FROM emp WHERE	empno=	7566;
-- 2) 사원 MGR로 사원 정보 조회.
SELECT * FROM emp WHERE mgr = 7839;
-- 3) 두 쿼리를 하나로 합침.

-- ///////////////////////////////////////
SELECT * FROM emp
WHERE mgr = (
	SELECT mgr FROM emp 
  WHERE empno=7566
  );



-- 다중행 쿼리 ---------------------------------------------
-- 부서별로 가장 많은 급여를 받는 사원 정보를 조회.
-- 1) 부서별 가장 많은 급여 조회.
SELECT max(sal) FROM emp GROUP BY deptno;
-- 2) 각 급여에 해당하는 사원 정보 조회.
-- (1) OR 사용
SELECT * FROM emp WHERE sal = 5000
	OR sal = 3000 OR sal = 2850;
-- (2) IN 사용
SELECT * FROM emp WHERE sal IN(5000, 3000, 2850);  

-- 3) 두 쿼리를 합침.
SELECT * FROM emp
WHERE sal IN (		-- 등가로 처리될때 in 사용
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

-- any : 서브쿼리의 여러 결과 중 어느 하나의 값만 만족하면 결과로 가져오는 연산자.
-- all : 모든 서브쿼리의 결과에 만족하면 결과로 가져오는 연산자.


-- 다중 컬럼 서브쿼리 ---------------------------------------------
-- 부서 번호가 30번이고, 커미션을 받는 사원과 같은 급여 또는 같은 부서인 사원의 정보
SELECT sal, deptno
FROM emp
WHERE deptno = 30
	AND comm IS NOT NULL;

SELECT * 
FROM emp 
WHERE(sal, deptno) IN (			-- IN만 사용 가능
	SELECT sal, deptno
	FROM emp
	WHERE deptno = 30
	AND comm IS NOT NULL
);


-- 사원 번호가 7654번인 사원의 부서명과 위치를 조회
-- 사원번호 조회 : emp 테이블
SELECT * FROM emp;
-- 부서명과 위치 조회 : dept 테이블		(dept의 기본키가 emp의 외래키로 사용됐다.)
SELECT * FROM dept;

-- 1) 7654번 사원의 부서번호 조회
SELECT deptno FROM emp WHERE empno = 7654;		 -- (deptno=30)
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

-- RESEARCH 부서의 사원 정보를 출력하시오.
-- 1) RESEARCH 부서의 부서번호 조회 (deptno = 20)
SELECT deptno FROM dept WHERE dname = 'RESEARCH';
-- 2) 부서번호로 사원번호 조회
SELECT * FROM emp WHERE deptno = 20;
-- 두 쿼리를 합침

SELECT * FROM emp
WHERE deptno = (
	SELECT deptno 
	FROM dept 
	WHERE dname = 'RESEARCH'
);


-- 서브쿼리는 한쪽의 테이블을 검색한 결과를 사용해서 다른 테이블을 조회하는 형태.(2회 이상의 조회가 이루어진다.)
-- join은 테이블을 먼저 붙이고, 그다음에 조회를 실행하는 형태. (조회는 1회만 이루어진다.)

/*
Join(조인)
	두 테이블 이상을 하나로 묶어서 조회하는 방법
  기준이 되는 테이블에 다른 테이블의 정보를 붙이는 형태.
	- 테이블 병합 작업 후 검색 수행.
	1) 내부 조인 (등가 조인)
		기준이 되는 테이블에 존재하는 데이터에 매치되는 다른 테이블의 정보가 붙는 형태.(NULL값 미포함)
  2) 외부 조인
		기준이 되는 테이블에 존재하지 않는 다른 테이블의 정보도 붙는 형태.(NULL 값이 포함된다.)

-- 조인 시 컬럼명을 사용할 때는 앞에 테이블명을 붙인다.
--예) 사원 번호 : emp.empno, 사원번호 전체 : emp.* 등
*/

SELECT emp.empno, emp.ename, emp.sal, dept.dname
FROM dept INNER JOIN emp -- 통상적으로, FROM에 보다 상위 테이블을 작성, JOIN에 보조하는 테이블 작성
ON emp.deptno = dept.deptno;

SELECT emp.*, dept.*
FROM emp, dept 
WHERE emp.deptno = dept.deptno;



-- ------------------------------------
use employees;
-- 테이블 명에 별칭 사용.


-- 사원별 급여 출력
-- employees 테이블과 salaries 테이블 조인
-- employees -> e , salaries -> s 별칭을 사용해서 쿼리문을 간략하게 한다. 

SELECT e.emp_no, e.first_name, s.salary
FROM employees e JOIN salaries s
ON e.emp_no = s.emp_no
WHERE s.to_date LIKE '9999%'  -- WHERE 절을 추가해서, 조건에 해당하는 데이터만 조회할 수도 있다.
LIMIT 0,100;	-- 조회되는 데이터가 많을 경우, 페이징


-- 위 쿼리에서 WHERE절의 다른 작성
SELECT e.emp_no, e.first_name, s.salary
FROM employees e JOIN salaries s
WHERE e.emp_no = s.emp_no
	AND s.to_date LIKE '9999%'
LIMIT 0,100;	


-- 사원별 부서명을 조회하시오.
SELECT e.emp_no, e.first_name, d.dept_name, s.salary
FROM employees e JOIN dept_emp de
	ON e.emp_no = de.emp_no		-- employees와 dept_emp를 emp_no로 join
  JOIN departments d
	ON de.dept_no = d.dept_no	-- 앞서 join한 테이블에, departments를 dept_no로 join.
	JOIN salaries s
	ON e.emp_no = s.emp_no
WHERE de.to_date LIKE '9999%'
	AND s.to_date LIKE '9999%;'
	AND dept_name = 'Sales';


-- ---------------------------------
use devdb;

-- FROM 절에 들어가는 서브쿼리(가상의 테이블)
-- 10번 부서 소속 사원명과 부서명

SELECT deptno, dname
FROM dept 
WHERE deptno = 10;

SELECT e.ename, d.dname
FROM emp e JOIN (
	SELECT deptno, dname 
  FROM dept
  -- WHERE deptno = 10
	)d
ON e.deptno = d.deptno;
-- from 절에 들어가는 서브쿼리 -> inline view

/*
View(뷰)




*/



/*
MySQL 내장 함수 
DB 관리를 위해 사용하는 MySQL 전용 함수들.
*/

-- 형변환 함수 : CAST(), CONVERT()
SELECT avg(amount) "평균 구매 개수" FROM buytbl;

SELECT CAST(avg(amount) AS SIGNED INTEGER)
FROM buytbl;

SELECT CONVERT(avg(amount), SIGNED INTEGER) "평균"
FROM buytbl;


SELECT CAST('2022-10-04' AS DATE);

-- 문자열의 결합 : CONCAT(str1, str2, ...) 						use employees;
SELECT first_name, last_name
FROM employees;

SELECT CONCAT(first_name, ' ', last_name) ename				-- ename이라는 별칭으로, 두개의 컬럼을 하나로 합치기., concat은 순서대로 결함
FROM employees;

SELECT concat_ws(' ', first_name, last_name, birth_date)  -- concat은 구분자를 먼저 작성하고, 구분자로 구분해서 문자열을 연결함.
FROM employees;

-- IF (수식, 참, 거짓) 
SELECT IF (100>50, '참이다', '거짓이다');

SELECT ename, if(sal>2000, '고연봉', '저연봉') '분류'
FROM emp;


-- IFNULL(수식1, 수식2)
-- 수식1의 값이 null이 아니면 수식1의 값을, null이면 수식2의 값을 출력.           -- use devdb
SELECT empno, ename, IFNULL(comm, 0) comm
FROM emp;


-- FORMAT(숫자, 소수점 자릿수)
SELECT FORMAT(123456.123456, 4); 




-- 수학 함수
-- ceiling(실수), floor(실수), round(실수, 위치)
SELECT ceiling(1.3) 'ceil'; 	-- 올림(항상 소숫점 기준)
SELECT floor(1.7) 'floor'; -- 내림(항상 소숫점 기준)

SELECT round(1654.35582, 3) 'round'; -- 반올림(소숫점 셋째 자리에서 반올림함)
SELECT round(1654.35582, -3) 'round'; -- 반올림(음수를 지정할 경우, 정수의 자릿수에서 반올림 지정 가능)

-- 날짜 관련 함수(year(), month(), day(), now()
SELECT ename, year(hiredate) 'year', month(hiredate) 'month', day(hiredate)'day', hiredate
FROM emp;


SELECT now() '현재',	
	dayofyear(now()) 'today-year',
  dayofmonth(now()) 'today-month',
  dayofweek(now()) 'today-week',
  monthname(now()) '월이름';

-- 요일 : 1- 일요일, 7 - 토요일.
SELECT date(now()), time(now());			-- date() 날짜만 / time() 시간만


