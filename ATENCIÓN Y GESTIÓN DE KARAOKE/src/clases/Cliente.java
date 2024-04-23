package clases;

public class Cliente {
	private int idCliente;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombres;
	private String direccion;
	private String fechaNacimiento;
	private String fechaAfiliacion;
	private int estadoCivil;
	private String telefono;
	private String dni;
	private int tipoDeCliente;
	
	public Cliente(int idCliente, String apellidoPaterno, String apellidoMaterno, String nombres, String direccion,
			String fechaNacimiento, String fechaAfiliacion, int estadoCivil, String telefono, 
			String dni, int tipoDeCliente) {
		this.idCliente =idCliente;
		this.apellidoPaterno=apellidoPaterno;
		this.apellidoMaterno=apellidoMaterno;
		this.nombres=nombres;
		this.direccion=direccion;
		this.fechaNacimiento=fechaNacimiento;
		this.fechaAfiliacion=fechaAfiliacion;
		this.estadoCivil=estadoCivil;
		this.telefono=telefono;
		this.dni=dni;
		this.tipoDeCliente=tipoDeCliente;
	}
	
	public void setidCliente(int idCliente) {
		this.idCliente =idCliente;
	}
	public void setapellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno =apellidoPaterno;
	}
	public void setapellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno =apellidoMaterno;
	}
	public void setnombres(String nombres) {
		this.nombres =nombres;
	}
	public void setdireccion(String direccion) {
		this.direccion =direccion;
	}
	
	public void setfechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento =fechaNacimiento;
	}
	public void setfechaAfiliacion(String fechaAfiliacion) {
		this.fechaAfiliacion =fechaAfiliacion;
	}
	public void setestadoCivil(int estadoCivil) {
		this.estadoCivil =estadoCivil;
	}
	public void settelefono(String telefono) {
		this.telefono =telefono;
	}
	public void setdni(String dni) {
		this.dni =dni;
	}
	public void settipoCliente(int tipoDeCliente) {
		this.tipoDeCliente =tipoDeCliente;
	}
	
	public int getidCliente() {
		return idCliente;
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
	public String getdireccion() {
		return direccion;
	}
	public String getfechaNacimiento() {
		return fechaNacimiento;
	}
	public String getfechaAfiliacion() {
		return fechaAfiliacion;
	}
	
	public int getestadoCivil() {
		return estadoCivil;
	}
	public String gettelefono() {
		return telefono;
	}
	public String getdni() {
		return dni;
	}
	public int gettipoCliente() {
		return tipoDeCliente;
	}
	
}
