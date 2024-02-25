/*
|------------------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved.        |
| francisco.torres@epn.edu.ec   Francisco Torres |
|------------------------------------------------|
Autor: Francisco Torres
Fecha: 24.feb.2k24
script: Creacion de la clase EstatusDTO
*/
package DataAccess.DTO;

public class EstatusDTO {
    private int    IdEstatus;     
    private String Nombre;       
    private String Estado;       
    private String FechaCrea;    
    private String FechaModifica;

    public EstatusDTO(){}
    public EstatusDTO(int  IdEstatus,    
                    String Nombre,       
                    String Estado,       
                    String FechaCrea,    
                    String FechaModifica

    ){
        this.IdEstatus     = IdEstatus; 
        this.Nombre        = Nombre;
        this.Estado        = Estado;
        this.FechaCrea     = FechaCrea; 
        this.FechaModifica = FechaModifica;      
    }

    public int getIdEstatus() {
        return IdEstatus;
    }
    public void setIdEstatus(int idestatus) {
        IdEstatus = idestatus;
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
        +"\n IdEstatus:         " + getIdEstatus()
        +"\n Nombre:            " + getNombre()
        +"\n Estado:            " + getEstado()
        +"\n FechaCrea:         " + getFechaCrea()
        +"\n FechaModifica      " + getFechaModifica();
    }
}
