package guis;
import java.awt.Image;

import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.EventQueue;

import arreglos.ArregloPiqueos;
import clases.Piqueo;
import libreria.Lib;

public class DlgPiqueo extends JDialog implements ActionListener, KeyListener, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID=1L;
	private JTextField textNombre;
	private JComboBox <String>cboTipoPiqueo;
	private JComboBox <String>cboEstado;
	private JTextField textPrecio;
	private JTextField textID;
	private JTable table;
	private JScrollPane scrollPane;
	
	private JButton btnAceptar;
	private JButton btnIngreso;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnConsultar;
	
	
	private DefaultTableModel tabla;
	

	/**
	 * Launch the application.
	 */	public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
				public void run() {
		try {
			DlgPiqueo dialog = new DlgPiqueo();
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
	public DlgPiqueo() {
		setResizable (false);
		setTitle("Piqueo");
		setBounds(100, 100, 812, 508);
		getContentPane().setLayout(null);
		
			JLabel lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setBounds(10, 11, 68, 14);
			getContentPane().add(lblNewLabel);
		
		
		JLabel lblTipoDePiqueo = new JLabel("Tipo de Piqueo:");
		lblTipoDePiqueo.setBounds(10, 36, 99, 14);
		getContentPane().add(lblTipoDePiqueo);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 61, 46, 14);
		getContentPane().add(lblPrecio);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 86, 46, 14);
		getContentPane().add(lblId);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 111, 46, 14);
		getContentPane().add(lblEstado);
		
		textNombre = new JTextField();
		textNombre.setBounds(135, 8, 190, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		cboTipoPiqueo = new JComboBox<String>();
		cboTipoPiqueo.setModel(new DefaultComboBoxModel<String>(Lib.tipopiqueo));
		cboTipoPiqueo.setBounds(135, 33, 154, 20);
		getContentPane().add(cboTipoPiqueo);
			
		textPrecio = new JTextField();
		textPrecio.setEditable(false);
		textPrecio.setBounds(135, 58, 143, 20);
		getContentPane().add(textPrecio);
		textPrecio.setColumns(10);
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(135, 83, 143, 20);
		getContentPane().add(textID);
		textID.setColumns(10);
		
		cboEstado = new JComboBox<String>();
		cboEstado.setModel(new DefaultComboBoxModel<String>(Lib.estado));
		cboEstado.setBounds(135, 108, 143, 20);
		getContentPane().add(cboEstado);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.addMouseListener(this);
		btnAceptar.setBounds(335, 7, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnIngreso = new JButton("Ingreso");
		btnIngreso.addActionListener(this);
		btnIngreso.addMouseListener(this);
		btnIngreso.setBounds(697, 7, 89, 23);
		getContentPane().add(btnIngreso);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.addMouseListener(this);
		btnModificar.setBounds(697, 36, 89, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.addMouseListener(this);
		btnEliminar.setBounds(697, 77, 89, 23);
		getContentPane().add(btnEliminar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.addMouseListener(this);
		btnConsultar.setBounds(697, 107, 89, 23);
		getContentPane().add(btnConsultar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 150, 776, 308);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addKeyListener(this);
		table.addMouseListener(this);
		table.setFillsViewportHeight(false);
		scrollPane.setViewportView(table);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("ID");
		tabla.addColumn("Nombre");
		tabla.addColumn("Tipo");
		tabla.addColumn("Precio");
		tabla.addColumn("Estado");
		table.setModel(tabla);
		
		tabla.setRowCount(0);
		
		ImageIcon imagen = new ImageIcon("Media\\Piqueos.jpg");
		JLabel lblImagen = new JLabel(imagen);
		lblImagen.setSize(170,170);
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth()-50,lblImagen.getHeight()-50,Image.SCALE_AREA_AVERAGING));
		lblImagen.setIcon(icono);
		lblImagen.setBounds(469, 11, 175, 117);
		getContentPane().add(lblImagen);
		
		ajustarAnchoColumnas();
		listar();
		editarFila();
		HabilitarEntradas(false);
		
	}
	
	ArregloPiqueos Us = new ArregloPiqueos(0);
	
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
		textNombre.requestFocus();
		
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnIngreso.setEnabled(true);
		btnModificar.setEnabled(false);
		if(Us.tamaño()==0){
			btnAceptar.setEnabled(false);
			HabilitarEntradas(false);
			mensaje("No existen piqueos");
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
		if (Us.tamaño()==0){
			mensaje("No existen piqueos");
		}
		else{
			editarFila();
			HabilitarEntradas(false);
			int ok = confirmar("¿deseas eliminar el registro?");
			if(ok==0){
				Us.eliminar((Us.buscar(leerID())));
				listar();
				editarFila();
			}
		}
		
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		int  id =leerID(), tipo=leerTipo();
		String nombre = leerNombre();
		double precio = leerPrecio();
		boolean estado =leerEstado();
					
					try {
						
						if (btnIngreso.isEnabled() == false){
							Us.adicionar(new Piqueo(id,
													 tipo,nombre,
													 precio, estado
													));
							btnIngreso.setEnabled(true);
						}
						if (btnModificar.isEnabled() == false) {
							Piqueo m = Us.buscar(id);
							m.setNombre(nombre);
							m.setestado(estado);
							m.setPrecio(precio);
							m.setTipoPiqueo(tipo);						
							Us.actualizarArchivo();
							btnModificar.setEnabled(true);
						}
						listar();
						HabilitarEntradas(false);
					}
					catch (Exception e) {
						error("Ingrese APELLIDOS correcto", textNombre);
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
		if (Us.tamaño() == 0)
			limpieza();
		else {
			Piqueo x = Us.obtener(table.getSelectedRow());
			textID.setText("PIQ00" + x.getIdPiqueo());
			textNombre.setText(x.getNombre());
			cboTipoPiqueo.setSelectedItem(x.getTipoPiqueo());
			cboEstado.setSelectedItem(x.getEstado());
		}
	}
	void limpieza(){
		textID.setText(""+ Us.codigoCorrelativo());
		textNombre.setText("");
		textPrecio.setText("");
		cboTipoPiqueo.setSelectedIndex(0);
		cboEstado.setSelectedIndex(1);
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
		Piqueo P;
		for(int i=0; i<Us.tamaño();i++){
			P = Us.obtener(i);
			int Estado;
			if(P.getEstado()==false)
			Estado=0;
			else
			Estado=1;
		 Object[] fila = { "PIQ00"+P.getIdPiqueo(),
				 			P.getNombre(),
				 			Lib.tipopiqueo[P.getTipoPiqueo()],
				 			P.getPrecio(),
				 			Lib.estado[Estado]
				 			 };
		tabla.addRow(fila);
		}
		if (Us.tamaño() > 0)
			table.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	void HabilitarEntradas(boolean sino){
		textNombre.setEditable(sino);
		textPrecio.setEditable(sino);
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
				mouseClickedTblMedicina(arg0);
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
				mouseEnteredTblMedicina(arg0);
			}
		}
		public void mouseExited(MouseEvent arg0) {
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
		protected void mouseClickedTblMedicina(MouseEvent arg0) {
			HabilitarEntradas(false);
			HabilitarBotones(true);
			editarFila();
		}
		protected void mouseEnteredTblMedicina(MouseEvent arg0) {
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
		//lectura de datos metodos
		
		int confirmar(String s) {
			return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
		}
		
		String leerNombre() {
			return textNombre.getText().trim();
		}
		
		int leerTipo() {
			return cboTipoPiqueo.getSelectedIndex();
		}
		boolean leerEstado(){
			return getBoolean(cboEstado.getSelectedIndex());
		}
		
		double leerPrecio(){
			return Double.parseDouble(textPrecio.getText().trim());
		}
				
		int leerID() {
			return Integer.parseInt(textID.getText().substring(3));
		}
		private boolean getBoolean(int i) {
			if(i==0)
			return false;
			else
				return true;
		}
		
}