 
create table EASYBUY_SHOP
(
  es_id           NUMBER not null,
  es_ep_file_name NVARCHAR2(30),
  es_ep_name      NVARCHAR2(30),
  es_ep_price     NUMBER,
  es_eod_quantity NUMBER,
  es_ep_stock     NUMBER,
  es_ep_id        NUMBER,
  es_eu_user_id   NVARCHAR2(30),
  es_valid        NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table EASYBUY_SHOP
  add primary key (ES_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

 
delete from EASYBUY_SHOP;
commit;
 
insert into EASYBUY_SHOP (es_id, es_ep_file_name, es_ep_name, es_ep_price, es_eod_quantity, es_ep_stock, es_ep_id, es_eu_user_id, es_valid)
values (43, 'b7.jpg', '护甲器', 4, 1, 10, 669, 'zxc', 2);
insert into EASYBUY_SHOP (es_id, es_ep_file_name, es_ep_name, es_ep_price, es_eod_quantity, es_ep_stock, es_ep_id, es_eu_user_id, es_valid)
values (1, '1.jpg', '奶粉', 20, 1, 196, 601, 'ss', 2);
insert into EASYBUY_SHOP (es_id, es_ep_file_name, es_ep_name, es_ep_price, es_eod_quantity, es_ep_stock, es_ep_id, es_eu_user_id, es_valid)
values (44, '8.jpg', '旅行包', 2, 2, 10, 639, 'zxc', 2);
insert into EASYBUY_SHOP (es_id, es_ep_file_name, es_ep_name, es_ep_price, es_eod_quantity, es_ep_stock, es_ep_id, es_eu_user_id, es_valid)
values (47, 'b2.jpg', '糖果瓶', 5, 500, 500, 668, 'admin', 2);
insert into EASYBUY_SHOP (es_id, es_ep_file_name, es_ep_name, es_ep_price, es_eod_quantity, es_ep_stock, es_ep_id, es_eu_user_id, es_valid)
values (46, 'dn5.jpg', '华硕电脑', 3700, 4, 100, 670, 'admin', 2);
insert into EASYBUY_SHOP (es_id, es_ep_file_name, es_ep_name, es_ep_price, es_eod_quantity, es_ep_stock, es_ep_id, es_eu_user_id, es_valid)
values (64, 'ts1.jpg', '带灯', 20, 1, 20, 679, 'zxc', 2);
insert into EASYBUY_SHOP (es_id, es_ep_file_name, es_ep_name, es_ep_price, es_eod_quantity, es_ep_stock, es_ep_id, es_eu_user_id, es_valid)
values (65, '10.jpg', '奶粉', 20, 3, 195, 601, 'zxc', 2);
insert into EASYBUY_SHOP (es_id, es_ep_file_name, es_ep_name, es_ep_price, es_eod_quantity, es_ep_stock, es_ep_id, es_eu_user_id, es_valid)
values (66, '8.jpg', '旅行包', 2, 10, 10, 639, 'zxc', 2);
commit;
 
