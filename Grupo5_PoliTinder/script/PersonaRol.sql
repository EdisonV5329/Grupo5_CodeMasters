-- database: ../database/POLITINDER.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 19.feb.2k24
Script: Creacion de la tabla PersonaRol + datos
*/

DROP TABLE IF EXISTS PersonaRol;

CREATE TABLE PersonaRol (
    IdPersonaRol         INTEGER PRIMARY KEY AUTOINCREMENT
    , IdPersonaRol_Padre INTEGER REFERENCES PersonaRol (IdPersonaRol)
    , Nombre             VARCHAR(10) NOT NULL UNIQUE 
    , Estado             VARCHAR(1)  NOT NULL DEFAULT('A') 
    , FechaCrea          DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    , FechaModifica      DATE 
);
---------------------------------------------------------------------
INSERT INTO PersonaRol(Nombre) VALUES 
  ("Admin");
INSERT INTO PersonaRol (
    IdPersonaRol_Padre
    , Nombre
) VALUES 
  (1, "AdminApp")
, (1, "Mensajero")
, (2, "Usuario");


SELECT * FROM PersonaRol;

SELECT IdPersonaRol, Nombre
FROM PersonaRol
WHERE Estado = 'A' AND IdPersonaRol = 2;

SELECT count(*)
FROM PersonaRol
WHERE Estado = 'A';