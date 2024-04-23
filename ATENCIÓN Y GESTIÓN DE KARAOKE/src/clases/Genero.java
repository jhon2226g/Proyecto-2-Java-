package clases;

public class Genero {
	// Atributos privados
		private int idGenero;
		private int epoca;
		private String descripcion ;
		private boolean estado;
		 
		// Constructor
		public Genero(int idGenero,int epoca, String  descripcion, boolean estado) {
			
			this.idGenero = idGenero;
			this.epoca = epoca;
			this.descripcion = descripcion;
			this.estado = estado;
		}	
		//  Métodos de acceso público: set/get
		public int getidGenero() {
	        return idGenero;
	   }
	   public void setidGenero(int idGenero) {
		this.idGenero = idGenero;
	   }
	   public String  getdescripcion () {
	    return  descripcion ;
	   }
	   public void setdescripcion (String descripcion ) {
		this.descripcion  = descripcion ;
	   }
	   public int  getepoca() {
	    return  epoca;
	   }
	   public void setepoca(int epoca) {
		this.epoca = epoca ;
	   }
	  public boolean getestado() {
	    return estado;
	  }
	 public void setestado(boolean estado) {
		this.estado = estado;
		}
}