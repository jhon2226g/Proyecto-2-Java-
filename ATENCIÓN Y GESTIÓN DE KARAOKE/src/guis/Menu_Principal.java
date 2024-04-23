package guis;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Menu_Principal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem mntmSalir;
	private JMenuItem mntmUsuario;
	private JMenuItem mntmCliente;
	private JMenuItem mntmGenero;
	private JMenuItem mntmArtista;
	private JMenuItem mntmCancion;
	private JMenuItem mntmBebida;
	private JMenuItem mntmPiqueo;
	private JMenuItem mntmRegistroP;
	private JMenuItem mntmRegistrosC;
	private JMenuItem mntmCanciones;
	private JMenuItem mntmPedidosCli;
	private JMenuItem mntmPedidosFecha;
	private JMenuItem mntmUsuarios;
	private JMenuItem mntmConsumosRegistrados;
	private JLabel lblFondo;
	private JLabel lblNewLabel;
	public JMenu mnMantenimiento;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Principal frame = new Menu_Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu_Principal() {
		setResizable(false);
		setTitle(" ATENCI\u00D3N Y GESTI\u00D3N DE KARAOKE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 632);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnVentana = new JMenu("Ventana");
		menuBar.add(mnVentana);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setSelected(true);
		mnVentana.add(mntmSalir);
		
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.addActionListener(this);
		menuBar.add(mnMantenimiento);
		
		mntmUsuario = new JMenuItem("Usuario");
		mntmUsuario.addActionListener(this);
		mnMantenimiento.add(mntmUsuario);
		
		mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(this);
		mnMantenimiento.add(mntmCliente);
		
		mntmGenero = new JMenuItem("Genero");
		mntmGenero.addActionListener(this);
		mnMantenimiento.add(mntmGenero);
		
		mntmArtista = new JMenuItem("Artista");
		mntmArtista.addActionListener(this);
		mnMantenimiento.add(mntmArtista);
		
		mntmCancion = new JMenuItem("Cancion");
		mntmCancion.addActionListener(this);
		mnMantenimiento.add(mntmCancion);
		
		mntmBebida = new JMenuItem("Bebida");
		mntmBebida.addActionListener(this);
		mnMantenimiento.add(mntmBebida);
		
		mntmPiqueo = new JMenuItem("Piqueo");
		mntmPiqueo.addActionListener(this);
		mnMantenimiento.add(mntmPiqueo);
		
		JMenu mnRegistroP = new JMenu("Registro De Pedidos");
		menuBar.add(mnRegistroP);
		
		mntmRegistroP = new JMenuItem("Registros P");
		mntmRegistroP.addActionListener(this);
		mnRegistroP.add(mntmRegistroP);
		
		JMenu mnRegistroC = new JMenu("Registro De Consumo");
		menuBar.add(mnRegistroC);
		
		mntmRegistrosC = new JMenuItem("Registros C");
		mntmRegistrosC.addActionListener(this);
		mnRegistroC.add(mntmRegistrosC);
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
		
		mntmCanciones = new JMenuItem("Canciones mas Pedidas");
		mntmCanciones.addActionListener(this);
		mnConsultas.add(mntmCanciones);
		
		mntmPedidosCli = new JMenuItem("Pedidos Por Cliente");
		mntmPedidosCli.addActionListener(this);
		mnConsultas.add(mntmPedidosCli);
		
		mntmPedidosFecha = new JMenuItem("Pedidos Por Rango De Fechas");
		mntmPedidosFecha.addActionListener(this);
		mnConsultas.add(mntmPedidosFecha);
		
		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		mntmUsuarios = new JMenuItem("Usuarios que han atendido mas pedidos");
		mntmUsuarios.addActionListener(this);
		mnReportes.add(mntmUsuarios);
		
		mntmConsumosRegistrados = new JMenuItem("Consumos Registrados");
		mntmConsumosRegistrados.addActionListener(this);
		mnReportes.add(mntmConsumosRegistrados);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ImageIcon imagen = new ImageIcon("Media/Karaoke.jpg");
		lblFondo = new JLabel(imagen);
		lblFondo.setSize(900,600);
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(lblFondo.getWidth(),lblFondo.getHeight(),Image.SCALE_DEFAULT));
		lblFondo.setIcon(icono);
		getContentPane().add(lblFondo);
		
		lblNewLabel = new JLabel("");
		contentPane.add(lblNewLabel, BorderLayout.EAST);
		
		lblNewLabel_1 = new JLabel("AUTORES: Cristopher, Diana, Stalyn, Jhonatan,Sergio.");
		contentPane.add(lblNewLabel_1, BorderLayout.SOUTH);
	}
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
		if (e.getSource() == mntmUsuario) {
			actionPerformedMntmUsuario(e);
		}
		if (e.getSource() == mntmCliente) {
			actionPerformedMntmCliente(e);
		}
		if (e.getSource() == mntmGenero) {
			actionPerformedMntmGenero(e);
		}
		if (e.getSource() == mntmArtista) {
			actionPerformedMntmArtista(e);
		}
		if (e.getSource() == mntmCancion) {
			actionPerformedMntmCancion(e);
		}	
		if (e.getSource() == mntmBebida) {
			actionPerformedMntmBebida(e);
		}
		if (e.getSource() == mntmPiqueo) {
			actionPerformedMntmPiqueo(e);
		}
		if (e.getSource() == mntmRegistroP) {
			actionPerformedMntmRegistroP(e);
		}
		if (e.getSource() == mntmRegistrosC) {
			actionPerformedMntmRegistrosC(e);
		}
		if (e.getSource() == mntmCanciones) {
			actionPerformedMntmCanciones(e);
		}
		if (e.getSource() == mntmPedidosCli) {
			actionPerformedMntmPedidosCli(e);
		}
		if (e.getSource() == mntmPedidosFecha) {
			actionPerformedMntmPedidosFecha(e);
		}
		if (e.getSource() == mntmUsuarios) {
			actionPerformedMntmUsuarios(e);
		}
		if (e.getSource() == mntmConsumosRegistrados) {
			actionPerformedMntmConsumosRegistrados(e);
		}
	}
	
	
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		System.exit(0);
	}
	protected void actionPerformedMntmUsuario(ActionEvent arg0) {
		LoginAS.ven=0;
		LoginAS l0 = new LoginAS();
		l0.setLocationRelativeTo(this);
		l0.setVisible(true);
		 	
	}
	protected void actionPerformedMntmCliente(ActionEvent arg0) {
		LoginAS.ven=1;
		LoginAS l1 = new LoginAS();
		l1.setLocationRelativeTo(this);
		l1.setVisible(true);
		 	
	}
	protected void actionPerformedMntmGenero(ActionEvent arg0) {
		LoginAS.ven=2;
		LoginAS l2 = new LoginAS();	
		l2.setLocationRelativeTo(this);
		l2.setVisible(true);
	}
	protected void actionPerformedMntmArtista(ActionEvent arg0) {
		LoginAS.ven=3;
		LoginAS l3 = new LoginAS();
		l3.setLocationRelativeTo(this);
		l3.setVisible(true);
	}
	protected void actionPerformedMntmCancion(ActionEvent arg0) {
		LoginAS.ven=4;
		LoginAS l4 = new LoginAS();
		l4.setLocationRelativeTo(this);
		l4.setVisible(true);
	}
	protected void actionPerformedMntmBebida(ActionEvent arg0) {
		LoginAS.ven=5;
		LoginAS l5 = new LoginAS();
		l5.setLocationRelativeTo(this);
		l5.setVisible(true);
	}
	protected void actionPerformedMntmPiqueo(ActionEvent arg0) {
		LoginAS.ven=6;
		LoginAS l6 = new LoginAS();
		l6.setLocationRelativeTo(this);
		l6.setVisible(true);
	}
	protected void actionPerformedMntmRegistroP(ActionEvent arg0) {
		DlgRegistrosP RP = new DlgRegistrosP();
		RP.setLocationRelativeTo(this);
		RP.setVisible(true);
	}
	protected void actionPerformedMntmRegistrosC(ActionEvent arg0) {
		LoginAS.ven=7;
		LoginAS l7 = new LoginAS();
		l7.setLocationRelativeTo(this);
		l7.setVisible(true);
	}
	protected void actionPerformedMntmCanciones(ActionEvent arg0) {
		DlgCanciones_mas_pedidas CP = new DlgCanciones_mas_pedidas();
		CP.setLocationRelativeTo(this);
		CP.setVisible(true);
	}
	protected void actionPerformedMntmPedidosCli(ActionEvent arg0) {
		DlgPedidos_por_Clientes PC = new DlgPedidos_por_Clientes();
		PC.setLocationRelativeTo(this);
		PC.setVisible(true);
	}
	protected void actionPerformedMntmPedidosFecha(ActionEvent arg0) {
		DlgPedidos_por_Fecha PF = new DlgPedidos_por_Fecha();
		PF.setLocationRelativeTo(this);
		PF.setVisible(true);
	}
	protected void actionPerformedMntmUsuarios(ActionEvent arg0) {
		LoginAS.ven=8;
		LoginAS l8 = new LoginAS();
		l8.setLocationRelativeTo(this);
		l8.setVisible(true);
	}
	protected void actionPerformedMntmConsumosRegistrados(ActionEvent arg0) {
		LoginAS.ven=9;
		LoginAS l9 = new LoginAS();
		l9.setLocationRelativeTo(this);
		l9.setVisible(true);
	}
}
