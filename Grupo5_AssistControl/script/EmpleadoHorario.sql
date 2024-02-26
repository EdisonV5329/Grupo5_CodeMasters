-- database: ../database/ASSIST_CONTROL.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 25.feb.2k24
script: Creacion de la tabla EmpleadoHorario
*/
DROP TABLE IF EXISTS EmpleadoHorario;

CREATE TABLE EmpleadoHorario(
    IdEmpleadoHorario   INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdDiaTrabajo       INTEGER     NOT NULL REFERENCES DiaTrabajo (IdDiaTrabajo)
    ,IdHoraAmEntrada    INTEGER     NOT NULL REFERENCES Hora (IdHora)
    ,IdHoraAmSalida     INTEGER     NOT NULL REFERENCES Hora (IdHora)
    ,IdHoraPmEntrada    INTEGER     NOT NULL REFERENCES Hora (IdHora)
    ,IdHoraPmSalida     INTEGER     NOT NULL REFERENCES Hora (IdHora)
    ,Estado             VARCHAR(1)  NOT NULL DEFAULT('A') 
    ,FechaCrea          DATETIME    NOT NULL DEFAULT(datetime('now', 'localtime'))
    ,FechaModifica      DATETIME
);

INSERT INTO  EmpleadoHorario(
    IdDiaTrabajo
    ,IdHoraAmEntrada
    ,IdHoraAmSalida
    ,IdHoraPmEntrada
    ,IdHoraPmSalida
) VALUES(
    '1'
    ,'1'
    ,'4'
    ,'6'
    ,'8' 
);
INSERT INTO  EmpleadoHorario(
    IdDiaTrabajo
    ,IdHoraAmEntrada
    ,IdHoraAmSalida
    ,IdHoraPmEntrada
    ,IdHoraPmSalida
) VALUES(
    '1'
    ,'2'
    ,'5'
    ,'6'
    ,'10' 
);
