-- database: ../database/ASSIST_CONTROL.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 24.feb.2k24
script: Creacion de la tabla RegistroHorario
*/

DROP TABLE IF EXISTS RegistroHorario;

CREATE TABLE RegistroHorario(
    IdRegistroHorario       INTEGER        NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdEmpleado             INTEGER        NOT NULL REFERENCES Empleado(IdEmpleado)
    ,IdEstatus              INTEGER        REFERENCES Estatus(IdEstatus)
    ,HoraAmEntrada          TIME                        
    ,HoraAmSalida           TIME                        
    ,HoraPmEntrada          TIME                        
    ,HoraPmSalida           TIME           
    ,Estado                 VARCHAR(1)     NOT NULL DEFAULT('A') 
    ,FechaCrea              DATETIME       NOT NULL DEFAULT(datetime('now', 'localtime'))
    ,FechaModifica          DATETIME             
);

INSERT INTO RegistroHorario (IdEmpleado, IdEstatus, HoraAmEntrada, HoraAmSalida, HoraPmEntrada, HoraPmSalida) VALUES
(1, 2, "7:30", "12:00", "14:00", "17:00");

SELECT rh.IdRegistroHorario IdRegistroHorario
       , em.Nombre Nombre
       , rh.HoraAmEntrada HoraAmEntrada
       , rh.HoraAmSalida HoraAmSalida
       , rh.HoraPmEntrada HoraPmEntrada
       , rh.HoraPmSalida HoraPmSalida
       , es.Nombre Estatus
       , rh.FechaCrea Fecha
FROM RegistroHorario               rh 
JOIN Empleado     em ON em.IdEmpleado = rh.IdEmpleado
JOIN Estatus      es ON es.IdEstatus  = rh.IdEstatus
WHERE   rh.Estado = 'A'
AND     em.Estado = 'A'
AND     es.Estado = 'A';

SELECT COUNT (*) TotalRegistroHorario 
FROM RegistroHorario
WHERE Estado = 'A';


