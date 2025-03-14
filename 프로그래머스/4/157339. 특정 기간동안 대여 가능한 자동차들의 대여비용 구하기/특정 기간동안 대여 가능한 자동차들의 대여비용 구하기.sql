SELECT CAR_ID, CAR_TYPE, FEE
FROM 
(
    SELECT c.CAR_ID, c.CAR_TYPE,
        FLOOR((c.DAILY_FEE * (1 - IFNULL(d.DISCOUNT_RATE, 0) / 100.0)) * 30) AS FEE
    FROM CAR_RENTAL_COMPANY_CAR c
    LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN d
        ON c.CAR_TYPE = d.CAR_TYPE
        AND d.duration_type LIKE '30%'
    WHERE c.CAR_TYPE IN ('세단', 'SUV')
    AND c.CAR_ID NOT IN (
        SELECT DISTINCT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE START_DATE <= '2022-11-30' AND END_DATE >= '2022-11-01'
    )
) sub
WHERE FEE >= 500000 
AND FEE < 2000000