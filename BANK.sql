create database BankApplication;
use BankApplication;
create table Customer_Details(
Acc_No bigint primary key auto_increment ,
Customer_Name varchar(20),
Mobile_No bigint,
Email_Id varchar(20),
Pwd varchar(20),
Aadhar_No long,
Pan_No long); 
alter table Customer_Details drop column Pan_No ;
alter table Customer_Details modify Acc_No bigint primary key auto_increment;
select * from Customer_Details;
truncate table Customer_Details;
truncate table Account_Details;
truncate table Transactions;



create table Account_Details(
Acc_No bigint auto_increment primary key ,
Customer_Name varchar(20) not null,
Ifsc_code varchar(20),
Transaction varchar(20),
Trans_Amt int,
Balance bigint not null);
alter table account_details add Trans_amt int;
alter table Account_Details modify Acc_No bigint auto_increment primary key ;
insert into account_details(Ifsc_code) values ("KVB123");
select * from Account_details;


drop table Customer_details;
drop table Account_Details;

create table Transactions(Acc_Id int auto_increment primary key, Acc_No bigint, Action varchar(20), Trans_amt int, Trans_date date);
alter table Transactions add Balance bigint;
alter table Transactions modify Trans_date timestamp ;
select * from Transactions;
alter table Account_Details drop Trans_date;