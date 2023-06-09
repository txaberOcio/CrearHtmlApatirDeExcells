package clases;

public class Reactivos {
String nombre,codigo,cas;
//consulta.java
public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

public String getCas() {
	return cas;
}

public void setCas(String cas) {
	this.cas = cas;
}

public Reactivos(String nombre2, String codigo2, String cas2) {
	super();
	this.nombre = nombre;
	this.codigo = codigo;
	this.cas = cas;
}

public Reactivos() {
	super();

}

}
