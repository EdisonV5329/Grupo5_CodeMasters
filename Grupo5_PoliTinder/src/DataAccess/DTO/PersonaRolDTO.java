package DataAccess.DTO;

public class PersonaRolDTO {
    private int    IdPersonaRol;       
    private int    IdPersonaRol_Padre; 
    private String Nombre;
    private String Estado;       
    private String FechaCrea;    
    private String FechaModifica;
    
    public PersonaRolDTO() {
    }

    public PersonaRolDTO(int idPersonaRol, int idPersonaRol_Padre, String nombre, String estado, String fechaCrea,
            String fechaModifica) {
        IdPersonaRol = idPersonaRol;
        IdPersonaRol_Padre = idPersonaRol_Padre;
        Nombre = nombre;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }

    public int getIdPersonaRol() {
        return IdPersonaRol;
    }

    public void setIdPersonaRol(int idPersonaRol) {
        IdPersonaRol = idPersonaRol;
    }

    public int getIdPersonaRol_Padre() {
        return IdPersonaRol_Padre;
    }

    public void setIdPersonaRol_Padre(int idPersonaRol_Padre) {
        IdPersonaRol_Padre = idPersonaRol_Padre;
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
        + "\nIdPersonaRol:       " + getIdPersonaRol()             
        + "\nIdPersonaRol_Padre: " + getIdPersonaRol_Padre()             
        + "\nNombre:             " + getNombre()             
        + "\nEstado:             " + getEstado()             
        + "\nFechaCrea:          " + getFechaCrea()       
        + "\nFechaModifica:      " + getFechaModifica();   
    }
}
