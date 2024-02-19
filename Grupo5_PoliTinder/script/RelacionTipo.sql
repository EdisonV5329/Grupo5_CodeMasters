-- database: ../database/POLITINDER.sqlite
DROP TABLE IF EXISTS RelacionTipo;

CREATE TABLE RelacionTipo(
    IdRelacionTipo      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre             TEXT        NOT NULL UNIQUE
    ,Estado             VARCHAR(1)  NOT NULL DEFAULT('A') 
    ,FechaCrea          DATETIME    NOT NULL DEFAULT(datetime('now', 'localtime'))
    ,FechaModifica      DATETIME 
);

-------------------------------
INSERT INTO RelacionTipo (Nombre) VALUES
('Novios')
,('Amigos')
,('Trabajo');



-- UPDATE RelacionTipo SET Nombre = 'Cambio' WHERE idRelacionTipo = 4

SELECT * FROM RelacionTipo; 

SELECT IdRelacionTipo, Nombre
FROM   RelacionTipo
WHERE  Estado = 'A';

-- SELECT count(*)
-- FROM   RelacionTipo
-- WHERE  Estado = 'A';