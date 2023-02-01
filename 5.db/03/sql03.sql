

-- -------------------------------------------day3------------------------------------------------------------------------
-- client가 request하면, sever는 respons
-- sever : request가 있을 때만 response함. 수동적이며, 24시간 대기를 하며 request를 기다린다.
-- 127.0.0.1 내부에서 사용하는 ip주소(네트워크를 순환시키는데 사용되는 특수목적의 ip 주소.)
-- port번호 3306 : 여러 프로그램이 각각 동작하기 때문에, 어느 프로그램의 네트워크와 관련된 데이터가 넘어가야하는지를 구분하기 위해 사용됨.
-- ip : 아파트 // port : 동 호수
-- 127.0.0.1 == 로컬 호스트

-- handshake 클라이언트가 손을 내밀면 서버가 맞잡아서 흔듦. - 요청 응답 과정을 악수에 비유
-- client - 데이터를 보낸다는 신호를 먼저 보내고, sever가 응답. ->요청과 응답의 순환 alter'


-- 위와 같은 방식을 tcp라고 함 (통신규약 )

-- mysql도 데이터만 취급하는 서버임.

-- 요청을 보내기 위해 사용하는 것이 sql



CREATE TABLE member(
m_id VARCHAR(20),
m_pwd VARCHAR(20),
m_name VARCHAR(20),
m_age INT,
m_job VARCHAR(20),
m_grade VARCHAR(10),
m_point INT
);

-- +) script 한줄씩 읽으면서 실행하는거. 

-- 프로그램에서 데이터베이스를 처리하기 위해선 sql문을 일단 알아야함.
-- 프로그램에 sql문을 넣어서, 프로그램이 sql로 query를 보내고, mysql에서 처리한다.
-- 워크벤치는 데이터베이스 설게, 구축, 확인 정도만 하는 용도로 사용되며, 데이터 처리는 보통 프로그램에 sql문을 넣어서 처리한다.


/*
MySQL 데이터 타입(자료형)

1. 문자형(5.0.3이전 버전은 byte로, 이후 버전은 글자수로 크기 지정) - CHAR(n)을 제외하면 모두 가변길이
    1) CHAR(n) - 고정 길이. n의 수치로 크기를 결정(최대 크기 255자) - 설정하면 크기가 달라지지 않는다. (성별(M/N)같은건 CHAR()사용하는게 나을수도 있음.)
    2) VARCHAR(n) - 가변 길이.(최대 크기 65535자) 
					- 최대크기 이내에서, 저장된 문자의 크기에 따라서 저장공간의 크기가 달라진다. 
					- 저장할땐 편하지만, 데이터를 가져올땐 절차가 고정길이보다 많아짐.
					- 대부분의 데이터는 가변길이로 처리하지만, 고정길이가 필요할 때도 있음.
                    *많이 사용됨.
    3) TEXT(n) - VARCHAR와 같으나 조회 속도가 느림.(65535자)
				-보통 크기를 설정하지 않고 사용
    4) TINYTEXT(n) - 255자
    5) MEDIUMTEXT(n) - 16777215자
    6) LONGTEXT(n) - 4294967295자
    7) JSON - json 형태로 저장(예 { '이름' : 홍길동, '나이' : 20})
 
 2. 숫자형
	1)TINYINT(n) - 정수. -(128 ~ 127)
    2) SMALLINT(n) - (-32768 ~ 32767)
    3)MEDIUMINT(n) -  (-8388608 ~ 8388607)
    4)INT(n) -  (-2147483548 ~ 2147483547) *많이 사용됨
    5)BIGINT(n) - 무제한 (8byte)
    -------------------
	6) FLOAT(n, d) - 실수.부동 소수형 (n : 전체길이, d : 소수점 아래 자릿수 ex, FLOAT(7,2) = 999999.99)
					부동 소수형
                    *많이사용됨.
    7) DECIMAL(n,d) - 고정 소수형(소수점 이하 숫자가 없어도, 0으로 채움. 3.00)
    8) DOUBLE(n, d) - 부정 소수형. (문자열로 저장)
    
    
    3. 날짜형
		1) DATE - 날짜(연, 월, 일) 형태
		2) TIME - 시간(시, 분, 초) 형태
        3)DATETIME - 날짜와 시간이 합쳐진 형태(8byte)
					1000-01-01부터 
		3) TIMESTAMP - 날짜와 시간이 합쳐진 형태(4byte)
					1970-01-01
		4) YEAR - 연도만 저장하는 형태
        +)UTC(Universal Time Coordinated) - 협정 세계시
        
	4.이진 데이터형(binary) - 대소구분 관련? 이거저거 다시 정리. 
    1) BINARY(n) & (BYTE) - CHAR 형태의 이진 데이터
    2) VARBINARY(n) = VARCHER - VARChar형태으 이진 데이터
    3) TIBYBLOB(n) - 이진 데이터(파일류). 255byte
    3) BLOB(n) - 65535byte
    4) MEDIUMBLOG(n) - 16777215byte(16mb)
    5) LONGBLOG(n)	- 4294967295byte(4gb)
    
        
        
        -- 위지 윅(WYSIWYG, what you see is what you get) - API형식으로 제공되므로, 클론코딩 할때 써볼 수도 있음.
        - 한 입력 공간에 텍스트와 이미지를 같이 입력할 수 있는 에디터(네이버의 스마트에디터) : blob 타입 사용
        ->보이는데로 처리한다는 의미.
        
+)데이터베이스에서 중요한 요소 
1. 저장공간의 효율
2. 처리속도

*/



/*제약조건
데이터의 무결성을 지키기 위해, 데이터를 입력할 때 실행되는 검사규칙
create문이나 alter 문에서 사용. - 테스트를 위해서 alter문을 사용해볼 순 있지만, 수정할 거 있으면 그냥 지우고 다시만드는게 편하다.
1. NOT NULL - 해당 칼럼에 NULL이 들어갈 수 없다.(반드시 입력) - default 값으로는 null값으로 지정할 수 있다.		//가능한 null값을 적게 유지하는 것이 좋다.
2. UNIQUE - 해당 칼럼에 중복값을 허용하지 않는다.(대체키 정도로 생각해볼 수 있음) - 이미 중복값이 들어가 있다면, unique를 설정할 수 없다. 
3. PRIMARY KEY - 해당 컬럼을 기본키로 설정한다. (NOT NULL + UNIQUE)
4. FOREIGN KEY - 해당 컬럼을 외래키로 설정한다. - 다른 키와 연계가 되므로 CONSTRAINT 키워드로 나중에 작성
5. DEFALUT - 해당 컬럼에 기본값을 설정한다.

CONSTRAINT 키워드 : 특정 컬럼에 제약조건을 설정하기 위한 명령어.
컬럼에 제약조건을 넣는 방식
1. 컬럼 작성시 같이한다.(foreign key를 제외하고, 나머지 필요한 제약조건들을 같이 작성할 수 있다.) + NOT NULL은 constraint에서 사용하지 못하므로, create할때 같이 작성한다.
2. CONSTRAINT 키워드로 나중에 추가한다.(생성 먼저 해놓고, 키워드로 제약조건 추가.)



컬럼작성시 외래키 작성 X
not null은 CONSTRAINT로 작성 X


+) not null은 값을 꼭 가져야 한다는 건데, default는 입력값이 없을경우, default값을 넣어준다.
=> not null과 default는 중복되는 의미로,  default를 작성할 경우, not null은 생략한다.

*/


-- 테이블 삭제 : DROP TABLE {테이블명};
DROP TABLE member;  -- 복구가 불가능하므로 신중히 !

-- 회원 테이블 생성(제약조건 추가)
CREATE TABLE member(
m_id VARCHAR(20) primary key,
m_pwd VARCHAR(20) NOT NULL,
m_name VARCHAR(10) NOT NULL,
m_age INT, 
m_job VARCHAR(20),
m_grade VARCHAR(10) NOT NULL DEFAULT 'silver',
m_point INT DEFAULT 0
);

-- 실습을 위한 insert문과 commit으로, 나중에 다시 학습.
INSERT INTO member VALUES ('hong02', '1234', '홍길동', 20, '학생', default, default); -- 정보 입력
-- 컬럼의 개수만큼 쉼표로 구분된 데이터가 작성해야하고, null을 허용하는 컬럼에 데이터를 안넣을 경우에는 null을 작성하고, default값을 갖는 컬럼에 데이터를 새로 넣지 않을경우, default를 입력한다.
COMMIT; -- 입력 최종 실행

SELECT * FROM member; -- 테이블 내용보기


DROP TABLE supplier;

CREATE TABLE SUPPLIER (
s_name VARCHAR(20) NOT NULL,
s_phone VARCHAR(20) NOT NULL,
s_location VARCHAR(20) NOT NULL,
s_manager VARCHAR(20) NOT NULL
);
INSERT INTO supplier VALUES('sup01', '010-0000-0000', '인천', 'kim');
COMMIT;


SELECT * FROM supplier;
-- +) 여러 라인을 묶어서 실행할 수도 있는데, 묶어서 할 경우엔 작성순서대로 실행된다. 

/*
CONSTRAINT를 사용한 제약 조건 처리(NOT NULL, DEFAULT 제외)
1. UNIQUE
CONSTRAINT 제약조건명 UNIQUE (컬럼명)
2. PRIMARY KEY
CONSTRAINT 제약조건명 PRIMARY KEY (컬럼명)
3. FOREIGN KEY
CONSTRAINT 제약조건명 FOREIGN KEY (컬럼명)
REFERENCES 테이블명 (컬럼명)

제약 조건명 : 제약 조건을 따로 관리 가능하면 해당 제약 조건을 나중에 변경하거나 제거할 때 구분하기 위해 사용.
			보통 테이블명과 컬럼명, 제약조건의 단어를 조합하여 작명.
			예) member테이블의 기본키 : m_id_pk / m_pk
*/

-- 제조회사 테이블
CREATE TABLE company(
c_name VARCHAR(20),	-- 기본키이므로, 따로 not null을 설정하지 않았다.
c_phone VARCHAR(15) NOT NULL,
c_loc VARCHAR(50) NOT NULL,
c_manager VARCHAR(10) NOT NULL,
CONSTRAINT c_n_pk PRIMARY KEY (c_name)
);

-- 상품테이블
-- 외래키는 기본테이블이 있어야 생성가능함.
-- 외래키 삭제할때는 참조하고있는 테이블에서 먼저 삭제해야한다.(끌고 간쪽 먼저 삭제)

CREATE TABLE product(
p_no INT PRIMARY KEY,
p_cname VARCHAR(20) NOT NULL, -- 외래키로 지정할 값의 컬럼명은 기존과 달라도 상관없지만 ,크기와 타입은 일치해야한다.
p_name VARCHAR(20) NOT NULL,
p_amount INT DEFAULT 0,
p_price INT NOT NULL,
p_cpdate DATE , 
cp_amount INT,
CONSTRATE p_c_fk FOREIGN KEY(p_c_name)
REFERENCES company(c_name)
);


-- 주문 테이블		졸았음 강의내용 보고 오타 및 필기내용 수정.----------------------------------------
CREATE TABLE ordertbl(
	o_no INT PRIMARY KEY,
    o_mid VARCHAR(20) NOT NULL,
    o_pno INT NOT NULL,
    o_amount INT NOT NULL,
    o_loc VARCHAR(50) NOT NULL,
    o_date DATE,

    CONSTRAINT o_m_fk FOREIGN KEY (o_mid)
    REFERENCES member (m_id),
    CONSTRAINT o_p_fk FOREIGN KEY (o_pno)
    REFERENCES product (p_no) 
    ON UPDATE CASCADE ON DELETE CASCADE
-- 상품 테이블의 상품번호를 수정/삭제하면, 그 번호를 사용하는 주문의 정보도 같이 수정/삭제

);


/*
	ON DELETE
    -참조되는 테이블의 값이 삭제될 경우
    ON UPDATE 
    -참조되는 테이블의 값이 수정될 경우
    
    설정동작
	1. CASCADE : 참조하는 테이블의 값도 같이 처리 (*많이 사용됨)
    2. SET NULL : 참조하는 테이블의 값을 NULL로 변경 (컬럼에 NOT NULL을 설정 했을 경우, 사용할 수 없다.)
    3. NO ACTION : 참조하는 테이블의 값에 아무 변경 안함
    4. SET DElETE : 참조하는 테이블의 값을 기본값으로 변경
	5. RESTART : 참조되는 테이블의 값이 변경 불가
    
   ex,  ON UPDATE CASCADE ON DELETE CASCADE
    +)참조되는 테이블 : member(기본키를 제공하는 테이블)
	  참조하는 테이블 : ordertbl(외래키가 있는 테이블)
*/

/*
자동으로 증가하는 정수 값을 사용하는 컬럼 설정
AUTO_INCREMENT : 1씩 증가하는 정수값이 자동으로 삽입됨. 정수형 기본키 컬럼에만 사용.


CREATE TABLE datatbl (
d_no INT AUTO_INCREMENT PRIMARY KEY,
d_data1 VARCHAR(10) NOT NULL,
......
);
*/

-- 게시판은 gui사용해서 테이블 생성(b_no : pk, ai 체크)
-- 컬럼 생성 후, 하단의 forein key탭에서 외래키 설정가능.
-- pk 기본키 / nn not null / uq unique(잘안쓰임) / b binary(b체크하면 검색할때, 대소문자 구문해서 검색할 수 있음) / un unsigned data type(잘안씀) / zf zero fill (잘 안씀)/ ai auto increment / g


/*
테이블 삭제와 수정
삭제 : DROP TABEL {테이블명};

수정 : ALTER TABLE {테이블명}
1) 컬럼 추가 : ADD COLUMN{컬럼명} {타입};
2) 컬럼 변경 : MODIFY COLUMN {컬럼명} {변경타입};
			변경하고자 하는 컬럼에 데이터가 있을 경우, 변경이 불가능하다.
3) 컬럼 삭제 : DROP COLUMN {컬럼명};
4) 테이블명 변경 : RENAME {변경할 테이블명}
5) 컬럼명 변경 : CHANGE COLUMN {기존컬럼명} {새컬럼명};
*/
-- 컬럼 추가
ALTER TABLE testtbl
ADD COLUMN phone VARCHAR(15);

-- 컬럼 변경
ALTER TABLE testtbl
MODIFY COLUMN phone VARCHAR(20);

-- 컬럼명 변경		/ 이름과 크기를 함께 바꾸는 명령어인데, 크기 안바꿀거면 기존과 같은 크기로 입력.
ALTER TABLE testtbl
CHANGE COLUMN phone t_phone VARCHAR(20);

-- 컬럼 삭제
ALTER TABLE testtbl
DROP COLUMN t_phone;

-- 테이블 명 변경
ALTER TABLE testtbl
RENAME test_tbl;

/*
제약 조건의 추가/삭제
1) 기본키 추가 : ADD PRIMARY KEY (컬럼명);
2) 기본키 삭제 : DROP PRIMARY KEY;
3) 외래키 추가 : ADD CONSTRAINT 제약조건명
				FOREIGN KEY (컬럼명)
				REFERENCES 테이블명(컬럼명)
4)외래키 삭제 : DROP FOREIGN KEY 제약조건명;
5)제약조건 추가/삭제 : 
	ADD CONSTRAINT 제약조건명 {제약조건_키워드}; 		-- 같은 제약조건 명을 가진 컬럼을 모두 제거한다.
    DROP CONSTRAINT 제약조건명;


*/

-- 기본키 추가
ALTER TABLE test_tbl
ADD PRIMARY KEY (t_id);


-- 왜래키 추가
ALTER TABLE test_tbl
ADD CONSTRAINT t_c_fk FOREIGN KEY (t_name)
REFERENCES company(c_name);

-- 테이블 상태 확인 명령어 : DESC{테이블명}	(description)
DESC board;	

-- 공간에 작성된 테이블명 확인 명령 
SHOW tables; 



-- ------------------여기까지 ddl--------------------

/*
DML : 데이터 조작어
1. INSERT : 테이블에 데이터를 삽입하기 위한 명령어
			같이쓰는 명령어 :
            1) INTO : 테이블을 지정하는 명령어
            2) VALUES : 컬럼별 데이터 입력을 위한 명령어
         작성법
         1) 입력할 컬럼을 지정하는 방식
         2) 모든 컬럼에 데이터를 입력하는 방식
         
2. SELECT
3. UPDATE
4. DELETE
*/

--   INSERT     1) 입력할 컬럼을 지정하는 방식
-- 회원 정보 저장
INSERT INTO member (m_id,m_pwd,m_name) -- 멤버테이블에서 실질적으로 데이터를 넣어야 하는 건 옆의 3개의 컬럼. (디폴트 있는거, null값 허용 제외)
VALUES('test01','1111','아무개'); -- 컬럼을 입력한 순서에 때라서 넣을 값들도 순서대로 작성한다.
-- 테이블의 컬럼은 순서에 상관없이 작성해도 상관없지만, VALUE는 컬럼 작성순서에 맞게 작성한다.
INSERT INTO member(m_name,m_id, m_pwd)
VALUES('전우치','jun01','1212');
SELECT * FROM member;
-- +)테이블에서 투플이 정렬되는 방식은 기본키를 기준으로 오름차순으로 정렬된다.

/*
트랜잭션(transaction) : insert, update, delete 작업의 기본 단위
	한 작업의 중간단계에서 실패할 경우, 해당 transaction의 최초의 상태로 되돌린다.
	데이터 베이스가 변경되는 작업에 한하여 트랜잭션 처리를 수행.
    작업완료에 대한 최종 승인 또는 되돌림 처리가 가능하다.
    COMMIT : 최종 승인 명령.
    ROLLBACK : 되돌림 명령.

=>insert, update, delete 작업 이후, commit이나 rollback을 해야한다.
+)commit 이후로는 해당 트렌젝션이 반영되어 원본으로 되돌릴 수 없다.
데이터의 삽입, 수정, 삭제 작업을 프로그램을 통해서가 아닌 워크벤치를 통해서 했을경우, 반드시 commit을 수행해야한다.
commit을 하기 전에는 임시로 저장된 데이터이기 때문에 프로그램에서 해당 데이터를 받을 수 없다.

*/
-- 자동 commit 설정 상태 확인(1은 설정상태, 0은 해제상태)
SELECT @@autocommit; 
-- auto commit 설정 변경
SET autocommit = 0;



commit;

-- INTERT         2) 모든 컬럼에 데이터를 입력하는 방식
INSERT INTO member VALUES ('hong02', '1234', '홍길동', 20, '학생', default, default); -- 정보 입력
-- 컬럼의 개수만큼 쉼표로 구분된 데이터가 작성해야하고, null을 허용하는 컬럼에 데이터를 안넣을 경우에는 null을 작성하고, default값을 갖는 컬럼에 데이터를 새로 넣지 않을경우, default를 입력한다.

-- +)외래키가 설정된 컬럼에 데이터를 넣을 경우, (게시판에서 외래키로 m_id 설정했으면, (관계 다시 확인) m_id값 중에서만 값을 입력할 수 있다.


