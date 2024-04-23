package clases;

public class Consumo {
	 private int codigoConsumo;
	 private int cliente;
	 private String fechaConsumo;
	 private double importeTotal;
	    
	 public Consumo(int cliente ,int codigoConsumo, String fechaConsumo, double importeTotal) {
	        this.codigoConsumo = codigoConsumo;
	        this.cliente = cliente;
	        this.fechaConsumo = fechaConsumo;
	        this.importeTotal = importeTotal;
	    }
	    //Metodo de acceso público:set/get
	 
	    public void setcodigoConsumo(int codigoConsumo) {
	    	this.codigoConsumo = codigoConsumo;
	    }
	    public int getcodigoConsumo() {
	        return codigoConsumo;
	    }
	    
	    public int getCliente() {
	        return cliente;
	    }
	    
	    public void setCliente(int cliente) {
	        this.cliente = cliente;
	    }
	    
	    public String getFechaConsumo() {
	        return fechaConsumo;
	    }
	    
	    public void setFechaConsumo(String fechaConsumo) {
	        this.fechaConsumo = fechaConsumo;
	    }
	    
	    public double getImporteTotal() {
	        return importeTotal;
	    }
	    
	    public void setImporteTotal(double importeTotal) {
	        this.importeTotal = importeTotal;
	    }	
}

