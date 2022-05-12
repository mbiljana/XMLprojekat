create table profile
(
    id LONG,
    username varchar,
    constraint profile_pk
        primary key (id)
);

insert into profile(id, username) values ( 1, 'marijaza');
insert into profile(id, username) values (2, 'martakrsm');
insert into profile(id, username) values (3, 'nevenatrif');

create table chat
(
    id LONG,
    constraint chat_pk
        primary key (id)
);
insert into chat(id) values (1);
insert into chat(id) values ( 2 );

create table message
(
    id LONG,
    is_seen boolean,
    text VARCHAR,
    time DATETIME,
    messages_id LONG,
    constraint message_pk
        primary key (id)
);
insert into message(id, is_seen, text, time, messages_id) values (1, true, 'Eej', '2021-04-15T14:30:00', 1);
create table chats
(
    profile_id LONG,
    chat_id LONG
);
insert into chats(profile_id, chat_id) values (1, 2);
insert into chats(profile_id, chat_id) values (2, 2);

