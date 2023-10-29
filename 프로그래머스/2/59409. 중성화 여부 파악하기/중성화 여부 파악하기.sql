-- 코드를 입력하세요
SELECT animal_id, name,
    case 
        when SEX_UPON_INTAKE like 'intact%' then 'X'
        else 'O'
    end
from animal_ins
order by animal_id