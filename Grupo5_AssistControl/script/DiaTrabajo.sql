-- database: ../database/ASSIST_CONTROL.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| matheus.velasco@epn.edu.ec   MATHEUSX  |
|----------------------------------------|
Autor: MATHEUSX
Fecha: 25.feb.2k24
script: Creacion de la tabla DiaTrabajo  + datos
*/
DROP TABLE IF EXISTS DiaTrabajo;

CREATE TABLE DiaTrabajo(
    IdDiaTrabajo        INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre             TEXT        NOT NULL
    ,Estado             VARCHAR(1)  NOT NULL DEFAULT('A')     
    ,FechaCrea          DATETIME    NOT NULL DEFAULT(datetime('now', 'localtime'))
    ,FechaModifica      DATETIME
);

INSERT INTO DiaTrabajo(Nombre) VALUES('Lunes-Viernes');
INSERT INTO DiaTrabajo(Nombre) VALUES('Lunes-Domingo');
INSERT INTO DiaTrabajo(Nombre) VALUES('Lunes-Jueves');
