insert into CATEGORY(id, name) value (1,'전시');
insert into CATEGORY(id, name) value (2,'뮤지컬');
insert into CATEGORY(id, name) value (3,'콘서트');
insert into CATEGORY(id, name) value (4,'클래식');
insert into CATEGORY(id, name) value (5,'연극');

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(1, 1, '전시 1', '전시 1 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(2, 1, '전시 2', '전시 2 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(3, 2, '뮤지컬 1', '뮤지컬 1 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(4, 2, '뮤지컬 2', '뮤지컬 2 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(5, 3, '콘서트 1', '콘서트 1 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(6, 3, '콘서트 2', '콘서트 2 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(7, 3, '콘서트 3', '콘서트 3 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(8, 3, '콘서트 4', '콘서트 4 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(9, 3, '콘서트 5', '콘서트 5 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(10, 3, '콘서트 6', '콘서트 6 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(11, 4, '클래식 1', '클래식 1 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(12, 5, '연극 1', '연극 1 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(1, 1, '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '장소명 1', '장소지번 1', '서울 강남구 강남대로 382', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(2, 2, '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '장소명 2', '장소지번 2', '장소도로주소 2', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(3, 3, '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '장소명 3', '장소지번 3', '장소도로주소 3', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(4, 4, '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '장소명 4', '장소지번 4', '장소도로주소 4', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(5, 5, '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '장소명 5', '장소지번 5', '장소도로주소 5', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(6, 6, '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '장소명 6', '장소지번 6', '장소도로주소 6', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(7, 7, '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '장소명 7', '장소지번 7', '장소도로주소 7', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(8, 8, '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '장소명 8', '장소지번 8', '장소도로주소 8', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(9, 9, '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '장소명 9', '장소지번 9', '장소도로주소 9', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(10, 10, '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '장소명 10', '장소지번 10', '장소도로주소 10', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(11, 11, '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '장소명 11', '장소지번 11', '장소도로주소 11', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(12, 12, '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '장소명 12', '장소지번 12', '장소도로주소 12', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());




insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (1, 1, '상세정보 1', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (2, 2, '상세정보 2', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (3, 3, '상세정보 3', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (4, 4, '상세정보 4', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (5, 5, '상세정보 5', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (6, 6, '상세정보 6', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (7, 7, '상세정보 7', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (8, 8, '상세정보 8', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (9, 9, '상세정보 9', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (10, 10, '상세정보 10', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (11, 11, '상세정보 11', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (12, 12, '상세정보 12', now(), now());


insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 1, 1, 1, 5000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 2, 1, 2, 3000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 3, 1, 3, 1000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 4, 2, 1, 5000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 5, 2, 2, 3000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 6, 3, 1, 1000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 7, 4, 1, 3000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 8, 5, 1, 4000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 9, 6, 1, 9000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 10, 7, 1, 11000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 11, 8, 1, 12000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 12, 9, 1, 13000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 13, 10, 1, 14000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 14, 11, 1, 15000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 15, 12, 1, 16000, 0.1, now(), now());

insert into users(id , username, email, tel, nickname, sns_id, sns_type, sns_profile, admin_flag, create_date, modify_date) values(1, '부스트', 'boost@boost.com', '', '', '', '', '', 1, now(), now());
insert into users(id , username, email, tel, nickname, sns_id, sns_type, sns_profile, admin_flag, create_date, modify_date) values(2, '네이버', 'naver@naver.com', '010-1234-1234', 'naver', 'fb_naver', 'facebook',  '네이버입니다', 0, now(), now());
insert into users(id , username, email, tel, nickname, sns_id, sns_type, sns_profile, admin_flag, create_date, modify_date) values(3, '예약', 'reservation@reservation.com', '010-2345-2345', 'res', 'tw_res', 'twitter',  '예약입니다', 0, now(), now());
insert into users(id , username, email, tel, nickname, sns_id, sns_type, sns_profile, admin_flag, create_date, modify_date) values(4, '김', 'kim@kim.net', '010-3456-3456', 'kim', 'fb_kim', 'facebook', '김씨입니다', 0, now(), now());
insert into users(id , username, email, tel, nickname, sns_id, sns_type, sns_profile, admin_flag, create_date, modify_date) values(5, '민준', 'minjune@minjune.net', '010-4567-4567', 'minjune', 'twi_minjune', 'twitter', '민준이입니다', 0, now(), now());


insert into file(id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date) values( 1, 1, '전시1.jpg', 'c:\\boost\\images\\productImages\\62fae68c-d2b2-4ce1-af58-2454445ec68b', 152231, 'image/jpeg', 0, now(), now());
insert into file(id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date) values( 2, 1, '전시2.jpg', 'c:\\boost\\images\\productImages\\aa65b39d-561c-4c1e-80cb-6666efac5917', 308525, 'image/jpeg', 0, now(), now());
insert into file(id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date) values( 3, 1, '뮤지컬1.jpg', 'c:\\boost\\images\\productImages\\025d64a6-1a01-43c2-b943-5c7270c9aa75', 148036, 'image/jpeg', 0, now(), now());
insert into file(id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date) values( 4, 1, '뮤지컬2.jpg', 'c:\\boost\\images\\productImages\\7f65a326-3f83-488a-9af5-3755c1ab86a7', 554528, 'image/jpeg', 0, now(), now());
insert into file(id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date) values( 5, 1, '콘서트1.jpg', 'c:\\boost\\images\\productImages\\7322a6ad-2ddd-4fb3-94e8-a15dfe336b64', 103913, 'image/jpeg', 0, now(), now());
insert into file(id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date) values( 6, 1, '콘서트2.jpg', 'c:\\boost\\images\\productImages\\fa0686c7-5238-4525-86df-4d53fb8ade86', 51647, 'image/jpeg', 0, now(), now());
insert into file(id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date) values( 7, 1, '콘서트3.jpg', 'c:\\boost\\images\\productImages\\ef2634d2-1882-446c-bb3c-f510d5d535b4', 98196, 'image/jpeg', 0, now(), now());
insert into file(id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date) values( 8, 1, '콘서트4.jpg', 'c:\\boost\\images\\productImages\\70046ebb-7af3-4ada-8630-9dc8819d820d', 785916, 'image/jpeg', 0, now(), now());
insert into file(id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date) values( 9, 1, '콘서트5.jpg', 'c:\\boost\\images\\productImages\\2912e5cb-b6f0-4c59-8da7-33260f7f7d9a', 103350, 'image/jpeg', 0, now(), now());
insert into file(id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date) values( 10, 1, '콘서트6.jpg', 'c:\\boost\\images\\productImages\\a457341c-2b84-4c93-904a-ed53c202786f', 265383, 'image/jpeg', 0, now(), now());
insert into file(id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date) values( 11, 1, '클래식1.jpg', 'c:\\boost\\images\\productImages\\cb978f32-40f3-474b-ad44-f1aada338470', 8935, 'image/jpeg', 0, now(), now());
insert into file(id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date) values( 12, 1, '연극1.jpg', 'c:\\boost\\images\\productImages\\e858fab0-ab5a-4f28-a8da-06f50a7051e7', 27482, 'image/jpeg', 0, now(), now());

insert into file(id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date) values( 13, 1, '전시1후기이미지1.jpg', 'c:\\boost\\images\\productCommentImages\\4af88220-8a12-42dc-9c6a-25070a8ea8d5', 438134, 'image/jpeg', 0, now(), now());
insert into file(id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date) values( 14, 2, '전시1후기이미지2.jpg', 'c:\\boost\\images\\productCommentImages\\a7ef64c8-a25a-4be2-b730-9dd6fa7a787a', 534732, 'image/jpeg', 0, now(), now());
insert into file(id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date) values( 15, 3, '전시1후기이미지3.jpg', 'c:\\boost\\images\\productCommentImages\\c31bc522-9fb7-46db-b2c0-4cf15eab1752', 133116, 'image/jpeg', 0, now(), now());
insert into file(id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date) values( 16, 4, '전시1후기이미지4.jpg', 'c:\\boost\\images\\productCommentImages\\75c2e1d7-aecc-4687-9053-a657a404bbe8', 3115472, 'image/jpeg', 0, now(), now());
insert into file(id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date) values( 17, 5, '전시1후기이미지5.jpg', 'c:\\boost\\images\\productCommentImages\\4703cb4d-2dca-4966-bda7-d7307dce488b', 246059, 'image/jpeg', 0, now(), now());

insert into file(id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date) values( 18, 1, '전시3.jpg', 'c:\\boost\\images\\productCommentImages\\8d805baf-d44a-46e4-b627-77363a17add7', 517392, 'image/jpeg', 0, now(), now());
insert into file(id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date) values( 19, 1, '전시4.jpg', 'c:\\boost\\images\\productCommentImages\\417f8c3b-30db-47aa-89eb-bb54711c077e', 132445, 'image/jpeg', 0, now(), now());

insert into product_image(id, product_id, file_id, type) values(1, 1, 1, 1);
insert into product_image(id, product_id, file_id, type) values(2, 2, 2, 1);
insert into product_image(id, product_id, file_id, type) values(3, 3, 3, 1);
insert into product_image(id, product_id, file_id, type) values(4, 4, 4, 1);
insert into product_image(id, product_id, file_id, type) values(5, 5, 5, 1);
insert into product_image(id, product_id, file_id, type) values(6, 6, 6, 1);
insert into product_image(id, product_id, file_id, type) values(7, 7, 7, 1);
insert into product_image(id, product_id, file_id, type) values(8, 8, 8, 1);
insert into product_image(id, product_id, file_id, type) values(9, 9, 9, 1);
insert into product_image(id, product_id, file_id, type) values(10, 10, 10, 1);
insert into product_image(id, product_id, file_id, type) values(11, 11, 11, 1);
insert into product_image(id, product_id, file_id, type) values(12, 12, 12, 1);

insert into product_image(id, product_id, file_id, type) values(18, 1, 18, 0);
insert into product_image(id, product_id, file_id, type) values(19, 1, 19, 0);


insert into reservation_user_comment(id, product_id, user_id, score, comment, create_date, modify_date) values(1, 1, 1, 3.6, '그럭저럭 볼만하네요', now(), now());
insert into reservation_user_comment(id, product_id, user_id, score, comment, create_date, modify_date) values(2, 1, 2, 4.7, '너무 재밌었습니다. 한번 더 보고싶네요 가격대비 최고최고 짱짱맨!!!', now(), now());
insert into reservation_user_comment(id, product_id, user_id, score, comment, create_date, modify_date) values(3, 1, 3, 1.5, '이게 뭔지 싶네요 돈아까워요...', now(), now());
insert into reservation_user_comment(id, product_id, user_id, score, comment, create_date, modify_date) values(4, 1, 4, 4.0, '나쁘지 않군요', now(), now());
insert into reservation_user_comment(id, product_id, user_id, score, comment, create_date, modify_date) values(5, 1, 5, 3.0, '무난합니다.', now(), now());

insert into reservation_user_comment_image(id, reservation_user_comment_id, file_id) value(1, 1, 13);
insert into reservation_user_comment_image(id, reservation_user_comment_id, file_id) value(2, 2, 14);
insert into reservation_user_comment_image(id, reservation_user_comment_id, file_id) value(3, 3, 15);
insert into reservation_user_comment_image(id, reservation_user_comment_id, file_id) value(4, 4, 16);
insert into reservation_user_comment_image(id, reservation_user_comment_id, file_id) value(5, 5, 17);
