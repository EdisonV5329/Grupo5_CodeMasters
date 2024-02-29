-- database: ../database/POLITINDER.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 19.feb.2k24
Script: Creacion de la tabla RegaloEnvio + datos
*/
DROP TABLE IF EXISTS RegaloEnvio;

CREATE TABLE RegaloEnvio(
    IdRegaloEnvio           INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdPersonaEnvia         INTEGER     NOT NULL REFERENCES Persona (IdPersona)
    ,IdPersonaRecibe        INTEGER     NOT NULL REFERENCES Persona (IdPersona)
    ,IdRegalo               INTEGER     NOT NULL REFERENCES Regalo (IdRegalo)
    ,Estado                 VARCHAR(1)  NOT NULL DEFAULT('A') 
    ,FechaCrea              DATETIME    NOT NULL DEFAULT(datetime('now', 'localtime'))
    ,FechaModifica          DATETIME 
);

-------------------------------
INSERT INTO RegaloEnvio (
    IdPersonaEnvia
    ,IdPersonaRecibe
    ,IdRegalo
) VALUES(
    '2'
    ,'1'
    ,'1'
);
INSERT INTO RegaloEnvio (
    IdPersonaEnvia
    ,IdPersonaRecibe
    ,IdRegalo
) VALUES(
    '1'
    ,'2'
    ,'2'
);


SELECT IdRegaloEnvio, IdPersonaEnvia, IdPersonaRecibe, IdRegalo
FROM   RegaloEnvio
WHERE  Estado = 'A';