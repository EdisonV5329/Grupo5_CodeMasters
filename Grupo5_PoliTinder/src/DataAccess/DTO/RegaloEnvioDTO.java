package DataAccess.DTO;

public class RegaloEnvioDTO {
    private int    IdRegaloEnvio;
    private int    IdPersonaEnvia;
    private int    IdPersonaRecibe;
    private int    IdRegalo;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;
    
    public  RegaloEnvioDTO() {}

    public RegaloEnvioDTO(int idRegaloEnvio, int idPersonaEnvia, int idPersonaRecibe, int idRegalo, String estado,
            String fechaCrea, String fechaModifica) {
        this.IdRegaloEnvio = idRegaloEnvio;
        this.IdPersonaEnvia = idPersonaEnvia;
        this.IdPersonaRecibe = idPersonaRecibe;
        this.IdRegalo = idRegalo;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }

    public int getIdRegaloEnvio() {
        return IdRegaloEnvio;
    }
    public void setIdRegaloEnvio(int idRegaloEnvio) {
        IdRegaloEnvio = idRegaloEnvio;
    }
    public int getIdPersonaEnvia() {
        return IdPersonaEnvia;
    }
    public void setIdPersonaEnvia(int idPersonaEnvia) {
        IdPersonaEnvia = idPersonaEnvia;
    }
    public int getIdPersonaRecibe() {
        return IdPersonaRecibe;
    }
    public void setIdPersonaRecibe(int idPersonaRecibe) {
        IdPersonaRecibe = idPersonaRecibe;
    }
    public int getIdRegalo() {
        return IdRegalo;
    }
    public void setIdRegalo(int idRegalo) {
        IdRegalo = idRegalo;
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

    public void setNombre(String nombre) {
        throw new UnsupportedOperationException("Unimplemented method 'setNombre'");
    }
    
    @Override
    public  String toString() {
        return getClass().getName()
        + "\n IdRegaloEnvio:    " + getIdRegaloEnvio()
        + "\n IdPersonaEnvia:   " + getIdPersonaEnvia()
        + "\n IdPersonaRecibe:  " + getIdPersonaRecibe()
        + "\n IdRegalo:         " + getIdRegalo()
        + "\n Estado:           " + getEstado()
        + "\n FechaCrea:        " + getFechaCrea()
        + "\n FechaModifica:    " + getFechaModifica();

    }

   


}
