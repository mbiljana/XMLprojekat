INSERT INTO COMMENTT(text) VALUES ('Bas lepo');
INSERT INTO COMMENTT(text) VALUES ('Nije bas dobro');
INSERT INTO COMMENTT(text) VALUES ('Super');
INSERT INTO COMMENTT(text) VALUES ('Jano jednostavno i lako');

INSERT INTO POST(IMAGE_LINK,NUM_OF_DISLIKES,NUM_OF_LIKES,TEXT) VALUES ('https://www.helloworld.rs/kompanija/Synechron-SRB-d.o.o.-Novi-Sad/713/cover-photo.png',3,50,'trazi se java developer');
INSERT INTO POST(IMAGE_LINK,NUM_OF_DISLIKES,NUM_OF_LIKES,TEXT) VALUES ('https://www.helloworld.rs/kompanija/Synechron-SRB-d.o.o.-Novi-Sad/713/cover-photo.png',1,100,'trazi se java developer');
INSERT INTO POST(IMAGE_LINK,NUM_OF_DISLIKES,NUM_OF_LIKES,TEXT) VALUES ('https://www.helloworld.rs/kompanija/Synechron-SRB-d.o.o.-Novi-Sad/713/cover-photo.png',5,60,'trazi se java developer');

INSERT INTO USER(USERNAME) VALUES ('ivana123');
INSERT INTO USER(USERNAME) VALUES ('jovan99');

INSERT INTO USER_POSTS(USER_ID,POSTS_ID) VALUES (1,1);
INSERT INTO USER_POSTS(USER_ID,POSTS_ID) VALUES (1,3);
INSERT INTO USER_POSTS(USER_ID,POSTS_ID) VALUES (2,2);
