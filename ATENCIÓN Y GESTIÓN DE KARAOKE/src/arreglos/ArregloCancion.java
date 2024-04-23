package arreglos;

import clases.Cancion;

import java.io.*;
import java.util.ArrayList;

public class ArregloCancion {
	
    //	Atributos privado
	private ArrayList <Cancion> cancion;
	private int indice=0;
	//  Constructor
	public ArregloCancion(int indice) {
		cancion = new ArrayList <Cancion> ();
		this.indice = indice;
		cargarCancion();
	}
	
   //  Operaciones públicas básicas
	public void adicionar(Cancion x) {
		cancion.add(x);
		grabarCancion();
	}
	public int tamaño() {
		return cancion.size();
	}
	public Cancion obtener(int i) {
		return cancion.get(i);
	}
	public Cancion buscar(int IdCancion) {
		for (int i=0; i<tamaño(); i++)
			if (obtener(i).getIdCancion() == IdCancion) 
				return obtener(i);
		return null;
	}
	public void eliminar(Cancion x) {
		cancion.remove(x);
		grabarCancion();
	}
	public void actualizarArchivo() {
		grabarCancion();	
	}
	private void grabarCancion() {
		try {
			PrintWriter pw;
			String linea;
			Cancion x;
			pw = new PrintWriter(new FileWriter("Cancion"+indice+".txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				linea =	x.getIdCancion() + ";" +
						x.getNombre() + ";" +
						x.getIdArtista() + ";" +
						x.getAlbum() + ";" +
						x.getFechaRegistro() + ";" +
						x.getNumeroreproducciones() + ";" +
						x.getEstado();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	public void cargarCancion() {
		try {
			BufferedReader br;
			String linea,  nombre, album;
			String[] s;
			int idCancion, idArtista,numeroreproducciones;
			String fechaRegistro;
			boolean estado; 
			br = new BufferedReader(new FileReader("Cancion"+indice+".txt"));
			while ((linea=br.readLine()) != null) {
				s = linea.split(";");
				idCancion = Integer.parseInt(s[0].trim());
				nombre = s[1].trim();
				idArtista = Integer.parseInt(s[2].trim());
				album = s[3].trim();
				fechaRegistro = s[4].trim();
				numeroreproducciones = Integer.parseInt(s[5].trim());
				estado = Boolean.parseBoolean(s[6].trim());
				adicionar(new Cancion( idCancion, nombre, idArtista, album
						,fechaRegistro, numeroreproducciones, estado));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	
	public String codigoCorrelativo() {
		if (tamaño() == 0) 
			return "CAN001";
		
		else{
			int cod = obtener(tamaño()-1).getIdCancion() + 1;
			if(cod%10<0)
				return "CAN00" + cod;
			else
				return "CAN0" + cod;
			
		}
	}
}
