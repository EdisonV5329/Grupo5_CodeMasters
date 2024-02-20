-- database: ../database/POLITINDER.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 19.feb.2k24
Script: Creacion de la tabla Cita + datos
*/
DROP TABLE IF EXISTS Cita;

CREATE TABLE Cita(
    IdCita              INTEGER     PRIMARY KEY AUTOINCREMENT
    , IdPersona1        INTEGER     NOT NULL REFERENCES Persona (IdPersona)
    , IdPersona2        INTEGER     NOT NULL REFERENCES Persona (IdPersona)
    , FechaCita         DATE        NOT NULL
    , Estado            VARCHAR(1)  NOT NULL DEFAULT('A')
    , FechaCrea         DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP
    , FechaModifica     DATE 
);
-------------------------------------------------------------------------------
INSERT INTO Cita (IdPersona1
                 , IdPersona2
                 , FechaCita)
VALUES 
  (1, 2, '2024-03-15');

SELECT * FROM Cita;

SELECT IdCita, IdPersona1, IdPersona2, FechaCita
FROM Cita
WHERE Estado = 'A' AND IdCita = 2;

SELECT count(*)
FROM Cita
WHERE Estado = 'A';