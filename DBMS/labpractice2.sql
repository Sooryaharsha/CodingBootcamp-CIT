create database labpractice2;
use labpractice2;

create table payslip(empcode varchar(25),basic int);
desc payslip;
insert into payslip values('E101',4000),('E102',4500),('E103',5000),('E104',7000),('E105',3000),('E106',5700),('E107',6200),('E108',5700),('E109',7500),('E110',5000),('E111',6000);
select*from payslip;
update  emply set age=age+15 where empcode = 'E107';
select*from emply;
insert into emply values('E101','Anjaly','Anjaly Nivas, Thiruvalla',25,'D301');
insert into emply values('E102','Bobby','alapuzha',28,'D305');
insert into emply values('E103','Aravind','Chennai',31,'D305');
insert into emply values('E104','Lakshmi','Mannar',55,'D707');
insert into emply values('E105','Daisy','Chaithram,Angamaly',35,'D707');
insert into emply values('E106','Esha','Mumbai',23,'D707');
insert into emply values('E107','Georgy','Pala',45,'D909');
insert into emply values('E108','Prakash','Vennikulam',36,'D110');
insert into emply values('E109','Madhavan','Mynakum,Kottayam',46,'D202');
insert into emply values('E110','Anugraha','Aparna,Angamaly',47,'D301');
insert into emply values('E111','Deva','Trichy',38,'D301');
insert into emply values('E112','Sanju','Dhanya,Ernakulam',27,'D202');
insert into emply values('E113','Priyesh','Priya Nivas,Kottayam',26,'D302');
Select*from emply;

create table dept(deptcode varchar(25),deptname varchar(50));
desc dept;
insert into dept values('D301','Sales'),('D302','Account'),('D707','Research'),('D909','Sales'),('D202','Stock'),('D110','Computer'),('D305','Marketing');
select*from dept;

create table payslip(empcode varchar(25),basic int);
desc payslip;
insert into payslip values('E101',4000),('E102',4500),('E103',5000),('E104',7000),('E105',3000),('E106',5700),('E107',6200),('E108',5700),('E109',7500),('E110',5000),('E111',6000);
select*from payslip;


select*from emply where age >24 and age<46;
select*from emply;
select empcode,empname,address,dept_code from emply where dept_code in (select deptcode from dept where deptname = 'account' or deptname ='stock');
select min(age) as Minimum_age , max(age) as Maximum_age, avg(age) as Average_age from emply; 
select*from emply;





  
