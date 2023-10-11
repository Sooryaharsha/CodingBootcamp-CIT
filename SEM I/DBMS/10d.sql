set serveroutput ON;
DECLARE
   n   NUMBER;
   rem   NUMBER;
   rev   NUMBER := 0;
BEGIN
   n := &n;
   WHILE n <> 0
   LOOP
      rem := MOD (n, 10);
      n := ( (n - rem) / 10);
      rev := rev * 10 + rem;
   END LOOP;

   DBMS_OUTPUT.PUT_LINE (rev);
END;
/