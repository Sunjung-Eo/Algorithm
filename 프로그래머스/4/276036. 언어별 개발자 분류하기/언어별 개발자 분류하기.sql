SELECT GRADE, ID, EMAIL
FROM (
    SELECT 
        D.ID,
        D.EMAIL,
        CASE
            WHEN SUM(SC.NAME = 'Python') > 0 
                 AND SUM(SC.CATEGORY = 'Front End') > 0 THEN 'A'
            WHEN SUM(SC.NAME = 'C#') > 0 THEN 'B'
            WHEN SUM(SC.CATEGORY = 'Front End') > 0 THEN 'C'
        END AS GRADE
    FROM DEVELOPERS D
    JOIN SKILLCODES SC 
      ON D.SKILL_CODE & SC.CODE != 0 
    GROUP BY D.ID, D.EMAIL
) AS T
WHERE GRADE IS NOT NULL
ORDER BY GRADE, ID;
