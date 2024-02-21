package DataAccess.DTO;

public class PersonaDTO {
    private int    IdPersona;
    private int    IdPersonaRol;
    private int    IdPersonaSexo;
    private String Cedula;
    private String Nombre;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;
    
    public PersonaDTO(){}

    public PersonaDTO(int idPersona, int idPersonaRol, int idPersonaSexo, String cedula, String nombre, String estado,
            String fechaCrea, String fechaModifica) {
        this.IdPersona = idPersona;
        this.IdPersonaRol = idPersonaRol;
        this.IdPersonaSexo = idPersonaSexo;
        this.Cedula = cedula;
        this.Nombre = nombre;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }

    public int getIdPersona() {
        return IdPersona;
    }
    public void setIdPersona(int idPersona) {
        IdPersona = idPersona;
    }
    public int getIdPersonaRol() {
        return IdPersonaRol;
    }
    public void setIdPersonaRol(int idPersonaRol) {
        IdPersonaRol = idPersonaRol;
    }
    public int getIdPersonaSexo() {
        return IdPersonaSexo;
    }
    public void setIdPersonaSexo(int idPersonaSexo) {
        IdPersonaSexo = idPersonaSexo;
    }
    public String getCedula() {
        return Cedula;
    }
    public void setCedula(String cedula) {
        Cedula = cedula;
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
        + "\n IdPersona:        " + getIdPersona()
        + "\n IdPersonaRol:     " + getIdPersonaRol()
        + "\n IdPersonaSexo:    " + getIdPersonaSexo()
        + "\n Cedula:           " + getCedula()
        + "\n Nombre:           " + getNombre()
        + "\n Estado:           " + getEstado()
        + "\n FechaCrea:        " + getFechaCrea()
        + "\n FechaModifica:    " + getFechaModifica();
    }
}
