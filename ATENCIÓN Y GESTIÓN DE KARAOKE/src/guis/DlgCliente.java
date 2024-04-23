package guis;


import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloClientes;
import clases.Cliente;
import libreria.Lib;
import libreria.Fecha;

public class DlgCliente extends JDialog implements ActionListener, KeyListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNombres;
	private JTextField textApePaterno;
	private JTextField textApeMaterno;
	private JTextField textDireccion;
	private JTextField textFechaNa;
	private JTextField textFechaAfi;
	private JTextField textTelef;
	private JTextField textDni;
	private JTable table;
	private JTextField textID;
	private JComboBox <String>cboEstadoCivil;
	private JComboBox <String>cboTipo;
	private DefaultTableModel tabla;
	
	private JButton btnAceptar;
	private JButton btnIngreso;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
		try {
			DlgCliente dialog = new DlgCliente();
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
	public DlgCliente() {
		setTitle("Cliente");
		setBounds(100, 100, 754, 646);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombres:");
		lblNewLabel.setBounds(10, 11, 64, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno:");
		lblApellidoPaterno.setBounds(10, 36, 103, 14);
		getContentPane().add(lblApellidoPaterno);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno:");
		lblApellidoMaterno.setBounds(10, 61, 89, 14);
		getContentPane().add(lblApellidoMaterno);
		
		JLabel lblNewLabel_1 = new JLabel("Direccion:");
		lblNewLabel_1.setBounds(10, 86, 89, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("F. Nacimineto:");
		lblNewLabel_2.setBounds(10, 111, 115, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblFechaDeAfiliacion = new JLabel("F. Afiliacion:");
		lblFechaDeAfiliacion.setBounds(10, 136, 103, 14);
		getContentPane().add(lblFechaDeAfiliacion);
		
		JLabel lblNewLabel_3 = new JLabel("Estado Civil:");
		lblNewLabel_3.setBounds(10, 161, 74, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(10, 186, 64, 14);
		getContentPane().add(lblTelefono);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 211, 46, 14);
		getContentPane().add(lblDni);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 236, 46, 14);
		getContentPane().add(lblTipo);
		
		textNombres = new JTextField();
		textNombres.setBounds(140, 8, 154, 20);
		getContentPane().add(textNombres);
		textNombres.setColumns(10);
		
		textApePaterno = new JTextField();
		textApePaterno.setBounds(140, 33, 154, 20);
		getContentPane().add(textApePaterno);
		textApePaterno.setColumns(10);
		
		textApeMaterno = new JTextField();
		textApeMaterno.setBounds(140, 58, 154, 20);
		getContentPane().add(textApeMaterno);
		textApeMaterno.setColumns(10);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(140, 83, 154, 20);
		getContentPane().add(textDireccion);
		textDireccion.setColumns(10);
		
		textFechaNa = new JTextField();
		textFechaNa.setBounds(140, 108, 154, 20);
		getContentPane().add(textFechaNa);
		textFechaNa.setColumns(10);
		
		textFechaAfi = new JTextField();
		textFechaAfi.setBounds(140, 133, 154, 20);
		getContentPane().add(textFechaAfi);
		textFechaAfi.setColumns(10);
		
		
		textTelef = new JTextField();
		textTelef.setBounds(140, 183, 154, 20);
		getContentPane().add(textTelef);
		textTelef.setColumns(10);
		
		textDni = new JTextField();
		textDni.setBounds(140, 208, 154, 20);
		getContentPane().add(textDni);
		textDni.setColumns(10);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 266, 718, 330);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addKeyListener(this);
		table.addMouseListener(this);
		table.setFillsViewportHeight(false);
		scrollPane.setViewportView(table);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("ID");
		tabla.addColumn("Nombre Y Apellidos");
		tabla.addColumn("Tipo");
		tabla.addColumn("DNI");
		table.setModel(tabla);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(46);
		table.getColumnModel().getColumn(1).setPreferredWidth(201);
		table.getColumnModel().getColumn(2).setPreferredWidth(82);
		table.getColumnModel().getColumn(3).setPreferredWidth(82);
		
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.addMouseListener(this);
		btnAceptar.setBounds(304, 7, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnIngreso = new JButton("Ingreso");
		btnIngreso.addActionListener(this);
		btnIngreso.addMouseListener(this);
		btnIngreso.setBounds(586, 7, 126, 23);
		getContentPane().add(btnIngreso);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.addMouseListener(this);
		btnModificar.setBounds(586, 32, 126, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.addMouseListener(this);
		btnEliminar.setBounds(586, 57, 126, 23);
		getContentPane().add(btnEliminar);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(304, 36, 46, 14);
		getContentPane().add(lblId);
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(325, 33, 68, 20);
		getContentPane().add(textID);
		textID.setColumns(10);
		
		ImageIcon imagen = new ImageIcon("Media\\Cliente.jpg");
		JLabel lblImagen = new JLabel(imagen);
		lblImagen.setSize(180,180);
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth()-20,lblImagen.getHeight()-20,Image.SCALE_AREA_AVERAGING));
		lblImagen.setIcon(icono);
		lblImagen.setBounds(423, 11, 126, 114);
		getContentPane().add(lblImagen);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.addMouseListener(this);
		btnConsultar.setBounds(586, 82, 126, 23);
		getContentPane().add(btnConsultar);
		
		cboEstadoCivil = new JComboBox<String>();
		cboEstadoCivil.setModel(new DefaultComboBoxModel<String>(Lib.estadocivil));
		cboEstadoCivil.setBounds(140, 158, 154, 20);
		getContentPane().add(cboEstadoCivil);
		
		cboTipo = new JComboBox<String>();
		cboTipo.setModel(new DefaultComboBoxModel<String>(Lib.tipocliente));
		cboTipo.setBounds(140, 233, 154, 20);
		getContentPane().add(cboTipo);
		
		listar();
		editarFila();
		HabilitarEntradas(false);
	}
	
	ArregloClientes CL = new ArregloClientes();	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnIngreso) {
			actionPerformedBtnIngreso(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
	}
	
	
	protected void actionPerformedBtnIngreso(ActionEvent arg0) {
		btnIngreso.setEnabled(false);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(true);
		HabilitarEntradas(true);
		limpieza();
		
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnIngreso.setEnabled(true);
		btnModificar.setEnabled(false);
		if(CL.tamaño()==0){
			btnAceptar.setEnabled(false);
			HabilitarEntradas(false);
			mensaje("No existen Clientes");
		}
		else{
			HabilitarEntradas(true);
			editarFila();
		}
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		btnIngreso.setEnabled(true);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(false);
		if(CL.tamaño()==0){
			mensaje("No existen Clientes");
		}
		else{
			editarFila();
			HabilitarEntradas(false);
			int ok = confirmar("deseas eliminar el registro?");
			if(ok==0){
				CL.eliminar((CL.buscar(leerID())));
				listar();
				editarFila();
			}
		}
		
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		int  tipo = leerTipo(),Estado = leerEstadoCivil(), id = leerID();
		String nombres = leerNombres();
		if (nombres.length() > 0) {
			String apPaterno = leerApellidoPaterno(),
					apMaterno = leerApellidoMaterno();
			if (apPaterno.length() > 0)
					try {
						String Dir = leerDireccion(), telf = leertelefono(),
								fechaAfi = Fecha.fechaActual(),
								fechaNa = leerFechaAF(),
								dni = leerDNI();
								
						if (btnIngreso.isEnabled() == false){
							CL.adicionar(new Cliente(id, apPaterno,apMaterno,
													nombres, Dir,fechaNa,fechaAfi,
													Estado,telf, dni, tipo));
							btnIngreso.setEnabled(true);
						}
						if (btnModificar.isEnabled() == false) {
							Cliente m = CL.buscar(id);
							m.setnombres(nombres);
							m.setapellidoPaterno(apPaterno);
							m.setapellidoMaterno(apMaterno);
							m.settipoCliente(tipo);
							m.setdireccion(Dir);
							m.setfechaNacimiento(fechaNa);
							m.setfechaAfiliacion(fechaAfi);
							m.setdni(dni);
							m.setestadoCivil(Estado);
							m.settelefono(telf);
							CL.actualizar();
							btnModificar.setEnabled(true);
						}
						listar();
						HabilitarEntradas(false);
					}
					catch (Exception e) {
						error("Ingrese APELLIDOS correcto", textApePaterno);
					}
				
			else	
				error("Ingrese NOMBRES correcto", textNombres);
		}
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		
	}
	
	
	// METODOS DE MANIPULACION''
	void editarFila(){
		if (CL.tamaño() == 0)
			limpieza();
		else {
			Cliente x = CL.obtener(table.getSelectedRow());
			textID.setText("CLI00" + x.getidCliente());
			textNombres.setText(x.getnombres());
			textApePaterno.setText(x.getapellidoPaterno());
			textApeMaterno.setText("" + x.getapellidoMaterno());
			cboTipo.setSelectedIndex(x.gettipoCliente());
			cboEstadoCivil.setSelectedIndex(x.getestadoCivil());
			textFechaNa.setText(x.getfechaNacimiento());
			textFechaAfi.setText(x.getfechaAfiliacion());
			textTelef.setText(x.gettelefono());
			textDireccion.setText(x.getdireccion());
			textDni.setText(x.getdni());
		}
	}
	void limpieza(){
		textID.setText("" + CL.CodigoCorrelativo());
		textFechaAfi.setText("" + Fecha.fechaActual());
		textNombres.setText("");
		textApePaterno.setText("");
		textApeMaterno.setText("");
		textTelef.setText("");
		textDni.setText("");
		textDireccion.setText("");
		textFechaNa.setText("");
	}
	
	void listar(){
		int posFila = 0;
		if (tabla.getRowCount() > 0)
			posFila = table.getSelectedRow();
		if (tabla.getRowCount() == CL.tamaño() - 1)
			posFila = CL.tamaño() - 1;
		if (posFila == CL.tamaño())
			posFila --;
		tabla.setRowCount(0);
		Cliente U;
		for(int i=0; i<CL.tamaño();i++){
			U = CL.obtener(i);
		 Object[] fila = { "CLI00"+U.getidCliente(),
				 			U.getnombres()+' '+
				 			U.getapellidoPaterno()+' '+ 
				 			U.getapellidoMaterno(),
				 			Lib.tipocliente[U.gettipoCliente()],
				 			U.getdni()
				 			 };
		tabla.addRow(fila);
		}
		if (CL.tamaño() > 0)
			table.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	//Habilitar ENTRADAS METODOS
	void HabilitarEntradas(boolean sino){
		textNombres.setEditable(sino);
		textApePaterno.setEditable(sino);
		textApeMaterno.setEditable(sino);
		textDireccion.setEditable(sino);
		textFechaNa.setEditable(sino);
		textFechaAfi.setEditable(sino);
		textTelef.setEditable(sino);
		textDni.setEditable(sino);
		btnConsultar.setEnabled(sino);
		btnAceptar.setEnabled(sino);
	}
	void HabilitarBotones(boolean sino){
		btnIngreso.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
	}
	
	//METEDORS DE LECTURA DE DATOS
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}
	
	String leerNombres() {
		return textNombres.getText().trim();
	}
	String leerApellidoPaterno() {
		return textApePaterno.getText().trim();
	}
	String leerApellidoMaterno() {
		return textApeMaterno.getText().trim();
	}
	String leerDireccion() {
		return textDireccion.getText().trim();
	}
	String leerFechaNA() {
		return textFechaNa.getText().trim();
	}
	String leerFechaAF() {
		return textFechaAfi.getText().trim();
	}
	String leertelefono() {
		return textTelef.getText().trim();
	}
	String leerDNI() {
		return textDni.getText().trim();
	}
	
	int leerEstadoCivil() {
		return cboEstadoCivil.getSelectedIndex();
	}
	int leerTipo() {
		return  cboTipo.getSelectedIndex();
	}
	int leerID() {
		return Integer.parseInt(textID.getText().substring(3));
	}
	
	//mouse acciones
	
		public void keyPressed(KeyEvent arg0) {
		}
		public void keyReleased(KeyEvent arg0) {
			arg0.consume();
			editarFila();		
		}
		public void keyTyped(KeyEvent arg0) {
		}
		public void mouseClicked(MouseEvent arg0) {
			if (arg0.getSource() == table) {
				mouseClickedTbl(arg0);
			}
		}
		public void mouseEntered(MouseEvent arg0) {
			if (arg0.getSource() == btnAceptar) {
				mouseEnteredBtnAceptar(arg0);
			}
			if (arg0.getSource() == btnEliminar) {
				mouseEnteredBtnEliminar(arg0);
			}
			if (arg0.getSource() == btnModificar) {
				mouseEnteredBtnModificar(arg0);
			}
			if (arg0.getSource() == btnIngreso) {
				mouseEnteredBtnAdicionar(arg0);
			}
			if (arg0.getSource() == table) {
				mouseEnteredTbl(arg0);
			}
		}
		public void mouseExited(MouseEvent arg0) {
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
		protected void mouseClickedTbl(MouseEvent arg0) {
			HabilitarEntradas(false);
			HabilitarBotones(true);
			editarFila();
		}
		protected void mouseEnteredTbl(MouseEvent arg0) {
			table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		protected void mouseEnteredBtnAdicionar(MouseEvent arg0) {
			btnIngreso.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		protected void mouseEnteredBtnModificar(MouseEvent arg0) {
			btnModificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		protected void mouseEnteredBtnEliminar(MouseEvent arg0) {
			btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		protected void mouseEnteredBtnAceptar(MouseEvent arg0) {
			btnAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
}
