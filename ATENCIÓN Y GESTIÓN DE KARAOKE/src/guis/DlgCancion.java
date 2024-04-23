package guis;


import java.awt.Cursor;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
import javax.swing.DefaultComboBoxModel;

import libreria.Fecha;
import libreria.Lib;

import javax.swing.JComboBox;
import clases.*;
import arreglos.*;

public class DlgCancion extends JDialog implements ActionListener, KeyListener, MouseListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textIDCancion;
	private JTextField textAlbum;
	private JTable table;
	private JScrollPane scrollPane;
	
	private JButton btnAceptar;
	private JButton btnIngreso;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JComboBox <String>cboEstado;
	private DefaultTableModel tabla;
	private JComboBox <String>cboIDArtista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCancion dialog = new DlgCancion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCancion() {
		setTitle("Cancion");
		setBounds(100, 100, 730, 469);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setBounds(10, 11, 63, 14);
			getContentPane().add(lblNewLabel);
		}
		{
			JLabel lblArtista = new JLabel("ID Cancion:");
			lblArtista.setBounds(10, 36, 63, 14);
			getContentPane().add(lblArtista);
		}
		{
			JLabel lblId = new JLabel("ID Artista:");
			lblId.setBounds(10, 61, 63, 14);
			getContentPane().add(lblId);
		}
		{
			JLabel lblAlbum = new JLabel("Album:");
			lblAlbum.setBounds(10, 86, 46, 14);
			getContentPane().add(lblAlbum);
		}
		{
			textNombre = new JTextField();
			textNombre.setBounds(83, 8, 201, 20);
			getContentPane().add(textNombre);
			textNombre.setColumns(10);
		}
		{
			textIDCancion = new JTextField();
			textIDCancion.setEditable(false);
			textIDCancion.setBounds(83, 33, 86, 20);
			getContentPane().add(textIDCancion);
			textIDCancion.setColumns(10);
		}
		{
			textAlbum = new JTextField();
			textAlbum.setBounds(83, 83, 201, 20);
			getContentPane().add(textAlbum);
			textAlbum.setColumns(10);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.addMouseListener(this);
			btnAceptar.setBounds(294, 7, 89, 23);
			getContentPane().add(btnAceptar);
		}
		{
			btnIngreso = new JButton("Ingreso");
			btnIngreso.addActionListener(this);
			btnIngreso.addMouseListener(this);
			btnIngreso.setBounds(615, 7, 89, 23);
			getContentPane().add(btnIngreso);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(this);
			btnModificar.addMouseListener(this);
			btnModificar.setBounds(615, 36, 89, 23);
			getContentPane().add(btnModificar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(this);
			btnEliminar.addMouseListener(this);
			btnEliminar.setBounds(615, 70, 89, 23);
			getContentPane().add(btnEliminar);
		}
		
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 166, 694, 253);
			getContentPane().add(scrollPane);
			
				table = new JTable();
				table.setFillsViewportHeight(false);
				table.addKeyListener(this);
				table.addMouseListener(this);
				scrollPane.setViewportView(table);
			
				tabla = new DefaultTableModel();
				tabla.addColumn("ID");
				tabla.addColumn("Nombre");
				tabla.addColumn("Estado");
				tabla.addColumn("Artista");
				tabla.addColumn("Genero");
				table.setModel(tabla);
				
				table.getColumnModel().getColumn(0).setPreferredWidth(58);
				table.getColumnModel().getColumn(1).setPreferredWidth(160);
				table.getColumnModel().getColumn(2).setPreferredWidth(112);
				table.getColumnModel().getColumn(3).setPreferredWidth(99);
				table.getColumnModel().getColumn(4).setPreferredWidth(107);
				
				tabla.setRowCount(0);
			JLabel lblEstado = new JLabel("Estado:");
			lblEstado.setBounds(10, 111, 46, 14);
			getContentPane().add(lblEstado);
		
		
		cboEstado = new JComboBox<String>();
		cboEstado.setModel(new DefaultComboBoxModel <String>(Lib.estado));
		cboEstado.setBounds(83, 108, 150, 20);
		getContentPane().add(cboEstado);
		
			ImageIcon imagen = new ImageIcon("Media\\Cancion.jpg");
			JLabel lblImagen = new JLabel(imagen);
			lblImagen.setSize(180,170);
			lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
			Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth()-50,lblImagen.getHeight()-50,Image.SCALE_AREA_AVERAGING));
			lblImagen.setIcon(icono);
			lblImagen.setBounds(427, 11, 142, 109);
			getContentPane().add(lblImagen);
		
		cboIDArtista = new JComboBox<String>();
		cboIDArtista.addActionListener(this);
		cboIDArtista.setModel(new DefaultComboBoxModel<String>(Artistas()));
		cboIDArtista.setBounds(83, 58, 150, 20);
		getContentPane().add(cboIDArtista);
		{
			lblGenero = new JLabel("Genero:");
			lblGenero.setBounds(10, 141, 46, 14);
			getContentPane().add(lblGenero);
		}
		{
			textGenero = new JTextField();
			textGenero.setBounds(83, 139, 150, 20);
			getContentPane().add(textGenero);
			textGenero.setColumns(10);
		}
		
		listar();
		editarFila();
		HabilitarEntradas(false);
	}
	
	ArregloCancion Us = new ArregloCancion(0);
	ArregloArtista Ar = new ArregloArtista();
	ArregloGenero G = new ArregloGenero();
	private JLabel lblGenero;
	private JTextField textGenero;
	
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
		if (arg0.getSource() == cboIDArtista) {
			actionPerformedCboArtista(arg0);
		}
	}
	
	protected void actionPerformedCboArtista(ActionEvent arg0) {	
		textGenero.setText("GEN00"+
	Ar.buscar(cboIDArtista.getSelectedIndex()).getidGenero());
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
		if(Us.tamaño()==0){
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
		if(Us.tamaño()==0){
			mensaje("No existen suarios");
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
		int idA = leerIDArtista(), id =leerID();
		boolean Estado = leerEstado();
		String nombre = leerNombre(), fecha = Fecha.fechaActual();
		if (nombre.length() > 0) {
			String album = leerAlbum();
			if (album.length() > 0 )
					try {
						if (btnIngreso.isEnabled() == false){
							Us.adicionar(new Cancion(id,nombre,idA,album,fecha,0,Estado));
							btnIngreso.setEnabled(true);
						}
						if (btnModificar.isEnabled() == false) {
							Cancion m = Us.buscar(id);
							m.setNombre(nombre);
							m.setIdArtista(idA);
							m.setAlbum(album);
							m.setFechaRegistro(fecha);
							m.setEstado(Estado);
							Us.actualizarArchivo();
							btnModificar.setEnabled(true);
						}
						listar();
						HabilitarEntradas(false);
					}
					catch (Exception e) {
						error("Ingrese NOMBRE correcto", textNombre);
					}
			else	
				error("Ingrese NOMBRE correcto", textNombre);
		}
	}
	
	void listar(){
		int posFila = 0;
		if (tabla.getRowCount() > 0)
			posFila = table.getSelectedRow();
		if (tabla.getRowCount() == Us.tamaño() - 1)
			posFila = Us.tamaño() - 1;
		if (posFila == Us.tamaño())
			posFila --;
		tabla.setRowCount(0);
		Cancion U;
		
		for(int i=0; i<Us.tamaño();i++){
			U = Us.obtener(i);
			int Estado;
			if(U.getEstado()==false)
			Estado=0;
			else
			Estado=1;
		 Object[] fila = { "CAN00" +U.getIdCancion(),
				 			U.getNombre(),
				 			Lib.estado[Estado], 
				 			Ar.buscar(U.getIdArtista()).getnombreArtistico(),
				 			G.buscar(Ar.buscar(U.getIdArtista()).getidGenero()).getdescripcion()
				 			 };
		tabla.addRow(fila);
		}
		if (Us.tamaño() > 0)
			table.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	void editarFila(){
		if (Us.tamaño() == 0)
			limpieza();
		else {
			Cancion x = Us.obtener(table.getSelectedRow());
			int Estado;
			if(x.getEstado()==false)
			Estado=0;
			else
			Estado=1;
			textIDCancion.setText("CAN00" + x.getIdCancion());
			textNombre.setText(x.getNombre());
			cboIDArtista.setSelectedIndex(x.getIdArtista());
			cboEstado.setSelectedIndex(Estado);
			textAlbum.setText(x.getAlbum());
		}
	}
	
	void HabilitarEntradas(boolean sino){
		textIDCancion.setEditable(sino);
		textNombre.setEditable(sino);
		textAlbum.setEditable(sino);
		btnAceptar.setEnabled(sino);
	}
	void HabilitarBotones(boolean sino){
		btnIngreso.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
	}
	void limpieza(){
		textIDCancion.setText(""+ Us.codigoCorrelativo());
		textNombre.setText("");
		textAlbum.setText("");
		cboEstado.setSelectedIndex(1);
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}	
		
	int leerID(){
		return Integer.parseInt(textIDCancion.getText().substring(3));
	}
	
	int leerIDArtista(){
		return cboIDArtista.getSelectedIndex();
	}
	
	String leerNombre(){
		return textNombre.getText().trim();
	}
	String leerAlbum(){
		return textAlbum.getText().trim();
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
	String[] Artistas(){
		int l = Ar.tamaño()+1;
		String[] s = new String[l];
		s[0]="desconocido";
		for(int i=1;i<l;i++){
			s[i] = Ar.obtener(i-1).getnombreArtistico();
		}
		return s;
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
}
