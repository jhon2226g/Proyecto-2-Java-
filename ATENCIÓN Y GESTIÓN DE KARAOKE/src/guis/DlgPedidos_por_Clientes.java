package guis;

import java.awt.Cursor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

import arreglos.*;
import clases.*;

import java.awt.Font;
import javax.swing.JTextField;

public class DlgPedidos_por_Clientes extends JDialog implements ActionListener, KeyListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablaPedidos;
	private JTextArea textArea ;
	private JComboBox <String> cboCliente;
	private JButton btnAtender;
	private JButton btnAnular;
	private DefaultTableModel tabla;
	private JTextField textcod;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPedidos_por_Clientes dialog = new DlgPedidos_por_Clientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPedidos_por_Clientes() {
		setTitle("Pedidos por Clientes");
		setBounds(100, 100, 600, 648);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 564, 200);
		getContentPane().add(scrollPane);
		
		tablaPedidos = new JTable();
		tablaPedidos.addKeyListener(this);
		tablaPedidos.addMouseListener(this);
		tablaPedidos.setFillsViewportHeight(false);
		scrollPane.setViewportView(tablaPedidos);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("Cod. de Cliente");
		tabla.addColumn("Nombre y Apellidos");
		tabla.addColumn("Fecha de Pedido");
		tabla.addColumn("Cod. de Usuario");
		tabla.addColumn("Cod. de Pedido");
		tablaPedidos.setModel(tabla);
		
		tablaPedidos.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPedidos.getColumnModel().getColumn(1).setPreferredWidth(244);
		tablaPedidos.getColumnModel().getColumn(2).setPreferredWidth(73);
		tablaPedidos.getColumnModel().getColumn(3).setPreferredWidth(103);
		tablaPedidos.getColumnModel().getColumn(4).setPreferredWidth(104);
		tabla.setRowCount(0);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 288, 302, 310);
		getContentPane().add(scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JLabel lblCodigoDeCliente = new JLabel("Codigo de Cliente:");
		lblCodigoDeCliente.setBounds(10, 30, 105, 14);
		getContentPane().add(lblCodigoDeCliente);
		
		cboCliente = new JComboBox<String>();
		cboCliente.addActionListener(this);
		cboCliente.setModel(new DefaultComboBoxModel<String>(Nombres()));
		cboCliente.setBounds(125, 27, 121, 20);
		getContentPane().add(cboCliente);
		
		btnAtender = new JButton("Atender");
		btnAtender.addActionListener(this);
		btnAtender.setBounds(348, 290, 89, 23);
		getContentPane().add(btnAtender);
		
		btnAnular = new JButton("Anular");
		btnAnular.addActionListener(this);
		btnAnular.setBounds(348, 325, 89, 23);
		getContentPane().add(btnAnular);
		
		JLabel lblDetalleDelPedido = new JLabel("DETALLE DEL PEDIDO");
		lblDetalleDelPedido.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblDetalleDelPedido.setBounds(53, 266, 197, 14);
		getContentPane().add(lblDetalleDelPedido);
		
		textcod = new JTextField();
		textcod.setBounds(275, 27, 105, 20);
		getContentPane().add(textcod);
		textcod.setColumns(10);
		
		textcod.setText("CLI0000");
		listar();
		
	}
	ArregloPedido P = new ArregloPedido();
	ArregloClientes C = new ArregloClientes();
	ArregloCancion Can = new ArregloCancion(0);
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAtender) {
			actionPerformedBtnAtender(arg0);
		}
		if (arg0.getSource() == btnAnular) {
			actionPerformedBtnAnular(arg0);
		}
		if (arg0.getSource() == cboCliente) {
			actionPerformedCboCliente(arg0);
		}
	}
	protected void actionPerformedCboCliente(ActionEvent arg0) {
		textcod.setText("CLI00"+ID[cboCliente.getSelectedIndex()]);
		listar();
	}
	protected void actionPerformedBtnAtender(ActionEvent arg0) {
		int ok=confirmar("esta seguro de atender este pedido?");
		if(ok==0){
			try{
		Object y = tabla.getValueAt(tablaPedidos.getSelectedRow(),0);
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
	protected void actionPerformedBtnAnular(ActionEvent arg0) {	
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
		 
		 if(cboCliente.getSelectedIndex()==0&&U.getEstado()==0)
			 tabla.addRow(fila);
		 else
			if(leerCod()==U.getIdCliente()&&U.getEstado()==0)
				tabla.addRow(fila);
		}
	}
	String[] Nombres(){
		String[] s = new String[P.tamaño()+1];
		s[0]="Todos";
		ID[0]= 0000;
		for(int i=1;i<P.tamaño()+1;i++){
			int id = P.obtener(i-1).getIdCliente();
			ID[i]=id;
			s[i] = C.buscar(id).getnombres();
		}
		return s;
	}
	int[] ID = new int[P.tamaño()+1];
	
	int leerCod() {
		return Integer.parseInt(textcod.getText().substring(3));
	}
	//mouse acciones
	
			public void keyPressed(KeyEvent arg0) {
			}
			public void keyReleased(KeyEvent arg0) {
					
			}
			public void keyTyped(KeyEvent arg0) {
			}
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getSource() == tablaPedidos) {
					mouseClickedTblTabla(arg0);
				}
			}
			
			public void mouseEntered(MouseEvent arg0) {
				
				if (arg0.getSource() == btnAnular) {
					mouseEnteredBtnModificar(arg0);
				}
				if (arg0.getSource() == btnAtender) {
					mouseEnteredBtnAdicionar(arg0);
				}
				if (arg0.getSource() == tablaPedidos) {
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
				imprimir();
			}
			
			protected void mouseEnteredTblTabla(MouseEvent arg0) {
				tablaPedidos.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			protected void mouseEnteredBtnAdicionar(MouseEvent arg0) {
				btnAtender.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			protected void mouseEnteredBtnModificar(MouseEvent arg0) {
				btnAnular.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
}
