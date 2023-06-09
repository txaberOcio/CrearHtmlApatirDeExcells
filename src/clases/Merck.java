package clases;

import java.util.ArrayList;

public class Merck {
	String tituloGeneral;
	String descGeneral;
	ArrayList<MerckClass> lista=new ArrayList<MerckClass>();
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
	public ArrayList<MerckClass> getLista() {
		return lista;
	}
	public void setLista(ArrayList<MerckClass> lista) {
		this.lista = lista;
	}
	public Merck() {
		super();
	}

	
	
}
