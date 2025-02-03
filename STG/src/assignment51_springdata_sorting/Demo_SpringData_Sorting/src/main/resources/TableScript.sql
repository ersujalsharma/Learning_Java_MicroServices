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

commit;
select * from transaction;