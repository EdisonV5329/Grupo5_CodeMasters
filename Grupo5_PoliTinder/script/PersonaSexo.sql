-- database: ../database/POLITINDER.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 19.feb.2k24
Script: Creacion de la tabla PersonaSexo + datos
*/
DROP TABLE IF EXISTS PersonaSexo;

CREATE TABLE PersonaSexo (
      IdPersonaSexo INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    , Nombre        VARCHAR(10) NOT NULL UNIQUE 
    , Estado        VARCHAR(1)  NOT NULL DEFAULT('A') 
    , FechaCrea     DATETIME    NOT NULL DEFAULT (datetime('now','localtime'))
    , FechaModifica DATETIME 
); 
---------------------------------------------------------------------
INSERT INTO PersonaSexo (Nombre) VALUES 
  ("Femenino")
, ("Masculino")
, ("Hibrido");

SELECT * FROM PersonaSexo;

SELECT IdPersonaSexo, Nombre
FROM PersonaSexo
WHERE Estado = 'A' AND IdPersonaSexo = 2;

SELECT count(*)
FROM PersonaSexo
WHERE Estado = 'A';