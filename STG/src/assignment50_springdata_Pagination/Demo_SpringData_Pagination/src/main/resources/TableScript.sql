drop database if exists transaction_db;
create database transaction_db;
use  transaction_db;

create table transaction(
   transaction_id int auto_increment,
   transaction_date date,
   transaction_amount float,
   constraint ps_transaction_id_pk primary key (transaction_id)
);
insert into transaction values (1, sysdate()- interval 9136 day, 1000);
insert into transaction values (2, sysdate()- interval 8136 day, 1569);
insert into transaction values (3, sysdate()- interval 8736 day, 4567);
insert into transaction values (4, sysdate()- interval 9036 day, 2345);
insert into transaction values (5, sysdate()- interval 8636 day, 6745);
insert into transaction values (6, sysdate()- interval 8936 day, 2123);
insert into transaction values(7, sysdate()- interval 8836 day, 6789);
insert into transaction values (8, sysdate()- interval 9133 day, 3434);
insert into transaction values (9, sysdate()- interval 9026 day, 2000);
insert into transaction values (10, sysdate()- interval 8899 day, 6000);
insert into transaction values (11, sysdate()- interval 9166 day, 1500);
insert into transaction values (12, sysdate()- interval 9016 day, 1200);
insert into transaction values (13, sysdate()- interval 8916 day, 2500);
insert into transaction values (14, sysdate()- interval 8899 day, 6500);
insert into transaction values (15, sysdate()- interval 8899 day, 7000);
commit;

select * from transaction;