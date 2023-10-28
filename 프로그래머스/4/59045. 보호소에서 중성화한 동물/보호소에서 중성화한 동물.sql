-- 코드를 입력하세요
SELECT ai.animal_id, ai.animal_type, ai.name
from ANIMAL_OUTS as ao left join ANIMAL_INS as ai on ao.animal_id = ai.animal_id
where ai.sex_upon_intake like 'intact%' and ao.SEX_UPON_OUTCOME not like 'intact%'