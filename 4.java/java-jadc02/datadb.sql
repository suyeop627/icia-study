-- 테이블 삭제 쿼리				(초기화 시킬때 자주 사용하는 형태로, 테이블이 있으면 지우고 없으면 생성.
DROP TABLE IF EXISTS datatbl;

-- 테이블 생성 뭐리
CREATE TABLE IF NOT EXISTS datatbl(
  m_code INT AUTO_INCREMENT PRIMARY KEY,
  m_str VARCHAR(20) NOT NULL, 
  m_int INT NOT NULL,
  m_date DATE NOT NULL
);

SELECT * FROM datatbl WHERE m_code =1;


-- 전체 수정
UPDATE datatbl
Set m_str = ?, m_int = ?, m_data=?
WHERE m_code=?;

-- 일부만 수정(문자만 수정)
UPDATE datatbl
Set m_str = ?
WHERE m_code=?;


