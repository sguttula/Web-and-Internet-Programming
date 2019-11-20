drop table if exists final_exam;

create table final_exam (
id      integer auto_increment primary key,
courseNumber  		text,    
courseName    		text,
Assignment			text
);

insert into final_exam values (1, 'CS3220', 'Web Programming', 'Final');
insert into final_exam values (2, 'CS3801', 'Ethics', 'Presentation');
