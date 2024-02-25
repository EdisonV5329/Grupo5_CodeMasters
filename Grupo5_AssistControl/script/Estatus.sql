-- database: ../database/ASSIST_CONTROL.sqlite
/*
|------------------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved.        |
| francisco.torres@epn.edu.ec   Francisco Torres |
|------------------------------------------------|
Autor: Francisco Torres
Fecha: 24.feb.2k24
script: Creacion de la tabla Estatus
*/
DROP TABLE IF EXISTS Estatus;

CREATE TABLE Estatus(
    idEstatus       INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre         TEXT        NOT NULL UNIQUE 
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A') 
    ,FechaCrea      DATETIME    NOT NULL DEFAULT(datetime('now', 'localtime'))
    ,FechaModifica  DATETIME
);
INSERT INTO Estatus(Nombre) VALUES
("A Tiempo"),
("Atrasado"),
("Enfermedad");