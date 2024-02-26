-- database: ../database/POLITINDER.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 19.feb.2k24
Script: Creacion de la tabla Persona + datos
*/
DROP TABLE IF EXISTS Persona;

CREATE TABLE Persona(
    IdPersona           INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdPersonaRol       INTEGER     NOT NULL REFERENCES PersonaRol (IdPersonaRol)
    ,IdPersonaSexo      INTEGER     NOT NULL REFERENCES  PersonaSexo (IdPersonaSexo)
    ,Cedula             VARCHAR(10) NOT NULL UNIQUE
    ,Nombre             TEXT        NOT NULL 
    ,Estado             VARCHAR(1)  NOT NULL DEFAULT('A') 
    ,FechaCrea          DATETIME    NOT NULL DEFAULT(datetime('now', 'localtime'))
    ,FechaModifica      DATETIME 
);

-------------------------------
INSERT INTO Persona (
    IdPersonaRol
    ,IdPersonaSexo
    ,Cedula
    ,Nombre
) VALUES(
    '4'
    ,'1'
    ,'2038745129'
    ,'Virginia'
);
INSERT INTO Persona (
    IdPersonaRol
    ,IdPersonaSexo
    ,Cedula
    ,Nombre
) VALUES(
    '4'
    ,'2'
    ,'1029384756'
    ,'Mateo'
);


SELECT IdPersona, IdPersonaRol, IdPersonaSexo, Cedula, Nombre
FROM   Persona
WHERE  Estado = 'A';