drop table if exists rider;

/*==============================================================*/
/* Table: rider                                                 */
/*==============================================================*/
create table rider
(
   rider_id             int not null,
   rider_name           varchar(20) not null,
   rider_passwd         varchar(20) not null,
   rider_phone          char(11) not null,
   rider_position       varchar(100) not null,
   primary key (rider_id)
);

drop table if exists rider_evaluation;

/*==============================================================*/
/* Table: rider_evaluation                                      */
/*==============================================================*/
create table rider_evaluation
(
   rider_id             int,
   user_id              varchar(20),
   rider_evaluate       text,
   rider_stars          float
);

drop table if exists discount;

/*==============================================================*/
/* Table: discount                                              */
/*==============================================================*/
create table discount
(
   discount_id          varchar(20) not null,
   user_id              varchar(20),
   discount_name        varchar(20) not null,
   discount_money       float not null,
   start_money          float not null,
   primary key (discount_id)
);

drop table if exists user;

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              varchar(20) not null,
   user_name            varchar(20),
	 user_phone						char(11),
   user_pwd             varchar(20),
   user_main_address    varchar(100),
   user_sex 	int(11) NOT NULL DEFAULT '0',
   primary key (user_id)
);

drop table if exists ord;

/*==============================================================*/
/* Table: ord                                                   */
/*==============================================================*/
create table ord
(
   ord_id               int not null,
   user_id              varchar(20),
   store_id             int,
   rider_id             int,
   total_money          float(8,2) not null,
   total_discount       float(8,2) not null,
   ord_time             datetime not null,
   rider_get            float(8,2) not null,
   primary key (ord_id)
);

drop table if exists ord_goods;

/*==============================================================*/
/* Table: ord_goods                                             */
/*==============================================================*/
create table ord_goods
(
   ord_id               int,
   goods_name           varchar(50),
   goods_num            int,
   goods_price          float(8,2)
);

drop table if exists store;

/*==============================================================*/
/* Table: store                                                 */
/*==============================================================*/
create table store
(
   store_id             int not null,
   store_name           varchar(50) not null,
   store_passwd         varchar(20) not null,
   store_address        varchar(200) not null,
   store_phone					char(11),
   delivery_begin       time not null,
   delivery_end         time not null,
   primary key (store_id)
);

drop table if exists reduction_plan;

/*==============================================================*/
/* Table: reduction_plan                                        */
/*==============================================================*/
create table reduction_plan
(
   plan_id              int not null,
   store_id             int,
   reduction_require    float(8,2) not null,
   reduction_money      float(8,2) not null,
   primary key (plan_id)
);

drop table if exists goods;

/*==============================================================*/
/* Table: goods                                                 */
/*==============================================================*/
create table goods
(
   class_name           varchar(50) not null,
   goods_id             int not null,
   store_id             int,
   goods_name           varchar(50) not null,
   goods_price          float(8,2) not null,
   goods_picture        longblob not null,
   goods_description    text not null,
   month_sales          int not null,
   high_rating          float not null,
   primary key (goods_id)
);

drop table if exists goods_evaluation;

/*==============================================================*/
/* Table: goods_evaluation                                      */
/*==============================================================*/
create table goods_evaluation
(
   store_id             int,
   user_id              varchar(20),
   evaluation_content   text,
   evaluation_star      float,
   evaluation_img       longblob
);

drop table if exists user_address;

/*==============================================================*/
/* Table: user_address                                          */
/*==============================================================*/
create table user_address
(
   user_id              varchar(20),
   user_address        varchar(100) not null,
   main_address	int(11) NOT NULL DEFAULT '0'
   user_name	varchar(20) NOT NULL,
   user_sex	int(11) DEFAULT NULL，
   address_detail	varchar(100) DEFAULT NULL,
   address_type	int(11) DEFAULT NULL
);