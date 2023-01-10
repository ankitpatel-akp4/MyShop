

drop database myshop; 

create database myshop;

use myshop;
show tables;

create table users(
user_id bigint primary key auto_increment,
email varchar(50) unique not null,
mobile_no varchar(20) unique,
username varchar(50) unique not null,
first_name varchar(25) not null,
last_name varchar(25),
roles varchar(100) not null,
password varchar(100) not null,
account_non_expired boolean not null,
account_non_locked boolean not null,
credentials_non_expired boolean not null,
enabled boolean not null
);

select * from users;

-- drop table users;  



create table country(
country_id smallint primary key,
country_name varchar(25)
);


create table address(
address_id bigint primary key auto_increment,
house_number varchar(15),
street_number varchar(15),
address_line1 varchar(100),
address_line2 varchar(100),
city varchar(20),
region varchar(20),
postal_code varchar(20),
is_default boolean,
country_id smallint,
FOREIGN KEY (country_id) REFERENCES country(country_id) on update cascade on delete cascade
);

select * from address;

-- drop table address;

create table users_address(
user_id bigint,
address_id bigint,
FOREIGN KEY (user_id) REFERENCES users(user_id) on update cascade on delete cascade,
FOREIGN KEY (address_id) REFERENCES address(address_id) on update cascade on delete cascade
);


desc users_address;

create table category(
 category_id int primary key auto_increment,
 parent_category_id int,
 category_name varchar(100),
 FOREIGN KEY (parent_category_id) REFERENCES category(category_id) on update cascade on delete cascade
 
);

-- drop table category;

create table product(
product_id bigint primary key auto_increment,
category_id int,
product_name varchar(100),
description varchar(1000),
product_image varchar(250),
FOREIGN KEY (category_id) REFERENCES category(category_id) on update cascade on delete cascade
);

create table variation(
variation_id bigint primary key auto_increment,
category_id int,
variation_name varchar(100),
FOREIGN KEY (category_id) REFERENCES category(category_id) on update cascade on delete cascade
);

create table variation_value(
variation_value_id bigint primary key auto_increment,
variation_id bigint,
value varchar(100),
FOREIGN KEY (variation_id) REFERENCES variation(variation_id) on update cascade on delete cascade
);

create table variation_value_num(
variation_value_num_id bigint primary key auto_increment,
variation_id bigint,
value double,
FOREIGN KEY (variation_id) REFERENCES variation(variation_id) on update cascade on delete cascade
);

create table product_item(
product_item_id bigint primary key auto_increment,
product_id bigint,
sku varchar(50),
qty_in_stock bigint,
product_item_image varchar(250),
sale_price double,
market_price double,
FOREIGN KEY (product_id) REFERENCES product(product_id) on update cascade on delete cascade
);

-- drop table product_item;

create table product_config(
product_item_id bigint,
variation_value_id bigint,
FOREIGN KEY (variation_value_id) REFERENCES variation_value(variation_value_id) on update cascade on delete cascade,
FOREIGN KEY (product_item_id) REFERENCES product_item(product_item_id) on update cascade on delete cascade
);

create table product_config_num(
product_item_id bigint,
variation_value_num_id bigint,
FOREIGN KEY (variation_value_num_id) REFERENCES variation_value_num(variation_value_num_id) on update cascade on delete cascade,
FOREIGN KEY (product_item_id) REFERENCES product_item(product_item_id) on update cascade on delete cascade
);

create table promotion(
promotion_id bigint primary key auto_increment,
promotion_name varchar(100),
description varchar(500),
discount_rate float,
start_date_time datetime,
end_date_time datetime
);

create table category_promotion(
category_id int,
promotion_id bigint,
FOREIGN KEY (category_id) REFERENCES category(category_id) on update cascade on delete cascade,
FOREIGN KEY (promotion_id) REFERENCES promotion(promotion_id) on update cascade on delete cascade
);

create table shoping_cart(
shoping_cart_id bigint primary key auto_increment,
user_id bigint,
FOREIGN KEY (user_id) REFERENCES users(user_id) on update cascade on delete cascade
);

create table shoping_cart_item(
shoping_cart_item_id bigint primary key auto_increment,
shoping_cart_id bigint,
product_item_id bigint,
FOREIGN KEY (shoping_cart_id) REFERENCES shoping_cart(shoping_cart_id) on update cascade on delete cascade,
FOREIGN KEY (product_item_id) REFERENCES product_item(product_item_id) on update cascade on delete cascade
);

create table payment_type(
payment_type_id smallint primary key auto_increment,
value varchar(15)
);


create table payment_method(
payment_method_id bigint primary key auto_increment,
user_id bigint,
payment_type_id smallint,
provider varchar(25),
account_number varchar(25),
expiry_date date,
is_default boolean,
FOREIGN KEY (user_id) REFERENCES users(user_id) on update cascade on delete cascade,
FOREIGN KEY (payment_type_id) REFERENCES payment_type(payment_type_id) on update cascade on delete cascade
);

create table shipping_method(
shipping_method_id smallint primary key auto_increment,
shipping_method_name varchar(20),
price double
);

create table order_status_enum(
order_status_enum_id smallint primary key auto_increment,
order_status_name varchar(20)
);


create table orders(
order_id bigint primary key auto_increment,
user_id bigint,
order_date_time datetime,
delivery_date_time datetime,
payment_method_id bigint,
shipping_address_id bigint,
shipping_method_id smallint,
total_amount double,
FOREIGN KEY (user_id) REFERENCES users(user_id) on update cascade on delete cascade,
FOREIGN KEY (payment_method_id) REFERENCES payment_method(payment_method_id) on update cascade on delete cascade,
FOREIGN KEY (shipping_address_id) REFERENCES address(address_id) on update cascade on delete cascade,
FOREIGN KEY (shipping_method_id) REFERENCES shipping_method(shipping_method_id) on update cascade on delete cascade
);

create table order_status(
order_status_id bigint primary key auto_increment,
date_time datetime,
order_status smallint,
order_id bigint,
is_current_sattus boolean,
FOREIGN KEY (order_id) REFERENCES orders(order_id) on update cascade on delete cascade,
FOREIGN KEY (order_status) REFERENCES order_status_enum(order_status_enum_id) on update cascade on delete cascade
);



create table order_line(
order_line_id bigint primary key auto_increment,
product_item_id bigint,
order_id bigint,
qty int,
price int,
FOREIGN KEY (order_id) REFERENCES orders(order_id) on update cascade on delete cascade,
FOREIGN KEY (product_item_id) REFERENCES product_item(product_item_id) on update cascade on delete cascade
);

-- drop table order_line;

create table review(
review_id bigint primary key auto_increment,
user_id bigint,
order_line_id bigint,
date_time datetime,
last_edit_date_time datetime,
rating smallint,
comment varbinary(500),
FOREIGN KEY (user_id) REFERENCES users(user_id) on update cascade on delete cascade,
FOREIGN KEY (order_line_id) REFERENCES order_line(order_line_id) on update cascade on delete cascade
);



create table otp_verification(
otp_id bigint primary key auto_increment,
user_id bigint,
type varchar(20),
expiry_time datetime,
FOREIGN KEY (user_id) REFERENCES users(user_id) on update cascade on delete cascade
);

-- drop table user_pending_verification;

create table user_pending_verification(
user_id bigint primary key auto_increment,
email varchar(50) unique not null,
mobile_no varchar(20) unique,
username varchar(50) unique not null,
first_name varchar(25) not null,
last_name varchar(25),
roles varchar(100) not null,
password varchar(100) not null,
is_email_varified boolean,
is_phone_varified boolean
);



