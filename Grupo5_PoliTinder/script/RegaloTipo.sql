-- database: ../database/POLITINDER.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 18.feb.2k24
Script: Creacion de la tabla RegaloTipo + datos
*/
DROP TABLE IF EXISTS RegaloTipo;

CREATE TABLE RegaloTipo(
    IdRegaloTipo     INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre          TEXT        NOT NULL UNIQUE
    ,Estado          VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCrea       DATETIME    NOT NULL DEFAULT(datetime('now', 'localtime'))
    ,FechaModifica   DATETIME
);

INSERT INTO  RegaloTipo (Nombre) VALUES
('Virtual')
,('Presencial');

SELECT IdRegaloTipo, Nombre
FROM   RegaloTipo
WHERE  Estado = 'A';