package clases;

public class Cancion {
	// Atributos privados 
		private String  nombre, album;
		private String fechaRegistro;
		private int idCancion, idArtista,numeroreproducciones;
		private boolean estado; 
		
		// Constructor
		public Cancion(int idCancion, String nombre, int idArtista, String album, 
				String fechaRegistro, int numeroreproducciones, boolean estado){
			this.idCancion = idCancion;
			this.nombre = nombre;
			this.idArtista = idArtista;
			this.album = album;
			this.fechaRegistro = fechaRegistro;
			this.numeroreproducciones = numeroreproducciones;
			this.estado = estado;
			
		}
		
		// Métodos de acceso público: set/get
		public int getIdCancion(){
			return idCancion;
		}
		public String getNombre(){
			return nombre;
		}
		public int getIdArtista(){
			return idArtista;
		}
		public String getAlbum(){
			return album;	
		}
		public String getFechaRegistro(){
			return fechaRegistro;
		}
		public int getNumeroreproducciones(){
			return numeroreproducciones;
		}
		public boolean getEstado(){
			return estado;
		}
		
		public void setIdCancion(int idCancion){
			this.idCancion = idCancion;
		}
		public void setNombre(String nombre){
			this.nombre = nombre;
		}
		public void setIdArtista(int idArtista){
			this.idArtista = idArtista;
		}
		public void setAlbum(String album){
			this.album = album;
		}
		public void setFechaRegistro(String fechaRegistro){
			this.fechaRegistro = fechaRegistro;
		}
		public void setNumeroreproducciones(int numeroreproducciones){
			this.numeroreproducciones = numeroreproducciones;
		}
		public void setEstado(boolean estado){
			this.estado = estado;
		}
}

