/*
|------------------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved.         |
| francisco.torres@epn.edu.ec   Francisco Torres |
| mateo.simbana@epn.edu.ec   mateitopro          |
|------------------------------------------------|
Autor: Francisco Torres y mateitopro
Fecha: 29.feb.2k24
script: Creacion de la clase EstatusDTO
*/
package DataAccess.DTO;

public class EstatusDTO {
    private Integer idEstatus;     
    private String  Nombre;       
    private String  Estado;       
    private String  FechaCrea;    
    private String  FechaModifica;

    public EstatusDTO(){}

    public EstatusDTO(String nombre) {
        Nombre = nombre;
    }
    
    public EstatusDTO(Integer  idEstatus,    
                    String Nombre,       
                    String Estado,       
                    String FechaCrea,    
                    String FechaModifica

    ){
        this.idEstatus     = idEstatus; 
        this.Nombre        = Nombre;
        this.Estado        = Estado;
        this.FechaCrea     = FechaCrea; 
        this.FechaModifica = FechaModifica;      
    }

    public Integer getIdEstatus() {
        return idEstatus;
    }
    public void setIdEstatus(Integer idestatus) {
        idEstatus = idestatus;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    public String getFechaCrea() {
        return FechaCrea;
    }
    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }
    public String getFechaModifica() {
        return FechaModifica;
    }
    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }

    @Override
    public String toString() {
        return getClass().getName()
        +"\n idEstatus:         " + getIdEstatus()
        +"\n Nombre:            " + getNombre()
        +"\n Estado:            " + getEstado()
        +"\n FechaCrea:         " + getFechaCrea()
        +"\n FechaModifica      " + getFechaModifica();
    }
}
