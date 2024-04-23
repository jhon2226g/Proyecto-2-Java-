package arreglos;

import java.io.*;
import java.util.ArrayList;

import clases.Artista;

public class ArregloArtista {
	
    //	Atributos privado
	private ArrayList <Artista> artista;
	//  Constructor
	public ArregloArtista() {
		artista = new ArrayList <Artista> ();
		cargarArtista();
	}
	
   //  Operaciones públicas básicas
	public void adicionar(Artista x) {
		artista.add(x);
		grabarArtista();
	}
	public int tamaño() {
		return artista.size();
	}
	public Artista obtener(int i) {
		return artista.get(i);
	}
	public Artista buscar(int IdArtista) {
		for (int i=0; i<tamaño(); i++)
			if (obtener(i).getidArtista() == IdArtista) 
				return obtener(i);
		return null;
	}
	public void eliminar(Artista x) {
		artista.remove(x);
		grabarArtista();
	}
	public void actualizarArchivo() {
		grabarArtista();	
	}
	private void grabarArtista() {
		try {
			PrintWriter pw;
			String linea;
			Artista x;
			pw = new PrintWriter(new FileWriter("Artista.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				linea =	x.getidArtista() + ";" +
						x.getnombreArtistico() + ";" +
						x.getidGenero() + ";" +
						x.getfechaRegistro() + ";" +
						x.getestado();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	public void cargarArtista() {
		try {
			BufferedReader br;
			int idArtista, idGenero;
			String linea, nombreArtistico;
			String[] s;
			String fechaRegistro;
			boolean estado; 
			br = new BufferedReader(new FileReader("Artista.txt"));
			while ((linea=br.readLine()) != null) {
				s = linea.split(";");
				idArtista = Integer.parseInt(s[0].trim());
				nombreArtistico = s[1].trim();
				idGenero = Integer.parseInt(s[2].trim());
				fechaRegistro = s[3].trim();
				estado = Boolean.parseBoolean(s[4].trim());
				adicionar(new Artista( idArtista , nombreArtistico, idGenero,
						fechaRegistro, estado));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	
	//Operaciones públicas complementarias
	
	public String codigoCorrelativo() {
		if (tamaño() == 0) 
			return "ART001";
		
		else{
			int cod = obtener(tamaño()-1).getidArtista() + 1;
			if(cod%10<0)
				return "ART00" + cod;
			else
				return "ART00" + cod;
		}
	}
}
