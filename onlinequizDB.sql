create table tblUser(
	username varchar(20),
	password varchar(20),
	role varchar(20),
	email varchar(50),
	primary key(username)
)

drop table tblQuestion

create table tblQuestion(
	id int identity(1,1),
	content nvarchar(250),
	op1 nvarchar(100),
	op2 nvarchar(100),
	op3 nvarchar(100),
	op4 nvarchar(100),
	answer int,
	quiz_id int,
	primary key(id)
)

alter table tblQuestion
add foreign key(quiz_id) references tblQuiz(id)

drop table tblQuiz
create table tblQuiz(
	id int identity(1,1),
	title nvarchar(250),
	taken_time int,
	created_date date,
	primary key(id)
)

drop table tblQuizHistory
create table tblQuizHistory(
	id int identity(1,1) primary key,
	username varchar(20),
	rightAnswers int,
	score float,
	takenDate date,
	quiz_id int
)

alter table tblQuizHistory
add foreign key(quiz_id) references tblQuiz(id)