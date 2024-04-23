package guis;


import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import arreglos.*;
import clases.Usuario;

public class DlgUsuarios_con_mas_Clientes extends JDialog {
	

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel tabla;
	 
	
	/**
	 * Launch the application.
	 */
	
	
	//clase auxiliar
	public class Cantidad{
		private int cod;
		private int cantidad;
		public Cantidad(int cod,int cantidad){
			this.cod=cod;
			this.cantidad=cantidad;
		}
		public void setcod(int cod){
			this.cod=cod;
		}
		public void setcantidad(int cantidad){
			this.cantidad=cantidad;
		}
		public int getcod(){
			return cod;
		}
		public int getcantidad(){
			return cantidad;
		}
	}
	
	public static void main(String[] args) {
		try {
			DlgUsuarios_con_mas_Clientes dialog = new DlgUsuarios_con_mas_Clientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgUsuarios_con_mas_Clientes() {
		        setTitle("Usuario que han atendido mas Clientes");
		        setBounds(100, 100, 573, 300);
		        getContentPane().setLayout(null);
		        
		        	
			    scrollPane = new JScrollPane();
			    scrollPane.setBounds(10, 11, 537, 239);
			    getContentPane().add(scrollPane);
			    {
			    	
					table = new JTable();
					table.setFillsViewportHeight(true);
					scrollPane.setViewportView(table);
					
					tabla = new DefaultTableModel();
					tabla.addColumn("Codigo");
					tabla.addColumn("Nombres y Apellidos");
					tabla.addColumn("Cantidad");
					table.setModel(tabla);
					
					table.getColumnModel().getColumn(0).setPreferredWidth(10);
					table.getColumnModel().getColumn(1).setPreferredWidth(50);
					table.getColumnModel().getColumn(2).setPreferredWidth(30);
					
					tabla.setRowCount(0);
					
					
					obtenernumerodeclientes();
					ordenarmayormenor();
					listar();
			}
	}
	
			ArregloPedido Us = new ArregloPedido();
			ArregloUsuario u = new ArregloUsuario();
			
		Cantidad[] cont = new Cantidad[0];
		int indiceRepetido;
		
	void obtenernumerodeclientes(){
		int y=0;
		for (int i = 0; i< Us.tamaño(); i++){
			int id	= Us.obtener(i).getIdUsuario();
			boolean ok=revisaridrepetida(id);
			if(ok==true&&y!=0){
				Cantidad c =cont[indiceRepetido];
				c.setcantidad(c.getcantidad()+1);;
			}
			else{
			if(y==cont.length)
				ampliarArreglo(y);
			cont[y]= new Cantidad(id,1);
			y++;
			}
		}
	}
	void ordenarmayormenor(){
		for (int i=cont.length-1;i>0;i--)
			for(int j=cont.length-2;j<=0;j--)
				if(cont[i].getcantidad()>cont[j].getcantidad())
					intercambiar(i,j);
	}
	void intercambiar( int i, int y){
		Cantidad aux;
		aux = cont[y];
		cont[y]= cont[i];
		cont[i]= aux;
	}
	void ampliarArreglo(int indice) {
		Cantidad[]aux = cont;
		cont = new Cantidad[indice + 1];
		for(int i=0; i<indice;i++)
			cont[i] = aux[i];
	}
	boolean revisaridrepetida(int id){
		for(int i=0;i<cont.length;i++){
			if(cont[i].getcod()==id){
				indiceRepetido=i;
				return true;
			}
		}
		return false;
	}
	void listar(){
		for(int i=0; i<cont.length;i++){
			Cantidad c = cont[i];
			Usuario usu= u.buscar(c.getcod());
			Object[] fila = { "USU00"+c.getcod(),
					usu.getnombres()+" "+ usu.getapellidoPaterno()+" "+usu.getapellidoMaterno(),
					c.getcantidad()
		 		};
			tabla.addRow(fila);
			
		}
	}
}
