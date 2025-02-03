drop database if exists sujalcricket_db;
create database sujalcricket_db;
use  sujalcricket_db;
create table players(
	player_id int auto_increment,
	player_name varchar(30),
	ranking int,
	batting_style varchar(10),
	bowling_style varchar(10),
	debut_date varchar(4),
	country varchar(20),
	constraint players_id_pk primary key (player_id)
);

insert into players values (1, 'Suzie Bates', 10, 'right-hand', 'right-arm', 2006, 'West Indies');
insert into players values (2, 'Amy Satterthwaite', 7, 'left-hand', 'right-arm', 2007, 'New Zealand');
insert into players values (3, 'Ellyse Perry', 3, 'right-hand', 'right-arm', 2007, 'Australia');
insert into players values (4, 'Stafanie Taylor', 1, 'right-hand', 'right-arm', 2008, 'West Indies');
insert into players values (5, 'Tammy Beaumont', 6, 'right-hand', 'NA', 2009, 'England');
insert into players values (6, 'Alyssa Healy', 2, 'right-hand', 'NA', 2010, 'Australia');
insert into players values (7, 'Meg Lanning', 5, 'right-hand', 'right-arm', 2010, 'Australia');
insert into players values (8, 'Lizelle Lee', 8, 'right-hand', 'right-arm', 2013, 'South Africa');
insert into players values (9, 'Smriti Mandhana', 4, 'left-hand', 'right-arm', 2014, 'India');
insert into players values (10, 'Laura Wolvaardt', 9, 'right-hand', 'NA', 2016, 'South Africa');

commit;

select * from players;