package guis;

import javax.swing.JDialog;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arreglos.*;
import clases.*;
public class DlgConsumos_Registrados extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable table;

	private DefaultTableModel tabla;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConsumos_Registrados dialog = new DlgConsumos_Registrados();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConsumos_Registrados() {
		setTitle("Consumos Registrados");
		setBounds(100, 100, 611, 397);
		getContentPane().setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 575, 336);
			getContentPane().add(scrollPane);
			
			
			table = new JTable();
			table.setFillsViewportHeight(true);
			scrollPane.setViewportView(table);
			
			tabla = new DefaultTableModel();
			tabla.addColumn("Cod. Consumo");
			tabla.addColumn("Nombre");
			tabla.addColumn("Importe total");
			tabla.addColumn("Fecha de Consumo");
			table.setModel(tabla);
			
			table.getColumnModel().getColumn(0).setPreferredWidth(10);
			table.getColumnModel().getColumn(1).setPreferredWidth(50);
			table.getColumnModel().getColumn(2).setPreferredWidth(30);
			table.getColumnModel().getColumn(3).setPreferredWidth(30);
			
			tabla.setRowCount(0);
			listar();
		}
	}
	ArregloConsumo Con=  new ArregloConsumo();
	ArregloClientes Cli = new ArregloClientes();
	
	void listar(){
		try{
		for(int i=Con.tamaño()-1; i>=0;i--){
			
				Consumo x = Con.obtener(i);
				Cliente c = Cli.buscar(x.getCliente());
			Object[] fila = { "CON00"+x.getcodigoConsumo(),
							c.getnombres(),
							x.getImporteTotal(),
							x.getFechaConsumo()
					
		 		};
			tabla.addRow(fila);
		}
		
		
		}catch(Exception e){
			
		}
	}
}
