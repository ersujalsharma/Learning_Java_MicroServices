drop database if exists customer_db;
create database customer_db;
use  customer_db;

create table id_gen (
gen_key varchar(10) not null,
gen_value int,
primary key (gen_key)
);


create table customer (
	customer_id int primary key,
	email_id varchar(20),
	name varchar(10),
	date_of_birth date
);

insert into customer (customer_id, email_id, name, date_of_birth) values (552092, 'martin@sujal.com', 'Martin', sysdate()- interval 9136 day);
insert into id_gen(gen_key,gen_value) values ('cust_id',1000);
commit;
select * from customer;

select * from id_gen;

