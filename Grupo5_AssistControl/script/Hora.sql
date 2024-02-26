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
    ,Nombre             TIME        NOT NULL UNIQUE   
    ,Estado             VARCHAR(1)  NOT NULL DEFAULT('A')     
    ,FechaCrea          DATETIME    NOT NULL DEFAULT(datetime('now', 'localtime'))
    ,FechaModifica      DATETIME
);

INSERT INTO Hora(Nombre) VALUES('07:00:00');
INSERT INTO Hora(Nombre) VALUES('07:30:00');
INSERT INTO Hora(Nombre) VALUES('08:00:00');
INSERT INTO Hora(Nombre) VALUES('12:00:00');
INSERT INTO Hora(Nombre) VALUES('12:30:00');
INSERT INTO Hora(Nombre) VALUES('13:00:00');
INSERT INTO Hora(Nombre) VALUES('14:00:00');
INSERT INTO Hora(Nombre) VALUES('16:00:00');
INSERT INTO Hora(Nombre) VALUES('16:30:00');
INSERT INTO Hora(Nombre) VALUES('17:00:00');