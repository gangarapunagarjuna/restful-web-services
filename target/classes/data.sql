insert into user_details(id,birth_date,name) 
values(10001,current_date(),'Naga');

insert into user_details(id,birth_date,name) 
values(10002,current_date(),'Ravi');

insert into user_details(id,birth_date,name) 
values(10003,current_date(),'Raju');


insert into post(id,description,user_id) 
values(20001,'I want learn AWS',10001);

insert into post(id,description,user_id) 
values(20002,'I want learn Microsoft Azure',10001);

insert into post(id,description,user_id) 
values(20003,'I want learn Google Cloud',10002);

insert into post(id,description,user_id) 
values(20004,'I want learn Multi Cloud',10002);