package arreglos;

import clases.Piqueo;

import java.util.ArrayList;
import java.io.*;

public class ArregloPiqueos {

	// Atributos privados
	private ArrayList <Piqueo> piqueo;
	private int indice;
	//Constructor
	public ArregloPiqueos(int indice){
		piqueo =new ArrayList <Piqueo> ();
		this.indice=indice;
		cargarPiqueos();
	}
	//operaciones p�blicas b�sicas
	public void adicionar(Piqueo x){
		piqueo.add(x);
		grabarPiqueos();
	}
	public int tama�o(){
		return piqueo.size();
	}
	public Piqueo obtener(int i){
		return piqueo.get(i);
	}
	public Piqueo buscar(int idPiqueo){
		for(int i=0; i<tama�o(); i++)
			if (obtener(i).getIdPiqueo()== idPiqueo)
				return obtener(i);
		return null;
	}
	public void eliminar(Piqueo x){
		piqueo.remove(x);
		grabarPiqueos();
	}
	public void actualizarArchivo(){
		grabarPiqueos();
	}
	private void grabarPiqueos(){
		try{
			PrintWriter pw;
			String linea;
			Piqueo x;
			pw=new PrintWriter(new FileWriter("piqueos"+indice+".txt"));
			for (int i=0; i<tama�o(); i++){
				x=obtener(i);
				linea = x.getIdPiqueo()+";"+
						x.getTipoPiqueo()+";"+
						x.getNombre()+";"+
						x.getPrecio()+";"+
						x.getEstado();
				pw.println(linea);
			}
			pw.close();
		}
		catch(Exception e){
		}
	}
	private void cargarPiqueos(){
		try{
			BufferedReader br;
			String  linea, nombre;
			String[] s;
			int  idPiqueo,tipoPiqueo;
			double precio;
			boolean estado;
			br= new BufferedReader(new FileReader("piqueos"+indice+".txt"));
			while((linea=br.readLine()) !=null){
				s=linea.split(";");
				idPiqueo=Integer.parseInt(s[0].trim());
				tipoPiqueo=Integer.parseInt(s[1].trim());
				nombre = s[2].trim();
				precio=Double.parseDouble(s[3].trim());
				estado=Boolean.parseBoolean(s[4].trim());
				adicionar(new Piqueo(idPiqueo, tipoPiqueo, nombre, precio, estado));
			}
			br.close();
		}
		catch (Exception e){
			}
	}
	//Operaciones p�blicas complementarias
	public String codigoCorrelativo(){
		if(tama�o()==0){
			return "PIQ001";
		}
		else{
			int cod = obtener(tama�o()-1).getIdPiqueo()+1;
			if(cod%10<0)
				return "PIQ00" + cod;
			else
				return "PIQ0" + cod;
		}
	}
	}
