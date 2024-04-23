package arreglos;

import java.io.*;
import java.util.ArrayList;

import clases.Bebida;

public class ArregloBebidas {
	
	//Atributos privados
	private ArrayList <Bebida> bebida;
	private int indice;
	//Constructores
	public ArregloBebidas(int indice){
		bebida= new ArrayList <Bebida>();
		this.indice =indice;
		cargarBebida();
	}
	//Operaciones públicas básicas
	public void adicionar(Bebida x) {
		bebida.add(x);
		grabarBebida();
	}
	
	public int tamaño(){
		return bebida.size();
	}
	public Bebida obtener (int i){
		return bebida.get(i);
	}
	public Bebida buscar (int idBebida){
		for (int i=0; i<tamaño(); i++)
			if(obtener(i).getidBebida()== idBebida)
				return obtener(i);
		return null;
	}
	public void eliminar(Bebida x){
		bebida.remove(x);
		grabarBebida();
		}
	public void actualizarArchivo(){
		grabarBebida();
	}
	private void grabarBebida(){
		try{
			PrintWriter pW;
			String linea;
			Bebida x;
			pW = new PrintWriter(new FileWriter("Bebida"+indice+".txt"));
			for (int i=0; i<tamaño();i++){
				x=obtener(i);
				linea = x.getidBebida()+";"+
						x.getTipoBebida() + ";" +
						x.getNombre()+ ";" +
						x.getPrecio() + ";" +
						x.getMarca()+ ";" +
						x.getEstado();
				pW.println(linea);  
			}
			pW.close();
		}
		catch (Exception e){
			}
	}
	private void cargarBebida(){
		try{
			BufferedReader br;
			String  linea, nombre, marca;
			String[] s;
			int  idBebida,tipoBebida;
			double precio;
			boolean estado;
			br= new BufferedReader(new FileReader("bebida"+indice+".txt"));
			while((linea=br.readLine()) !=null){
				s=linea.split(";");
				idBebida=Integer.parseInt(s[0].trim());
				tipoBebida=Integer.parseInt(s[1].trim());
				nombre = s[2].trim();
				precio=Double.parseDouble(s[3].trim());
				marca= s[4].trim();
				estado=Boolean.parseBoolean(s[5].trim());
				adicionar(new Bebida(idBebida, tipoBebida, nombre, precio, marca, estado));
			}
			br.close();
		}
		catch (Exception e){
			}
	}
	// Operaciones públicas complementarias
	public String codigoCorrelativo(){
	if (tamaño()==0)
		return "BEB001";
		
	else{
		int cod;
		cod = obtener(tamaño()-1).getidBebida()+1;
		
		if(cod%10<0)
		return "BEB0" + cod;
		else
			return "BEB00" + cod;
		}
	}
}