delete from tasks where id > 0;
insert into tasks (id, summary, start_date, end_date, assignee) 
values 
(1, 'create task', '2019-03-05', '2019-06-05', 'Paul'),
(2, 'create pro', '2019-07-04', '2019-08-06', 'Tom');
