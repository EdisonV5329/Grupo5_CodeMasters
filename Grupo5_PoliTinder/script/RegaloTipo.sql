-- database: ../database/POLITINDER.sqlite
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