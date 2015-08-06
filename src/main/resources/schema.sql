CREATE TABLE user (
	username varchar(128),
	email_address varchar(128),
	first_name varchar(128),
	last_name varchar(128),
	created_date date,
	last_accessed date
);
insert into user(username, email_address, first_name, last_name, created_date, last_accessed) values ('damc-dev', 'damc.dev@gmail.com', 'David', 'McElligott', now(), now());
