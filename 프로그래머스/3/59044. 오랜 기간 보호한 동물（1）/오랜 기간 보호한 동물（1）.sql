-- 코드를 입력하세요
SELECT ai.name, ai.DATETIME
from animal_ins as ai left join animal_outs as ao on ai.ANIMAL_ID = ao.ANIMAL_ID
where ao.name is null and ai.name is not null
order by ai.DATETIME limit 3