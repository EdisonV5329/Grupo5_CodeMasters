package DataAccess.DTO;

public class RelacionTipoDTO {
    private int    IdRelacionTipo;
    private String Nombre;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;
    
    public  RelacionTipoDTO() {}

    public RelacionTipoDTO(String nombre) {
        Nombre = nombre;
    }

    public RelacionTipoDTO(int idRegaloTipo, String nombre, String estado, String fechaCrea, String fechaModifica) {
        this.IdRelacionTipo = idRegaloTipo;
        this.Nombre = nombre;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }

    public Integer getIdRelacionTipo() {
        return IdRelacionTipo;
    }
    public void setIdRelacionTipo(int idRegaloTipo) {
        IdRelacionTipo = idRegaloTipo;
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
        + "\n IdRelacionTipo:    " + getIdRelacionTipo() 
        + "\n Nombre:            " + getNombre() 
        + "\n Estado:            " + getEstado() 
        + "\n FechaCrea:         " + getFechaCrea() 
        + "\n FechaModifica:     " + getFechaModifica();
    }
}
