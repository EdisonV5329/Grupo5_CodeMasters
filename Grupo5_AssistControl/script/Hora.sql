-- database: ../database/ASSIST_CONTROL.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| matheus.velasco@epn.edu.ec   MATHEUSX  |
|----------------------------------------|
Autor: MATHEUSX
Fecha: 25.feb.2k24
script: Creacion de la tabla Hora + datos
*/

DROP TABLE IF EXISTS Hora;

CREATE TABLE Hora(
    IdHora              INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre             TEXT        NOT NULL
    ,Estado             VARCHAR(1)  NOT NULL DEFAULT('A')     
    ,FechaCrea          DATETIME    NOT NULL DEFAULT(datetime('now', 'localtime'))
    ,FechaModifica      DATETIME
);

INSERT INTO Hora(Nombre) VALUES('07:00');
INSERT INTO Hora(Nombre) VALUES('07:30');
INSERT INTO Hora(Nombre) VALUES('08:00');
INSERT INTO Hora(Nombre) VALUES('12:00');
INSERT INTO Hora(Nombre) VALUES('12:30');
INSERT INTO Hora(Nombre) VALUES('13:00');
INSERT INTO Hora(Nombre) VALUES('14:00');
INSERT INTO Hora(Nombre) VALUES('16:00');
INSERT INTO Hora(Nombre) VALUES('16:30');
INSERT INTO Hora(Nombre) VALUES('17:00');