package DataAccess.DTO;

public class RegaloTipoDTO {
    private Integer IdRegaloTipo;
    private String  Nombre;
    private String  Estado;
    private String  FechaCrea;
    private String  FechaModifica;
    
    public RegaloTipoDTO(){}

    public RegaloTipoDTO(String nombre) {
        Nombre = nombre;
    }
    
    public RegaloTipoDTO(Integer idRegaloTipo, String nombre, String estado, String fechaCrea, String fechaModifica) {
        this.IdRegaloTipo = idRegaloTipo;
        this.Nombre = nombre;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }

    public Integer getIdRegaloTipo() {
        return IdRegaloTipo;
    }
    public void setIdRegaloTipo(Integer idRegaloTipo) {
        IdRegaloTipo = idRegaloTipo;
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
    public String toString(){
        return getClass().getName()
               + "\n IdRegaloTipo:  " + getIdRegaloTipo()   
               + "\n Nombre:        " + getNombre()      
               + "\n Estado:        " + getEstado() 
               + "\n FechaCrea:     " + getFechaCrea() 
               + "\n FechaModifica: " + getFechaModifica();
    }
}
