SELECT * FROM clientmaster;
Select*from saleorder;
select*from clientmaster where bal_due = 0;
update clientmaster set city = 'jaipoor' where client_no = 'c0004';
select*from clientmaster where city = 'mumbai';
select name,city from clientmaster where client_no in (select client_no from saleorder where order_no = 'o19003' or order_no = 'o19002');
select trim(name) from clientmaster || ' live in the city of '|| city as address from clientmaster;
update saleorder set  order_status = 'in process' where client_no = 'c0005';
select client_no,name,city,pincode from clientmaster where client_no in (select client_no from saleorder where order_status = 'In process');
