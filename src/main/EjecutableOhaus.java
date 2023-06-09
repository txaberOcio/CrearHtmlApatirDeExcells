package main;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import clases.RegistroOhaus;

public class EjecutableOhaus {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// recoger excel y cagarlo en un array
		FileWriter fichero = null;
		PrintWriter pw = null;
		String ruta="C:\\ohaus.xls";
		LinkedList<RegistroOhaus> listaRegistros = new LinkedList<RegistroOhaus>();
		LinkedList<RegistroOhaus> listaRegistrosDefinitiva = new LinkedList<RegistroOhaus>();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(ruta);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet hoja = wb.getSheetAt(0);
			Iterator rows = hoja.rowIterator();
			
			int x = 0;
			int u = 0;
			int r = 0;
			String DescriLarga="";
			String DescriLarga1="";
			String DescriLarga2="";
			String txt;
			String[] lista;
			while (rows.hasNext()) {
				LinkedList<RegistroOhaus> vacio = new LinkedList<RegistroOhaus>();
				HSSFRow row = (HSSFRow) rows.next();
				RegistroOhaus reg = new RegistroOhaus();
				
					try {
					txt=row.getCell(0).getStringCellValue();
					lista=txt.split("a");
					System.out.println(lista[1]);
					reg.setCodigo(lista[1]);
					}catch(Exception e) {
						reg.setCodigo("0");
						e.printStackTrace();
					}
					try {
					reg.setModelo(row.getCell(1).getNumericCellValue());
					}catch(Exception e) {
						reg.setModelo(0);
					}
					try {
						reg.setFamilia(row.getCell(2).getStringCellValue());
						}catch(Exception e) {
							
						}
					try {
					reg.getListaDetalle().add(row.getCell(3).getStringCellValue());
					}catch(Exception e) {
						reg.getListaDetalle().add("");
					}
					try {
					reg.getListaDetalle().add(row.getCell(4).getStringCellValue());
					}catch(Exception e) {
						reg.getListaDetalle().add("");
					}
					try {
					reg.setEnlace(row.getCell(5).getStringCellValue());
					}catch(Exception e) {
						
						reg.setEnlace("");
					}
					try {
					DescriLarga=(row.getCell(6).getStringCellValue());
					}catch(Exception e) {
					
						DescriLarga="";
					}
					try {
						DescriLarga1=(row.getCell(7).getStringCellValue()+"<br/>");
					}catch(Exception e) {
						
						DescriLarga1="";
					}					
					try {
					DescriLarga2=(row.getCell(8).getStringCellValue());
							}catch(Exception e) {
						
								DescriLarga2="";
							}
					
					reg.setDescripcionLarga(DescriLarga+DescriLarga1+DescriLarga2);
					System.out.println("----------");
				System.out.println("codigo:"+reg.getCodigo());
				System.out.println("modelo:"+reg.getModelo());
				System.out.println("familia:"+reg.getFamilia());
				System.out.println("descrilarga:"+reg.getDescripcionLarga());
				System.out.println("foto:"+reg.getEnlace());
				System.out.println("modelo:"+reg.getModelo());
				System.out.println("detalle 1:"+reg.getListaDetalle().get(0));
				System.out.println("detalle2:"+reg.getListaDetalle().get(1));

				System.out.println("////////////////");
				listaRegistros.add(reg);
				
				x++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {

			try {
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}listaRegistrosDefinitiva=listaRegistros;
	
		/*// ordenar cada registo con sus sub subproductos

		for (int e = 0; e < listaRegistros.size(); e++) {
			if (e == 0) {
				listaRegistrosDefinitiva.add(listaRegistros.get(e));
			}else {
			int existe = 0;
			for (int o = 0; o < listaRegistrosDefinitiva.size(); o++) {
				if (listaRegistros.get(e).getGrupo() == listaRegistrosDefinitiva.get(o).getGrupo()) {
					existe = 1;
					listaRegistrosDefinitiva.get(o).getListaObj().add(listaRegistros.get(e));
					break;
				}
			}
			if (existe == 0) {
				listaRegistrosDefinitiva.add(listaRegistros.get(e));
				listaRegistrosDefinitiva.get(listaRegistrosDefinitiva.size() -1).getListaObj().add(listaRegistros.get(e));
			}
			}
		}*/
		System.out.println(listaRegistrosDefinitiva.size());
			for (int i = 0; i < listaRegistrosDefinitiva.size(); i++) {
			try {
				fichero = new FileWriter("C:\\htmlsCreados\\archivo" + i + ".jsp");
				pw = new PrintWriter(fichero);
				pw.println("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\r\n" + 
						"	pageEncoding=\"UTF-8\" errorPage=\"error.jsp\"\r\n" + 
						"	import=\"java.lang.Float\" import=\"java.text.DecimalFormat\"\r\n" + 
						"	import=\"admin.ParametrosUsuario\" import=\"clases.EstadoAlmacen\"\r\n" + 
						"	import=\"clases.GestionaEmpresas\" import=\"clases.Login\"\r\n" + 
						"	import=\"clases.Imagenes\" import=\"clases.Sesion\"\r\n" + 
						"	import=\"excel.CuentaEspecial\" import=\"excel.LecturaPrecios\"\r\n" + 
						"	import=\"admin.RutasImagenes\" import=\"java.util.LinkedList\"\r\n" + 
						"	import=\"index.*\" import=\"admin.Index\" import=\"buscador.BuscarPrecio\"%>\r\n " + 
						"\r\n" + 
						"<!DOCTYPE HTML>\r\n" + 
						"<html>\r\n" + 
						"\r\n" + 
						"<head>\r\n" + 
						"\r\n" + 
						"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n" + 
						"<!--boostrap-->\r\n" + 
						"<link rel=\"stylesheet\"\r\n" + 
						"	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n" + 
						"	integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n" + 
						"	crossorigin=\"anonymous\">\r\n" + 
						"<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"\r\n" + 
						"	integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\r\n" + 
						"	crossorigin=\"anonymous\"></script>\r\n" + 
						"<script\r\n" + 
						"	src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"\r\n" + 
						"	integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\"\r\n" + 
						"	crossorigin=\"anonymous\"></script>\r\n" + 
						"<script\r\n" + 
						"	src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"\r\n" + 
						"	integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\"\r\n" + 
						"	crossorigin=\"anonymous\"></script>\r\n" + 
						"<!--mi css-->\r\n" + 
						"<script\r\n" + 
						"	src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>\r\n" + 
						"<script\r\n" + 
						"	src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.0/jquery.cookie.min.js\"></script>\r\n" + 
						"<script\r\n" + 
						"	src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js\"></script>\r\n" + 
						"<script src=\"/es/js/cookies.js\"></script>\r\n" + 
						"<script type=\"text/javascript\" charset=\"utf-8\" src=\"/es/js/rotador.js\"></script>\r\n" + 
						"<script type=\"text/javascript\" src=\"../../../es/js/codigo.js\"></script>\r\n" + 
						"<script type=\"text/javascript\" src=\"../../../es/js/submit.js\"></script>\r\n" + 
						"<script type=\"text/javascript\" src=\"../../../es/js/ajustaAlturas.js\"></script>\r\n" + 
						"<script type=\"text/javascript\" src=\"../../../es/js/pruebasMenu.js\"></script>\r\n" + 
						"<script src=\"../../../es/Source/jquery.tinycarousel.js\"></script>\r\n" + 
						"<script type=\"text/javascript\" src=\"../../../es/js/carrito.js\"></script>\r\n" +  
						"<link rel=\"stylesheet\" type=\"text/css\" href=\"../../css/estilos.css\">\r\n" + 
						"<script type=\"text/javascript\">\r\n" + 
						"	function clickInicio() {\r\n" + 
						"		temp = \"\";\r\n" + 
						"		if (document.getElementById(\"fs1\").style.display == \"none\") {\r\n" + 
						"			temp = \"block\";\r\n" + 
						"		}\r\n" + 
						"		if (document.getElementById(\"fs1\").style.display == \"block\") {\r\n" + 
						"			temp = \"none\";\r\n" + 
						"		}\r\n" + 
						"		document.getElementById(\"fs1\").style.display = temp;\r\n" + 
						"	}\r\n" + 
						"	\r\n" + 
						"</script>\r\n" + 
						"<script type=\"text/javascript\">\r\n" + 
						"	function muestraAyuda() {\r\n" + 
						"		document.getElementById(\"ayudaBuscador\").style.visibility = \"visible\";\r\n" + 
						"	}\r\n" + 
						"	function ocultaAyuda() {\r\n" + 
						"		document.getElementById(\"ayudaBuscador\").style.visibility = \"hidden\";\r\n" + 
						"	}\r\n" + 
						"</script>\r\n" + 
						"<title>Proquinorte</title>\r\n" + 
						"</head>\r\n" + 
						"\r\n" + 
						"<body>\r\n" + 
						"		<div class=\"container\">" + 
						"	<div class=\"row\">" + 
						"			<div id=\"panel\" style=\"margin: 0; padding: 0; zindex: 4;\"><%@ include\r\n" + 
						"					file=\"..\\..\\cabecera.jsp\"%></div>\r\n" + 
						"		</div>\r\n" + 
						"	</div>\r\n" + 
						"   <div class=\"container\">" + 
						"	<div class=\"row\"id=\"linea\">" + 
						"<div class=\"col-xs-0 col-sm-0 col-md-0 col-lg-1 col-xl-1\"></div>"+
						"				<div class=\"col-xs-12 col-sm-12 col-md-4 col-lg-3 col-xl-3\" id=\"foto\"><img class='foto' src='");
				pw.println(listaRegistrosDefinitiva.get(i).getEnlace().trim());
				pw.println("'></div>" + 
						"				<div class=\"col-xs-12 col-sm-12 col-md-8 col-lg-7 col-xl-6\" id=\"descripcion\">");
				pw.println(listaRegistrosDefinitiva.get(i).getDescripcionLarga());
				pw.println("</div>\r\n" + 
						"<div class=\"col-xs-0 col-sm-0 col-md-0 col-lg-1 col-xl-2\"></div>"+
						"		</div>\r\n" + 
						"	</div>\r\n" + 
						"		<div class=\"container\">\r\n" + 
						"	<div class=\"row\" id=\"linea\">" + 
						"			<div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12\"\r\n" + 
						"				id=\"tabla\">");
		pw.println("<table><tr><th class='th1'> Codigo</th><th class='th2'>Caracteristicas</th><th class='th2'>Detalle</th><th class='th3'>Precio</th></tr>");
		pw.println("<% String obj=\"\";%>");
		try {
					
							RegistroOhaus obj=new RegistroOhaus();
							obj=listaRegistrosDefinitiva.get(i);
							
						System.out.println(obj.getCodigo());
						pw.println(" <%  obj=\""+obj.getCodigo()+"\"; %><tr><td class='codigo'>"+obj.getCodigo() +"</td><td class='descripcion'>"+obj.getListaDetalle().get(0) +"</td><td class='descripcion'>"+obj.getListaDetalle().get(1) +"</td><td class='precio'><%= BuscarPrecio.BuscarPrecio(obj) %></td><td class='comprar'>"+
								
								"<form name='comprar' action='/es/pedido/tramitaPedido.jsp' method='post'>\r\n" + 			
								"<input type='hidden' name='numLineas' value='1'/>" +
								"<input type='hidden' name='linea1' value='OH"+obj.getCodigo()+"'/>" +
								"<input type='number' name='un1' min='1' size='1'class='cantidad' '/>\r\n" + 
								"<input type='image' title='A&ntilde;adir a cesta' src='/es/imagenes/carro/add.png' class='carrito'onclick='document.comprar.submit()' alt='Add'/>\r\n" + 
								"</form></td></tr>");
						
		}catch(Exception e) {}
				pw.println("</table></div>\r\n" + 
						"		</div>\r\n" + 
						"	</div></html>");
				pw.println("		<div class=\"row\">\r\n" + 
						"			<div class=\"container\">\r\n" + 
						
						"				<div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12\">\r\n" + 
						"			<footer>\r\n" + 
						"\r\n" + 
						"					<div id=\"cookie-policy\" class=\"notice hidden\">\r\n" + 
						"						<div class=\"bg\"></div>\r\n" + 
						"						<div class=\"content\">\r\n" + 
						"							<p>\r\n" + 
						"								<a href=\"#\" id=\"dorado\">Informaci&oacuten Legal</a> ||<a\r\n" + 
						"									href=\"#\" id=\"dorado\"> Condiciones Generales</a>\r\n" + 
						"							</p>\r\n" + 
						"\r\n" + 
						"							<p id=\"texto\">www.proquinorte.com - Copyright&copy; 2019 -\r\n" + 
						"								Proquinorte, S.A.</p>\r\n" + 
						"						</div>\r\n" + 
						"					</div>\r\n" + 
						"				</footer>\r\n" + 
						"				</div>\r\n" + 
						"			</div>\r\n" + 
						"		</div>");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					// Nuevamente aprovechamos el finally para
					// asegurarnos que se cierra el fichero.
					if (null != fichero)
						
						fichero.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			}
		
	}

}
