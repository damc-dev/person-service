CREATE TABLE user (
	username varchar(128),
	first_name varchar(128),
	last_name varchar(128),
	created_date date
);
insert into user(username, first_name, last_name, created_date) values ('danveloper', 'Dan', 'Woods', now());