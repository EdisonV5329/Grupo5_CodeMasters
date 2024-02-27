/*
|------------------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved.        |
| nombre.apellido@epn.edu.ec   Nombre Autor      |
|------------------------------------------------|
Autor: Nombre Autor
Fecha: dia.mes.2k24
script: Especificacion de lo creado
*/
package DataAccess.DTO;

public class EstatusDTO {
    private int    idEstatus;     
    private String Nombre;       
    private String Estado;       
    private String FechaCrea;    
    private String FechaModifica;

    public EstatusDTO(){}
    public EstatusDTO(int  idEstatus,    
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

    public int getIdEstatus() {
        return idEstatus;
    }
    public void setIdEstatus(int idestatus) {
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
