package guis;

import java.awt.Cursor;
import java.awt.EventQueue;

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


import arreglos.*;
import clases.*;	
import libreria.Fecha;

import javax.swing.SwingConstants;
import java.awt.Color;



public class DlgRegistrosP extends JDialog implements ActionListener, KeyListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textBuscar;
	private JTable tablaCanciones;
	private JTable tablaPiqueos;
	private JTable tablaPedidoCanciones;
	private JTable tablaPedidoPiqueos;
	private JTextField textID;
	private JButton btnEliminarCancion;
	private JButton btnRegistrarPedidos ;
	private JButton btnEliminarPiqueo;
	private JButton btnBuscar;
	private JComboBox<String> cboNombre;
	private JComboBox<String> cboArtista;
	private JComboBox<String> cboGenero;
	private JButton btnRegistrate;
	private DefaultTableModel tabla;
	private DefaultTableModel tablaP;
	private DefaultTableModel tablaPC;
	private DefaultTableModel tablaPP;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JScrollPane scrollPane;
	private JComboBox<String> cboMozos;
	private JTextField textCodPedido;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
		try {
			DlgRegistrosP dialog = new DlgRegistrosP();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
			}
		});
			
	}

	/**
	 * Create the dialog.
	 */
	public DlgRegistrosP() {
		setTitle("Registro de Pedidos");
		setBounds(100, 100, 800, 739);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar Nombre:");
		lblNewLabel.setBounds(10, 48, 111, 14);
		getContentPane().add(lblNewLabel);
		
		textBuscar = new JTextField();
		textBuscar.setBounds(131, 45, 170, 20);
		getContentPane().add(textBuscar);
		textBuscar.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 358, 239);
		getContentPane().add(scrollPane);
		
		tablaCanciones = new JTable();
		tablaCanciones.addKeyListener(this);
		tablaCanciones.addMouseListener(this);
		scrollPane.setViewportView(tablaCanciones);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("cod");
		tabla.addColumn("Nombre");
		tabla.addColumn("Artista");
		tabla.addColumn("Genero");
		tablaCanciones.setModel(tabla);
		
		tablaCanciones.getColumnModel().getColumn(0).setPreferredWidth(83);
		tablaCanciones.getColumnModel().getColumn(1).setPreferredWidth(83);
		tablaCanciones.getColumnModel().getColumn(2).setPreferredWidth(87);
		tablaCanciones.getColumnModel().getColumn(3).setPreferredWidth(87);
		
		tabla.setRowCount(0);
		
		JLabel lblArtista = new JLabel("Artista:");
		lblArtista.setBounds(10, 73, 46, 14);
		getContentPane().add(lblArtista);
		
		cboArtista = new JComboBox<String>();
		cboArtista.setModel(new DefaultComboBoxModel<String>(Artistas()));
		cboArtista.setBounds(131, 70, 170, 20);
		getContentPane().add(cboArtista);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(10, 98, 62, 14);
		getContentPane().add(lblGenero);
		
		cboGenero = new JComboBox<String>();
		cboGenero.setModel(new DefaultComboBoxModel<String>(Generos()));
		cboGenero.setBounds(131, 95, 99, 20);
		getContentPane().add(cboGenero);
		
		JLabel lblCodigoDeCliente = new JLabel("Nombre de Cliente:");
		lblCodigoDeCliente.setBounds(10, 23, 121, 14);
		getContentPane().add(lblCodigoDeCliente);
		
		JLabel lblPideUnPiqueo = new JLabel("PIDE UN PIQUEO!!");
		lblPideUnPiqueo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPideUnPiqueo.setBounds(131, 376, 136, 14);
		getContentPane().add(lblPideUnPiqueo);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 415, 358, 228);
		getContentPane().add(scrollPane_1);
		
		tablaPiqueos = new JTable();
		tablaPiqueos.addKeyListener(this);
		tablaPiqueos.addMouseListener(this);
		scrollPane_1.setViewportView(tablaPiqueos);
		
		tablaP = new DefaultTableModel();
		tablaP.addColumn("ITEM");
		tablaP.addColumn("Piqueo O Bebida");
		tablaPiqueos.setModel(tablaP);
		
		tablaPiqueos.getColumnModel().getColumn(0).setPreferredWidth(20);
		tablaPiqueos.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaP.setRowCount(0);
		
		JLabel lblTuPedido = new JLabel("TU PEDIDO");
		lblTuPedido.setBounds(545, 401, 74, 14);
		getContentPane().add(lblTuPedido);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(399, 126, 358, 239);
		getContentPane().add(scrollPane_2);
		
		tablaPedidoCanciones = new JTable();
		tablaPedidoCanciones.setForeground(new Color(0, 0, 255));
		tablaPedidoCanciones.setFillsViewportHeight(true);
		scrollPane_2.setViewportView(tablaPedidoCanciones);
		
		tablaPC = new DefaultTableModel();
		tablaPC.addColumn("Cod");
		tablaPC.addColumn("Nombre");
		tablaPC.addColumn("Artista");
		tablaPC.addColumn("Genero");
		tablaPedidoCanciones.setModel(tablaPC);
		
		tablaPedidoCanciones.getColumnModel().getColumn(0).setPreferredWidth(83);
		tablaPedidoCanciones.getColumnModel().getColumn(1).setPreferredWidth(83);
		tablaPedidoCanciones.getColumnModel().getColumn(2).setPreferredWidth(87);
		tablaPedidoCanciones.getColumnModel().getColumn(3).setPreferredWidth(87);
		
		tablaPC.setRowCount(0);
		
		btnEliminarCancion = new JButton("Eliminar Cancion");
		btnEliminarCancion.addActionListener(this);
		btnEliminarCancion.addMouseListener(this);
		btnEliminarCancion.setBounds(510, 94, 136, 23);
		getContentPane().add(btnEliminarCancion);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(399, 415, 358, 228);
		getContentPane().add(scrollPane_3);
		
		tablaPedidoPiqueos = new JTable();
		tablaPedidoPiqueos.setForeground(new Color(0, 0, 255));
		tablaPedidoPiqueos.setFillsViewportHeight(true);
		scrollPane_3.setViewportView(tablaPedidoPiqueos);
		
		tablaPP = new DefaultTableModel();
		tablaPP.addColumn("ITEM");
		tablaPP.addColumn("Piqueo O Bebida");
		tablaPedidoPiqueos.setModel(tablaPP);
		tablaPedidoPiqueos.getColumnModel().getColumn(0).setPreferredWidth(20);
		tablaPedidoPiqueos.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPP.setRowCount(0);
		
		JLabel lblPiqueosDisponibles = new JLabel("PIQUEOS Y BEBIDAS  DISPONIBLES:");
		lblPiqueosDisponibles.setBounds(81, 401, 220, 14);
		getContentPane().add(lblPiqueosDisponibles);
		
		btnRegistrarPedidos = new JButton("REGISTRAR PEDIDOS");
		btnRegistrarPedidos.addActionListener(this);
		btnRegistrarPedidos.addMouseListener(this);
		btnRegistrarPedidos.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnRegistrarPedidos.setBounds(448, 654, 273, 35);
		getContentPane().add(btnRegistrarPedidos);
		
		btnEliminarPiqueo = new JButton("Eliminar Piqueo");
		btnEliminarPiqueo.addActionListener(this);
		btnEliminarPiqueo.addMouseListener(this);
		btnEliminarPiqueo.setBounds(510, 373, 136, 23);
		getContentPane().add(btnEliminarPiqueo);
		
		btnBuscar = new JButton("buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.addMouseListener(this);
		btnBuscar.setBounds(232, 94, 74, 23);
		getContentPane().add(btnBuscar);
		
		cboNombre = new JComboBox<String>();
		cboNombre.addActionListener(this);
		cboNombre.addMouseListener(this);
		cboNombre.addKeyListener(this);
		cboNombre.setModel(new DefaultComboBoxModel<String>(NombresCliente()));
		
		cboNombre.setBounds(131, 20, 170, 20);
		getContentPane().add(cboNombre);
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(316, 20, 74, 20);
		getContentPane().add(textID);
		textID.setColumns(10);
		
		btnRegistrate = new JButton("REGISTRATE!!!");
		btnRegistrate.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnRegistrate.addActionListener(this);
		btnRegistrate.addMouseListener(this);
		btnRegistrate.setBounds(545, 18, 176, 35);
		getContentPane().add(btnRegistrate);
		
		btnRegistrarPedidos.setEnabled(false);
		
		JLabel lblCodPedido = new JLabel("Cod. Pedido:");
		lblCodPedido.setBounds(328, 79, 79, 14);
		getContentPane().add(lblCodPedido);
		
		textCodPedido = new JTextField();
		textCodPedido.setHorizontalAlignment(SwingConstants.CENTER);
		textCodPedido.setEditable(false);
		textCodPedido.setBounds(417, 76, 86, 20);
		getContentPane().add(textCodPedido);
		textCodPedido.setColumns(10);
		
		cboMozos = new JComboBox<String>();
		cboMozos.setModel(new DefaultComboBoxModel<String>(Mozos()));
		cboMozos.setBounds(417, 48, 85, 20);
		getContentPane().add(cboMozos);
		
		JLabel lblCodMozo = new JLabel("Cod. Mozo:");
		lblCodMozo.setBounds(326, 51, 64, 14);
		getContentPane().add(lblCodMozo);
		
		 // arranque
		
		btnRegistrarPedidos.setEnabled(true);
		btnEliminarCancion.setEnabled(true);
		
		limpieza();
		listarGeneral();
		listarGeneralPiqueosBebidas();
		listarCancion();
		listarPiqueosBebidas();

	}
	ArregloClientes C = new ArregloClientes();
	ArregloGenero G = new ArregloGenero();
	ArregloCancion Can = new ArregloCancion(0);
	ArregloBebidas Be = new ArregloBebidas(0);
	ArregloPiqueos Pi = new ArregloPiqueos(0);
	ArregloArtista Ar = new ArregloArtista();
	ArregloPedido Pe = new ArregloPedido();
	ArregloUsuario Us = new ArregloUsuario();
	
	public void actionPerformed(ActionEvent arg0){
		if(arg0.getSource()== btnBuscar){
			actionPerformedbtnBuscar(arg0);
		}
		if(arg0.getSource()== btnEliminarPiqueo){
			actionPerformedbtnElimnarPiqueo(arg0);
		}
		if(arg0.getSource()== btnEliminarCancion){
			actionPerformedbtnEliminarCancion(arg0);
		}
		if(arg0.getSource()== btnRegistrate){
			actionPerformedbtnRegistrate(arg0);
		}
		if(arg0.getSource()== btnRegistrarPedidos){
			actionPerformedbtnRegsitrarPedidos(arg0);
		}
		if(arg0.getSource()== cboNombre){
			actionPerformedCboNombre(arg0);
		}
	}
	
	protected void actionPerformedCboNombre(ActionEvent arg0){
		int indice = leerNombreCliente()+1;
		textID.setText("CLI00"+ indice);
	}
	protected void actionPerformedbtnBuscar(ActionEvent arg0){
		listarGeneral();
	}
	protected void actionPerformedbtnElimnarPiqueo(ActionEvent arg0){
		ArregloBebidas B = new ArregloBebidas(leerCodPedido());
		ArregloPiqueos P = new ArregloPiqueos(leerCodPedido());
		int ok = confirmar("deseas eliminar el Pedido?");
		if(ok==0){
			for(int i=0;i<B.tamaño();i++)
			B.eliminar(B.obtener(i));
			for(int i=0;i<P.tamaño();i++)
			P.eliminar(P.obtener(i));
			listarPiqueosBebidas();
		}
		if(B.tamaño()>0||P.tamaño()>0){
			btnRegistrarPedidos.setEnabled(true);
			btnEliminarCancion.setEnabled(true);
		}else{
			btnRegistrarPedidos.setEnabled(false);
			btnEliminarCancion.setEnabled(false);
		}
		
	}
	protected void actionPerformedbtnEliminarCancion(ActionEvent arg0){
		ArregloCancion GG = new ArregloCancion(leerCodPedido());
		int ok = confirmar("deseas eliminar el Pedido?");
		if(ok==0){
			for(int i=0;i<GG.tamaño();i++)
			GG.eliminar(GG.obtener(i));
			listarCancion();
		}
		if(GG.tamaño()>0){
			btnRegistrarPedidos.setEnabled(true);
			btnEliminarCancion.setEnabled(true);
		}else{
			btnRegistrarPedidos.setEnabled(false);
			btnEliminarCancion.setEnabled(false);
		}
		
	}
	protected void actionPerformedbtnRegistrate(ActionEvent arg0){
		DlgCliente D = new DlgCliente();
		D.setLocationRelativeTo(this);
		D.setVisible(true);
	}
	protected void actionPerformedbtnRegsitrarPedidos(ActionEvent arg0){
		ArregloCancion Canciones = new ArregloCancion(leerCodPedido());
		int ok = confirmar("deseas Registrar los Pedidos?");
		if(ok==0)
		if(Canciones.tamaño()>0){
			int idPedido = leerCodPedido(), idCliente = leerID(),
					idUsuario = leerCodMozo();
			String fechaPedido = Fecha.fechaActual();
			if(Canciones.tamaño()>0)
			Pe.adicionar(new Pedido(idPedido,idUsuario,idCliente,fechaPedido,0));
			Pe.actualizarArchivo();
			limpieza();
			btnRegistrarPedidos.setEnabled(false);
		}
	}
	
	void AgregarCancion(){
		ArregloCancion GG = new ArregloCancion(leerCodPedido());
			Object y = tabla.getValueAt(tablaCanciones.getSelectedRow(),0);
			int cod = Integer.parseInt(y.toString().substring(3));
			Cancion x = Can.buscar(cod);
			GG.adicionar(new Cancion(x.getIdCancion(),x.getNombre(),x.getIdArtista(),
					x.getAlbum(),x.getFechaRegistro(),x.getNumeroreproducciones(),
					x.getEstado()));
			btnEliminarCancion.setEnabled(true);
			listarCancion();
		
	}
	void listarCancion(){
		ArregloCancion GG = new ArregloCancion(leerCodPedido());
		tablaPC.setRowCount(0);
		Cancion U;
		for(int i=0; i<GG.tamaño();i++){
			U = GG.obtener(i);
		 Object[] fila = {"CAN00"+ U.getIdCancion(),
				 			U.getNombre(),
				 			Ar.buscar(U.getIdArtista()).getnombreArtistico(),
				 			G.buscar(Ar.buscar(U.getIdArtista()).getidGenero()).getdescripcion()
				 			 };
		tablaPC.addRow(fila);
		}
	}
	
	void listarGeneral(){
		 int o=4;
		 if(leerArtista()!=0)
			 o=0;
		 if(leerGenero()!=0)
			 o=1;
		 if(leerNombre().length()>0)
			 o=2;
		 if(leerArtista()!=0&&leerGenero()!=0&&leerNombre().length()==0)
			 o=3;
		tabla.setRowCount(0);
		Cancion U;
		for(int i=0; i<Can.tamaño();i++){
			U = Can.obtener(i);
		 Object[] fila = { "CAN00"+	U.getIdCancion(),
				 U.getNombre(),
				 Ar.buscar(U.getIdArtista()).getnombreArtistico(),
				 G.buscar(Ar.buscar(U.getIdArtista()).getidGenero()).getdescripcion()
				 			 };
		 switch(o){
		 case 0: if(fila[2].equals(cboArtista.getSelectedItem()))tabla.addRow(fila);break;
		 case 1:if(fila[3].equals(cboGenero.getSelectedItem()))tabla.addRow(fila);break;
		 case 2: if(fila[1].equals(leerNombre()))tabla.addRow(fila);break;
		 case 3: if(fila[2].equals(cboArtista.getSelectedItem())||
				 fila[3].equals(cboGenero.getSelectedItem())
				 )tabla.addRow(fila);break;
		 default : tabla.addRow(fila);break;
		 }
		}
	}
	
	
	void AgregarPiqueo(){
		ArregloBebidas B = new ArregloBebidas(leerCodPedido());
		ArregloPiqueos P = new ArregloPiqueos(leerCodPedido());
		
		if(B.tamaño()>=0||P.tamaño()>=0){
			if(tablaPiqueos.getSelectedRow()<Pi.tamaño()){
				Piqueo x = Pi.obtener(tablaPiqueos.getSelectedRow());
				P.adicionar(new Piqueo(x.getIdPiqueo(),x.getTipoPiqueo(),
						x.getNombre(),x.getPrecio(),x.getEstado()));
				listarPiqueosBebidas();
				}
			else{
				Bebida x = Be.obtener(tablaPiqueos.getSelectedRow()-Pi.tamaño());
				B.adicionar(new Bebida(x.getidBebida(),x.getTipoBebida(),x.getNombre(),
						x.getPrecio(),x.getMarca(),x.getEstado()));
				listarPiqueosBebidas();
			}
				
		}
	}
	void listarPiqueosBebidas(){
		ArregloBebidas B = new ArregloBebidas(leerCodPedido());
		ArregloPiqueos P = new ArregloPiqueos(leerCodPedido());
		
		tablaPP.setRowCount(0);
		Piqueo U;
		for(int i=0; i<P.tamaño();i++){
			U = P.obtener(i);
		 Object[] fila = { i+1,	U.getNombre()
				 			 };
		tablaPP.addRow(fila);
		}
		Bebida E;
		for(int i=P.tamaño(); i<B.tamaño()+P.tamaño();i++){
			E = B.obtener(i-P.tamaño());
		 Object[] fila = { i+1, E.getNombre()
				 			
				 			 };
		tablaPP.addRow(fila);
		}
	}
	
	void listarGeneralPiqueosBebidas(){
		tablaP.setRowCount(0);
		Piqueo U;
		Bebida E;
		for(int i=0; i<Pi.tamaño();i++){
			U = Pi.obtener(i);
		 Object[] fila = { i+1,	U.getNombre()
				 			 };
			 tablaP.addRow(fila);
		}
		for(int i=0; i<Be.tamaño();i++){
			E = Be.obtener(i);
		 Object[] filax = {i+Pi.tamaño()+1,E.getNombre()
				 			 };
			 tablaP.addRow(filax);
		}
		
		
	}
	//mouse acciones
	
			public void keyPressed(KeyEvent arg0) {
			}
			public void keyReleased(KeyEvent arg0) {
				
			}
			public void keyTyped(KeyEvent arg0) {
			}
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getSource() == tablaPiqueos) {
					mouseClickedTblPiqueo(arg0);
				}
				if (arg0.getSource() == tablaCanciones) {
					mouseClickedTblCaciones(arg0);
				}
			}
			public void mouseEntered(MouseEvent arg0) {
				
				if (arg0.getSource() == tablaPiqueos) {
					mouseEnteredTblPiqueo(arg0);
				}
				if (arg0.getSource() == tablaCanciones) {
					mouseEnteredTblCaciones(arg0);
				}
				if (arg0.getSource() == btnBuscar) {
					mouseEnteredBtnBuscar(arg0);
				}
				if (arg0.getSource() == btnEliminarCancion) {
					mouseEnteredBtnEliminarCancion(arg0);
				}
				if (arg0.getSource() == btnEliminarPiqueo) {
					mouseEnteredBtnEliminarPiqueo(arg0);
				}
				if (arg0.getSource() == btnRegistrate) {
					mouseEnteredBtnRegistrate(arg0);
				}
				if (arg0.getSource() == btnRegistrarPedidos) {
					mouseEnteredBtnRegistrate(arg0);
				}
				
			}
			public void mouseExited(MouseEvent arg0) {
			}
			public void mousePressed(MouseEvent arg0) {
			}
			public void mouseReleased(MouseEvent arg0) {
			}
			protected void mouseClickedTblCaciones(MouseEvent arg0) {
				if(Can.tamaño()>0)
					AgregarCancion();
				btnRegistrarPedidos.setEnabled(true);
					
			}
			protected void mouseClickedTblPiqueo(MouseEvent arg0) {	
				if(Be.tamaño()>0||Pi.tamaño()>0)
					AgregarPiqueo();
				btnRegistrarPedidos.setEnabled(true);
			}
			protected void mouseEnteredCboNombre(MouseEvent arg0) {
				cboNombre.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			protected void mouseEnteredTblCaciones(MouseEvent arg0) {
				tablaCanciones.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			protected void mouseEnteredTblPiqueo(MouseEvent arg0) {
				tablaPiqueos.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			protected void mouseEnteredBtnBuscar(MouseEvent arg0) {
				btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			protected void mouseEnteredBtnEliminarCancion(MouseEvent arg0) {
				btnEliminarCancion.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			protected void mouseEnteredBtnEliminarPiqueo(MouseEvent arg0) {
				btnEliminarPiqueo.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			protected void mouseEnteredBtnRegistrate(MouseEvent arg0) {
				btnRegistrate.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			protected void mouseEnteredBtnRegistratarPedidos(MouseEvent arg0) {
				btnRegistrarPedidos.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	void limpieza(){
		textCodPedido.setText(Pe.codigoCorrelativo());
		textID.setText("CLI00"+ C.obtener(leerNombreCliente()).getidCliente());
		textBuscar.setText("");
		cboArtista.setSelectedIndex(0);
		cboGenero.setSelectedIndex(0);
		textBuscar.requestFocus();
		tablaPC.setRowCount(0);
		tablaPP.setRowCount(0);
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	int leerArtista() {
		return cboArtista.getSelectedIndex();
	}
	
	int leerGenero() {
		return cboGenero.getSelectedIndex();
	}
	int leerNombreCliente() {
		return cboNombre.getSelectedIndex();
	}
	int leerID() {
		return Integer.parseInt(textID.getText().substring(3));
	}
	int leerCodPedido() {
		return Integer.parseInt(textCodPedido.getText().substring(3));
	}
	int leerCodMozo() {
		return Integer.parseInt(cboMozos.getItemAt(cboMozos.getSelectedIndex()).substring(3));
	}
	String leerNombre() {
		return textBuscar.getText().trim();
		
	}
	String[] NombresCliente(){
		int l = C.tamaño();
		String[] s = new String[l];
		for(int i=0;i<C.tamaño();i++){
			s[i] = C.obtener(i).getnombres();
		}
		return s;
		
	}
	String[] Generos(){
		int l = G.tamaño()+1;
		String[] s = new String[l];
		s[0]="Todos";
		for(int i=1;i<l;i++){
			s[i] = G.obtener(i-1).getdescripcion();
		}
		return s;
	}
	
	String[] Artistas(){
		int l = Ar.tamaño()+1;
		String[] s = new String[l];
		s[0]="Todos";
		for(int i=1;i<l;i++){
			s[i] = Ar.obtener(i-1).getnombreArtistico();
		}
		return s;
	}
	String[] Mozos(){
		int l = Us.tamanio();
		String[] s = new String[l];
		int tam=0;
		for(int i=0;i<l;i++){
			if(Us.obtener(i).gettipoEmpleado()==2){
			s[tam] = "USU00"+Us.obtener(i).getidUsuario();
			tam++;
			}
		}
		String[] M = new String[tam];
		for(int i=0;i<tam;i++)
			M[i]=s[i];
		return M;
	}
}
