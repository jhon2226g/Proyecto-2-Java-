package clases;

public class DetalleConsumo {
	private int codigoConsumo; //clase Consumo
    private String codigoProducto;
    private int cantidad;
    private double subtotal;
          
    public DetalleConsumo(int codigoConsumo , String codigoProducto, int cantidad,
    		double subtotal) {
        this.codigoConsumo = codigoConsumo;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }
    //Metodo de acceso público:set/get
    
    public int getcodigoConsumo() {
        return codigoConsumo;
    }
    
    public void setcodigoConsumo(int codigoConsumo) {
        this.codigoConsumo = codigoConsumo;
    }
    
    public String getCodigoProducto() {
        return codigoProducto;
    }
    
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
      
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double getSubtotal() {
        return subtotal;
    }
    
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}

