drop database if exists customer_db;

create database customer_db;

use customer_db;

create table customer (
	customer_id int auto_increment ,
	email_id varchar(20),
	name varchar(10),
	date_of_birth date,
	constraint ps_customer_id_pk primary key ( customer_id )
);

insert into customer (customer_id, email_id, name, date_of_birth) values (552092, 'martin@sujal.com', 'Martin', '1994-01-10');

commit;
select * from customer;