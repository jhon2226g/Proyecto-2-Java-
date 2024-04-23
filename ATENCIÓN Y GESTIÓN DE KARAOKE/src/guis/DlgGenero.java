package guis;
import java.awt.Cursor;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloGenero;
import clases.Genero;
import libreria.Lib;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class DlgGenero extends JDialog implements ActionListener, KeyListener, MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> cboEstado;
	private JTable table;
	private JTextField textDescripcion;
	private JTextField textEpoca;
	private JTextField textID;
	private JScrollPane scrollPane;
	private JButton btnAceptar;
	private JButton btnIngreso;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnConsulta;
	private DefaultTableModel tabla;
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgGenero dialog = new DlgGenero();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgGenero() {
		setTitle("Genero");
		setBounds(100, 100, 780, 759);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 271, 744, 438);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addKeyListener(this);
		table.addMouseListener(this);
		table.setFillsViewportHeight(false);
		scrollPane.setViewportView(table);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("ID");
		tabla.addColumn("Descripcion");
		tabla.addColumn("Epoca");
		tabla.addColumn("Estado");
		table.setModel(tabla);
		
		tabla.setRowCount(0);
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(10, 50, 78, 14);
		getContentPane().add(lblDescripcion);
		
		JLabel lblEpoca = new JLabel("Epoca:");
		lblEpoca.setBounds(10, 143, 46, 14);
		getContentPane().add(lblEpoca);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 168, 46, 14);
		getContentPane().add(lblEstado);
		
		textDescripcion = new JTextField();
		textDescripcion.setBounds(93, 51, 201, 81);
		getContentPane().add(textDescripcion);
		textDescripcion.setColumns(10);
		
		textEpoca = new JTextField();
		textEpoca.setBounds(93, 143, 201, 20);
		getContentPane().add(textEpoca);
		textEpoca.setColumns(10);
		
		cboEstado = new JComboBox<String>();
		cboEstado.setModel(new DefaultComboBoxModel<String>(Lib.estado));
		cboEstado.setBounds(93, 168, 201, 20);
		getContentPane().add(cboEstado);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 22, 46, 14);
		getContentPane().add(lblId);
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(93, 22, 86, 20);
		getContentPane().add(textID);
		textID.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.addMouseListener(this);
		btnAceptar.setBounds(297, 18, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnIngreso = new JButton("Ingreso");
		btnIngreso.addActionListener(this);
		btnIngreso.addMouseListener(this);
		btnIngreso.setBounds(622, 18, 89, 23);
		getContentPane().add(btnIngreso);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.addMouseListener(this);
		btnModificar.setBounds(622, 52, 89, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.addMouseListener(this);
		btnEliminar.setBounds(622, 86, 89, 23);
		getContentPane().add(btnEliminar);
		
		ImageIcon imagen = new ImageIcon("Media\\Genero.jpg");
		JLabel lblImagen = new JLabel(imagen);
		lblImagen.setSize(180,180);
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth()-30,lblImagen.getHeight()-30,Image.SCALE_AREA_AVERAGING));
		lblImagen.setIcon(icono);
		lblImagen.setBounds(419, 22, 135, 135);
		getContentPane().add(lblImagen);
		
		
		
		btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(this);
		btnConsulta.addMouseListener(this);
		btnConsulta.setBounds(622, 120, 89, 23);
		getContentPane().add(btnConsulta);
		
		ajustarAnchoColumnas();
		listar();
		editarFila();
		HabilitarEntradas(false);
	}
	
	ArregloGenero Us = new ArregloGenero();
	
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
		if (arg0.getSource() == btnConsulta) {
			actionPerformedBtnConsulta(arg0);
		}
	}
	
	
	protected void actionPerformedBtnIngreso(ActionEvent arg0) {
		btnIngreso.setEnabled(false);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(true);
		limpieza();
		HabilitarEntradas(true);
		textDescripcion.requestFocus();
		
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
		boolean estado = leerEstado();
		int		id =leerID();
		String	descripcion = leerDescripcion();
		if (descripcion.length() > 0) {
			int epoca = leerEpoca();
				
			if ( descripcion.length() > 0 )
					try {
						if (btnIngreso.isEnabled() == false){
							Us.adicionar(new Genero(id, epoca, descripcion, estado));
							btnIngreso.setEnabled(true);
						}
						if (btnModificar.isEnabled() == false) {
							Genero m = Us.buscar(id);
							m.setidGenero(id);
							m.setdescripcion(descripcion);
							m.setepoca(epoca);
							m.setestado(estado);
							Us.actualizar();
							btnModificar.setEnabled(true);
						}
						listar();
						HabilitarEntradas(false);
					}
					catch (Exception e) {
						error("Ingrese APELLIDOS correcto", textDescripcion);
					}
				
			else	
				error("Ingrese NOMBRES correcto", textEpoca);
		}
	}

	protected void actionPerformedBtnConsulta(ActionEvent arg0) {
		
	}
	
	void mensaje(String s){
		JOptionPane.showMessageDialog(this, s,"Informacion",0);
	}
	
	void error(String s, JTextField txt){
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	void editarFila(){
		if(Us.tamaño() ==0)
			limpieza();
		else{
			int Estado;
			Genero x = Us.obtener(table.getSelectedRow());
			if(x.getestado()==false)
				Estado=0;
				else
				Estado=1;
			textID.setText("GEN00" + x.getidGenero());
			textDescripcion.setText(x.getdescripcion());
			textEpoca.setText("" + x.getepoca());
			cboEstado.setSelectedIndex(Estado);
		}
	}
	
	void limpieza(){
		textID.setText(""+ Us.codigoCorrelativo());
		textDescripcion.setText("");
		textEpoca.setText("");
	}
	
	void listar(){
		int posFila = 0;
		if (tabla.getRowCount()>0)
			posFila = table.getSelectedRow();
		if (tabla.getRowCount() == Us.tamaño() -1)
			posFila = Us.tamaño() -1;
		if (posFila == Us.tamaño())
			posFila --;
		tabla.setRowCount(0);
		Genero U;
		for(int i=0; i<Us.tamaño(); i++){
			U= Us.obtener(i);
			int Estado;
			if(U.getestado()==false)
			Estado=0;
			else
			Estado=1;
		 Object[] fila = { "GEN00"+U.getidGenero(),
		 			U.getdescripcion(),
		 			U.getepoca(),
		 			Lib.estado[Estado]
		 			 };
         tabla.addRow(fila);
         }
		if (Us.tamaño() > 0)
			table.getSelectionModel().setSelectionInterval(posFila, posFila);
		
	   }
	
	void HabilitarEntradas(boolean sino){
		textID.setEditable(sino);
		textDescripcion.setEditable(sino);
		textEpoca.setEditable(sino);
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
				mouseClickedTblTabla(arg0);
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
				mouseEnteredTblTabla(arg0);
			}
		}
		public void mouseExited(MouseEvent arg0) {
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
		protected void mouseClickedTblTabla(MouseEvent arg0) {
			HabilitarEntradas(false);
			HabilitarBotones(true);
			editarFila();
		}
		
		protected void mouseEnteredTblTabla(MouseEvent arg0) {
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

	//Lectura de datos metodos
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}	
		
	int leerID(){
		return Integer.parseInt(textID.getText().substring(3));
	}
	
	int leerEpoca(){
		return Integer.parseInt(textEpoca.getText());
	}
	
	String leerDescripcion(){
		return textDescripcion.getText().trim();
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
	
}