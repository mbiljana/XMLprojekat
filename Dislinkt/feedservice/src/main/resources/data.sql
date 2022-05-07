insert into profile(id,username)
values (10,'bika');
insert into profile(id,username)
values (11,'maki');
insert into profile(id,username)
values (12,'aleks');
insert into profile(id,username)
values (13,'ana');

insert into connection(id,profile_id)
values(50,10);
insert into connection(id,profile_id)
values(51,11);

insert into post(id,created,post,CONNECTION_ID )
values (1,'2022-02-02','Biljana marinkov',50);
insert into post(id,created,post,CONNECTION_ID )
values (2,'2022-02-02','Biljana marinkov marija zaric',51);

