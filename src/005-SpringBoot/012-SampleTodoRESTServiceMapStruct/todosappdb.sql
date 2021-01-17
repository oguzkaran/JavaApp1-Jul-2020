create table todos (
   todo_id bigserial primary key,
   username varchar(50) not null,
   title varchar(100) not null,
   description text not null,
   insert_date date not null,
   start_date date not null,
   expected_end_date date not null,
   end_date date,
   completed boolean
);

insert into todos (username, title, description, insert_date, start_date, expected_end_date, completed)
values
('kaanaslan', 'eczane', 'Vitamin, aspirin', '2020-01-15', '2020-01-15', '2020-01-15', false);

select * from todos where username = 'oguzkaran' and end_date is not null;

delete from todos where username = 'kaanaslan';

update todos set end_date = current_date where todo_id=2;

select * from todos where date_part('month', start_date)=2


select * from todos where date_part('month', start_date) between 2 and 3;
