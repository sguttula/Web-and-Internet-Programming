drop table if exists guestbook;

create table guestbook (
    id      integer auto_increment primary key,
    name    varchar(255),
    message varchar(8000)
);

insert into guestbook (name, message) values ('john', 'hello');
insert into guestbook (name, message) values ('joe', 'hi');
