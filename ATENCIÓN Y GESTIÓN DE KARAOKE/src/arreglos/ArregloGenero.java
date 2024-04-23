package arreglos;

import clases.Genero;
import clases.Usuario;

import java.io.*;
	import java.util.ArrayList;

public class ArregloGenero {
		
		
		private ArrayList <Genero> genero;
		//  Constructor
		public ArregloGenero () {
			genero = new ArrayList <Genero> ();
			cargarGenero();
		}
		
		public void adicionar(Genero  x) {
			genero.add(x);
			grabarGenero ();
		}
		public int tamaño() {
			return genero.size();
		}
		public Genero  obtener(int i) {
			return genero.get(i);
		}
		public Genero buscar(int idGenero) {
			for (int i=0; i<tamaño(); i++)
				if (obtener(i).getidGenero()==idGenero)
					return obtener(i);
			return null;
		}
		public void eliminar(Genero  x) {
			genero .remove(x);
			grabarGenero();
		}
		public void actualizar() {
			grabarGenero();	
		}
		private void grabarGenero () {
			try {
				PrintWriter pw;
				String linea;
				Genero x;
				pw = new PrintWriter(new FileWriter("generos.txt"));
				for (int i=0; i<tamaño(); i++) {
					x = obtener(i);
					linea = x.getidGenero() + ";" +
							x.getepoca() + ";" +
							x.getdescripcion() + ";" +
							x.getestado();
					pw.println(linea);
				}
				pw.close();
			}
			catch (Exception e) {	
			}
		}
		
		private void cargarGenero() {
			try {
				BufferedReader br;
				String  descripcion, linea;
				boolean estado;
				String[] s;
				int epoca,id;
				br = new BufferedReader(new FileReader("generos.txt"));
				while ((linea = br.readLine()) != null) {
					s = linea.split(";");
					id = Integer.parseInt(s[0].trim());
					epoca = Integer.parseInt(s[1].trim());
					descripcion = s[2].trim();
					estado = Boolean.parseBoolean(s[3].trim());
					adicionar(new Genero(id, epoca, descripcion, estado));
				}
				br.close();
			}
			catch (Exception e) {
			}
		}
		
		public String codigoCorrelativo() {
			
			if (tamaño()==0){
				return "GEN001";
			}
			else{
				int cod;
				cod = obtener(tamaño()-1).getidGenero () + 1;
				
				if(cod%10<0)
				return "GEN0" + cod;
				else
					return "GEN00" + cod;
			}
		}
		
	}