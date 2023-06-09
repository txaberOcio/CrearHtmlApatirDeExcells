package clases;

public class MedidoresPH {
String codigo,nombreProducto,descripcion,detalle,marca,tipo,foto;

public String getFoto() {
	return foto;
}

public void setFoto(String foto) {
	this.foto = foto;
}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

public String getNombreProducto() {
	return nombreProducto;
}

public void setNombreProducto(String nombreProducto) {
	this.nombreProducto = nombreProducto;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public String getDetalle() {
	return detalle;
}

public void setDetalle(String detalle) {
	this.detalle = detalle;
}

public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}

public MedidoresPH(String codigo, String nombreProducto, String descripcion, String detalle, String marca,
		String tipo) {
	super();
	this.codigo = codigo;
	this.nombreProducto = nombreProducto;
	this.descripcion = descripcion;
	this.detalle = detalle;
	this.marca = marca;
	this.tipo = tipo;
}

public MedidoresPH() {
	super();
}

	
}
