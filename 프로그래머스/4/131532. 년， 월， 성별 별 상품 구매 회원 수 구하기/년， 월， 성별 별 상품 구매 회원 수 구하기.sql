-- 코드를 입력하세요
SELECT YEAR(SALES_DATE), MONTH(SALES_DATE), gender, count(distinct(USER_INFO.user_id))
from ONLINE_SALE left join USER_INFO on USER_INFO.user_id = ONLINE_SALE.user_id
where USER_INFO.gender is not null
group by YEAR(SALES_DATE), MONTH(SALES_DATE), gender
order by YEAR(SALES_DATE), MONTH(SALES_DATE), gender