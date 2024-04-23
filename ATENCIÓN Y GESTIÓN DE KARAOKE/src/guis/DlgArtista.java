package guis;


import java.awt.Cursor;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arreglos.*;
import clases.*;
import libreria.Fecha;
import libreria.Lib;
import javax.swing.JComboBox;

public class DlgArtista extends JDialog implements ActionListener, KeyListener, MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textIDArtista;
	private JTable table;
	private JTextField textFecha;
	
	private JButton btnAceptar;
	private JButton btnIngreso;
	private JButton btnModificar;
	private JButton btnEliminar;
	
	private JComboBox<String> cboEstado;
	private JComboBox<String> cboGenero ;
	private DefaultTableModel tabla;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgArtista dialog = new DlgArtista();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgArtista() {
		setTitle("Artista");
		setBounds(100, 100, 761, 470);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Artistico:");
		lblNewLabel.setBounds(10, 11, 140, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblApellidoParteno = new JLabel("ID Artista:");
		lblApellidoParteno.setBounds(10, 36, 84, 14);
		getContentPane().add(lblApellidoParteno);
		
		JLabel lblApellidoMaterno = new JLabel("Genero:");
		lblApellidoMaterno.setBounds(10, 61, 94, 14);
		getContentPane().add(lblApellidoMaterno);
		
		JLabel lblNewLabel_1 = new JLabel("Estado:");
		lblNewLabel_1.setBounds(10, 86, 94, 14);
		getContentPane().add(lblNewLabel_1);
		
		textNombre = new JTextField();
		textNombre.setBounds(148, 8, 177, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textIDArtista = new JTextField();
		textIDArtista.setEditable(false);
		textIDArtista.setBounds(148, 33, 86, 20);
		getContentPane().add(textIDArtista);
		textIDArtista.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.addMouseListener(this);
		btnAceptar.setBounds(335, 7, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnIngreso = new JButton("Ingreso");
		btnIngreso.addActionListener(this);
		btnIngreso.addMouseListener(this);
		btnIngreso.setBounds(635, 7, 89, 23);
		getContentPane().add(btnIngreso);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.addMouseListener(this);
		btnModificar.setBounds(635, 36, 89, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.addMouseListener(this);
		btnEliminar.setBounds(635, 77, 89, 23);
		getContentPane().add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 141, 725, 279);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addKeyListener(this);
		table.addMouseListener(this);
		table.setFillsViewportHeight(false);
		scrollPane.setViewportView(table);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("ID");
		tabla.addColumn("Nombre Artistico");
		tabla.addColumn("Genero");
		tabla.addColumn("Fecha de Regsitro");
		tabla.addColumn("Estado");
		table.setModel(tabla);
		
		
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		tabla.setRowCount(0);
		
		ImageIcon imagen = new ImageIcon("Media\\Artista.jpg");
		JLabel lblImagen = new JLabel(imagen);
		lblImagen.setSize(180,160);
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth()-50,lblImagen.getHeight()-50,Image.SCALE_AREA_AVERAGING));
		lblImagen.setIcon(icono);
		lblImagen.setBounds(458, 11, 140, 106);
		getContentPane().add(lblImagen);
		
		cboEstado = new JComboBox<String>();
		cboEstado.setModel(new DefaultComboBoxModel <String>(Lib.estado));
		cboEstado.setBounds(148, 82, 177, 22);
		getContentPane().add(cboEstado);
		
		cboGenero = new JComboBox<String>();
		cboGenero.setModel(new DefaultComboBoxModel<String>(Generos()));
		cboGenero.setBounds(148, 58, 124, 20);
		getContentPane().add(cboGenero);
		
		JLabel lblFechaDeRegistro = new JLabel("Fecha de Registro:");
		lblFechaDeRegistro.setBounds(10, 111, 111, 14);
		getContentPane().add(lblFechaDeRegistro);
		
		textFecha = new JTextField();
		textFecha.setEditable(false);
		textFecha.setBounds(148, 107, 124, 20);
		getContentPane().add(textFecha);
		textFecha.setColumns(10);
		
		listar();
		editarFila();
		HabilitarEntradas(false);
	}
	// DECLARACION GLOBAL
	ArregloArtista Ar = new ArregloArtista();
	ArregloGenero G = new ArregloGenero();
	
	
	
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
	}
	
	
	protected void actionPerformedBtnIngreso(ActionEvent arg0) {
		btnIngreso.setEnabled(false);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(true);
		limpieza();
		HabilitarEntradas(true);
		textNombre.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnIngreso.setEnabled(true);
		btnModificar.setEnabled(false);
		btnModificar.setEnabled(false);
		if(Ar.tamaño()==0){
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
		if (Ar.tamaño() == 0)
			mensaje("No existen Artistas");
		else {
			editarFila();
			HabilitarEntradas(false);
			int ok = confirmar("¿ Desea eliminar el registro ?");
			if (ok == 0) {
				Ar.eliminar(Ar.buscar(leerCodigoArtista()));
				listar();
				editarFila();
			}
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
			 int id = leerCodigoArtista(), idGenero = leeridGenero();
			 boolean Estado = leerEstado();
			 String Nombre = leerNombres() ;
			if (Nombre.length() > 0) {
				String  fechaRegistro = Fecha.fechaActual();
				if ( fechaRegistro.length() > 0 )
				try {
					if (btnIngreso.isEnabled() == false){
						Ar.adicionar(new Artista(id, Nombre, idGenero,fechaRegistro, Estado));
						btnIngreso.setEnabled(true);
					}
						 if (btnModificar.isEnabled()==false) {
							        Artista m = Ar.buscar(id);
							        m.setidArtista(id);
							        m.setidGenero(idGenero);
							        m.setnombreArtistico(Nombre);
							        m.setfechaRegistro(fechaRegistro);
							        m.setestado(Estado);
							        Ar.actualizarArchivo();
							        btnModificar.setEnabled(true);
						 }
						 
						listar();
						HabilitarEntradas(false);
				}
					catch (Exception e) {
							error("Ingrese id Artista Correcto", textIDArtista);
					}
							
						 else 
							error("Ingrese fecha correcto", textFecha);	
				
				 }
		}
		
		void mensaje(String s) {
			JOptionPane.showMessageDialog(this, s, "Información", 0);
		}
		void error(String s, JTextField txt) {
			mensaje(s);
			txt.setText("");
			txt.requestFocus();
		}
		void editarFila() {
		if (Ar.tamaño() == 0)
		limpieza();
		 else {
			 
		 Artista x = Ar.obtener(table.getSelectedRow());
		 int Estado;
			if(x.getestado()==false)
			Estado=0;
			else
			Estado=1;
		 	textNombre.setText( x.getnombreArtistico());
		 	textIDArtista.setText("ART00" +x.getidArtista());
		 	textFecha.setText(x.getfechaRegistro());
		 	cboGenero.setSelectedIndex(x.getidGenero());
		 	cboEstado.setSelectedIndex(Estado);
		 }
		}

		void limpieza() {
			textNombre.setText("" );
			textIDArtista.setText(""+ Ar.codigoCorrelativo());
			textFecha.setText(Fecha.fechaActual());
		}
		void listar(){
		int posFila = 0;
		if (tabla.getRowCount() > 0)
		posFila = table.getSelectedRow();
		if (tabla.getRowCount() == Ar.tamaño() - 1)
		posFila = Ar.tamaño() - 1;
		if (posFila == Ar.tamaño())
		posFila --;
		tabla.setRowCount(0);
		Artista A;
		for(int i=0; i<Ar.tamaño();i++){
		A = Ar.obtener(i);
		int Estado;
		if(A.getestado()==false)
		Estado=0;
		else
		Estado=1;
		Object[] fila =  { "ART00"+A.getidArtista(),
						A.getnombreArtistico(),
						G.buscar(A.getidGenero()).getdescripcion(),
						A.getfechaRegistro(),
						Lib.estado[Estado]
						};
				tabla.addRow(fila);
			}
		if (Ar.tamaño() > 0)
			table.getSelectionModel().setSelectionInterval(posFila, posFila);
		}				
		void HabilitarEntradas(boolean sino){
		textNombre.setEditable(sino);
		btnAceptar.setEnabled(sino);
		}
		void HabilitarBotones(boolean sino){
		btnIngreso.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);	
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
	int leeridGenero() {
		return cboGenero.getSelectedIndex();
	}
	boolean leerEstado() {
		return getBoolean(cboEstado.getSelectedIndex());
	}

	private boolean getBoolean(int i) {
		if(i==0)
		return false;
		else
			return true;
	}
	String leerNombres() {
		return textNombre.getText().trim();
	}
	int leerCodigoArtista() {
		return Integer.parseInt(textIDArtista.getText().trim().substring(3));
	}
	String[] Generos(){
		int l = G.tamaño()+1;
		String[] s = new String[l];
		s[0]="desconocido";
		for(int i=1;i<l;i++){
			s[i] = G.obtener(i-1).getdescripcion();
		}
		return s;
	}
}
