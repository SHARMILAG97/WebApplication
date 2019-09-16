create database Water_Can;
use Water_Can;

create table User_Details(
User_id int auto_increment primary key,
User_name varchar(20),
Mobile_no bigint unique,
Pwd varchar(20),
Address varchar(20),Status varchar(10) default 'Active');

//
alter table User_Details modify Status varchar(10) default 'Active';
alter table User_Details modify Mobile_no bigint unique;

select * from User_Details;




create table Order_Details(Date_time datetime default current_timestamp,
Order_id int auto_increment primary key,
Reserve_id int not null default 0,
User_id int, User_name varchar(20), Mobile_no bigint, Address varchar(20),
Order_cans int not null,foreign key(User_id) references User_Details(User_id),foreign key(Reserve_id) references Reserve_Details(Reserve_id));

//alter table Order_Details add Date_time datetime default current_timestamp;alter table Order_Details ADD CONSTRAINT foreign key(Reserve_id) references Reserve_Details(Reserve_id);

//alter table Order_Details ADD CONSTRAINT foreign key(User_id) references User_Details(User_id);

select * from Order_Details;
truncate Order_Details;



create table Reserve_Details(Date_time datetime default current_timestamp,
Reserve_id int auto_increment primary key,
User_id varchar(20), User_name varchar(20), Mobile_no bigint, Reserve_Cans int not null,Ordered_cans int default 0,Status varchar(10) default 'Reserved',foreign key(User_id) references User_Details(User_id));

//alter table Reserve_Details add Status varchar(10) default 'Reserved';
// 
alter table Reserve_Details add Ordered_cans int default 0;

//alter table Reserve_Details add Date_time datetime default current_timestamp;

//alter table Order_Details ADD CONSTRAINT foreign key(User_id) references User_Details(User_id);

select * from Reserve_Details;
truncate Reserve_Details;



create table AdminLogin(Name varchar(20),Pwd varchar(20));

insert into AdminLogin(Name,Pwd) values ('Naresh','naresh');

select * from AdminLogin;
drop table Admin;



create table Stock_Details(
Date_time datetime default current_timestamp,
Stock_id int primary key auto_increment,
Updated_cans int default 0,
Ordered_cans int default 0,
Reserved_cans int default 0,
Available_cans int default 0);
 
select * from Stock_Details;

alter table Stock_Details drop Total_cans;

alter table Stock_Details add Available_cans int ;



truncate Stock_Details;


select * from Stock_Details where date(Date_time) = current_date();