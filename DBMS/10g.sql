declare
n number:=10;
i number:=1;
j number;
k number;
space char(2):='';
begin
while i<n
loop
j:=1;
while j<n-i
loop
dbms_output.put(lpad(space,n-i,' '));
j:=j+2;
end loop;
 
for k in 1..i
loop
dbms_output.put('* ');
end loop;
dbms_output.new_line;
i:=i+2;
end loop;
 
i:=7;
while i>=1
loop
j:=9;
while j>i
loop
dbms_output.put(lpad(space,n-i,' '));
j:=j-2;
end loop;
 
for k in 1..i
loop
dbms_output.put('* ');
end loop;
dbms_output.new_line;
i:=i-2;
end loop;
end;
/
