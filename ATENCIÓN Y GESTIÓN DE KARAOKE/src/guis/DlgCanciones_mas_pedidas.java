package guis;

import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

import arreglos.*;
import clases.*;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class DlgCanciones_mas_pedidas extends JDialog {
			
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel tabla;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCanciones_mas_pedidas dialog = new DlgCanciones_mas_pedidas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCanciones_mas_pedidas() {
		setTitle("Canciones mas Pedidas");
		setBounds(100, 100, 695, 394);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 659, 333);
		getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("Puesto");
		tabla.addColumn("Codigo");
		tabla.addColumn("Cancion");
		tabla.addColumn("Artista");
		tabla.addColumn("Genero");
		tabla.addColumn("Numero de reproducciones");
		table.setModel(tabla);
		
		tabla.setRowCount(0);
		
		obtenernumerodeclientes();
		ordenarmayormenor();
		listar();
	}
	     ArregloCancion u = new ArregloCancion(0);
	     ArregloArtista Ar = new ArregloArtista();
	     ArregloGenero Ge = new ArregloGenero();
	     
	     int[] cont = new int[u.tamaño()];
	     
	    void obtenernumerodeclientes(){
	 		for(int i=0; i <u.tamaño(); i++){
	 			int id	= u.obtener(i).getIdCancion();
	 			cont[i]= id;
	 		}
	 	}
	 	void ordenarmayormenor(){
			for (int i=0;i<u.tamaño()-1;i++)
				for(int j=i+1;j<u.tamaño();j++){
				Cancion x = u.buscar(cont[i]);
				Cancion y = u.buscar(cont[j]);
					if(x.getNumeroreproducciones()<y.getNumeroreproducciones())
						intercambiar(i,j);
			}
		}
		void intercambiar( int i, int y){
			int aux;
			aux = cont[y];
			cont[y]= cont[i];
			cont[i]= aux;
		}
		
		void listar(){
			int item=0;
			for(int i=0; i<u.tamaño();i++){
				Cancion x = u.buscar(cont[i]);
				Artista A = Ar.buscar(x.getIdArtista());
				Genero G = Ge.buscar(A.getidGenero());
				item++;
				Object[] fila = {item,
								"CAN00"+ x.getIdCancion(),
								x.getNombre(),
								A.getnombreArtistico(),
								G.getdescripcion(),
								x.getNumeroreproducciones()
			 		};
				tabla.addRow(fila);
				
			}
		}
}