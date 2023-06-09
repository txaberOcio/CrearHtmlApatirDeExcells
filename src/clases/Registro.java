package clases;

public class Registro {

	String codigo;
	String enlace;
	String descripcion;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getEnlace() {
		return enlace;
	}
	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Rregistro [codigo=" + codigo + ", enlace=" + enlace + ", descripcion=" + descripcion + "]";
	}
	public Registro(String codigo, String enlace, String descripcion) {
		super();
		this.codigo = codigo;
		this.enlace = enlace;
		this.descripcion = descripcion;
	}
	public Registro() {
		super();
	}
	
	
}
