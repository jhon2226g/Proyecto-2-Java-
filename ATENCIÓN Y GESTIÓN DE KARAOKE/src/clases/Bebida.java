package clases;

public class Bebida {
	//Atributos privados
		private String  nombre, marca;
		private int idBebida,tipoBebida;
		private double precio;
		private boolean estado;

		//Constructor
		public Bebida(int idBebida, int tipoBebida, String nombre, double precio, String marca, boolean estado){
			this.idBebida = idBebida;
			this.tipoBebida=tipoBebida;
			this.nombre=nombre;
			this.precio=precio;
			this.marca=marca;
			this.estado=estado;
		}
		//METODOS DE ACCESO PUBLICO SET/GET
		public void setIdBebida(int idBebida){
			this.idBebida=idBebida;
		}
		public void setTipoBebida(int tipoBebida){
			this.tipoBebida=tipoBebida;
		}
		public void setNombre(String nombre){
			this.nombre=nombre;
		}
		public void setPrecio(double precio){
			this.precio=precio;
		}
		public void setMarca(String marca){
			this.marca=marca;
		}
		public void setEstado(boolean estado){
			this.estado=estado;
		}
		
		public int getidBebida(){
			return idBebida;
		}
		public int getTipoBebida(){
			return tipoBebida;
		}
		public String getNombre(){
			return nombre;
		}
		public double getPrecio(){
			return precio;
		}
		public String getMarca(){
			return marca;
		}
		public boolean getEstado(){
			return estado;
		}
}
