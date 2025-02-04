drop database if exists transaction_db;
create database transaction_db;
use  transaction_db;

create table transaction(
    transaction_id   int primary key auto_increment,
    customer_id      varchar(10) not null,
    transaction_time date not null,
    amount   decimal(10,2)
);

insert into transaction  values (1001, 'C5001', sysdate()-interval 10 day, 1000);
insert into transaction  values (1002, 'C5002', sysdate()-interval  9 day, 450.2);
insert into transaction  values (1003, 'C5003', sysdate()-interval  12 day, 283.30);
insert into transaction  values (1004, 'C5002', sysdate()-interval 10 day, 900.0);
insert into transaction  values (1005, 'C5001', sysdate(), 789.22);

commit;
select * from transaction;
