-- 코드를 입력하세요
SELECT count(a.name)
from (
    select distinct(name)
    from animal_ins
    where name is not null
) a