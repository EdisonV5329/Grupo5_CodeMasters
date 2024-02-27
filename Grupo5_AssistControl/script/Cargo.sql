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
    ,IdCargoPadre       INTEGER     REFERENCES  Cargo(IdCargo)
    ,IdEmpleadoHorario  INTEGER     NOT NULL REFERENCES EmpleadoHorario (IdEmpleadoHorario)
    ,Nombre             TEXT        NOT NULL UNIQUE 
    ,Estado             VARCHAR(1)  NOT NULL DEFAULT('A') 
    ,FechaCrea          DATETIME    NOT NULL DEFAULT(datetime('now', 'localtime'))
    ,FechaModifica      DATETIME
);

INSERT INTO Cargo(Nombre, IdEmpleadoHorario) VALUES 
  ("Admin", '1');

INSERT INTO Cargo(
    IdCargoPadre
    ,IdEmpleadoHorario
    ,Nombre
) VALUES(
    '1'
    ,'2'
    ,'Limpieza'
);

SELECT * FROM Cargo;

SELECT  IdCargo, Nombre
FROM    Cargo
WHERE   Estado ='A' AND IdCargo = 1;

SELECT  count(*)
FROM   Cargo
WHERE   Estado ='A';
