package guis;

import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;

import arreglos.ArregloBebidas;
import arreglos.ArregloCancion;
import arreglos.ArregloClientes;
import arreglos.ArregloPedido;
import arreglos.ArregloPiqueos;
import clases.Cancion;
import clases.Cliente;
import clases.Pedido;
import libreria.Fecha;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class DlgPedidos_por_Fecha extends JDialog implements ActionListener, KeyListener, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFechaini;
	private JTextField textFechafin;
	private JTable tablaPedidos;
	private JScrollPane scrollPane;
	private DefaultTableModel tabla;
	private JTextArea textArea;
	private JButton btnAtender;
	private JButton btnAnular;
	private JButton btnBuscar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPedidos_por_Fecha dialog = new DlgPedidos_por_Fecha();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPedidos_por_Fecha() {
		setTitle("Pedidos por Rango de Fecha");
		setBounds(100, 100, 546, 646);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Fecha de inicio:");
			lblNewLabel.setBounds(10, 11, 90, 14);
			getContentPane().add(lblNewLabel);
		}
		{
			JLabel lblFechaDeFin = new JLabel("Fecha de fin:");
			lblFechaDeFin.setBounds(10, 36, 90, 14);
			getContentPane().add(lblFechaDeFin);
		}
		
		textFechaini = new JTextField();
		textFechaini.setBounds(110, 8, 86, 20);
		getContentPane().add(textFechaini);
		textFechaini.setColumns(10);
		
		textFechafin = new JTextField();
		textFechafin.setBounds(110, 33, 86, 20);
		getContentPane().add(textFechafin);
		textFechafin.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.addMouseListener(this);
		btnBuscar.setBounds(206, 7, 89, 23);
		getContentPane().add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 510, 229);
		getContentPane().add(scrollPane);
		
		tablaPedidos = new JTable();
		tablaPedidos.addKeyListener(this);
		tablaPedidos.addMouseListener(this);
		scrollPane.setViewportView(tablaPedidos);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("Cod. Cliente");
		tabla.addColumn("Nombres y Apellidos de Cliente");
		tabla.addColumn("Fecha Pedido");
		tabla.addColumn("Cod. Usuario");
		tabla.addColumn("Cod. Pedido");
		tablaPedidos.setModel(tabla);
		
		//"Cod. Pedido", "Nombres y Apellidos de Cliente", "Apellido del Usuario", "Estado"
			
		tablaPedidos.getColumnModel().getColumn(0).setPreferredWidth(92);
		tablaPedidos.getColumnModel().getColumn(1).setPreferredWidth(289);
		tablaPedidos.getColumnModel().getColumn(2).setPreferredWidth(185);
		tablaPedidos.getColumnModel().getColumn(3).setPreferredWidth(185);
		tablaPedidos.getColumnModel().getColumn(4).setPreferredWidth(185);
		tabla.setRowCount(0);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 301, 313, 295);
		getContentPane().add(scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		btnAtender = new JButton("Atender");
		btnAtender.addActionListener(this);
		btnAtender.setBounds(366, 301, 89, 23);
		getContentPane().add(btnAtender);
		
		btnAnular = new JButton("Anular");
		btnAnular.addActionListener(this);
		btnAnular.setBounds(366, 335, 89, 23);
		getContentPane().add(btnAnular);
		
		listar();
		
	}
	
	   ArregloPedido P = new ArregloPedido();
	   ArregloClientes C = new ArregloClientes();
	   ArregloCancion Can = new ArregloCancion(0);
	
	public void actionPerformed(ActionEvent arg0){
		if(arg0.getSource()==btnBuscar){
			actionPerformedbtnBuscar(arg0);
		}
		if(arg0.getSource()==btnAtender){
			actionPerformedbtnBuscar(arg0);
		}
		if(arg0.getSource()==btnAnular){
			actionPerformedbtnBuscar(arg0);
		}
	}
	protected void actionPerformedbtnBuscar(ActionEvent arg0){
		listar();
	}
	protected void actionPerformedbtnAtender(ActionEvent arg0){
		int ok=confirmar("esta seguro de anular este pedido?");
		if(ok==0){
			try{
		Object y = tabla.getValueAt(tablaPedidos.getSelectedRow(),4);
		int indice = Integer.parseInt(y.toString().substring(3));
		Pedido x = P.buscar(indice);
		x.setEstado(1);
		ArregloCancion C = new ArregloCancion(indice);
		for(int i =0;i<C.tamaño();i++){
			int cod = C.obtener(i).getIdCancion();
			Cancion Ca = Can.buscar(cod);
			Ca.setNumeroreproducciones(Ca.getNumeroreproducciones()+1);
		}
		Can.actualizarArchivo();
		P.actualizarArchivo();
		listar();
		textArea.setText("");
		}
			catch(Exception e){
				mensaje("Seleccione una fila de la tabla");
			}
		}
	}
	protected void actionPerformedbtnAnular(ActionEvent arg0){
		int ok=confirmar("esta seguro de anular este pedido?");
		if(ok==0){
			try{
		Object y = tabla.getValueAt(tablaPedidos.getSelectedRow(),4);
		int indice = Integer.parseInt(y.toString().substring(3));
		Pedido x = P.buscar(indice);
		P.eliminar(x);
		listar();
		textArea.setText("");
		}
			catch(Exception e){
				mensaje("Seleccione una fila de la tabla");
			}
		}
	}
	
	void imprimir(){
		Object y = tabla.getValueAt(tablaPedidos.getSelectedRow(),4);
		int indice = Integer.parseInt(y.toString().substring(3));
		ArregloCancion Can = new ArregloCancion(indice);
		ArregloPiqueos Pi = new ArregloPiqueos(indice);
		ArregloBebidas B = new ArregloBebidas(indice);
		Pedido x = P.buscar(indice);
		Cliente c = C.buscar(x.getIdCliente());
		textArea.setText("");
		print("----------------DETALLE----------------");
		print("fecha	"+x.getFechaPedido());
		print("Cliente:	"+c.getnombres()+' '+
				c.getapellidoPaterno()+' '+c.getapellidoMaterno());
		print("Caciones:		");
		for(int i=0;i<Can.tamaño();i++)
			print("	"+Can.obtener(i).getNombre());
		print("Piqueos:			");
		for(int i=0;i<Pi.tamaño();i++)
			print("	"+Pi.obtener(i).getNombre());
		print("Bebidas:			");
		for(int i=0;i<B.tamaño();i++)
			print("	"+B.obtener(i).getNombre());
	}
	
	void print(String p){
		textArea.append(p+"\n");	
	}
	void mensaje(String s){
		JOptionPane.showMessageDialog(this, s,"Informacion",0);
	}
	
	void error(String s, JTextField txt){
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	
	void listar(){
		tabla.setRowCount(0);
		Pedido U;
		Cliente c;
		for(int i=0; i<P.tamaño();i++){
			U = P.obtener(i);
			c = C.buscar(U.getIdCliente());
		 Object[] fila = { "CLI00"+	U.getIdCliente(),
				 			c.getnombres()+' '+c.getapellidoPaterno()+' '+c.getapellidoMaterno(),
				 			U.getFechaPedido(),
				 			"USU00"+U.getIdUsuario(),
				 			"PED00"+U.getIdPedido()
				 			 };
		 
		 if((textFechaini.getText().length()==0||textFechafin.getText().length()==0))
			 tabla.addRow(fila);
		 else
			if(Comprobar(U.getFechaPedido()))
				tabla.addRow(fila);
		}
	}
	boolean Comprobar(String fecha){
		try{
		int dias = Fecha.diasTranscurridos(textFechaini.getText(), textFechafin.getText());
		String fechainicial=textFechaini.getText();
		for(int i=0;i<dias;i++){
			if(fecha == fechainicial)
				return true;
			fechainicial = Fecha.Aumentardia(fechainicial);
			}
		}
		catch(Exception e){
			error("introduzca conrrectamente la fecha usando /",textFechaini);
			textFechafin.setText("");
		}
		return false;
	}
	String leerFechaI(){
			return textFechaini.getText().trim();
		}
		
		String leerFechaF(){
			return textFechafin.getText().trim();
		}
		
		
	//mouse acciones
	
		public void keyPressed(KeyEvent arg0) {
		}
		public void keyReleased(KeyEvent arg0) {
			arg0.consume();
					
		}
		public void keyTyped(KeyEvent arg0) {
		}
		public void mouseClicked(MouseEvent arg0) {
			if (arg0.getSource() == tablaPedidos) {
				mouseClickedTblPedidos(arg0);
			}
		}
		public void mouseEntered(MouseEvent arg0) {
			if (arg0.getSource() == btnBuscar) {
				mouseEnteredBtnBuscar(arg0);
			}
			if (arg0.getSource() == btnAtender) {
				mouseEnteredBtnAtender(arg0);
			}
			if (arg0.getSource() == btnAnular) {
				mouseEnteredBtnAnular(arg0);
			}
			if (arg0.getSource() == tablaPedidos) {
				mouseEnteredTblPedidos(arg0);
			}
		}	
		public void mouseExited(MouseEvent arg0) {
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
		protected void mouseClickedTblPedidos(MouseEvent arg0) {
			imprimir();
		}
		protected void mouseEnteredTblPedidos(MouseEvent arg0) {
			tablaPedidos.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		protected void mouseEnteredBtnBuscar(MouseEvent arg0) {
			btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		protected void mouseEnteredBtnAtender(MouseEvent arg0) {
			btnAtender.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		protected void mouseEnteredBtnAnular(MouseEvent arg0) {
			btnAnular.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
}

