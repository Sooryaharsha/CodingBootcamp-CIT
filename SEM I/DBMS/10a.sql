set serveroutput on;
declare
 i number;
 j number;
 f number;

begin	
 i:=&i;
 f:=1;
 for j in 1..i
 loop	
 f:=f*j;				
 end loop;		
 dbms_output.put_line('Factorial of i is '||f);
end;			
/