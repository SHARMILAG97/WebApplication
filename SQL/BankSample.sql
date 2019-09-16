create database BankSample;
use BankSample;
create table Bank( Uname varchar(20), email varchar(50), mobile_no int, pwd varchar(20));
alter table Bank change Uname  Customer_Name varchar(20);
alter table Bank modify mobile_no long;
alter table Bank add Aadhar_No long;
alter table Bank add Pan_No long;
alter table Bank add Acc_No long ;
select * from Bank;
drop table Bank;

rollback;


create  table Account_Details (Acc_no long, Acc_Uname varchar(20), Balance long, foreign key (Acc_Uname) references Bank(Uname));
alter table Account_Details change Acc_Uname Customer_Name varchar(20);
alter table Account_Details add Acc_id int not null auto_increment primary key;

create table Deposit(D_Acc_id int, Deposit_Amount long, foreign key (D_Acc_id) references Account_Details (Acc_id));
create table Withdraw(W_Acc_id int, Withdraw_Amount long, foreign key (W_Acc_id) references Account_Details (Acc_id));
