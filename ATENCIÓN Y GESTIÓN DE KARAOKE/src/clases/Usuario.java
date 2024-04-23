package clases;

public class Usuario {
	private int idUsuario;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombres;
	private int tipoEmpleado;
	private String login;
	private String password;
	private int turno;
	
	public Usuario(int idUsuario, String apellidoPaterno, String apellidoMaterno,  String nombres, 
			int tipoEmpleado, String login, String password, int turno) {
		
		this.idUsuario = idUsuario;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombres = nombres;
		this.tipoEmpleado = tipoEmpleado;
		this.login = login;
		this.password = password;
		this.turno = turno;
	}
	//metodos get/set
	public void setidUsuario(int idUsuario) {
		this.idUsuario =  idUsuario;
	}
	public void setapellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public void setapellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public void setnombres(String nombres) {
		this.nombres = nombres;
	}
	public void settipoEmpleado(int tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}
	public void setlogin(String login) {
		this.login = login;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public void setturno(int turno) {
		this.turno = turno;
	}
	
	public int getidUsuario() {
		return idUsuario;
	}
	public String getapellidoPaterno() {
		return apellidoPaterno;
	}
	public String getapellidoMaterno() {
		return apellidoMaterno;
	}
	public String getnombres() {
		return nombres;
	}
	public int gettipoEmpleado() {
		return tipoEmpleado;
	}
	public String getlogin() {
		return login;
	}
	public String getpassword() {
		return password;
	}
	public int getturno() {
		return turno;
	}
}