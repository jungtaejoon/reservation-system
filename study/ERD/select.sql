select product.id, product.name, display_info.place_name, product_detail.content, product.category_id, product_image.file_id
from product 
join display_info on display_info.product_id=product.id 
join product_detail on product_detail.product_id=product.id
join product_image on product_image.product_id=product.idS
GROUP BY product.id;

select pi.id, pi.product_id, pi.file_id, f.user_id, pi.type, f.file_name, f.save_file_name
from PRODUCT_IMAGE pi
join file f on f.id=pi.file_id
join product p on p.id=pi.product_id
where product_id=1




select ruci.id, ruc.user_id, ruci.file_id, f.file_name, f.save_file_name, f.file_length, f.content_type, f.delete_flag, f.create_date, f.modify_date
from RESERVATION_USER_COMMENT_IMAGE ruci
join RESERVATION_USER_COMMENT ruc on ruc.id=ruci.reservation_user_comment_id
join FILE f on f.id=ruci.file_id
where ruc.product_id=1 AND ruci.reservation_user_comment_id=1;


select ruci.id, ruc.user_id, ruci.file_id, f.file_name, f.save_file_name, f.file_length, f.content_type, f.delete_flag, f.create_date, f.modify_date
from RESERVATION_USER_COMMENT_IMAGE ruci
right outer join RESERVATION_USER_COMMENT ruc on ruc.id=ruci.reservation_user_comment_id
right outer join FILE f on f.id=ruci.file_id
where ruc.product_id=1 AND ruci.reservation_user_comment_id=1;

select ruc.id, ruc.user_id, ruc.score, ruc.comment, count(1) as imgcount, ruci.file_id from reservation_user_comment ruc
left outer join reservation_user_comment_image ruci on ruci.reservation_user_comment_id=ruc.id 
where ruc.product_id=1
group by ruc.id;

select sum(score)
from reservation_user_comment
where product_id=1

select ruc.id, ruc.user_id, ruci.file_id, f.file_name from reservation_user_comment ruc
join reservation_user_comment_image ruci on ruci.reservation_user_comment_id=ruc.id 
join file f on f.id=ruci.file_id
where ruc.id=3;


select id, username, email, tel, nickname, sns_id, sns_type, sns_profile, 
create_date, modify_date from users;