# SOL1) JOIN
SELECT ins.NAME, ins.DATETIME
FROM ANIMAL_INS ins
    LEFT JOIN ANIMAL_OUTS outs
    ON ins.ANIMAL_ID = outs.ANIMAL_ID
WHERE outs.ANIMAL_ID IS NULL
ORDER BY DATETIME ASC
LIMIT 3;


# SOL2) IN
# SELECT NAME, DATETIME
# FROM ANIMAL_INS
# WHERE  ANIMAL_ID NOT IN (SELECT ANIMAL_ID FROM ANIMAL_OUTS)
# ORDER BY DATETIME ASC
# LIMIT 3;