package DataAccess.DTO;

public class RegaloDTO {
    private Integer    IdRegalo;
    private Integer    IdRegaloTipo;
    private String Nombre;
    private String Estado;
    private Integer    Stock;
    private Double   Precio;
    private String FechaCrea;
    private String FechaModifica;
    
    public RegaloDTO(){}

    public RegaloDTO(String nombre) {
        Nombre = nombre;
    }
    
    public RegaloDTO(Integer idRegalo, Integer idRegaloTipo, String nombre, String estado, Integer stock, Double precio,
            String fechaCrea, String fechaModifica) {
        this.IdRegalo = idRegalo;
        this.IdRegaloTipo = idRegaloTipo;
        this.Nombre = nombre;
        this.Estado = estado;
        this.Stock = stock;
        this.Precio = precio;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }

    public Integer getIdRegalo() {
        return IdRegalo;
    }
    public void setIdRegalo(Integer idRegalo) {
        IdRegalo = idRegalo;
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
    public Integer getStock() {
        return Stock;
    }
    public void setStock(Integer stock) {
        Stock = stock;
    }
    public Double getPrecio() {
        return Precio;
    }
    public void setPrecio( Double precio) {
        Precio = precio;
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
        + "\n IdRegalo:         " + getIdRegalo()
        + "\n IdRegaloTipo:     " + getIdRegaloTipo()
        + "\n Nombre:           " + getNombre()
        + "\n Estado:           " + getEstado()
        + "\n Stock:            " + getStock()
        + "\n Precio:           " + getPrecio()
        + "\n FechaCrea:        " + getFechaCrea()
        + "\n FechaModifica:    " + getFechaModifica();
    }
}
