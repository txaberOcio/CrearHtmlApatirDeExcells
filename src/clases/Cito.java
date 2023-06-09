package clases;

import java.util.ArrayList;

public class Cito {
	String tituloGeneral;
	String descGeneral;
	ArrayList<CitoClass> lista=new ArrayList<CitoClass>();
	public String getTituloGeneral() {
		return tituloGeneral;
	}
	public void setTituloGeneral(String tituloGeneral) {
		this.tituloGeneral = tituloGeneral;
	}
	public String getDescGeneral() {
		return descGeneral;
	}
	public void setDescGeneral(String descGeneral) {
		this.descGeneral = descGeneral;
	}
	public ArrayList<CitoClass> getLista() {
		return lista;
	}
	public void setLista(ArrayList<CitoClass> lista) {
		this.lista = lista;
	}
	public Cito() {
		super();
	}

	
	
}
