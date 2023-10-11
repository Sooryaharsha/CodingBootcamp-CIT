set serveroutput ON;
declare
 i number(5);
 j number(5);

begin
 i:=&i;
dbms_output.put_line('The '||i||'th Table values till '||i||' * 10'); 
 for j in 1..10
 loop
 dbms_output.put_line(i||'x'||j||'='||i*j);
 end loop;

end;
/