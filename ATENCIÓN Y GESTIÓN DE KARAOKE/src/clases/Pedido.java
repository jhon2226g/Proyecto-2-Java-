package clases;

public class Pedido {
	// Atributos privados 
		private String fechaPedido;
		private int estado,idPedido, idUsuario, idCliente ;
		//Constructor
		public Pedido(int idPedido, int idUsuario, int idCliente, String fechaPedido, int estado){
			this.idPedido = idPedido;
			this.idUsuario = idUsuario;
			this.idCliente = idCliente;
			this.fechaPedido = fechaPedido;
			this.estado = estado;
		}
		
		// Metodos de acceso público: set/get
		public int getIdPedido(){
			return idPedido;
		}
		public int getIdUsuario(){
			return idUsuario;
		}
		public int getIdCliente(){
			return idCliente;
		}
		public String getFechaPedido(){
			return fechaPedido;
		}
		public int getEstado(){
			return estado;
		}
		public void setIdPedido(int idPedido){
			this.idPedido = idPedido;
		}
		public void setIdUsuario(int idUsuario){
			this.idUsuario = idUsuario;
		}
		public void setIdCliente(int idCliente){
			this.idCliente = idCliente;
		}
		public void setFechaPedido(String fechaPedido){
			this.fechaPedido = fechaPedido;
		}
		public void setEstado(int estado){
			this.estado = estado;
		}
}
