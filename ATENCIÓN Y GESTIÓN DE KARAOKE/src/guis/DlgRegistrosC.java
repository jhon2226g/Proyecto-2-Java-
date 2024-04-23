package guis;

import java.awt.Cursor;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import libreria.Fecha;

import arreglos.*;
import clases.*;

public class DlgRegistrosC extends JDialog implements ActionListener, KeyListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JComboBox<String>cboNombre;
	private JComboBox<String> cboID;
	private JButton btnRegistrar;
	private DefaultTableModel tabla;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRegistrosC dialog = new DlgRegistrosC();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRegistrosC() {
		setTitle("Regsitro de Consumo");
		setBounds(100, 100, 598, 566);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre de Usuario o Cliente:");
			lblNewLabel.setBounds(10, 11, 176, 14);
			getContentPane().add(lblNewLabel);
		}
		
		cboNombre = new JComboBox<String>();
		cboNombre.addActionListener(this);
		cboNombre.setModel(new DefaultComboBoxModel <String>(Nombres()));
		cboNombre.addActionListener(this);
		cboNombre.setBounds(196, 8, 172, 20);
		getContentPane().add(cboNombre);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.addMouseListener(this);
		btnRegistrar.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnRegistrar.setBounds(402, 7, 164, 40);
		getContentPane().add(btnRegistrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 556, 452);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addKeyListener(this);
		table.addMouseListener(this);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("Cod. de Cliente");
		tabla.addColumn("Nombre y Apellidos");
		tabla.addColumn("Fecha");
		tabla.addColumn("Cod. de Usuario");
		tabla.addColumn("Cod. de Pedido");
		table.setModel(tabla);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(103);
		table.getColumnModel().getColumn(1).setPreferredWidth(244);
		table.getColumnModel().getColumn(2).setPreferredWidth(73);
		table.getColumnModel().getColumn(3).setPreferredWidth(103);
		table.getColumnModel().getColumn(4).setPreferredWidth(104);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(109, 33, 46, 14);
		getContentPane().add(lblCodigo);
		
		cboID = new JComboBox<String>();
		cboID.addActionListener(this);
		cboID.setModel(new DefaultComboBoxModel <String>(ID));
		cboID.addActionListener(this);
		cboID.setBounds(196, 30, 109, 20);
		getContentPane().add(cboID);
		
		tabla.setRowCount(0);
		listar();
	}
	
	ArregloClientes C = new ArregloClientes();
	ArregloUsuario Us = new ArregloUsuario();
	ArregloPedido pe = new ArregloPedido();
	ArregloConsumo Con = new ArregloConsumo();
	
	public void actionPerformed(ActionEvent arg0){
		
		if(arg0.getSource()==btnRegistrar){
			actionPerformedBtnRegistrar(arg0);
		}
		if(arg0.getSource()==cboNombre){
			actionPerformedCboNombre(arg0);
		}
		if(arg0.getSource()==cboID){
			actionPerformedCboID(arg0);
		}
	}
	protected void actionPerformedCboID(ActionEvent arg0){
		cboNombre.setSelectedIndex(leerID());
		listar();
		
	}
	protected void actionPerformedCboNombre(ActionEvent arg0){
		cboID.setSelectedIndex(leerNombre());
		listar();
		
	}
	protected void actionPerformedBtnRegistrar(ActionEvent arg0){
		int ok=confirmar("esta seguro de atender todos los pedidos de este CLIENTE?");
		if(ok==0)
			{
		Object y = tabla.getValueAt(table.getSelectedRow(),0);
		int indice = Integer.parseInt(y.toString().substring(3));
		int idconsumo =Integer.parseInt(Con.codigoCorrelativo().toString().substring(3));
		double importeTotal = 0;
		String fechaConsumo = Fecha.fechaActual();
		buscarPedidos(indice) ;
		for(int j=0;j<s.length;j++){
			int idpedido = s[j];
			ArregloBebidas b = new ArregloBebidas(idpedido);
			ArregloPiqueos p = new ArregloPiqueos(idpedido);
			Pedido x = pe.buscar(idpedido);
			for(int i=0;i<b.tamaño();i++){
				importeTotal = importeTotal + b.obtener(i).getPrecio();}
			for(int i=0;i<p.tamaño();i++){
				importeTotal =importeTotal +p.obtener(i).getPrecio();}
			x.setEstado(2);
			pe.actualizarArchivo();
		}
		Con.adicionar(new Consumo(indice,idconsumo,fechaConsumo,importeTotal));
		Con.actualizarArchivo();
		pe.actualizarArchivo();
			}
		listar();
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
	int leerNombre() {
		return cboNombre.getSelectedIndex();
	}
	int leerID() {
		return  cboID.getSelectedIndex();
	}
	int leerCod() {
		return Integer.parseInt(cboID.getItemAt(cboID.getSelectedIndex()).substring(3));
	}
	String leerPrefijo() {
		return cboID.getItemAt(cboID.getSelectedIndex()).substring(0, 3);
	}
	
	int[] s = new int[0];
	
	void buscarPedidos(int idCliente){
		int indice=0;
		for(int i =0 ; i<pe.tamaño();i++){
			Pedido P = pe.obtener(i);
			if(idCliente==P.getIdCliente()&&P.getEstado()==1){
				if(indice==s.length)
					ampliarArreglo(indice);
				s[indice]= P.getIdPedido();
				indice++;
			}
		}
		
	}
	void ampliarArreglo(int indice) {
		int[]aux = s;
		s = new int[indice + 1];
		for(int i=0; i<indice;i++)
			s[i] = aux[i];
	}
	void listar(){
		tabla.setRowCount(0);
		Pedido U;
		Cliente c;
		for(int i=0; i<pe.tamaño();i++){
			U = pe.obtener(i);
			c = C.buscar(U.getIdCliente());
			
		 Object[] fila = { "CLI00"+	U.getIdCliente(),
				 			c.getnombres()+' '+c.getapellidoPaterno()+' '+c.getapellidoMaterno(),
				 			U.getFechaPedido(),
				 			"USU00"+U.getIdUsuario(),
				 			"PED00"+U.getIdPedido()
				 			 };
			if(leerCod()==U.getIdCliente()&&U.getEstado()==1&&leerPrefijo().equals("CLI"))
				tabla.addRow(fila);
			else
				if(U.getEstado()==1&&leerCod()==U.getIdUsuario()&&leerPrefijo().equals("USU"))
					tabla.addRow(fila);
		}
	}
	 
	String[] Nombres(){
		
		String[] s = new String[C.tamaño()+Us.tamanio()];
		
		for(int i=0;i<C.tamaño();i++){
			s[i] = C.obtener(i).getnombres();
			ID[i]= "CLI00"+ C.obtener(i).getidCliente();
		}
		for(int y=0,i=C.tamaño();i<C.tamaño()+Us.tamanio();i++,y++){
			s[i] = Us.obtener(y).getnombres();
			ID[i]="USU00"+ Us.obtener(y).getidUsuario();
		}
		return s;
	}
	String[] ID = new String[C.tamaño()+Us.tamanio()];
	
	
	//mouse acciones
	
		public void keyPressed(KeyEvent arg0) {
		}
		public void keyReleased(KeyEvent arg0) {
			arg0.consume();
					
		}
		public void keyTyped(KeyEvent arg0) {
		}		
		public void mouseClicked(MouseEvent arg0) {
			if (arg0.getSource() == table) {
				mouseClickedTblRegistro(arg0);
			}
		}
		public void mouseEntered(MouseEvent arg0) {
		
			if (arg0.getSource() == btnRegistrar) {
				mouseEnteredTblRegistro(arg0);
			}
			if (arg0.getSource() == cboNombre) {
				mouseEnteredCboNombre(arg0);
			}
			if (arg0.getSource() == table) {
				mouseEnteredTblRegistro(arg0);
			}
			
		}
		public void mouseExited(MouseEvent arg0) {
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) { 	
		}
		protected void mouseClickedTblRegistro(MouseEvent arg0) {
		}
		protected void mouseEnteredTblRegistro(MouseEvent arg0) {
			table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		protected void mouseEnteredBtnRegistrar(MouseEvent arg0) {
			btnRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		protected void mouseEnteredCboNombre(MouseEvent arg0) {
			cboNombre.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
}
