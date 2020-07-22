drop database if exists flowershop;
create database flowershop;
use flowershop;

create table user(
  userid int(4) primary key AUTO_INCREMENT,
  username varchar(8) not null,
  usertype varchar(5) not null,
  password varchar(20) not null,
  address varchar(20) not null
);

create table flower(
  fid int(4) primary key AUTO_INCREMENT,
  fname varchar(10) not null,
  fprice int(3) not null,
  famount int(4) not null
);

create table stock(
  sid int(4) primary key AUTO_INCREMENT,
  sdate varchar(20),
  sprice int(3)not null
);

create table stockindent(
siid int(4)primary key AUTO_INCREMENT,
fid int(4),
fprice int(3) not null,
samount int(4),
sid int(4),
foreign key (sid) references stock(sid) on delete restrict on update restrict
);


create table market(
mid int(4) primary key AUTO_INCREMENT,
userid int(4) not null,
mprice int(4) not null,
mdate varchar(20)not null,
address varchar(20) not null,
foreign key (userid) references user(userid) on delete restrict on update restrict
);

create table indent(
iid int(4)primary key AUTO_INCREMENT,
fid int(4),
mamount int(4),
mid int(4),
foreign key (mid) references market(mid) on delete restrict on update restrict

);


insert into flower(fname,fprice,famount)
 values('������',18,45),('��õ��',14,50),
('������',10,85),('����ܰ',17,35),
('���տ�',20,40),('ˮ�ɻ�',12,35),
('������',35,45),('�ջ�',15,50),
('������',16,80),('�ž�',12,70),
('������',22,40),('޹�²�',19,55),
('ĵ��',24,65),('�϶���',30,60),
('������Ҷ',35,50);


insert into user(username,usertype,password,address)
values('�����','��Ա','123a','ϼɽ��'),
('��һ��','��Ա','123a','�࿲��'),
('֣     ��','��Ա','123a','������'),
('������','�˿�','123a','�࿲��'),
('������','�˿�','123a','������'),
('������','�˿�','123c','�࿲��'),
('������','�˿�','123a','������'),
('����֮','�˿�','123a','ϼɽ��'),
('������','�˿�','123f','�࿲��'),
('������','�˿�','123g','�࿲��'),
('����Ȼ','�˿�','123a','������'),
('��     ��','�˿�','123a','ϼɽ��'),
('222','��Ա','222','ϼɽ��');



insert into stock(sid,sdate,sprice)
 values(100,"2019��6��21",100);
insert into stock(sid,sdate,sprice)
 values(101,"2019��6��22",300);


insert into stockindent(fid,fprice,samount,sid)
values(1,10,10,100);
insert into stockindent(fid,fprice,samount,sid)
values(2,15,10,101);
insert into stockindent(fid,fprice,samount,sid)
values(3,15,10,101);

insert into market(mid,userid,mprice,mdate,address)
 values(100,4,200,"2019��6��21","�࿲��");

insert into market(mid,userid,mprice,mdate,address)
 values(101,6,32,"2019��6��25","�࿲��");


insert into indent(fid,mamount,mid)
values(5,10,100);
insert into indent(fid,mamount,mid)
values(1,1,101);
insert into indent(fid,mamount,mid)
values(2,1,101);
