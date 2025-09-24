-- 코드를 입력하세요
-- 진료과가 CS이거나 GS인 의사 이름, ID, 진료과, 고용일자
-- 고용일자 기준 내림차순 정렬, 이름 오름차순
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') AS HIRE_YMD
FROM DOCTOR 
WHERE MCDP_CD = 'CS' OR MCDP_CD = 'GS' 
ORDER BY HIRE_YMD DESC, DR_NAME ASC