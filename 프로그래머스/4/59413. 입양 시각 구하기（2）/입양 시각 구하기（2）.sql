-- 0 ~ 23시까지 시간대 테이블 생성
WITH RECURSIVE HOUR_TABLE AS (
    SELECT 0 AS HOUR
    UNION ALL
    SELECT HOUR + 1 FROM HOUR_TABLE WHERE HOUR < 23
)

-- 조회
SELECT 
    H.HOUR,
    COUNT(A.DATETIME) AS COUNT
FROM HOUR_TABLE H
LEFT JOIN ANIMAL_OUTS A
    ON H.HOUR = HOUR(DATETIME)
GROUP BY H.HOUR
ORDER BY H.HOUR

