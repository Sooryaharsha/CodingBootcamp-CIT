set serveroutput ON;
declare
    n number;
    s number:=0;
    r number;
    len number;
    m number;
  
begin
    n :=&n;
    m := n;
  
    len := length(to_char(n));
    while n>0
    loop
        r := mod(n , 10);
        s := s + power(r , len);
        n := trunc(n / 10);
    end loop;
      
    if m = s
    then
        dbms_output.put_line('yes '||m||' is an Armstrong number');
    else
        dbms_output.put_line('NO '||m||' is not an Armstrong number');
    end if;
      
end;
/