insert into users values(1,"richasharma", "richa123#");
insert into users values(2,"chetnapatil", "chetna123#");
insert into users values(3,"sudeeptarlekar", "sudeep123#");
insert into users values(4,"monikapandey","monika123#");
insert into users values(5,"akashpande","akash123#");


insert into roles values(1,"Admin");
insert into roles values(2,"Users");


insert into assignments values(1,"Programming Language", 1);
insert into assignments values(2, "RDBMS", 2);


insert into questions values(1,"Is PHP platform independent");
insert into questions values(2,"Is JAVA platform independent");
insert into questions values(3,"Full form of RDBMS");
insert into questions values(4,"Properties of RDBMS");



insert into user_roles values(1,1,1);
insert into user_roles values(2,2,1);
insert into user_roles values(3,3,2);
insert into user_roles values(4,4,2);
insert into user_roles values(5,5,2);


insert into assignment_allocations values(1,1,3);
insert into assignment_allocations values(2,1,4);
insert into assignment_allocations values(3,1,5);
insert into assignment_allocations values(4,2,3);
insert into assignment_allocations values(5,2,4);
insert into assignment_allocations values(6,2,5);


insert into options values(1,"A. Yes", 1);
insert into options values(2,"B. No", 1);
insert into options values(3,"C. Trully", 1);
insert into options values(4,"D. None of the above", 1);

insert into options values(5,"A. Yes", 2);
insert into options values(6,"B. No", 2);
insert into options values(7,"c. Partialy", 2);
insert into options values(8,"D. None of the above", 2);

insert into options values(9,"A. Relational Database System", 3);
insert into options values(10,"B. Rational Database System", 3);
insert into options values(11,"C. Role Database System", 3);
insert into options values(12,"D. None of the above", 3);

insert into options values(13,"A. ACID", 4);
insert into options values(14,"B. BASE", 4);
insert into options values(15,"C. All of the above", 4);
insert into options values(16,"D. None of the above", 4);


insert into assignment_sets values(1,1,1);
insert into assignment_sets values(2,1,2);
insert into assignment_sets values(3,2,3);
insert into assignment_sets values(4,2,4);

insert into answers values(1,1,3);
insert into answers values(2,2,7);
insert into answers values(3,3,9);
insert into answers values(4,4,13);


insert into assignment_submissions values(1,4,1,1,3);
insert into assignment_submissions values(2,4,1,2,7);
insert into assignment_submissions values(3,4,2,3,9);
insert into assignment_submissions values(4,4,2,4,13);

insert into results values(1,4,1,10);
insert into results values(2,4,2,10);

