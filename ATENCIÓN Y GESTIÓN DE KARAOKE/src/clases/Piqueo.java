package clases;

public class Piqueo {
	//Atributos privados
			private String  nombre;
			private int idPiqueo,tipoPiqueo;
			private double precio;
			private boolean estado;
			
			//Constructores
			public Piqueo(int idPiqueo, int tipoPiqueo, String nombre,
					double precio, boolean estado){
				this.idPiqueo = idPiqueo;
				this.tipoPiqueo = tipoPiqueo;
				this.nombre= nombre;
				this.precio=precio;
				this.estado=estado;
			}
			//MÉTODOS DE ACCESO PÚBLICO  set/get
			public void setIdPiqueo(int idPiqueo){
				this.idPiqueo=idPiqueo;
			}
			public void setTipoPiqueo(int tipoPiqueo){
				this.tipoPiqueo=tipoPiqueo;
			}
			public void setNombre(String nombre){
				this.nombre=nombre;
			}
			public void setPrecio(double precio){
				this.precio=precio;
			}
			public void setestado(boolean estado){
				this.estado=estado;
			}
			
			public int getIdPiqueo(){
				return idPiqueo;
			}
			public int getTipoPiqueo(){
				return tipoPiqueo;
			}
			public String getNombre(){
				return nombre;
			}
			public double getPrecio(){
				return precio;
			}
			public boolean getEstado(){
				return estado;
			}
}

