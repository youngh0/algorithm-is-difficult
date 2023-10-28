-- 코드를 입력하세요
SELECT product_code, sum(SALES_AMOUNT * price)  as sales
from OFFLINE_SALE left join product on product.product_id = OFFLINE_SALE.PRODUCT_ID
group by PRODUCT_CODE
order by sales desc, PRODUCT_CODE asc