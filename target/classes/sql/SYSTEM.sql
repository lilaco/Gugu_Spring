SHOW USER;
CREATE USER book_ex IDENTIFIED BY book_ex
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP;
GRANT CONNECT, DBA TO BOOK_EX;
select dbms_xdb.gethttpport() from dual;
exec dbms_xdb.sethttpport(9090);