-- database: ../database/POLITINDER.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 19.feb.2k24
Script: Creacion de la tabla Relacion + datos
*/

DROP TABLE IF EXISTS Relacion;

CREATE TABLE Relacion (
    IdRelacion              INTEGER     PRIMARY KEY AUTOINCREMENT
    , IdRelacionTipo        INTEGER     REFERENCES RelacionTipo (IdRelacionTipo)
    , IdPersona1            INTEGER     NOT NULL REFERENCES Persona (IdPersona)
    , IdPersona2            INTEGER     NOT NULL REFERENCES Persona (IdPersona)
    , FechaInicioRelacion   DATE        NOT NULL
    , Estado                VARCHAR(1)  NOT NULL DEFAULT('A') 
    , FechaCrea             DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP
    , FechaModifica         DATE 
);

---------------------------------------------------------------------

INSERT INTO Relacion ( IdRelacionTipo
                     , IdPersona1
                     , IdPersona2
                     , FechaInicioRelacion)
VALUES
  (2, 1, 2, "2022-02-19");

SELECT * FROM Relacion;

SELECT IdRelacionTipo, IdPersona1, IdPersona2, FechaInicioRelacion
FROM Relacion
WHERE Estado = 'A';

SELECT count(*)
FROM Relacion
WHERE Estado = 'A';