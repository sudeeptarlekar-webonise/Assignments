create database assessment_system;

use assessment_system;

create table users(
id Integer,
name varchar(20) unique,
password varchar(20),
Constraint users_id_PK primary key(id)
);

create table roles(
id Integer,
name varchar(10),
Constraint roles_id_PK primary key (id)
);

create table user_roles(
id Integer,
user_id Integer,
role_id Integer,
Constraint userRoles_id_PK primary key (id),
Constraint userRoles_userId_users_FK foreign key (user_id) references users(id),
Constraint userRoles_roleID_roles_FK foreign key (role_id) references roles(id)
);

create table assignments(
id Integer,
name varchar(30),
user_id Integer,
Constraint assignments_id_PK primary key (id),
Constraint assignments_userId_users_FK foreign key (user_id) references users(id)
);

create table questions(
id Integer,
question varchar(60),
Constraint questions_id_PK primary key (id)
);

create table assignment_allocations(
id Integer,
assignment_id Integer,
user_id Integer,
Constraint assignmentAllo_assignmentId_assignments_FK foreign key (assignment_id) references assignments(id),
Constraint assignmentAllo_id_PK primary key (id),
Constraint assignmentAllo_userId_users_FK foreign key (user_id) references users(id)
);

create table assignment_sets(
id Integer,
assignment_id Integer,
question_id Integer,
Constraint assignmentSets_id_PK primary key (id),
Constraint assignmentSets_assignmentId_assignments_FK Foreign key (assignment_id) references assignments(id),
Constraint assignmentSets_questionId_questions_FK foreign key (question_id) references questions(id)
);

create table options(
id Integer,
opption varchar(20),
question_id Integer,
Constraint options_id_PK primary key (id),
Constraint options_questionId_questions_FK foreign key (question_id) references questions(id)
);

create table results(
id Integer,
assignment_id Integer,
user_id Integer,
score Integer,
Constraint results_id_PK primary key (id),
Constraint results_assignmentId_assignments_FK foreign key (assignment_id) references assignments(id),
Constraint results_userId_users_FK foreign key (user_id) references users(id)
);


create table assignment_submissions(
id Integer,
user_id Integer,
assignment_id Integer,
question_id Integer,
Constraint assignmentSub_id_PK primary key (id),
Constraint assignmentSub_userId_users_FK foreign key (user_id) references users(id),
Constraint assignmentSub_assignmentId_assignments_FK foreign key (assignment_id) references assignments(id),
Constraint assignmentSub_questionId_questions_FK foreign key (question_id) references questions(id)
);


create table answers(
id Integer,
question_id Integer,
option_id Integer,
Constraint answers_id_PK primary key (id),
Constraint answers_questionId_questions_FK foreign key (question_id) references questions(id),
Constraint answers_optionId_options_FK foreign key (option_id) references options(id)
);

create or replace view Result as 
select u.user_name, r.score, a.assignment_name from users u, results r, assignments a where u.id = r.user_id and r.assignment_id = a.id;

create or replace view Pivot As select u.id, u.user_name, a.assignment_name, q.question, o.opption from users u, questions q, assignments a, options o , assignment_submissions as1 where as1.user_id = u.id and as1.assignment_id = a.id and as1.question_id = q.id and as1.option_id = o.id;
