package arreglos;

import java.util.ArrayList;
import java.io.*;
import clases.Pedido;

public class ArregloPedido {
	
    //  Atributos privado
	private ArrayList <Pedido> pedido;
	//  Constructor
	public ArregloPedido() {
		pedido = new ArrayList <Pedido> ();
		cargarPedido();
	}
	
   //  Operaciones públicas básicas
	public void adicionar(Pedido x) {
		pedido.add(x);
		grabarPedido();
	}
	public int tamaño() {
		return pedido.size();
	}
	public Pedido obtener(int i) {
		return pedido.get(i);
	}
	public Pedido buscar(int idPedido) {
		for (int i=0; i<tamaño(); i++)
			if (obtener(i).getIdPedido() == idPedido)
				return obtener(i);
		return null;
	}
	public void eliminar(Pedido x) {
		pedido.remove(x);
		grabarPedido();
	}
	public void actualizarArchivo() {
		grabarPedido();	
	}
	
	////////////////////////////////////////////////////
	private void grabarPedido() {
		try {
			PrintWriter pw;
			String linea;
			Pedido x;
			pw = new PrintWriter(new FileWriter("Pedido.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				linea =	x.getIdPedido() + ";" +
						x.getIdUsuario() + ";" +
						x.getIdCliente() + ";" +
						x.getFechaPedido() + ";" +
						x.getEstado();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	public void cargarPedido() {
		try {
			BufferedReader br;
			String linea,  fechaPedido;
			String[] s;
			int estado,idPedido, idUsuario, idCliente;
			br = new BufferedReader(new FileReader("Pedido.txt"));
			while ((linea=br.readLine()) != null) {
				s = linea.split(";");
				idPedido = Integer.parseInt(s[0].trim());
				idUsuario = Integer.parseInt(s[1].trim());
				idCliente = Integer.parseInt(s[2].trim());
				fechaPedido = s[3].trim();
				estado = Integer.parseInt(s[4].trim());
				
				adicionar(new Pedido(idPedido, idUsuario, idCliente,
						fechaPedido,estado));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	
	public String codigoCorrelativo() {
		
		if (tamaño()==0)
			return "PED001";
			
		else{
			int cod;
			cod = obtener(tamaño()-1).getIdPedido() + 1;
			
			if(cod%10<0)
			return "PED0" + cod;
			else
				return "PED00" + cod;
			}
	}
}