package guis;

import arreglos.ArregloUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.JPasswordField;


public class LoginAS extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textLogin;
	private JButton btnInicio;
	public static int ven;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginAS dialog = new LoginAS();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginAS() {
		
		setTitle("Solo ADMINISTRADORES ");
		
		if(LoginAS.ven==7)
			setTitle("Solo ADMINISTRADORES Y SUPERVISORES" );
		
		setBounds(100, 100, 310, 146);
		getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(10, 11, 65, 14);
		getContentPane().add(lblLogin);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(10, 36, 96, 14);
		getContentPane().add(lblContrasea);
		
		textLogin = new JTextField();
		textLogin.setBounds(116, 8, 154, 20);
		getContentPane().add(textLogin);
		textLogin.setColumns(10);
		
		btnInicio = new JButton("Iniciar Sesion");
		btnInicio.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent arg0){
				char[] Clave = textPass.getPassword();
				String C = new String(Clave);
				String L = textLogin.getText().trim();
				if( buscarLogin(C,L)==true){
					dispose();
				JOptionPane.showMessageDialog(null,"Bienvenido " + Nombre, 
						"INICIO DE SESION EXITOSA",
						JOptionPane.INFORMATION_MESSAGE);
				mostrarventana(LoginAS.ven);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Login o Contraseña INCORRECTA",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					textLogin.setText("");
					textPass.setText("");
					textLogin.requestFocus();
					
				}
			}
		}	
				);
		
		btnInicio.setBounds(56, 61, 187, 32);
		getContentPane().add(btnInicio);
		
		textPass = new JPasswordField();
		textPass.setBounds(116, 33, 154, 20);
		getContentPane().add(textPass);
	}
	
	//variables globales
	
		ArregloUsuario Usi = new ArregloUsuario();
		String Nombre="";
		private JPasswordField textPass;
		
		//metodos
		boolean buscarLogin(String Login, String Clave){
			for (int i=0;i<Usi.tamanio();i++){
				
				if(Usi.obtener(i).getlogin().equals(Login) 
				&& Usi.obtener(i).getpassword().equals(Clave)
				&& ((Usi.obtener(i).gettipoEmpleado()==0)||
						((Usi.obtener(i).gettipoEmpleado()==1)&&LoginAS.ven==7))){
					Nombre = Usi.obtener(i).getnombres().trim();
					return true;}
					}
			return false;
		}
	
	void mostrarventana(int ventana){
		switch(ventana){
		case 0 : {
		DlgUsuario Du = new DlgUsuario();
		Du.setLocationRelativeTo(this);
		Du.setVisible(true);
		}break;
		case 1 : {
		DlgCliente Dc = new DlgCliente();
		Dc.setLocationRelativeTo(this);
		Dc.setVisible(true);	
		}break;
		case 2 : {
		DlgGenero Dg = new DlgGenero();
		Dg.setLocationRelativeTo(this);
		Dg.setVisible(true);	
		}break;
		case 3 : {
		DlgArtista Da = new DlgArtista();
		Da.setLocationRelativeTo(this);
		Da.setVisible(true);	
		}break;
		case 4 : {
		DlgCancion Dc = new DlgCancion();
		Dc.setLocationRelativeTo(this);
		Dc.setVisible(true);	
		}break;	
		case 5 : {
		DlgBebida b = new DlgBebida();
		b.setLocationRelativeTo(this);
		b.setVisible(true);
		}break;	
		case 6 : {
		DlgPiqueo p = new DlgPiqueo();
		p.setLocationRelativeTo(this);
		p.setVisible(true);
		}break;	
		// admin y supervisor
		case 7 : {
		DlgRegistrosC Rc = new DlgRegistrosC();
		Rc.setLocationRelativeTo(this);
		Rc.setVisible(true);
		}break;	
		// solo admin
		case 8 : {
		DlgUsuarios_con_mas_Clientes UC = new DlgUsuarios_con_mas_Clientes();
		UC.setLocationRelativeTo(this);
		UC.setVisible(true);
		}break;	
		case 9 : {
		DlgConsumos_Registrados CR = new DlgConsumos_Registrados();
		CR.setLocationRelativeTo(this);
		CR.setVisible(true);
		}break;	
		
		default : break;
		}
	}	
}
