package DataAccess.DTO;

public class RegaloDTO {
    private int    IdRegalo;
    private int    IdRegaloTipo;
    private String Nombre;
    private String Estado;
    private int    Stock;
    private double   Precio;
    private String FechaCrea;
    private String FechaModifica;
    
    public RegaloDTO(){}

    public RegaloDTO(int idRegalo, int idRegaloTipo, String nombre, String estado, int stock, double precio,
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

    public int getIdRegalo() {
        return IdRegalo;
    }
    public void setIdRegalo(int idRegalo) {
        IdRegalo = idRegalo;
    }
    public int getIdRegaloTipo() {
        return IdRegaloTipo;
    }
    public void setIdRegaloTipo(int idRegaloTipo) {
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
    public int getStock() {
        return Stock;
    }
    public void setStock(int stock) {
        Stock = stock;
    }
    public double getPrecio() {
        return Precio;
    }
    public void setPrecio(double precio) {
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
