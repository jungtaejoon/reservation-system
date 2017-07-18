select product.id, product.name, display_info.place_name, product_detail.content, product.category_id, product_image.file_id
from product 
join display_info on display_info.product_id=product.id 
join product_detail on product_detail.product_id=product.id
join product_image on product_image.product_id=product.id
GROUP BY product.id;