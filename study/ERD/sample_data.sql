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
values(1, 1, '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '장소명 1', '장소지번 1', '장소도로주소 1', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

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

--관리자 유저 생성:
insert into USERS(id, username, email, tel, nickname, admin_flag) values (1, 'admin', 'chljy33@naver.com', '010-6348-5375', 'admin', 1);

--샘플 유저:
insert into USERS(id, username, email, tel, nickname, admin_flag, sns_id, sns_profile, create_date, modify_date) values (2, 'a', 'a@naver.com', '010-1111-1111', '준이', 0, 'a_sns_id', 'a_profile', now(), now());
insert into USERS(id, username, email, tel, nickname, admin_flag, sns_id, sns_profile, create_date, modify_date) values (3, 'b', 'b@naver.com', '010-2222-2222', '열이', 0, 'b_sns_id', 'b_profile', now(), now());
insert into USERS(id, username, email, tel, nickname, admin_flag, sns_id, sns_profile, create_date, modify_date) values (4, 'c', 'c@naver.com', '010-3333-3333', '홍이', 0, 'c_sns_id', 'c_profile', now(), now());
insert into USERS(id, username, email, tel, nickname, admin_flag, sns_id, sns_profile, create_date, modify_date) values (5, 'd', 'd@naver.com', '010-4444-4444', '어이', 0, 'd_sns_id', 'd_profile', now(), now());
insert into USERS(id, username, email, tel, nickname, admin_flag, sns_id, sns_profile, create_date, modify_date) values (6, 'e', 'e@naver.com', '010-5555-5555', '호호', 0, 'e_sns_id', 'e_profile', now(), now());

select * from RESERVATION_USER_COMMENT;
delete from RESERVATION_USER_COMMENT;

--샘플 유저 한줄평:
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (1, 1, 2, 3.3, '코멘트1', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (2, 1, 3, 1.6, '코멘트2', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (3, 2, 4, 5.0, '코멘트3', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (4, 2, 5, 2.7, '코멘트4', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (5, 3, 6, 2.1, '코멘트5', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (6, 3, 2, 2.2, '코멘트6', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (7, 4, 3, 2.3, '코멘트7', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (8, 4, 4, 1.4, '코멘트8', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (9, 6, 5, 2.5, '코멘트9', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (10, 6, 6,3.6, '코멘트10', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (11, 7, 2, 4.7, '코멘트11', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (12, 7, 3, 3.8, '코멘트12', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (13, 8, 4, 2.9, '코멘트13', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (14, 8, 5, 1.1, '코멘트14', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (15, 9, 6, 3.2, '코멘트15', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (16, 9, 2, 3.5, '코멘트16', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (17, 10, 3, 4.3, '코멘트17', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (18, 1, 4, 5.0, '코멘트18', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (19, 2, 5, 3.5, '코멘트19', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (20, 3, 6, 2.3, '코멘트20', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (21, 3, 2, 1.5, '코멘트21', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (22, 4, 3, 3.2, '코멘트22', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (23, 4, 4, 0.5, '코멘트23', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (24, 1, 5, 2.5, '코멘트24', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (25, 1, 6, 3.5, '코멘트25', now(), now());
insert into RESERVATION_USER_COMMENT(id, product_id, user_id, score, comment, create_date, modify_date) values (26, 1, 2, 4.3, '코멘트26', now(), now());

select * from RESERVATION_USER_COMMENT;

select * from FILE;
 54       2 41vJnHaEi3L._SY355_.jpg                                                   C:\Users\jylee\Work\ReservationFiles\UserCommentsImages\2\122b200c-1429-4dd1-8812-24595799cadf       20466 image/jpeg                         0 2017-07-19 18:16:00.0 2017-07-19 18:16:00.0
 55       2 bleacher-creatures-nba-player-plush-derrick-rose-bulls-white-jersey-1.jpg C:\Users\jylee\Work\ReservationFiles\UserCommentsImages\2\84292a5d-6b3b-425d-b62f-07aa635a340d       25127 image/jpeg                         0 2017-07-19 18:16:00.0 2017-07-19 18:16:00.0
 56       3 Shy_Guy_(Mario).png                                                       C:\Users\jylee\Work\ReservationFiles\UserCommentsImages\3\29fceda1-e33f-440f-b8fe-05072ac6f682       73639 image/png                          0 2017-07-19 18:16:23.0 2017-07-19 18:16:23.0
 57       3 nbacartoons3-640x640.jpg                                                  C:\Users\jylee\Work\ReservationFiles\UserCommentsImages\3\b8c4a97f-0880-428e-bfd8-106929f60a59       48996 image/jpeg                         0 2017-07-19 18:16:23.0 2017-07-19 18:16:23.0
 58       4 7f15ae81154d4d2d83a3613b62cb96cd.jpg                                      C:\Users\jylee\Work\ReservationFiles\UserCommentsImages\4\39539186-d64a-4852-8e34-5cf13625f748       25643 image/jpeg                         0 2017-07-19 18:16:33.0 2017-07-19 18:16:33.0
 59       4 nintchdbpict000092527638.jpg                                              C:\Users\jylee\Work\ReservationFiles\UserCommentsImages\4\559b1bc9-86f4-4aca-bd34-6f814bbc8627       57596 image/jpeg                         0 2017-07-19 18:16:33.0 2017-07-19 18:16:33.0
 60       6 7f15ae81154d4d2d83a3613b62cb96cd.jpg                                      C:\Users\jylee\Work\ReservationFiles\UserCommentsImages\6\4785ab5e-1ea6-4f7c-9f1b-4b409fee3093       25643 image/jpeg                         0 2017-07-19 18:16:40.0 2017-07-19 18:16:40.0
 61       6 20140126_905919.jpg                                                       C:\Users\jylee\Work\ReservationFiles\UserCommentsImages\6\dd794a28-e6db-42b3-b99f-4fba4e699c4e       27433 image/jpeg                         0 2017-07-19 18:16:40.0 2017-07-19 18:16:40.0

select * from RESERVATION_USER_COMMENT;
 
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (1, 54);
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (1, 55);
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (1, 54);
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (1, 55);
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (2, 56);
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (2, 57);
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (2, 56);
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (2, 57);
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (3, 58);
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (3, 59);
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (3, 58);
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (3, 59);
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (4, 60);
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (6, 54);
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (6, 55);
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (6, 54);
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (7, );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (7, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (7, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (8, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (9, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (9, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (9, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (10, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (11, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (12, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (13, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (14, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (15, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (16, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (17, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (18, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (19, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (20, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (21, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (22, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (23, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (24, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (25, , );
insert into RESERVATION_USER_COMMENT_IMAGE(reservation_user_comment_id, file_id) values (26, , );
