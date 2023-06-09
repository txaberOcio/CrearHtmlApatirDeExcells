package clases;

public class Microscopios {

	String tituloGrupo,DescGrupo,codigoUnidad,detalle1,detalle2,detalle3,unidades,grupo,Marca;

	
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		
		Marca = marca;
		if(marca==null) {
			Marca="";
		}
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getTituloGrupo() {
		return tituloGrupo;
	}

	public void setTituloGrupo(String tituloGrupo) {
		this.tituloGrupo = tituloGrupo;
	}

	public String getDescGrupo() {
		return DescGrupo;
	}

	public void setDescGrupo(String descGrupo) {
		DescGrupo = descGrupo;
	}

	public String getCodigoUnidad() {
		return codigoUnidad;
	}

	public void setCodigoUnidad(String codigoUnidad) {
		this.codigoUnidad = codigoUnidad;
	}

	public String getDetalle1() {
		return detalle1;
	}

	public void setDetalle1(String detalle1) {
		this.detalle1 = detalle1;
	}

	public String getDetalle2() {
		return detalle2;
	}

	public void setDetalle2(String detalle2) {
		this.detalle2 = detalle2;
	}

	public String getDetalle3() {
		return detalle3;
	}

	public void setDetalle3(String detalle3) {
		this.detalle3 = detalle3;
	}

	public String getUnidades() {
		return unidades;
	}

	public void setUnidades(String unidades) {
		this.unidades = unidades;
	}

	public Microscopios() {
		super();
	}
	
	
}
