with recursive hours as(
    select 0 as hour
    union all
    select hour + 1 from hours
    where hour < 23
)
# coalesce(count(name), 0)

select hour, ifnull(count(animal_id),0)
from hours left outer join animal_outs on hour = hour(datetime)
group by hour