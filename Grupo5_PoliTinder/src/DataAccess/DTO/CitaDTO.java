package DataAccess.DTO;

public class CitaDTO {
    private int idCita;
    private int idPersona1;
    private int idPersona2;
    private String fechaCita;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;

    public CitaDTO() {
    }

    public CitaDTO(int idCita, int idPersona1, int idPersona2, String fechaCita, String estado, String fechaCrea,
            String fechaModifica) {
        this.idCita = idCita;
        this.idPersona1 = idPersona1;
        this.idPersona2 = idPersona2;
        this.fechaCita = fechaCita;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }

    public int getIdCita() {
        return idCita;
    }
    public void setIdCita(int idCita) {
        this.idCita = idCita;
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
    public String getFechaCita() {
        return fechaCita;
    }
    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
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
        + "\nIdCita:        " + getIdCita()             
        + "\nIdPersona1:    " + getIdPersona1()             
        + "\nIdPersona2:    " + getIdPersona2()             
        + "\nIdFechaCita:   " + getFechaCita()             
        + "\nEstado:        " + getEstado()             
        + "\nFechaCrea:     " + getFechaCrea()       
        + "\nFechaModifica: " + getFechaModifica();   
    }

    public void setNombre(String nombre) {
    
        throw new UnsupportedOperationException("Unimplemented method 'setNombre'");
    }

    public void setidCita(int idCita2) {
    
        throw new UnsupportedOperationException("Unimplemented method 'setidCita'");
    }

}
