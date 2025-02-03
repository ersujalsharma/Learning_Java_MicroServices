create database if not exists db_sujalbook;


use db_sujalbook;
drop table Book;

create table Book (
	book_id BIGINT(10) PRIMARY KEY,
	book_name varchar(30) NOT NULL,
	author_name varchar(25) NOT NULL,
	year date NOT NULL,
	publisher varchar(30) NOT NULL,
	isbn BIGINT(13) UNIQUE NOT NULL,
	price BIGINT(10) NOT NULL
);

INSERT INTO Book VALUES (1001, 'The Immortals of Meluha', 'Amish Tripathi', '2010-02-03', 'Westland Press',7893451237893,540);
INSERT INTO Book VALUES (1002, 'The Alchemist', 'Paulo Coelho', '1993-01-15', 'Harper Collins',7893400211893,700);
INSERT INTO Book VALUES (1003, 'The Notebook', 'Nicholas Sparks', '1996-03-15','Warner Books',7893400211822,845);
INSERT INTO Book VALUES (1004, 'To Kill a Mockingbird','Harper Lee', '1960-07-11','JB Lipincott',1293560280893,685);
INSERT INTO Book VALUES (1005, 'A Fine Balance', 'Rohinton Mistry', '1995-03-22','McClelland',1289560027889,679);
INSERT INTO Book VALUES (1006, 'Message in a Bottle', 'Nicholas Sparks', '1998-03-15','Warner Books',2293411211822,820);
INSERT INTO Book VALUES (1007, 'The Choice', 'Nicholas Sparks', '2007-09-24','Grand Central',8993499211894,711);
INSERT INTO Book VALUES (1008, 'The Secret of Nagas', 'Amish Tripathi', '2011-07-21','Westland Press',1290099211894,650);
INSERT INTO Book VALUES (1009, 'The Oath of Vayuputra', 'Amish Tripathi', '2013-07-23','Westland Press',4567099211894,540);

commit;
SELECT * FROM Book;