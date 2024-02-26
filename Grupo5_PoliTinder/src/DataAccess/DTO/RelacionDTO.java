/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 19.feb.2k24
Script: Creacion de la clase RelacionDTO
*/
package DataAccess.DTO;

public class RelacionDTO {
    private int    idRelacion;
    private int    idRelacionTipo;
    private int    idPersona1; 
    private int    idPersona2; 
    private String fechaInicioRelacion; 
    private String Estado; 
    private String fechaCrea; 
    private String fechaModifica;

    public RelacionDTO() {
    }

    public RelacionDTO(int idRelacion, int idRelacionTipo, int idPersona1, int idPersona2, String fechaInicioRelacion,
            String estado, String fechaCrea, String fechaModifica) {
        this.idRelacion = idRelacion;
        this.idRelacionTipo = idRelacionTipo;
        this.idPersona1 = idPersona1;
        this.idPersona2 = idPersona2;
        this.fechaInicioRelacion = fechaInicioRelacion;
        Estado = estado;
        this.fechaCrea = fechaCrea;
        this.fechaModifica = fechaModifica;
    }
    
    public int getIdRelacion() {
        return idRelacion;
    }
    public void setIdRelacion(int idRelacion) {
        this.idRelacion = idRelacion;
    }
    public int getIdRelacionTipo() {
        return idRelacionTipo;
    }
    public void setIdRelacionTipo(int idRelacionTipo) {
        this.idRelacionTipo = idRelacionTipo;
    }
    public int getIdPersona1() {
        return idPersona1;
    }
    public void setIdPersona1(int idPersona1) {
        this.idPersona1 = idPersona1;
    }
    public int getIdPersona2() {
        return idPersona2;
    }
    public void setIdPersona2(int idPersona2) {
        this.idPersona2 = idPersona2;
    }
    public String getFechaInicioRelacion() {
        return fechaInicioRelacion;
    }
    public void setFechaInicioRelacion(String fechaInicioRelacion) {
        this.fechaInicioRelacion = fechaInicioRelacion;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    public String getFechaCrea() {
        return fechaCrea;
    }
    public void setFechaCrea(String fechaCrea) {
        this.fechaCrea = fechaCrea;
    }
    public String getFechaModifica() {
        return fechaModifica;
    }
    public void setFechaModifica(String fechaModifica) {
        this.fechaModifica = fechaModifica;
    } 

    @Override
    public String toString(){
        return getClass().getName()
        + "\nIdRelacion:          " + getIdRelacion()             
        + "\nIdRelacionTipo:      " + getIdRelacionTipo()             
        + "\nIdPersona1:          " + getIdPersona1()             
        + "\nIdPersona2:          " + getIdPersona2()             
        + "\nFechaInicioRelacion: " + getFechaInicioRelacion()             
        + "\nEstado:              " + getEstado()             
        + "\nFechaCrea:           " + getFechaCrea()       
        + "\nFechaModifica:       " + getFechaModifica();   
    }
}
