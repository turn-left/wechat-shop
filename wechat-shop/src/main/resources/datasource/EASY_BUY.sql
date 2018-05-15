--留言表
create table EASYBUY_COMMENT
(
  EC_ID          NUMBER(10) primary key not null,--留言ID
  EC_CONTENT     VARCHAR2(200) not null,--留言内容
  EC_CREATE_TIME DATE not null,--留言创建时间
  EC_REPLY       VARCHAR2(200),--回复内容
  EC_REPLY_TIME  DATE,--回复时间
  EC_NICK_NAME   VARCHAR2(10) not null--留言人昵称
);


--新闻表
create table EASYBUY_NEWS
(
  EN_ID          NUMBER(10) primary key not null,
  EN_TITLE       VARCHAR2(40) not null,--新闻标题
  EN_CONTENT     VARCHAR2(1000) not null,--新闻内容
  EN_CREATE_TIME DATE not null--新闻创建时间
);

--订单表
create table EASYBUY_ORDER
(
  EO_ID           NUMBER(10) primary key not null,
  EO_USER_ID      VARCHAR2(10) not null,--用户ID
  EO_USER_NAME    VARCHAR2(20),--用户昵称
  EO_USER_ADDRESS VARCHAR2(200),--用户地址
  EO_CREATE_TIME  DATE not null,--订单产生时间
  EO_COST         NUMBER(10,2) not null,--总价钱
  EO_STATUS       NUMBER(6) not null,--订单状态（待审核，发货......）
  EO_TYPE         NUMBER(6) not null--付款类型（直接写死，不管）
);
--订单状态：
--1.待审核
--2.审核通过
--3.配货
--4.发货
--5.收货确认

--订单详细表
create table EASYBUY_ORDER_DETAIL
(
  EOD_ID       NUMBER(10) primary key not null,
  EO_ID        NUMBER(10) not null,--订单ID
  EP_ID        NUMBER(10) not null,--商品ID
  EOD_QUANTITY NUMBER(6) not null,--购买数量
  EOD_COST     NUMBER(10,2) not null--此商品的总价钱
);

--商品表
create table EASYBUY_PRODUCT
(
  EP_ID          NUMBER(10) primary key not null,
  EP_NAME        VARCHAR2(20) not null,--商品名称
  EP_DESCRIPTION VARCHAR2(100),--商品描述
  EP_PRICE       NUMBER(10,2) not null,--商品单价
  EP_STOCK       NUMBER(10) not null,--商品库存
  EPC_ID         NUMBER(10),--商品分类父ID
  EPC_CHILD_ID   NUMBER(10),--商品分类子ID
  EP_FILE_NAME   VARCHAR2(200)--商品图片名称
);

--商品分类表
create table EASYBUY_PRODUCT_CATEGORY
(
  EPC_ID        NUMBER(10) primary key not null,--商品分类ID
  EPC_NAME      VARCHAR2(20) not null,--商品分类名称
  EPC_PARENT_ID NUMBER(10) not null--商品分类父ID
);

--用户表
create table EASYBUY_USER
(
  EU_USER_ID       VARCHAR2(10) primary key not null,
  EU_USER_NAME     VARCHAR2(20) not null,--用户名
  EU_PASSWORD      VARCHAR2(20) not null,--密码
  EU_SEX           VARCHAR2(1) not null,--性别
  EU_BIRTHDAY      DATE,--生日
  EU_IDENTITY_CODE VARCHAR2(60),--身份证号
  EU_EMAIL         VARCHAR2(80),--email
  EU_MOBILE        VARCHAR2(11),--电话
  EU_ADDRESS       VARCHAR2(200),--地址
  EU_STATUS        NUMBER(6) not null--用户权限状态，1普通用户  2管理员
);

delete from EASYBUY_USER;
commit;
delete from EASYBUY_PRODUCT_CATEGORY;
commit;
delete from EASYBUY_PRODUCT;
commit;
delete from EASYBUY_ORDER_DETAIL;
commit;
delete from EASYBUY_ORDER;
commit;
delete from EASYBUY_NEWS;
commit;
delete from EASYBUY_COMMENT;
commit;


insert into EASYBUY_COMMENT (EC_ID, EC_CONTENT, EC_CREATE_TIME, EC_REPLY, EC_REPLY_TIME, EC_NICK_NAME)
values (655, '刚订了台IPod，很是期待啊', to_date('22-12-2010', 'dd-mm-yyyy'), '货已发出，请注意收货时开箱检查货物是否有问题', to_date('22-12-2010', 'dd-mm-yyyy'), '小乖');
insert into EASYBUY_COMMENT (EC_ID, EC_CONTENT, EC_CREATE_TIME, EC_REPLY, EC_REPLY_TIME, EC_NICK_NAME)
values (680, '佳能D50现在可以多长时间发货呢', to_date('24-12-2010', 'dd-mm-yyyy'), '一般在订单确认后的第3天发货', to_date('24-02-2011', 'dd-mm-yyyy'), '无极');
commit;


insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (529, '最新酷睿笔记本', 'IBME系列全场促销中，最新酷睿双核处理器，保证CPU更高效的运转。', to_date('23-12-2010', 'dd-mm-yyyy'));
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (530, '团购无忧', '团购无忧', to_date('22-12-2010', 'dd-mm-yyyy'));
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (531, '会员特惠月开始了', '会员特惠月开始了', to_date('22-12-2010', 'dd-mm-yyyy'));
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (649, '加入会员，赢千万大礼包', '加入会员，赢千万大礼包', to_date('22-12-2010', 'dd-mm-yyyy'));
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (597, '迎双旦促销大酬宾', '迎双旦促销大酬宾', to_date('24-12-2010', 'dd-mm-yyyy'));
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (650, '新年不夜天，通宵也是开张了', '新年不夜天，通宵也是开张了', to_date('22-12-2010', 'dd-mm-yyyy'));
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (651, '积分兑换开始了', '积分兑换开始了', to_date('22-12-2010', 'dd-mm-yyyy'));
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (654, '配货通知', '配货通知', to_date('22-12-2010', 'dd-mm-yyyy'));
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (653, '团购阿迪1折起', '团购阿迪1折起', to_date('22-12-2010', 'dd-mm-yyyy'));
commit;


insert into EASYBUY_ORDER (EO_ID, EO_USER_ID, EO_USER_NAME, EO_USER_ADDRESS, EO_CREATE_TIME, EO_COST, EO_STATUS, EO_TYPE)
values (747, 'sss', '小乖', '北京海淀区中关村大厦202', to_date('21-02-2011', 'dd-mm-yyyy'), 800, 1, 1);
commit;


insert into EASYBUY_ORDER_DETAIL (EOD_ID, EO_ID, EP_ID, EOD_QUANTITY, EOD_COST)
values (748, 747, 592, 1, 200);
insert into EASYBUY_ORDER_DETAIL (EOD_ID, EO_ID, EP_ID, EOD_QUANTITY, EOD_COST)
values (749, 747, 643, 2, 600);
commit;


insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_ID, EPC_CHILD_ID, EP_FILE_NAME)
values (591, '画册', '画册', 100, 9999, 542, null, '591.jpg');
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_ID, EPC_CHILD_ID, EP_FILE_NAME)
values (592, '饭盒', '韩国风格', 200, 1997, 545, 626, '592.jpg');
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_ID, EPC_CHILD_ID, EP_FILE_NAME)
values (593, '护肤王', '女士专用', 300, 29998, 542, null, '596.jpg');
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_ID, EPC_CHILD_ID, EP_FILE_NAME)
values (601, '奶粉', '三元', 20, 199, 545, null, '601.jpg');
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_ID, EPC_CHILD_ID, EP_FILE_NAME)
values (639, '旅行包', '旅行包', 2, 0, 545, 628, '641.jpg');
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_ID, EPC_CHILD_ID, EP_FILE_NAME)
values (643, '项链', '饰品', 300, 2996, 545, 548, '643.jpg');
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_ID, EPC_CHILD_ID, EP_FILE_NAME)
values (645, '丝袜', '女士', 50, 500, 545, 548, '645.jpg');
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_ID, EPC_CHILD_ID, EP_FILE_NAME)
values (660, '显示器', '三星', 20, 2000, 545, 628, '660.jpg');
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_ID, EPC_CHILD_ID, EP_FILE_NAME)
values (663, '液晶屏', '纯平液晶显示器', 590, 3, 545, 628, '663.jpg');
commit;


insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (628, '家用电器', 545);
insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (542, '图书', 542);
insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (546, '少儿图书', 542);
insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (545, '生活用品', 545);
insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (626, '厨房用品', 545);
insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (548, '化妆品', 545);
commit;


insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('ss', '普通用户', 'ss', 'F', null, null, null, null, '北京市海淀区成府路207号', 1);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('admin', '管理员', 'admin', 'T', null, null, null, null, '北京市海淀区成府路207号', 2);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('sss', '小乖', '123456', 'T', null, null, null, null, '北京海淀区中关村大厦202', 1);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('www', '大家米', 'www', 'T', null, null, null, null, null, 1);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('q', 'JQ', 'q', 'T', to_date('02-01-2010', 'dd-mm-yyyy'), null, null, null, null, 1);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('a', 'amdda', 'a', 'F', null, null, null, null, null, 1);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('w', 'w', 'w', 'T', null, null, null, null, 'w', 1);
commit;
