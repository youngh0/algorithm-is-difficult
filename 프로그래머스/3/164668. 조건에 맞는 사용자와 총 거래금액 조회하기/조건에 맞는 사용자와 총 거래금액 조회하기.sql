-- 코드를 입력하세요
SELECT uu.user_id, uu.nickname, sum(ub.price) as total_sales
from USED_GOODS_BOARD as ub left join USED_GOODS_USER as uu on  ub.WRITER_ID = uu.user_id
where ub.status = 'DONE'
group by ub.writer_id
having sum(price) >= 700000
order by total_sales