package arreglos;
import clases.Cliente;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArregloClientes {
	//Atributos privados
		private ArrayList <Cliente> Cliente;
		
		//Constructores
		public ArregloClientes(){
			Cliente= new ArrayList <Cliente>();
			cargarCliente();
		}
		//Operaciones públicas básicas
		public void adicionar(Cliente x) {
			Cliente.add(x);
			grabarCliente();
		}
		
		public int tamaño(){
			return Cliente.size();
		}
		public Cliente obtener (int i){
			return Cliente.get(i);
		}
		public Cliente buscar(int idCliente){
			for (int i=0; i<tamaño(); i++)
				if(obtener(i).getidCliente()== idCliente)
					return obtener(i);
			return null;
		}
		public void eliminar(Cliente x){
			Cliente.remove(x);
			grabarCliente();
			}
		public void actualizar(){
			grabarCliente();
		}
		private void grabarCliente(){
			try{
				PrintWriter pW;
				String linea;
				Cliente x;
				pW = new PrintWriter(new FileWriter("Clientes.txt"));
				for (int i=0; i<tamaño();i++){
					x=obtener(i);
					linea = x.getidCliente()+";"+
							x.getapellidoPaterno() + ";" +
							x.getapellidoMaterno() + ";" +
							x.getnombres()+ ";" +
							x.getdireccion() + ";" +
							x.getfechaNacimiento() + ";" +
							x.getfechaAfiliacion() + ";" +
							x.getestadoCivil()+ ";" +
							x.gettelefono()+ ";" +
							x.getdni()+ ";" +
							x.gettipoCliente()
							;
					pW.println(linea);  
				}
				pW.close();
			}
			catch (Exception e){
				}
		}
		public void cargarCliente(){
			try{
				BufferedReader br;
				String  linea, nombres, apePA, 
				apeMA, direccion, fechaNA, fechaAF, telefono
				, dni;
				String[] s;
				int  estadocivil,idcliente,tipocliente;
				br= new BufferedReader(new FileReader("Clientes.txt"));
				while((linea=br.readLine()) !=null){
					s=linea.split(";");
					idcliente=Integer.parseInt(s[0].trim());
					apePA=s[1].trim();
					apeMA = s[2].trim();
					nombres = s[3].trim();
					direccion=s[4].trim();
					fechaNA= s[5].trim();
					fechaAF= s[6].trim();
					estadocivil = Integer.parseInt(s[7].trim());
					telefono= s[8].trim();
					dni=s[9].trim();
					tipocliente=Integer.parseInt(s[10].trim());
					adicionar(new Cliente(idcliente, apePA, apeMA,nombres,
							direccion, fechaNA, fechaAF,estadocivil, 
							telefono, dni,tipocliente));
				}
				br.close();
			}
			catch (Exception e){
				}
		}
		// Operaciones públicas complementarias
		public String CodigoCorrelativo(){
		if (tamaño()==0)
			return "CLI001";
			
		else{
			int cod;
			cod = obtener(tamaño()-1).getidCliente()+1;
			
			if(cod%10<0)
			return "CLI0" + cod;
			else
				return "CLI00" + cod;
			}
		}	
}
