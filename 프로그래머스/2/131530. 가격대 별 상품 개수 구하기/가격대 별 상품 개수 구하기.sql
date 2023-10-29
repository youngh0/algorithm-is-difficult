-- 코드를 입력하세요
SELECT truncate(price, -4) as price_group, count(product_id)
from product
group by price_group
order by price_group