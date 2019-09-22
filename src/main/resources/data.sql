Insert into user (FIRST_NAME, LAST_NAME, GENDER) VALUES
('SZYMON', 'NOWAK', 'MALE'),
('Anna', 'Kowalska', 'FEMALE'),
('Mateusz', 'Medon', 'MALE'),
('Zbyszek', 'Kieliszek', 'FEMALE');

insert into ADDRESS (CITY, STREET) VALUES ('Poznan', 'Mickiewicza');
insert into ADDRESS (CITY, STREET) VALUES ('Dublin', 'Ranelagh');

insert into USER_ADDRESS (USER_ID, ADDRESS_ID) VALUES (1,1);
insert into USER_ADDRESS (USER_ID, ADDRESS_ID) VALUES (2,2);
insert into USER_ADDRESS (USER_ID, ADDRESS_ID) VALUES (3,1);
insert into USER_ADDRESS (USER_ID, ADDRESS_ID) VALUES (4,2);

insert into TODO (TITLE, DESCRIPTION, STATUS) VALUES ('WYJSC Z PSEM', '26 OCTOBER', 'DONE');