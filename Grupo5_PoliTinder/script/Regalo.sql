-- database: ../database/REGALO.sqlite
DROP TABLE IF EXISTS Regalo;

CREATE TABLE Regalo(
    IdRegalo            INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdRegaloTipo       INTEGER     NOT NULL REFERENCES  RegaloTipo (IdRegaloTipo)
    ,Nombre             TEXT        NOT NULL UNIQUE
    ,Estado             VARCHAR(1)  NOT NULL DEFAULT('A') 
    ,Stock              INTEGER     NOT NULL
    ,Precio             REAL        NOT NULL
    ,FechaCrea          DATETIME    NOT NULL DEFAULT(datetime('now', 'localtime'))
    ,FechaModifica      DATETIME 
);

-------------------------------
INSERT INTO Regalo (
    IdRegaloTipo
    ,Nombre
    ,Stock
    ,Precio
) VALUES(
    '2'
    ,'Rosas'
    ,'50'
    ,'15.00'
);
INSERT INTO Regalo (
    IdRegaloTipo
    ,Nombre
    ,Stock
    ,Precio
) VALUES(
    '2'
    ,'Chocolates'
    ,'100'
    ,'7.50'
);
INSERT INTO Regalo (
    IdRegaloTipo
    ,Nombre
    ,Stock
    ,Precio
) VALUES(
    '1'
    ,'Poema'
    ,'20'
    ,'4.50'
);

SELECT IdRegalo, IdRegaloTipo, Nombre, Stock, Precio
FROM   Regalo
WHERE  Estado = 'A';