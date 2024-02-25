-- database: ../database/ASSIST_CONTROL.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 22.feb.2k24
script: Creacion de la tabla Cargo + datos
*/
DROP TABLE IF EXISTS Cargo;

CREATE TABLE  Cargo(
    IdCargo             INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdCargoPadre       INTEGER     REFERENCES  Cargo (IdCargo)
    ,Nombre             TEXT        NOT NULL UNIQUE 
    ,Estado             VARCHAR(1)  NOT NULL DEFAULT('A') 
    ,FechaCrea          DATETIME    NOT NULL DEFAULT(datetime('now', 'localtime'))
    ,FechaModifica      DATETIME
);

INSERT INTO Cargo(Nombre) VALUES 
  ("Admin");

INSERT INTO Cargo(
    IdCargoPadre
    ,Nombre
) VALUES(
    '1'
    ,'Limpieza'
);