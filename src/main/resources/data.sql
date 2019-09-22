Insert into user (FIRST_NAME, LAST_NAME, GENDER) VALUES
('SZYMON', 'NOWAK', 0),
('Anna', 'Kowalska', 1),
('Mateusz', 'Medon', 0),
('Zbyszek', 'Kieliszek', 1);

insert into ADDRESS (CITY, STREET) VALUES ('Poznan', 'Mickiewicza');
insert into ADDRESS (CITY, STREET) VALUES ('Dublin', 'Ranelagh');

insert into USER_ADDRESS (USER_ID, ADDRESS_ID) VALUES (1,1);
insert into USER_ADDRESS (USER_ID, ADDRESS_ID) VALUES (2,2);
insert into USER_ADDRESS (USER_ID, ADDRESS_ID) VALUES (3,1);
insert into USER_ADDRESS (USER_ID, ADDRESS_ID) VALUES (4,2);