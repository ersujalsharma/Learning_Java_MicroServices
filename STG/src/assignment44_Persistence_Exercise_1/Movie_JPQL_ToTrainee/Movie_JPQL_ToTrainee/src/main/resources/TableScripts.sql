DROP DATABASE IF EXISTS IMovie_ToTrainee;

CREATE DATABASE IMovie_ToTrainee;

USE IMovie_ToTrainee;

CREATE TABLE Movie(
    movie_id int PRIMARY KEY,
    movie_name VARCHAR(20) UNIQUE NOT NULL,
    director_name VARCHAR(20) NOT NULL,
    imdb_rating float(4,2) NULL, 
    release_year int
);
  
INSERT INTO Movie VALUES(9001, 'Dunkirk', 'Christopher Nolan', 8.5, 2017);
INSERT INTO Movie VALUES(9002, 'The Emoji Movie', 'Tony Leondis', 4.5, 2017);
INSERT INTO Movie VALUES(9003, 'Annabelle', 'David Sandberg', 7.6, 2017);
INSERT INTO Movie VALUES(9004, 'The Amazing Spider-Man', 'Jon Watts', 7.9, 2012);
INSERT INTO Movie VALUES(9005, 'Wonder Woman', 'Patty Jenkins', 7.9, 2017);
INSERT INTO Movie VALUES(9006, 'Planet of the Apes', 'Matt Reeves', 8.0, 2011);
INSERT INTO Movie VALUES(9007, 'Atomic Blonde', 'David Leitch', 7.2, 2017);
INSERT INTO Movie VALUES(9008, 'Despicable Me 2', 'Kyle Balda', 6.4, 2013);
INSERT INTO Movie VALUES(9009, 'The Avengers', 'Joss Whedon', 8.1, 2012);
INSERT INTO Movie VALUES(9010, 'Avengers: Age of Ultron', 'Joss Whedon', 7.4, 2015);
INSERT INTO Movie VALUES(9011, 'Deadpool', 'Tim Miller', 8.0, 2016);
INSERT INTO Movie VALUES(9012, 'Downsizing', 'Alexander Payne', 5.9, 2017);
INSERT INTO Movie VALUES(9013, 'Avengers: Infinity War', 'Joss Whedon', NULL, 2018);
INSERT INTO Movie VALUES(9014, 'Deadpool2', 'Tim Miller', NULL, 2018);

commit;

SELECT * FROM Movie;
