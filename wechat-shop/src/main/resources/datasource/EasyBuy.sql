--���Ա�
create table EASYBUY_COMMENT
(
  EC_ID          NUMBER(10) primary key not null,--����ID
  EC_CONTENT     VARCHAR2(200) not null,--��������
  EC_CREATE_TIME DATE not null,--���Դ���ʱ��
  EC_REPLY       VARCHAR2(200),--�ظ�����
  EC_REPLY_TIME  DATE,--�ظ�ʱ��
  EC_NICK_NAME   VARCHAR2(10) not null--�������ǳ�
);


--���ű�
create table EASYBUY_NEWS
(
  EN_ID          NUMBER(10) primary key not null,
  EN_TITLE       VARCHAR2(40) not null,--���ű���
  EN_CONTENT     VARCHAR2(1000) not null,--��������
  EN_CREATE_TIME DATE not null--���Ŵ���ʱ��
);

--������
create table EASYBUY_ORDER
(
  EO_ID           NUMBER(10) primary key not null,
  EO_USER_ID      VARCHAR2(10) not null,--�û�ID
  EO_USER_NAME    VARCHAR2(20),--�û��ǳ�
  EO_USER_ADDRESS VARCHAR2(200),--�û���ַ
  EO_CREATE_TIME  DATE not null,--��������ʱ��
  EO_COST         NUMBER(10,2) not null,--�ܼ�Ǯ
  EO_STATUS       NUMBER(6) not null,--����״̬������ˣ�����......��
  EO_TYPE         NUMBER(6) not null--�������ͣ�ֱ��д�������ܣ�
);
--����״̬��
--1.�����
--2.���ͨ��
--3.���
--4.����
--5.�ջ�ȷ��

--������ϸ��
create table EASYBUY_ORDER_DETAIL
(
  EOD_ID       NUMBER(10) primary key not null,
  EO_ID        NUMBER(10) not null,--����ID
  EP_ID        NUMBER(10) not null,--��ƷID
  EOD_QUANTITY NUMBER(6) not null,--��������
  EOD_COST     NUMBER(10,2) not null--����Ʒ���ܼ�Ǯ
);

--��Ʒ��
create table EASYBUY_PRODUCT
(
  EP_ID          NUMBER(10) primary key not null,
  EP_NAME        VARCHAR2(20) not null,--��Ʒ����
  EP_DESCRIPTION VARCHAR2(100),--��Ʒ����
  EP_PRICE       NUMBER(10,2) not null,--��Ʒ����
  EP_STOCK       NUMBER(10) not null,--��Ʒ���
  EPC_ID         NUMBER(10),--��Ʒ���ุID
  EPC_CHILD_ID   NUMBER(10),--��Ʒ������ID
  EP_FILE_NAME   VARCHAR2(200)--��ƷͼƬ����
);

--��Ʒ�����
create table EASYBUY_PRODUCT_CATEGORY
(
  EPC_ID        NUMBER(10) primary key not null,--��Ʒ����ID
  EPC_NAME      VARCHAR2(20) not null,--��Ʒ��������
  EPC_PARENT_ID NUMBER(10) not null--��Ʒ���ุID
);

--�û���
create table EASYBUY_USER
(
  EU_USER_ID       VARCHAR2(10) primary key not null,
  EU_USER_NAME     VARCHAR2(20) not null,--�û���
  EU_PASSWORD      VARCHAR2(20) not null,--����
  EU_SEX           VARCHAR2(1) not null,--�Ա�
  EU_BIRTHDAY      DATE,--����
  EU_IDENTITY_CODE VARCHAR2(60),--����֤��
  EU_EMAIL         VARCHAR2(80),--email
  EU_MOBILE        VARCHAR2(11),--�绰
  EU_ADDRESS       VARCHAR2(200),--��ַ
  EU_STATUS        NUMBER(6) not null--�û�Ȩ��״̬��1��ͨ�û�  2����Ա
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
values (655, '�ն���̨IPod�������ڴ���', to_date('22-12-2010', 'dd-mm-yyyy'), '���ѷ�������ע���ջ�ʱ����������Ƿ�������', to_date('22-12-2010', 'dd-mm-yyyy'), 'С��');
insert into EASYBUY_COMMENT (EC_ID, EC_CONTENT, EC_CREATE_TIME, EC_REPLY, EC_REPLY_TIME, EC_NICK_NAME)
values (680, '����D50���ڿ��Զ೤ʱ�䷢����', to_date('24-12-2010', 'dd-mm-yyyy'), 'һ���ڶ���ȷ�Ϻ�ĵ�3�췢��', to_date('24-02-2011', 'dd-mm-yyyy'), '�޼�');
commit;


insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (529, '���¿�ʼǱ�', 'IBMEϵ��ȫ�������У����¿��˫�˴���������֤CPU����Ч����ת��', to_date('23-12-2010', 'dd-mm-yyyy'));
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (530, '�Ź�����', '�Ź�����', to_date('22-12-2010', 'dd-mm-yyyy'));
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (531, '��Ա�ػ��¿�ʼ��', '��Ա�ػ��¿�ʼ��', to_date('22-12-2010', 'dd-mm-yyyy'));
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (649, '�����Ա��Ӯǧ������', '�����Ա��Ӯǧ������', to_date('22-12-2010', 'dd-mm-yyyy'));
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (597, 'ӭ˫����������', 'ӭ˫����������', to_date('24-12-2010', 'dd-mm-yyyy'));
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (650, '���겻ҹ�죬ͨ��Ҳ�ǿ�����', '���겻ҹ�죬ͨ��Ҳ�ǿ�����', to_date('22-12-2010', 'dd-mm-yyyy'));
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (651, '���ֶһ���ʼ��', '���ֶһ���ʼ��', to_date('22-12-2010', 'dd-mm-yyyy'));
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (654, '���֪ͨ', '���֪ͨ', to_date('22-12-2010', 'dd-mm-yyyy'));
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (653, '�Ź�����1����', '�Ź�����1����', to_date('22-12-2010', 'dd-mm-yyyy'));
commit;


insert into EASYBUY_ORDER (EO_ID, EO_USER_ID, EO_USER_NAME, EO_USER_ADDRESS, EO_CREATE_TIME, EO_COST, EO_STATUS, EO_TYPE)
values (747, 'sss', 'С��', '�����������йش����202', to_date('21-02-2011', 'dd-mm-yyyy'), 800, 1, 1);
commit;


insert into EASYBUY_ORDER_DETAIL (EOD_ID, EO_ID, EP_ID, EOD_QUANTITY, EOD_COST)
values (748, 747, 592, 1, 200);
insert into EASYBUY_ORDER_DETAIL (EOD_ID, EO_ID, EP_ID, EOD_QUANTITY, EOD_COST)
values (749, 747, 643, 2, 600);
commit;


insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_ID, EPC_CHILD_ID, EP_FILE_NAME)
values (591, '����', '����', 100, 9999, 542, null, '591.jpg');
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_ID, EPC_CHILD_ID, EP_FILE_NAME)
values (592, '����', '�������', 200, 1997, 545, 626, '592.jpg');
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_ID, EPC_CHILD_ID, EP_FILE_NAME)
values (593, '������', 'Ůʿר��', 300, 29998, 542, null, '596.jpg');
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_ID, EPC_CHILD_ID, EP_FILE_NAME)
values (601, '�̷�', '��Ԫ', 20, 199, 545, null, '601.jpg');
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_ID, EPC_CHILD_ID, EP_FILE_NAME)
values (639, '���а�', '���а�', 2, 0, 545, 628, '641.jpg');
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_ID, EPC_CHILD_ID, EP_FILE_NAME)
values (643, '����', '��Ʒ', 300, 2996, 545, 548, '643.jpg');
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_ID, EPC_CHILD_ID, EP_FILE_NAME)
values (645, '˿��', 'Ůʿ', 50, 500, 545, 548, '645.jpg');
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_ID, EPC_CHILD_ID, EP_FILE_NAME)
values (660, '��ʾ��', '����', 20, 2000, 545, 628, '660.jpg');
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_ID, EPC_CHILD_ID, EP_FILE_NAME)
values (663, 'Һ����', '��ƽҺ����ʾ��', 590, 3, 545, 628, '663.jpg');
commit;


insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (628, '���õ���', 545);
insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (542, 'ͼ��', 542);
insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (546, '�ٶ�ͼ��', 542);
insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (545, '������Ʒ', 545);
insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (626, '������Ʒ', 545);
insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (548, '��ױƷ', 545);
commit;


insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('ss', '��ͨ�û�', 'ss', 'F', null, null, null, null, '�����к������ɸ�·207��', 1);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('admin', '����Ա', 'admin', 'T', null, null, null, null, '�����к������ɸ�·207��', 2);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('sss', 'С��', '123456', 'T', null, null, null, null, '�����������йش����202', 1);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('www', '�����', 'www', 'T', null, null, null, null, null, 1);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('q', 'JQ', 'q', 'T', to_date('02-01-2010', 'dd-mm-yyyy'), null, null, null, null, 1);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('a', 'amdda', 'a', 'F', null, null, null, null, null, 1);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('w', 'w', 'w', 'T', null, null, null, null, 'w', 1);
commit;