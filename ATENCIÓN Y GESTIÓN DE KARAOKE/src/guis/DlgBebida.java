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
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import clases.*;
import libreria.Lib;
import arreglos.ArregloBebidas;

public class DlgBebida extends JDialog implements ActionListener, KeyListener, MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textID;
	private JTextField textMarca;
	private JTextField textPrecio;
	private JTable table;
	private DefaultTableModel tabla;
	private JScrollPane scrollPane;
	
	private JButton btnAceptar;
	private JButton btnIngreso;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnConsultar;
	private JComboBox <String>cboEstado;
	private JComboBox <String>cboTipoBebida;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgBebida dialog = new DlgBebida();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgBebida() {
		setBounds(100, 100, 745, 473);
		getContentPane().setLayout(null);
		{
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 11, 60, 14);
			getContentPane().add(lblNombre);
		}
		{
			JLabel lblIdBebida = new JLabel("ID Bebida:");
			lblIdBebida.setBounds(10, 36, 81, 14);
			getContentPane().add(lblIdBebida);
		}
		{
			JLabel lblNewLabel = new JLabel("Tipo Bebida:");
			lblNewLabel.setBounds(10, 61, 81, 14);
			getContentPane().add(lblNewLabel);
		}
		{
			JLabel lblMarca = new JLabel("Marca:");
			lblMarca.setBounds(10, 86, 46, 14);
			getContentPane().add(lblMarca);
		}
		{
			JLabel lblPrecio = new JLabel("Precio:");
			lblPrecio.setBounds(10, 111, 60, 14);
			getContentPane().add(lblPrecio);
		}
		{
			JLabel lblEstado = new JLabel("Estado:");
			lblEstado.setBounds(10, 136, 60, 14);
			getContentPane().add(lblEstado);
		}
		{
			textNombre = new JTextField();
			textNombre.setBounds(80, 8, 201, 20);
			getContentPane().add(textNombre);
			textNombre.setColumns(10);
		}
		{
			textID = new JTextField();
			textID.setEditable(false);
			textID.setBounds(80, 33, 86, 20);
			getContentPane().add(textID);
			textID.setColumns(10);
		}
		{
			cboTipoBebida = new JComboBox<String>();
			cboTipoBebida.setModel(new DefaultComboBoxModel<String>(Lib.tipobebida));
			cboTipoBebida.setBounds(80, 58, 116, 20);
			getContentPane().add(cboTipoBebida);
		}
		{
			textMarca = new JTextField();
			textMarca.setBounds(80, 83, 167, 20);
			getContentPane().add(textMarca);
			textMarca.setColumns(10);
		}
		{
			textPrecio = new JTextField();
			textPrecio.setEditable(false);
			textPrecio.setBounds(80, 108, 86, 20);
			getContentPane().add(textPrecio);
			textPrecio.setColumns(10);
		}
		{
			cboEstado = new JComboBox<String>();
			cboEstado.setModel(new DefaultComboBoxModel<String>(Lib.estado));
			cboEstado.setBounds(80, 136, 86, 20);
			getContentPane().add(cboEstado);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.addMouseListener(this);
			btnAceptar.setBounds(291, 7, 89, 23);
			getContentPane().add(btnAceptar);
		}
		{
			btnIngreso = new JButton("Ingreso");
			btnIngreso.addActionListener(this);
			btnIngreso.addMouseListener(this);
			btnIngreso.setBounds(630, 7, 89, 23);
			getContentPane().add(btnIngreso);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(this);
			btnModificar.addMouseListener(this);
			btnModificar.setBounds(630, 36, 89, 23);
			getContentPane().add(btnModificar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(this);
			btnEliminar.addMouseListener(this);
			btnEliminar.setBounds(630, 77, 89, 23);
			getContentPane().add(btnEliminar);
		}
		
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 164, 709, 259);
			getContentPane().add(scrollPane);
			{
				table = new JTable();
				table.addKeyListener(this);
				table.addMouseListener(this);
				
				table.setFillsViewportHeight(false);
				scrollPane.setViewportView(table);
				tabla = new DefaultTableModel();
				tabla.addColumn("ID");
				tabla.addColumn("Nombre");
				tabla.addColumn("Tipo");
				tabla.addColumn("Marca");
				tabla.addColumn("Precio");
				tabla.addColumn("Estado");
				table.setModel(tabla);
				
				tabla.setRowCount(0);
			}
		}
		{
			ImageIcon imagen = new ImageIcon("Media\\Bebidas.jpg");
			JLabel lblImagen = new JLabel(imagen);
			lblImagen.setSize(190,150);
			lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
			Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth()-30,lblImagen.getHeight()-30,Image.SCALE_AREA_AVERAGING));
			lblImagen.setIcon(icono);
			lblImagen.setBounds(433, 11, 147, 120);
			getContentPane().add(lblImagen);
		}
		
		ajustarAnchoColumnas();
		listar();
		editarFila();
		HabilitarEntradas(false);
	}
	
	     ArregloBebidas Us = new ArregloBebidas(0);
	
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
    	boolean estado = leerEstado();
        int id = leerID(), tipo = leerTipo();   
        String nombre = leerNombre();
        if (nombre.length() > 0){
        	String marca = leerMarca();
           if(marca.length() >0)
        	   try{ double precio = leerPrecio();
        	   if (btnIngreso.isEnabled() == false){
					Us.adicionar(new Bebida(id, tipo, nombre, precio, marca, estado));
					btnIngreso.setEnabled(true);
				}
        	   if (btnModificar.isEnabled() == false) {
					Bebida m = Us.buscar(id);
					m.setIdBebida(id);
					m.setTipoBebida(tipo);
					m.setNombre(nombre);
					m.setPrecio(precio);
					m.setMarca(marca);
					m.setEstado(estado);
					Us.actualizarArchivo();
					btnModificar.setEnabled(true);
				}
				listar();
				HabilitarEntradas(false);      	   
        }
           catch (Exception e) {
				error("Ingrese APELLIDOS correcto", textPrecio);
			}
           else 
        	   error("Ingrese APELLIDOS correcto", textNombre);
       }
    }

    protected void actionPerformedBtnConsultar(ActionEvent arg0) {
     
    }

    void mensaje(String s) {
        JOptionPane.showMessageDialog(this, s, "Información", JOptionPane.INFORMATION_MESSAGE);
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
			Bebida x = Us.obtener(table.getSelectedRow());
			textID.setText("BEB00" + x.getidBebida());
			textNombre.setText(x.getNombre());
			textMarca.setText("" + x.getMarca());
			textPrecio.setText("" + x.getPrecio());
			cboEstado.setSelectedItem(x.getEstado());
		}
	}
	
	void limpieza(){
		textID.setText(""+ Us.codigoCorrelativo());
		textNombre.setText("");
		textMarca.setText("");
		textPrecio.setText("");
		cboEstado.setSelectedIndex(1);
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
		Bebida U;
		for(int i=0; i<Us.tamaño(); i++){
			U= Us.obtener(i);
			int Estado;
			if(U.getEstado()==false)
			Estado=0;
			else
			Estado=1;
		 Object[] fila = { "BEB00"+U.getidBebida(),
		 			U.getNombre(),
		 			U.getTipoBebida(),
		 			U.getMarca(),
		 			U.getPrecio(),
		 			Lib.estado[Estado]
		 			 };
         tabla.addRow(fila);
         }
		if (Us.tamaño() > 0)
			table.getSelectionModel().setSelectionInterval(posFila, posFila);
	   }
	
	void HabilitarEntradas(boolean sino){
		textID.setEditable(sino);
		textNombre.setEditable(sino);
		textMarca.setEditable(sino);
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
			mouseEnteredTblTablaB(arg0);
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
	
	protected void mouseEnteredTblTablaB(MouseEvent arg0) {
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
	
    int leerID(){
		return Integer.parseInt(textID.getText().substring(3));
	}
    
    int leerTipo() {
		return cboTipoBebida.getSelectedIndex();
	}
    
    String leerNombre() {
        return textNombre.getText().trim();
    }
    
    String leerMarca() {
        return textMarca.getText().trim();
    }
    
    boolean leerEstado() {
		return getBoolean(cboEstado.getSelectedIndex());
	}
    
    double leerPrecio() {
        return  Double.parseDouble(textPrecio.getText().trim());
    }
    
    private boolean getBoolean(int i) {
		if(i==0)
		return false;
		else
			return true;
	}

}
