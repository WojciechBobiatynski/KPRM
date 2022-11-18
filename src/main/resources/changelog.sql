CREATE TABLE Author (Id INT, Name VARCHAR, Surname VARCHAR, PRIMARY KEY (Id));

INSERT INTO Author (Id, Name, Surname) VALUES ( 1, 'Henryk', 'Sienkiewicz');
INSERT INTO Author (Id, Name, Surname) VALUES ( 2, 'Boleslaw', 'Prus');
INSERT INTO Author (Id, Name, Surname) VALUES ( 3, 'Adam', 'Mickiewicz');

CREATE TABLE Book (Id INT, Title VARCHAR, ISBN VARCHAR, Author INT, FOREIGN KEY (Author) REFERENCES Author(Id), PRIMARY KEY (Id));

INSERT INTO Book (Id, Title, ISBN, Author) VALUES ( 1, 'Ogniem i mieczem', '1234567890ABC', 1);
INSERT INTO Book (Id, Title, ISBN, Author) VALUES ( 2, 'Potop', '1234567890DEF', 1);
INSERT INTO Book (Id, Title, ISBN, Author) VALUES ( 3, 'COI Pan Wolodyjowski', '1234567890GHI', 1);
INSERT INTO Book (Id, Title, ISBN, Author) VALUES ( 4, 'Lalka', '1234567123GHI', 2);
INSERT INTO Book (Id, Title, ISBN, Author) VALUES ( 5, 'COI Pan Tadeusz', 'Niedobry ISBN 3244567123GHI', 3);