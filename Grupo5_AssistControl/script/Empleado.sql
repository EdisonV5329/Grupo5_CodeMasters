-- database: ../database/ASSIST_CONTROL.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 24.feb.2k24
script: Creacion de la tabla Empleado
*/
DROP TABLE IF EXISTS Empleado;

CREATE TABLE Empleado(
    IdEmpleado       INTEGER        NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdCargo         INTEGER        NOT NULL REFERENCES Cargo(IdCargo)
    ,Nombre          VARCHAR(20)    NOT NULL                  
    ,Apellido        VARCHAR(20)    NOT NULL
    ,Cedula          VARCHAR(10)    NOT NULL UNIQUE
    ,HuellaDigital   TEXT           NOT NULL      
    ,Estado          VARCHAR(1)     NOT NULL DEFAULT('A') 
    ,FechaCrea       DATETIME       NOT NULL DEFAULT(datetime('now', 'localtime'))
    ,FechaModifica   DATETIME             
);

INSERT INTO Empleado(
    IdCargo
    ,Nombre
    ,Apellido
    ,Cedula
    ,HuellaDigital
) VALUES(
    '1'
    ,'Edison'
    ,'Vera'
    ,'2356877402'
    ,'huella_digital'
);