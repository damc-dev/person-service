CREATE TABLE user (
	id number,
	user_id number,
	first_name varchar(128),
	last_name varchar(128),
	created_date date,
	last_accessed date
);
insert into user(id, user_id, first_name, last_name, created_date, last_accessed) values (1, 1, 'David', 'McElligott', now(), now());
