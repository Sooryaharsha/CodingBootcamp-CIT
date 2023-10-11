set serveroutput ON;
declare
  str1 varchar2(30);
  len number(3);
  str2 varchar2(30);
  i number(3);
begin
  str1:='&str1';
  len:=length(str1);
  for i in reverse 1..len
   loop
    str2:=str2 || substr(str1,i,1);
   end loop;
  dbms_output.put_line('Reverse string is: '||str2);
end;
/