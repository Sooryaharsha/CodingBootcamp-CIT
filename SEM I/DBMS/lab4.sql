create database lab4;
use lab4;
create table staff(staff_no varchar(20),first_name varchar(30), last_name varchar(20),postion varchar(20),sex varchar(7),Dob date, salary int, branch_no varchar(20));
desc staff;
alter table staff drop column sex;
alter table staff drop column dob;
desc staff;

select*from staff;	
create table branch(branch_no varchar(20),street varchar(20),city varchar(20));	
truncate table staff;
insert into staff values('SL21','John','White','Manager','30000.00','B005'),('SG37','Ann','Beech','Assdistant','12000.00','B003'),('SG14','David','Ford','Supervisior','18000.00','B003'),('SA9','Mary','Howe','Assistant','9000.00','B007'),('SG5','Susan','Brand','Manager','24000.00','B003'),('SL41','Julie','Lee','Assistant','9000.00','B005');
update staff set branch_no='B006' where staff_no='SL21';
select*from staff;
insert into branch values('B003','163 Main Street','Glasgow'),('B005','22B Bakers street','London'),('B006','9th cross street','Ireland'),('B007','Alister Cook street','Aberdeen');
select*from branch;
create table properties(property_no varchar(20),property_type varchar(20),Property_Status varchar(20) );
insert into properties values('PA14','HOUSE','VIEWED'),('PG4','FLAT','VIEWED'),('PA15','HOUSE','NOT VIEWED'),('PG14','FLAT','VIEWED'),('PG36','FLAT','VIEWED');
SELECT*FROM properties;

SELECT*FROM staff;
select*from staff;
update staff set salary = '30000';

truncate table staff;
insert into staff values('SL21','John','White','Manager','30000.00','B005'),('SG37','Ann','Beech','Assdistant','12000.00','B003'),('SG14','David','Ford','Supervisior','18000.00','B003'),('SA9','Mary','Howe','Assistant','9000.00','B007'),('SG5','Susan','Brand','Manager','24000.00','B003'),('SL41','Julie','Lee','Assistant','9000.00','B005');
select*from staff;

select staff_no,first_name,last_name,salary from staff order by staff_no asc;
select property_no from properties where Property_Status  ='VIEWED';
select staff_no,first_name,last_name,salary/12 from staff order by staff_no;
select*from staff where salary>10000;
select*from branch where city='London' or city ='Glasgow';
select branch_no,sum(salary) as total from staff group by branch_no order by branch_no;
 select min(salary) as min_salary,max(salary) as max_salary from staff;
 select branch_no,count(staff_no) as my_count,sum(salary) as total_salary from staff group by branch_no order by staff_no;
 select branch_no,count(staff_no) as staff_count,sum(salary) as total_salary from staff  group by branch_no having count(staff_no)>1 order by branch_no;
 select staff_no, first_name,last_name,postion from staff where branch_no in (select branch_no from branch where street = '163 Main Street');
update staff set salary = salary +(salary*0.03);
select*from staff;
update staff set salary = salary +(salary*0.05) Where postion = 'Manager';
select*from staff;
update staff set postion = 'Manager',salary=18000 where staff_no ='SG14';
select*from staff where staff_no ='SG14';









