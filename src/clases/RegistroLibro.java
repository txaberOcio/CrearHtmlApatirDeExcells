package clases;

import java.util.ArrayList;

public class RegistroLibro {
String titulo;
String contenido;
ArrayList<ClaseLista> listaCeldas=new <ClaseLista>ArrayList();



public RegistroLibro() {
	super();
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getContenido() {
	return contenido;
}
public void setContenido(String contenido) {
	this.contenido = contenido;
}
public ArrayList<ClaseLista> getListaCeldas() {
	return listaCeldas;
}
public void setListaCeldas(ArrayList<ClaseLista> listaCeldas) {
	this.listaCeldas = listaCeldas;
}




}
