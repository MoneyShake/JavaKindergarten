Здравствуйте. В приложении используется postgresql.
Для корректного запуска на вашей системе нужно изменить название базы данных или оставить такой же, если вы назовете её также(kindergarten) и пароль на ваш.
В файле \src\main\java\model\DatabaseUtils.java.

Ниже приведены скрипты для создания базы данных.

CREATE TABLE gr(
	id SERIAL PRIMARY KEY,
	gr_name varchar(80) NOT NULL,
	min_age int,
	max_age int
);

CREATE TABLE child (
	id SERIAL PRIMARY KEY,
	first_name varchar(100) NOT NULL,
	last_name varchar(100) NOT NULL,
	sex varchar(30) NOT NULL,
	group_id int REFERENCES gr (id),
age int
);

CREATE TABLE teacher (
	id SERIAL PRIMARY KEY,
	first_name varchar(100) NOT NULL,
	last_name varchar(100) NOT NULL,
	sex varchar(30) NOT NULL
);

CREATE TABLE extra_class (
	id SERIAL PRIMARY KEY,
	class_name varchar(100) NOT NULL,
	description varchar(300) NOT NULL
);

CREATE TABLE gr_teacher (
	teacher_id int REFERENCES teacher (id),
	group_id int REFERENCES gr (id),
    PRIMARY KEY (teacher_id, group_id) 

);

CREATE TABLE extra_class_teacher (
	teacher_id int REFERENCES teacher (id),
	extra_class_id int REFERENCES extra_class (id),
    PRIMARY KEY (teacher_id , extra_class_id) 
);

CREATE TABLE extra_class_child (
	child_id int REFERENCES child (id),
	extra_class_id int REFERENCES extra_class (id),
	PRIMARY KEY (child_id, extra_class_id) 
);
