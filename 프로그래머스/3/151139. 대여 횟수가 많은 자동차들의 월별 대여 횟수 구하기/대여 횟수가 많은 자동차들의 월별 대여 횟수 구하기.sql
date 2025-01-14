-- 월별 대여 횟수를 구하기
SELECT 
    MONTH,                  -- 월(Month)
    CAR_ID,                 -- 자동차 ID
    RECORDS                 -- 월별 대여 횟수
FROM (
    -- 윈도우 함수로 총 대여 횟수를 계산
    SELECT 
        DATE_FORMAT(START_DATE, '%c') AS MONTH,  -- 월(Month)을 숫자로 추출
        CAR_ID,                                 -- 자동차 ID
        COUNT(*) AS RECORDS,                   -- 월별 대여 횟수
        SUM(COUNT(*)) OVER (PARTITION BY CAR_ID) AS TOTAL_RECORDS  -- 자동차별 총 대여 횟수
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'  -- 대여 기간 필터링
    GROUP BY MONTH, CAR_ID                      -- 월별 및 자동차별로 그룹화
) SUB
WHERE TOTAL_RECORDS >= 5                         -- 총 대여 횟수가 5회 이상인 자동차 필터링
ORDER BY CAST(MONTH AS UNSIGNED) ASC, CAR_ID DESC; -- 월 오름차순, 자동차 ID 내림차순
