package arreglos;

import java.io.*;
import java.util.ArrayList;
import clases.Usuario;

public class ArregloUsuario {
	private ArrayList <Usuario> arr;
	//constructor
	public ArregloUsuario(){
		arr = new ArrayList <Usuario>();
		cargarUsuarios();
	}
	
	public void adicionar(Usuario x){
		arr.add(x);
		grabarUsuarios();
	}
	
	public int tamanio(){
		return arr.size();
	}
	public Usuario obtener(int i){
		return arr.get(i);
	}
	public Usuario buscar(int cod){
		for (int i=0;i<tamanio();i++)
			if(obtener(i).getidUsuario()== cod)
				return obtener(i);
		return null;
			
	}
	public void eliminar(Usuario x){
		arr.remove(x);
		grabarUsuarios();
	}
	public void actualizar(){
		grabarUsuarios();
	}
	
	private void grabarUsuarios() {
		try {
			PrintWriter pw;
			String linea;
			Usuario x;
			pw = new PrintWriter(new FileWriter("Usuarios.txt"));
			for (int i=0; i<tamanio(); i++) {
				x = obtener(i);
				linea = x.getidUsuario() + ";" +
						x.getapellidoPaterno() + ";" +
						x.getapellidoMaterno() + ";" +
						x.getnombres() + ";" +
						x.gettipoEmpleado()+";"+
						x.getlogin()+";"+
						x.getpassword()+";"+
						x.getturno();				
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {	
		}
	}
	private void cargarUsuarios() {
		try {
			BufferedReader br;
			String linea, apePa, apeMa, nom, login, pass;
			String[] s;
			int id, tipo, turno;
			br = new BufferedReader(new FileReader("Usuarios.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				id = Integer.parseInt(s[0].trim());
				apePa = s[1].trim();
				apeMa = s[2].trim();
				nom = s[3].trim();
				tipo = Integer.parseInt(s[4].trim());
				login = s[5].trim();
				pass = s[6].trim();
				turno = Integer.parseInt(s[7].trim());
				adicionar(new Usuario(id, apePa, apeMa, nom,tipo, login, pass, turno));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	
	public String CodigoCorrelativo(){
		
		
		if (tamanio()==0){
			return "USU001";
		}
		else{
			int cod;
			cod = obtener(tamanio()-1).getidUsuario()+1;
			
			if(cod%10<0)
			return "USU0" + cod;
			else
				return "USU00" + cod;
		}
	}
}
