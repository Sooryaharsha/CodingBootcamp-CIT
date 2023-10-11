set serveroutput ON;
declare
 i number(5);
 n number(5);
 t1 number(5);
 t2 number(5);
 nt number(5);

begin
 n:=&n;
 t1:=0;
 t2:=1;
 dbms_output.put_line(t1);
 dbms_output.put_line(t2);

 for i in 2..n-1
 loop
 nt:=t1+t2; 
 dbms_output.put_line(nt);
 t1:=t2;
 t2:=nt;
 end loop;

end;
/