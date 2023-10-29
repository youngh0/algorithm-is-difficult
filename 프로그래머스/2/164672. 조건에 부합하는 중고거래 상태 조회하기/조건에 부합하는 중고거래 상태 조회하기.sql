-- 코드를 입력하세요
SELECT BOARD_ID,WRITER_ID, TITLE,PRICE,
    case
        when STATUS like 'SALE' then '판매중'
        when STATUS like 'RESERVED' then '예약중'
        when STATUS like 'DONE' then '거래완료'
    end
from used_goods_board
where created_date like '2022-10-05'
order by board_id desc