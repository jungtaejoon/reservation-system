use reservation_system;
drop table RESERVATION_USER_COMMENT_IMAGE;
drop table RESERVATION_USER_COMMENT;
drop table RESERVATION_INFO;
drop table PRODUCT_IMAGE;
drop table FILE;
drop table PRODUCT_PRICE;
drop table PRODUCT_DETAIL;
drop table DISPLAY_INFO;
drop table PRODUCT;
drop table CATEGORY;
drop table USERS;

-- naver  연동 로그인을 위한 USERS테이블  : https://developers.naver.com/docs/login/devguide/ 신규시스템 네아(네이버로그인)를 이용 부분을 참고함
CREATE  TABLE `USERS` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NULL ,
  `email` VARCHAR(100) NULL ,
  `tel` VARCHAR(50) NULL ,
  `nickname` VARCHAR(50) NULL ,
  `sns_id` VARCHAR(255) NULL ,
  `sns_type` varchar(10)  NULL,
  `sns_profile` varchar(255)  NULL,
  `admin_flag` INT NOT NULL,
  `create_date` DATETIME NULL ,
  `modify_date` DATETIME NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `idx1_username` (`username` ASC) ,
  INDEX `idx2_email` (`email` ASC),
  INDEX `idx3_sns_id` (`sns_id` ASC)
);

CREATE TABLE CATEGORY(
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY(`id`)
);


-- 상품 기본정보, 전시정보, 상세정보
-- 상품판매여부 : sales_flag - 0 : 판매안됨 1: 판매 됨
CREATE TABLE PRODUCT (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category_id` INT NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `description` VARCHAR(100) NULL,
  `sales_start` DATETIME NOT NULL,
  `sales_end` DATETIME NULL,
  `sales_flag` INT(1) NOT NULL,
  `event` VARCHAR(4000),
  `create_date` DATETIME,
  `modify_date` DATETIME,
  PRIMARY KEY(`id`),
  FOREIGN KEY(`category_id`) REFERENCES CATEGORY(`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE DISPLAY_INFO(
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `observation_time` VARCHAR(100) NOT NULL,
  `display_start` DATETIME NOT NULL,
  `display_end` DATETIME NOT NULL,
  `place_name` VARCHAR(50) NOT NULL,
  `place_lot` VARCHAR(100) ,
  `place_street` VARCHAR(100),
  `tel` VARCHAR(20) ,
  `homepage` VARCHAR(255),
  `email` VARCHAR(255),
  `create_date` DATETIME,
  `modify_date` DATETIME,
  PRIMARY KEY(`id`),
  FOREIGN KEY(`product_id`) REFERENCES PRODUCT(`id`) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE PRODUCT_DETAIL(
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `content` TEXT,
  `create_date` DATETIME,
  `modify_date` DATETIME,
  PRIMARY KEY(`id`),
  FOREIGN KEY(`product_id`) REFERENCES PRODUCT(`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

-- price_type : 1, 일반  2 :청소년 3: 어린이 , CODE 테이블이 사실 필요하다.
CREATE TABLE PRODUCT_PRICE (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `price_type` INT NOT NULL,
  `price` INT NOT NULL,
  `discount_rate` DECIMAL(5,2) NOT NULL,
  `create_date` DATETIME,
  `modify_date` DATETIME,
  PRIMARY KEY(`id`),
  FOREIGN KEY(`product_id`) REFERENCES PRODUCT(`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE FILE (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `file_name` VARCHAR(255) NOT NULL,
  `save_file_name` VARCHAR(4000) NOT NULL,
  `file_length` INT NOT NULL,
  `content_type` VARCHAR(255) NOT NULL,
  `delete_flag` INT(1) NOT NULL,
  `create_date` DATETIME,
  `modify_date` DATETIME,
  PRIMARY KEY(`id`),
  FOREIGN KEY(`user_id`) REFERENCES USERS(`id`)
);

-- type : 대표이미지 - 1 , 부가이미지 - 2
-- delete_flag 0 :삭제안됨, 1: 삭제된 이미지
CREATE TABLE PRODUCT_IMAGE (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `file_id` INT NOT NULL,
  `type` INT(1) NOT NULL,
  PRIMARY KEY(`id`),
  FOREIGN KEY(`product_id`) REFERENCES PRODUCT(`id`) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(`file_id`) REFERENCES FILE(`id`) ON UPDATE CASCADE ON DELETE CASCADE
);


-- 예약은 상품의 스냅샷을 저장하도록 할 것인가? 아니면 그냥 상품 id만을 가지도록 할 것인가?
CREATE TABLE RESERVATION_INFO(
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `general_ticket_count` INT,
  `youth_ticket_count` INT,
  `child_ticket_count` INT,
  `reservation_name` VARCHAR(50) NOT NULL,
  `reservation_tel` VARCHAR(255) NOT NULL,
  `reservation_email` VARCHAR(255) NOT NULL,
  `reservation_date` DATETIME NOT NULL,
  `reservation_type` INT,
  `create_date` DATETIME,
  `modify_date` DATETIME,
  PRIMARY KEY(`id`),
  FOREIGN KEY(`product_id`) REFERENCES PRODUCT(`id`) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(`user_id`) REFERENCES USERS(`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE RESERVATION_USER_COMMENT (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `score` DECIMAL(2,1) NOT NULL,
  `comment` TEXT NOT NULL,
  `create_date` DATETIME,
  `modify_date` DATETIME,
  PRIMARY KEY(`id`),
  FOREIGN KEY(`product_id`) REFERENCES PRODUCT(`id`) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(`user_id`) REFERENCES USERS(`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE RESERVATION_USER_COMMENT_IMAGE (
  `id` INT NOT NULL AUTO_INCREMENT,
  `reservation_user_comment_id` INT NOT NULL,
  `file_id` INT NOT NULL,
  PRIMARY KEY(`id`),
  FOREIGN KEY(`reservation_user_comment_id`) REFERENCES RESERVATION_USER_COMMENT(`id`) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(`file_id`) REFERENCES FILE(`id`) ON UPDATE CASCADE ON DELETE CASCADE
);



insert into CATEGORY(id, name) value (1,'전시');
insert into CATEGORY(id, name) value (2,'뮤지컬');
insert into CATEGORY(id, name) value (3,'콘서트');
insert into CATEGORY(id, name) value (4,'클래식');
insert into CATEGORY(id, name) value (5,'연극');

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(1, 1, '전시 1', '전시 1 - description', '2017-01-01 23:50:40', '2020-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(2, 1, '전시 2', '전시 2 - description', '2017-01-01 23:50:40', '2020-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(3, 2, '뮤지컬 1', '뮤지컬 1 - description', '2017-01-01 23:50:40', '2020-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(4, 2, '뮤지컬 2', '뮤지컬 2 - description', '2017-01-01 23:50:40', '2020-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(5, 3, '콘서트 1', '콘서트 1 - description', '2017-01-01 23:50:40', '2020-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(6, 3, '콘서트 2', '콘서트 2 - description', '2017-01-01 23:50:40', '2020-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(7, 3, '콘서트 3', '콘서트 3 - description', '2017-01-01 23:50:40', '2020-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(8, 3, '콘서트 4', '콘서트 4 - description', '2017-01-01 23:50:40', '2020-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(9, 3, '콘서트 5', '콘서트 5 - description', '2017-01-01 23:50:40', '2020-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(10, 3, '콘서트 6', '콘서트 6 - description', '2017-01-01 23:50:40', '2020-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(11, 4, '클래식 1', '클래식 1 - description', '2017-01-01 23:50:40', '2020-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(12, 4, '클래식 2', '클래식 2 - description', '2017-01-01 23:50:40', '2020-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(13, 4, '클래식 3', '클래식 3 - description', '2017-01-01 23:50:40', '2020-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(14, 4, '클래식 4', '클래식 4 - description', '2017-01-01 23:50:40', '2020-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(15, 5, '연극 1', '연극 1 - description', '2017-01-01 23:50:40', '2020-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(16, 5, '연극 2', '연극 2 - description', '2017-01-01 23:50:40', '2020-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(17, 5, '연극 3', '연극 3 - description', '2017-01-01 23:50:40', '2020-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(18, 5, '연극 4', '연극 4 - description', '2017-01-01 23:50:40', '2020-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(19, 5, '연극 5', '연극 5 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40',0, 'event 정보', now(), now() );

insert into PRODUCT(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date)
values(20, 2, '뮤지컬 3', '뮤지컬 3 - description', '2017-01-01 23:50:40', '2020-01-10 23:50:40', 1, 'event 정보', now(), now() );


insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(1, 1, '09:00-18:00', '2017-01-01 23:50:40', '2134-01-10 23:50:40', '장소명 1', '강남구 역삼동 825-11', '장소도로주소 1', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(2, 2, '09:00-18:00', '2017-01-01 23:50:40', '2134-01-10 23:50:40', '장소명 2', '장소지번 2', '장소도로주소 2', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(3, 3, '09:00-18:00', '2017-01-01 23:50:40', '2134-01-10 23:50:40', '장소명 3', '장소지번 3', '장소도로주소 3', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(4, 4, '09:00-18:00', '2017-01-01 23:50:40', '2134-01-10 23:50:40', '장소명 4', '장소지번 4', '장소도로주소 4', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

--insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
--values(5, 5, '09:00-18:00', '2017-01-01 23:50:40', '2134-01-10 23:50:40', '장소명 5', '장소지번 5', '장소도로주소 5', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(6, 6, '09:00-18:00', '2017-01-01 23:50:40', '2134-01-10 23:50:40', '장소명 6', '장소지번 6', '장소도로주소 6', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(7, 7, '09:00-18:00', '2017-01-01 23:50:40', '2134-01-10 23:50:40', '장소명 7', '장소지번 7', '장소도로주소 7', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(8, 8, '09:00-18:00', '2017-01-01 23:50:40', '2134-01-10 23:50:40', '장소명 8', '장소지번 8', '장소도로주소 8', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(9, 9, '09:00-18:00', '2017-01-01 23:50:40', '2118-01-10 23:50:40', '장소명 9', '장소지번 9', '장소도로주소 9', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(10, 10, '09:00-18:00', '2017-01-01 23:50:40', '2134-01-10 23:50:40', '장소명 10', '장소지번 10', '장소도로주소 10', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(11, 11, '09:00-18:00', '2017-01-01 23:50:40', '2134-01-10 23:50:40', '장소명 11', '장소지번 11', '장소도로주소 11', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(12, 12, '09:00-18:00', '2017-01-01 23:50:40', '2134-01-10 23:50:40', '장소명 12', '장소지번 12', '장소도로주소 12', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(13, 13, '09:00-18:00', '2017-01-01 23:50:40', '2134-01-10 23:50:40', '장소명 13', '장소지번 13', '장소도로주소 13', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(14, 14, '09:00-18:00', '2017-01-01 23:50:40', '2134-01-10 23:50:40', '장소명 14', '장소지번 14', '장소도로주소 14', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(15, 15, '09:00-18:00', '2017-01-01 23:50:40', '2134-01-10 23:50:40', '장소명 15', '장소지번 15', '장소도로주소 15', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(16, 16, '09:00-18:00', '2017-01-01 23:50:40', '2134-01-10 23:50:40', '장소명 16', '장소지번 16', '장소도로주소 16', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(17, 17, '09:00-18:00', '2017-01-01 23:50:40', '2118-01-10 23:50:40', '장소명 17', '장소지번 17', '장소도로주소 17', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(18, 18, '09:00-18:00', '2017-01-01 23:50:40', '2134-01-10 23:50:40', '장소명 18', '장소지번 18', '장소도로주소 18', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(19, 19, '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '장소명 19', '장소지번 19', '장소도로주소 19', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());

insert into DISPLAY_INFO(id, product_id, observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date)
values(20, 20, '09:00-18:00', '2017-01-01 23:50:40', '2134-01-10 23:50:40', '장소명 20', '장소지번 20', '장소도로주소 20', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', now(), now());


insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (1, 1, '상세정보 1', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (2, 2, '상세정보 2', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (3, 3, '상세정보 3', now(), now());
--insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (4, 4, '상세정보 4', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (5, 5, '상세정보 5', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (6, 6, '상세정보 6', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (7, 7, '상세정보 7', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (8, 8, '상세정보 8', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (9, 9, '상세정보 9', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (10, 10, '상세정보 10', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (11, 11, '상세정보 11', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (12, 12, '상세정보 12', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (13, 13, '상세정보 13', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (14, 14, '상세정보 14', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (15, 15, '상세정보 15', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (16, 16, '상세정보 16', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (17, 17, '상세정보 17', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (18, 18, '상세정보 18', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (19, 19, '상세정보 19', now(), now());
insert into PRODUCT_DETAIL(id, product_id, content, create_date, modify_date) values (20, 20, '상세정보 20', now(), now());

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
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 16, 12, 1, 3000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 17, 13, 1, 3000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 18, 13, 1, 4000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 19, 14, 1, 9000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 20, 14, 1, 11000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 21, 15, 1, 12000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 22, 16, 1, 13000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 23, 17, 1, 14000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 24, 18, 1, 15000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 25, 19, 1, 16000, 0.1, now(), now());
insert into PRODUCT_PRICE(id, product_id, price_type, price, discount_rate, create_date, modify_date) values( 26, 20, 1, 18000, 0.1, now(), now());


-- From SeYeong
insert into USERS (id, username, email, tel, nickname, sns_id, sns_type, sns_profile, admin_flag, create_date, modify_date)
values (id, 'username 1' , 'email 1', 'tel 1', 'nickname 1', 'sns_id 1', 'sns_type 1', 'sns_profile 1', 1, now(), now());
insert into USERS (id, username, email, tel, nickname, sns_id, sns_type, sns_profile, admin_flag, create_date, modify_date)
values (id, 'username 2' , 'email 2', 'tel 2', 'nickname 2', 'sns_id 2', 'sns_type 2', 'sns_profile 2', 0, now(), now());
insert into USERS (id, username, email, tel, nickname, sns_id, sns_type, sns_profile, admin_flag, create_date, modify_date)
values (id, 'username 3' , 'email 3', 'tel 3', 'nickname 3', 'sns_id 3', 'sns_type 3', 'sns_profile 3', 0, now(), now());
insert into USERS (id, username, email, tel, nickname, sns_id, sns_type, sns_profile, admin_flag, create_date, modify_date)
values (id, 'username 4' , 'email 4', 'tel 4', 'nickname 4', 'sns_id 4', 'sns_type 4', 'sns_profile 4', 0, now(), now());
insert into USERS (id, username, email, tel, nickname, sns_id, sns_type, sns_profile, admin_flag, create_date, modify_date)
values (id, 'username 5' , 'email 5', 'tel 5', 'nickname 5', 'sns_id 5', 'sns_type 5', 'sns_profile 5', 0, now(), now());
insert into USERS (id, username, email, tel, nickname, sns_id, sns_type, sns_profile, admin_flag, create_date, modify_date)
values (id, 'username 6' , 'email 6', 'tel 6', 'nickname 6', 'sns_id 6', 'sns_type 6', 'sns_profile 6', 0, now(), now());


insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(1, 1, 'file_name 1', 'http://naverbooking.phinf.naver.net/20170704_132/1499148450612FVOIS_JPEG/1242x1242px.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(2, 1, 'file_name 2', 'http://naverbooking.phinf.naver.net/20170522_241/1495440584399410KY_JPEG/%C5%E4%B5%E5_%B3%D7%C0%CC%B9%F6_%B9%E8%B3%CA_1242x1242.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(3, 1, 'file_name 3', 'http://naverbooking.phinf.naver.net/20170518_66/1495070751156YzEN8_JPEG/resized_tate_poster_01-2.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(4, 1, 'file_name 4', 'https://ssl.phinf.net/naverbooking/20170303_271/1488514705030TuUK4_JPEG/17%B5%E5%B8%B2%B0%C9%C1%EE_%B8%DE%C0%CE%C6%F7%BD%BA%C5%CD_%C3%D6%C1%BE.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(5, 1, 'file_name 5', 'https://ssl.phinf.net/naverbooking/20170111_195/1484112206459rGQGI_JPEG/%BB%F3%BC%BC%C6%E4%C0%CC%C1%F6_%BB%F3%B4%DC%28%B3%D7%C0%CC%B9%F6_%BF%B9%BE%E0%29.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(6, 1, 'file_name 6', 'https://ssl.phinf.net/naverbooking/20170119_135/1484789767866RPO6o_JPEG/%B7%CE%B9%CC%BF%C0%C1%D9%B8%AE%BF%A7_1242.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(7, 1, 'file_name 7', 'https://ssl.phinf.net/naverbooking/20170111_225/1484116579024rNkXW_JPEG/2016_%B9%C2%C1%F6%C4%C3_%C0%CE_%B4%F5_%C7%CF%C0%CC%C3%F7_%C6%F7%BD%BA%C5%CD%2820MB%29.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(8, 1, 'file_name 8', 'http://naverbooking.phinf.naver.net/20170704_132/1499148450612FVOIS_JPEG/1242x1242px.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(9, 1, 'file_name 9', 'http://naverbooking.phinf.naver.net/20170522_241/1495440584399410KY_JPEG/%C5%E4%B5%E5_%B3%D7%C0%CC%B9%F6_%B9%E8%B3%CA_1242x1242.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(10, 1, 'file_name 10', 'http://naverbooking.phinf.naver.net/20170518_66/1495070751156YzEN8_JPEG/resized_tate_poster_01-2.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(11, 1, 'file_name 11', 'http://naverbooking.phinf.naver.net/20170319_199/148984980736207XEa_JPEG/%B3%D7%C0%CC%B9%F6_%BF%B9%BE%E0_%B4%EB%C7%A5_%BB%E7%C0%CC%C1%EE-01.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(12, 1, 'file_name 12', 'https://ssl.phinf.net/naverbooking/20170303_271/1488514705030TuUK4_JPEG/17%B5%E5%B8%B2%B0%C9%C1%EE_%B8%DE%C0%CE%C6%F7%BD%BA%C5%CD_%C3%D6%C1%BE.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(13, 1, 'file_name 13', 'https://ssl.phinf.net/naverbooking/20170111_195/1484112206459rGQGI_JPEG/%BB%F3%BC%BC%C6%E4%C0%CC%C1%F6_%BB%F3%B4%DC%28%B3%D7%C0%CC%B9%F6_%BF%B9%BE%E0%29.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(14, 1, 'file_name 14', 'https://ssl.phinf.net/naverbooking/20170119_135/1484789767866RPO6o_JPEG/%B7%CE%B9%CC%BF%C0%C1%D9%B8%AE%BF%A7_1242.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(15, 1, 'file_name 15', 'https://ssl.phinf.net/naverbooking/20170111_225/1484116579024rNkXW_JPEG/2016_%B9%C2%C1%F6%C4%C3_%C0%CE_%B4%F5_%C7%CF%C0%CC%C3%F7_%C6%F7%BD%BA%C5%CD%2820MB%29.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(16, 1, 'file_name 16', 'https://ssl.phinf.net/naverbooking/20170303_271/1488514705030TuUK4_JPEG/17%B5%E5%B8%B2%B0%C9%C1%EE_%B8%DE%C0%CE%C6%F7%BD%BA%C5%CD_%C3%D6%C1%BE.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(17, 1, 'file_name 17', 'https://ssl.phinf.net/naverbooking/20170111_195/1484112206459rGQGI_JPEG/%BB%F3%BC%BC%C6%E4%C0%CC%C1%F6_%BB%F3%B4%DC%28%B3%D7%C0%CC%B9%F6_%BF%B9%BE%E0%29.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(18, 1, 'file_name 18', 'https://ssl.phinf.net/naverbooking/20170119_135/1484789767866RPO6o_JPEG/%B7%CE%B9%CC%BF%C0%C1%D9%B8%AE%BF%A7_1242.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(19, 1, 'file_name 19', 'https://ssl.phinf.net/naverbooking/20170111_225/1484116579024rNkXW_JPEG/2016_%B9%C2%C1%F6%C4%C3_%C0%CE_%B4%F5_%C7%CF%C0%CC%C3%F7_%C6%F7%BD%BA%C5%CD%2820MB%29.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(20, 1, 'file_name 20', 'https://ssl.phinf.net/naverbooking/20170111_225/1484116579024rNkXW_JPEG/2016_%B9%C2%C1%F6%C4%C3_%C0%CE_%B4%F5_%C7%CF%C0%CC%C3%F7_%C6%F7%BD%BA%C5%CD%2820MB%29.jpg?type=l591_945', 20, 'jpg', 0, now(),now());





insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(101, 1, 'file_name 101', 'http://naverbooking.phinf.naver.net/20170209_66/1486628146913la6nC_JPEG/image.jpg', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(102, 1, 'file_name 102', 'http://naverbooking.phinf.naver.net/20170119_48/1484802596907hmVDm_JPEG/image.jpg', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(103, 1, 'file_name 103', 'http://naverbooking.phinf.naver.net/20170714_239/1500010726574qVoiA_JPEG/image.jpg', 20, 'jpg', 0, now(),now());


insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(21, 1, 'file_name 21', 'http://naverbooking.phinf.naver.net/20170319_199/148984980736207XEa_JPEG/%B3%D7%C0%CC%B9%F6_%BF%B9%BE%E0_%B4%EB%C7%A5_%BB%E7%C0%CC%C1%EE-01.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(22, 1, 'file_name 22', 'https://ssl.phinf.net/naverbooking/20170303_271/1488514705030TuUK4_JPEG/17%B5%E5%B8%B2%B0%C9%C1%EE_%B8%DE%C0%CE%C6%F7%BD%BA%C5%CD_%C3%D6%C1%BE.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(23, 1, 'file_name 23', 'https://ssl.phinf.net/naverbooking/20170111_195/1484112206459rGQGI_JPEG/%BB%F3%BC%BC%C6%E4%C0%CC%C1%F6_%BB%F3%B4%DC%28%B3%D7%C0%CC%B9%F6_%BF%B9%BE%E0%29.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(24, 1, 'file_name 24', 'https://ssl.phinf.net/naverbooking/20170119_135/1484789767866RPO6o_JPEG/%B7%CE%B9%CC%BF%C0%C1%D9%B8%AE%BF%A7_1242.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(25, 1, 'file_name 25', 'https://ssl.phinf.net/naverbooking/20170111_225/1484116579024rNkXW_JPEG/2016_%B9%C2%C1%F6%C4%C3_%C0%CE_%B4%F5_%C7%CF%C0%CC%C3%F7_%C6%F7%BD%BA%C5%CD%2820MB%29.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(26, 1, 'file_name 26', 'https://ssl.phinf.net/naverbooking/20170303_271/1488514705030TuUK4_JPEG/17%B5%E5%B8%B2%B0%C9%C1%EE_%B8%DE%C0%CE%C6%F7%BD%BA%C5%CD_%C3%D6%C1%BE.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(27, 1, 'file_name 27', 'https://ssl.phinf.net/naverbooking/20170111_195/1484112206459rGQGI_JPEG/%BB%F3%BC%BC%C6%E4%C0%CC%C1%F6_%BB%F3%B4%DC%28%B3%D7%C0%CC%B9%F6_%BF%B9%BE%E0%29.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(28, 1, 'file_name 28', 'https://ssl.phinf.net/naverbooking/20170119_135/1484789767866RPO6o_JPEG/%B7%CE%B9%CC%BF%C0%C1%D9%B8%AE%BF%A7_1242.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(29, 1, 'file_name 29', 'https://ssl.phinf.net/naverbooking/20170111_225/1484116579024rNkXW_JPEG/2016_%B9%C2%C1%F6%C4%C3_%C0%CE_%B4%F5_%C7%CF%C0%CC%C3%F7_%C6%F7%BD%BA%C5%CD%2820MB%29.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(30, 1, 'file_name 30', 'https://ssl.phinf.net/naverbooking/20170111_225/1484116579024rNkXW_JPEG/2016_%B9%C2%C1%F6%C4%C3_%C0%CE_%B4%F5_%C7%CF%C0%CC%C3%F7_%C6%F7%BD%BA%C5%CD%2820MB%29.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(31, 1, 'file_name 31', 'http://naverbooking.phinf.naver.net/20170704_132/1499148450612FVOIS_JPEG/1242x1242px.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(32, 1, 'file_name 32', 'http://naverbooking.phinf.naver.net/20170522_241/1495440584399410KY_JPEG/%C5%E4%B5%E5_%B3%D7%C0%CC%B9%F6_%B9%E8%B3%CA_1242x1242.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(33, 1, 'file_name 33', 'http://naverbooking.phinf.naver.net/20170518_66/1495070751156YzEN8_JPEG/resized_tate_poster_01-2.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(34, 1, 'file_name 34', 'https://ssl.phinf.net/naverbooking/20170303_271/1488514705030TuUK4_JPEG/17%B5%E5%B8%B2%B0%C9%C1%EE_%B8%DE%C0%CE%C6%F7%BD%BA%C5%CD_%C3%D6%C1%BE.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(35, 1, 'file_name 35', 'https://ssl.phinf.net/naverbooking/20170111_195/1484112206459rGQGI_JPEG/%BB%F3%BC%BC%C6%E4%C0%CC%C1%F6_%BB%F3%B4%DC%28%B3%D7%C0%CC%B9%F6_%BF%B9%BE%E0%29.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(36, 1, 'file_name 36', 'https://ssl.phinf.net/naverbooking/20170119_135/1484789767866RPO6o_JPEG/%B7%CE%B9%CC%BF%C0%C1%D9%B8%AE%BF%A7_1242.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(37, 1, 'file_name 37', 'https://ssl.phinf.net/naverbooking/20170111_225/1484116579024rNkXW_JPEG/2016_%B9%C2%C1%F6%C4%C3_%C0%CE_%B4%F5_%C7%CF%C0%CC%C3%F7_%C6%F7%BD%BA%C5%CD%2820MB%29.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(38, 1, 'file_name 38', 'http://naverbooking.phinf.naver.net/20170704_132/1499148450612FVOIS_JPEG/1242x1242px.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(39, 1, 'file_name 39', 'http://naverbooking.phinf.naver.net/20170522_241/1495440584399410KY_JPEG/%C5%E4%B5%E5_%B3%D7%C0%CC%B9%F6_%B9%E8%B3%CA_1242x1242.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(40, 1, 'file_name 40', 'http://naverbooking.phinf.naver.net/20170518_66/1495070751156YzEN8_JPEG/resized_tate_poster_01-2.jpg?type=l591_945', 20, 'jpg', 0, now(),now());


insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(201, 2, 'file_name 201', 'http://naverbooking.phinf.naver.net/20170306_3/1488772023601A4195_JPEG/image.jpg?type=f300_300', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(202, 2, 'file_name 202', 'http://naverbooking.phinf.naver.net/20170306_3/1488772023601A4195_JPEG/image.jpg?type=f300_300', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(203, 2, 'file_name 203', 'http://naverbooking.phinf.naver.net/20170306_3/1488772023601A4195_JPEG/image.jpg?type=f300_300', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(204, 3, 'file_name 39', 'http://naverbooking.phinf.naver.net/20170522_241/1495440584399410KY_JPEG/%C5%E4%B5%E5_%B3%D7%C0%CC%B9%F6_%B9%E8%B3%CA_1242x1242.jpg?type=l591_945', 20, 'jpg', 0, now(),now());
insert into FILE (id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)
values(205, 3, 'file_name 40', 'http://naverbooking.phinf.naver.net/20170518_66/1495070751156YzEN8_JPEG/resized_tate_poster_01-2.jpg?type=l591_945', 20, 'jpg', 0, now(),now());

-- type: { 1:대표이미지, 2:부가이미지, 3:메인상단프로모션 이미지}

insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(1, 1, 1, 1);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(2, 2, 2, 1);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(3, 3, 3, 1);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(4, 4, 4, 1);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(5, 5, 5, 1);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(6, 6, 6, 1);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(7, 7, 7, 1);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(8, 8, 8, 1);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(9, 9, 9, 1);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(10, 10, 10, 1);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(11, 11, 11, 1);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(12, 12, 12, 1);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(13, 13, 13, 1);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(14, 14, 14, 1);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(15, 15, 15, 1);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(16, 16, 16, 1);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(17, 17, 17, 1);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(18, 18, 18, 1);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(19, 19, 19, 1);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(20, 20, 20, 1);

insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(21, 1, 21, 2);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(22, 2, 22, 2);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(23, 3, 23, 2);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(24, 1, 24, 2);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(25, 1, 25, 2);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(26, 6, 26, 2);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(27, 7, 27, 2);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(28, 8, 28, 2);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(29, 9, 29, 2);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(30, 10, 30, 2);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(31, 11, 31, 2);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(32, 12, 32, 2);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(33, 13, 33, 2);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(34, 14, 34, 2);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(35, 15, 35, 2);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(36, 16, 36, 2);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(37, 17, 37, 2);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(38, 18, 38, 2);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(39, 19, 39, 2);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(40, 20, 40, 2);



insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(101, 1, 101, 3);
insert into PRODUCT_IMAGE (id, product_id, file_id, type) 
values(102, 2, 102, 3);
insert into PRODUCT_IMAGE (id, product_id, file_id, type)
values(103, 3, 103, 3);





insert into reservation_user_comment ( id, product_id, user_id, score, comment, create_date, modify_date )
values ( 11, 1, 2, '4.9', "코멘트 1-1", '2017-01-01 23:50:40', '2017-01-10 23:50:40' );
insert into reservation_user_comment ( id, product_id, user_id, score, comment, create_date, modify_date )
values ( 12, 1, 3, '3.9', "코멘트 1-2", '2017-01-02 23:50:40', '2017-01-10 23:50:40' );
insert into reservation_user_comment ( id, product_id, user_id, score, comment, create_date, modify_date )
values ( 13, 1, 4, '2.9', "코멘트 1-3", '2017-01-02 23:50:40', '2017-01-10 23:50:40' );
insert into reservation_user_comment ( id, product_id, user_id, score, comment, create_date, modify_date )
values ( 21, 2, 2, '4.4', "코멘트 2-1", '2017-01-01 23:50:40', '2017-01-10 23:50:40' );
insert into reservation_user_comment ( id, product_id, user_id, score, comment, create_date, modify_date )
values ( 22, 2, 3, '3.4', "코멘트 2-2", '2017-01-02 23:50:40', '2017-01-10 23:50:40' );
insert into reservation_user_comment ( id, product_id, user_id, score, comment, create_date, modify_date )
values ( 23, 2, 4, '2.4', "코멘트 2-3", '2017-01-02 23:50:40', '2017-01-10 23:50:40' );


insert into reservation_user_comment_image ( id, reservation_user_comment_id, file_id) values ( 1, 11, 201);
insert into reservation_user_comment_image ( id, reservation_user_comment_id, file_id) values ( 2, 11, 202);
insert into reservation_user_comment_image ( id, reservation_user_comment_id, file_id) values ( 3, 11, 203);

insert into reservation_user_comment_image ( id, reservation_user_comment_id, file_id) values ( 4, 12, 204);
insert into reservation_user_comment_image ( id, reservation_user_comment_id, file_id) values ( 5, 12, 205);



-- 통계, 대표이미지 컬럼 추가.

alter table product
add column `avg_score` DECIMAL(2,1) DEFAULT 0,
add column `comment_count` INT DEFAULT 0;

update product p1
set avg_score = (select avg(score) from reservation_user_comment
    group by product_id having product_id = p1.id),
    comment_count = (select count(*) from reservation_user_comment
    group by product_id having product_id = p1.id);


alter table reservation_user_comment
add column `image_count` INT DEFAULT 0,
add column `first_image_save_file_name` VARCHAR(4000);


update reservation_user_comment
set image_count = (select count(*) from reservation_user_comment_image group by reservation_user_comment_id 
    having reservation_user_comment_id = reservation_user_comment.id),
    
    first_image_save_file_name = ( select save_file_name from reservation_user_comment_image t1 inner join file t2 on t1.file_id = t2.id group by reservation_user_comment_id 
    having reservation_user_comment_id = reservation_user_comment.id);


alter table users 
add column naver_id INT NULL;

alter table users 
modify column admin_flag INT NOT NULL DEFAULT 0;

