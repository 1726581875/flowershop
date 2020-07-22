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
 values('郁金香',18,45),('红玫瑰',14,50),
('满天星',10,85),('康乃馨',17,35),
('向日葵',20,40),('水仙花',12,35),
('蝴蝶兰',35,45),('菊花',15,50),
('勿忘我',16,80),('杜鹃',12,70),
('风信子',22,40),('薰衣草',19,55),
('牡丹',24,65),('紫丁香',30,60),
('新西兰叶',35,50);


insert into user(username,usertype,password,address)
values('朱昊天','店员','123a','霞山区'),
('王一丹','店员','123a','赤坎区'),
('郑     涛','店员','123a','麻章区'),
('赵子鑫','顾客','123a','赤坎区'),
('曾可琪','顾客','123a','麻章区'),
('刘晓婷','顾客','123c','赤坎区'),
('吴欣雨','顾客','123a','麻章区'),
('张旭之','顾客','123a','霞山区'),
('刘国贤','顾客','123f','赤坎区'),
('陈钰钰','顾客','123g','赤坎区'),
('梁浩然','顾客','123a','麻章区'),
('周     哲','顾客','123a','霞山区'),
('222','店员','222','霞山区');



insert into stock(sid,sdate,sprice)
 values(100,"2019年6月21",100);
insert into stock(sid,sdate,sprice)
 values(101,"2019年6月22",300);


insert into stockindent(fid,fprice,samount,sid)
values(1,10,10,100);
insert into stockindent(fid,fprice,samount,sid)
values(2,15,10,101);
insert into stockindent(fid,fprice,samount,sid)
values(3,15,10,101);

insert into market(mid,userid,mprice,mdate,address)
 values(100,4,200,"2019年6月21","赤坎区");

insert into market(mid,userid,mprice,mdate,address)
 values(101,6,32,"2019年6月25","赤坎区");


insert into indent(fid,mamount,mid)
values(5,10,100);
insert into indent(fid,mamount,mid)
values(1,1,101);
insert into indent(fid,mamount,mid)
values(2,1,101);
