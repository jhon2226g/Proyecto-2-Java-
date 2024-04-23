package guis;

import java.awt.Image;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.EventQueue;

import libreria.Lib;
import arreglos.ArregloUsuario;
import clases.Usuario;

public class DlgUsuario extends JDialog implements ActionListener, KeyListener, MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNombres;
	private JTextField textApePaterno;
	private JTextField textApeMaterno;
	private JTextField textLogin;
	private JTextField textPass;
	private JTable table;
	private JScrollPane scrollPane;
	
	private JButton btnAceptar;
	private JButton btnIngreso;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnConsultar;
	
	private JComboBox<String> cboTipo;
	private JComboBox<String> cboTurno;
	private JLabel lblId;
	private JTextField textID;
	private DefaultTableModel tabla;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
		try {
			DlgUsuario dialog = new DlgUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			} 
		catch (Exception e) {
				e.printStackTrace();
				}
		
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgUsuario() {
		setResizable(false);
		setTitle("Usuario");
		setBounds(100, 100, 667, 562);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombres:");
		lblNewLabel.setBounds(10, 11, 104, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Paterno:");
		lblApellidoMaterno.setBounds(10, 36, 104, 14);
		getContentPane().add(lblApellidoMaterno);
		
		JLabel lblApellidoParterno = new JLabel("Apellido Materno:");
		lblApellidoParterno.setBounds(10, 61, 104, 14);
		getContentPane().add(lblApellidoParterno);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo:");
		lblNewLabel_1.setBounds(10, 86, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Login:");
		lblNewLabel_2.setBounds(10, 111, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 136, 69, 14);
		getContentPane().add(lblPassword);
		
		JLabel lblTurno = new JLabel("Turno:");
		lblTurno.setBounds(10, 161, 46, 14);
		getContentPane().add(lblTurno);
		
		textNombres = new JTextField();
		textNombres.setBounds(124, 8, 140, 20);
		getContentPane().add(textNombres);
		textNombres.setColumns(10);
		
		textApePaterno = new JTextField();
		textApePaterno.setBounds(124, 33, 140, 20);
		getContentPane().add(textApePaterno);
		textApePaterno.setColumns(10);
		
		textApeMaterno = new JTextField();
		textApeMaterno.setBounds(124, 58, 140, 20);
		getContentPane().add(textApeMaterno);
		textApeMaterno.setColumns(10);
		
		cboTipo =new JComboBox<String>();
		cboTipo.setModel(new DefaultComboBoxModel<String>(Lib.TipoEmpleado));
		cboTipo.setBounds(124, 83, 140, 20);
		getContentPane().add(cboTipo);
		
		cboTurno=new JComboBox<String>();
		cboTurno.setModel(new DefaultComboBoxModel<String>(Lib.Turno));
		cboTurno.setBounds(124, 158, 140, 20);
		getContentPane().add(cboTurno);
		
		textLogin = new JTextField();
		textLogin.setBounds(124, 108, 140, 20);
		getContentPane().add(textLogin);
		textLogin.setColumns(10);
		
		textPass = new JTextField();
		textPass.setBounds(124, 133, 140, 20);
		getContentPane().add(textPass);
		textPass.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.addMouseListener(this);
		btnAceptar.setBounds(274, 7, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnIngreso = new JButton("Ingreso");
		btnIngreso.addActionListener(this);
		btnIngreso.addMouseListener(this);
		btnIngreso.setBounds(497, 7, 144, 23);
		getContentPane().add(btnIngreso);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.addMouseListener(this);
		btnModificar.setBounds(497, 32, 144, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.addMouseListener(this);
		btnEliminar.setBounds(497, 57, 144, 23);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 197, 631, 315);
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
		tabla.addColumn("Turno");
		table.setModel(tabla);
		
		tabla.setRowCount(0);
		
		ImageIcon imagen = new ImageIcon("Media\\Usuario.jpg");
		JLabel lblNewLabel_3 = new JLabel(imagen);
		lblNewLabel_3.setSize(160,160);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(lblNewLabel_3.getWidth()-20,lblNewLabel_3.getHeight()-20,Image.SCALE_FAST));
		lblNewLabel_3.setIcon(icono);
		lblNewLabel_3.setBounds(373, 11, 114, 114);
		getContentPane().add(lblNewLabel_3);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(274, 107, 89, 23);
		btnConsultar.addActionListener(this);
		btnConsultar.addMouseListener(this);
		getContentPane().add(btnConsultar);
		
		lblId = new JLabel("ID:");
		lblId.setBounds(274, 36, 46, 14);
		getContentPane().add(lblId);
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(294, 33, 69, 20);
		getContentPane().add(textID);
		textID.setColumns(10);
		
		ajustarAnchoColumnas();
		listar();
		editarFila();
		HabilitarEntradas(false);
	}
	
	ArregloUsuario Us = new ArregloUsuario();
	
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
		limpieza();
		HabilitarEntradas(true);
		textNombres.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnIngreso.setEnabled(true);
		btnModificar.setEnabled(false);
		if(Us.tamanio()==0){
			btnAceptar.setEnabled(false);
			HabilitarEntradas(false);
			mensaje("No existen usuarios");
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
		if(Us.tamanio()==0){
			mensaje("No existen Usuarios");
		}
		else{
			editarFila();
			HabilitarEntradas(false);
			int ok = confirmar("deseas eliminar el registro?");
			if(ok==0){
				Us.eliminar((Us.buscar(leerID())));
				listar();
				editarFila();
			}
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		int tipo = leerTipo(), turno = leerTurno(), id =leerID();
		String nombres = leerNombres();
		if (nombres.length() > 0) {
			String apPaterno = leerApellidoPaterno(),
					apMaterno = leerApellidoMaterno();
			if (apPaterno.length() > 0 && apMaterno.length() > 0 )
					try {
						String login = leerLogin(), pass = leerPassword();
						if (btnIngreso.isEnabled() == false){
							Us.adicionar(new Usuario(id,
													 apPaterno,apMaterno,
													nombres,tipo, login,
													pass,turno));
							btnIngreso.setEnabled(true);
						}
						if (btnModificar.isEnabled() == false) {
							Usuario m = Us.buscar(id);
							m.setnombres(nombres);
							m.setapellidoPaterno(apPaterno);
							m.setapellidoMaterno(apMaterno);
							m.settipoEmpleado(tipo);
							m.setlogin(login);
							m.setpassword(pass);
							m.setturno(turno);
							Us.actualizar();
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
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	void editarFila(){
		if (Us.tamanio() == 0)
			limpieza();
		else {
			Usuario x = Us.obtener(table.getSelectedRow());
			textID.setText("USU00" + x.getidUsuario());
			textNombres.setText(x.getnombres());
			textApePaterno.setText(x.getapellidoPaterno());
			textApeMaterno.setText("" + x.getapellidoMaterno());
			cboTipo.setSelectedIndex(x.gettipoEmpleado());
			cboTurno.setSelectedIndex(x.getturno());
			textLogin.setText(x.getlogin());
			textPass.setText(x.getpassword());
		}
	}
	void limpieza(){
		textID.setText(""+ Us.CodigoCorrelativo());
		textNombres.setText("");
		textApePaterno.setText("");
		textApeMaterno.setText("");
		textLogin.setText("");
		textPass.setText("");
	}
	
	void listar(){
		int posFila = 0;
		if (tabla.getRowCount() > 0)
			posFila = table.getSelectedRow();
		if (tabla.getRowCount() == Us.tamanio() - 1)
			posFila = Us.tamanio() - 1;
		if (posFila == Us.tamanio())
			posFila --;
		tabla.setRowCount(0);
		Usuario U;
		for(int i=0; i<Us.tamanio();i++){
			U = Us.obtener(i);
		 Object[] fila = { "USU00"+U.getidUsuario(),
				 			U.getnombres()+' '+
				 			U.getapellidoPaterno()+' '+ 
				 			U.getapellidoMaterno(),
				 			Lib.TipoEmpleado[U.gettipoEmpleado()],
				 			Lib.Turno[U.getturno()]
				 			 };
		tabla.addRow(fila);
		}
		if (Us.tamanio() > 0)
			table.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void HabilitarEntradas(boolean sino){
		textNombres.setEditable(sino);
		textApePaterno.setEditable(sino);
		textApeMaterno.setEditable(sino);
		textLogin.setEditable(sino);
		textPass.setEditable(sino);
		btnConsultar.setEnabled(sino);
		btnAceptar.setEnabled(sino);
	}
	void HabilitarBotones(boolean sino){
		btnIngreso.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
		
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10));  // 
		tcm.getColumn(1).setPreferredWidth(anchoColumna(45));  // 
		tcm.getColumn(2).setPreferredWidth(anchoColumna(15));  // 
		tcm.getColumn(3).setPreferredWidth(anchoColumna(15));  //
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
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
			mouseClickedTblUsuario(arg0);
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
			mouseEnteredTblUsuario(arg0);
		}
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedTblUsuario(MouseEvent arg0) {
		HabilitarEntradas(false);
		HabilitarBotones(true);
		editarFila();
	}
	protected void mouseEnteredTblUsuario(MouseEvent arg0) {
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
	
	//lectura de datos metodos'
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
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
	int leerTipo() {
		return cboTipo.getSelectedIndex();
	}
	int leerID() {
		return Integer.parseInt(textID.getText().substring(3));
	}
	String leerLogin() {
		return textLogin.getText().trim();
	}
	String leerPassword	() {
		return textPass.getText().trim();
	}
	int leerTurno() {
		return cboTurno.getSelectedIndex();
	}
}


