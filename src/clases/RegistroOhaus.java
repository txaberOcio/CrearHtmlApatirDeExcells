package clases;

import java.util.ArrayList;

public class RegistroOhaus {
	int grupo;
	String familia;
	String codigo;
	double modelo;
	String enlace;
	String descripcionLarga;
	ArrayList<String> ListaDetalle=new ArrayList<String>();
	ArrayList<RegistroOhaus>ListaObj=new ArrayList<RegistroOhaus>();
	

	public String getFamilia() {
		return familia;
	}
	public void setFamilia(String familia) {
		this.familia = familia;
	}
	public double getModelo() {
		return modelo;
	}
	public void setModelo(double modelo) {
		this.modelo = modelo;
	}
	public ArrayList<RegistroOhaus> getListaObj() {
		return ListaObj;
	}
	public void setListaObj(ArrayList<RegistroOhaus> listaObj) {
		ListaObj = listaObj;
	}
	public String getDescripcionLarga() {
		return descripcionLarga;
	}
	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}
	public int getGrupo() {
		return grupo;
	}
	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	public ArrayList<String> getListaDetalle() {
		return ListaDetalle;
	}
	public void setListaDetalle(ArrayList<String> listaDetalle) {
		ListaDetalle = listaDetalle;
	}
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

	
	public RegistroOhaus() {
		super();
	}
	
	
	
}
