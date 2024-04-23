package clases;

import java.sql.Date;

public class Artista {

	// Atributos privados
	private int idArtista;
	private String  nombreArtistico;
	private int  idGenero;
	private String fechaRegistro;
	private boolean estado;
    
	// Constructor
	public Artista(int idArtista , String nombreArtistico, int idGenero,
			String fechaRegistro,boolean estado) {
		this.idArtista = idArtista;
		this.nombreArtistico = nombreArtistico;
		this.idGenero = idGenero;
		this.fechaRegistro = fechaRegistro;
		this.estado = estado;
		
	}
	// Métodos de acceso público: set/get

	public int getidArtista() {
	        return idArtista;
	}
	
	public void setidArtista(int idArtista) {
		this.idArtista = idArtista;
	}
	public int getidGenero() {
        return  idGenero;
    }
	public void setidGenero(int idGenero) {
		this.idGenero = idGenero;
	}
	public String  getnombreArtistico() {
        return  nombreArtistico;
    }
	public String setnombreArtistico(String nombreArtistico) {
		return nombreArtistico;
	}
	public String getfechaRegistro() {
        return fechaRegistro;
}
	public void setfechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public boolean getestado() {
        return estado;
	}
	public void setestado(boolean estado) {
		this.estado = estado;
	}
	
	
}