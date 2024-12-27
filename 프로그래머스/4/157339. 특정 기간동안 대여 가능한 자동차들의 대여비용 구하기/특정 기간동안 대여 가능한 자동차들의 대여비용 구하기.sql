
SELECT D.CAR_ID, D.CAR_TYPE, CAST(D.DAILY_FEE * (1 -(C.DISCOUNT_RATE * 0.01)) * 30 AS SIGNED) AS FEE
FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS C
INNER JOIN (SELECT DISTINCT B.CAR_ID, B.DAILY_FEE, B.CAR_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS A   
RIGHT OUTER JOIN CAR_RENTAL_COMPANY_CAR  AS B
ON A.CAR_ID = B.CAR_ID
WHERE (B.CAR_TYPE IN ('SUV','세단'))
AND (A.START_DATE IS NULL) OR B.CAR_ID NOT IN (select CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE END_DATE >= '2022-11-01'
    AND START_DATE < '2022-12-01') ) AS D
ON C.CAR_TYPE  = D.CAR_TYPE
WHERE C.DURATION_TYPE like ("%30%")
AND D.DAILY_FEE * (1 -(C.DISCOUNT_RATE * 0.01)) *30 >= 500000
AND D.DAILY_FEE * (1 -(C.DISCOUNT_RATE * 0.01)) *30 < 2000000
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC;
