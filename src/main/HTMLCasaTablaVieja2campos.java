package main;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import clases.Ohaus4;



public class HTMLCasaTablaVieja2campos {

	public static void main(String[] args) {
	
		String ruta="C:\\casetes1\\termometrosdevarillaAuxilab.xls";
		  ArrayList<Ohaus4> reg= new ArrayList();
		  Ohaus4 obj=new Ohaus4();	
		  FileInputStream fis=null;
		  try {
		   fis=new FileInputStream(ruta);
		   HSSFWorkbook wb=new HSSFWorkbook(fis);
		   HSSFSheet hoja=wb.getSheetAt(0);
		   Iterator rows=hoja.rowIterator();
		   HSSFRow row = (HSSFRow) rows.next();
		   int x=0;
		   int u=0;
		   int cont=0;
		
		   
		  do{
		  
				
			     try{
			    	 obj=new Ohaus4();
			    	 
			    	 try {
			    		 int num=(int) row.getCell(0).getNumericCellValue();
			    		
			    		 obj.setCodigo(String.valueOf(num));
			    		// System.out.println(num);
			    	 }catch(Exception e) {
			    		 try {
			    		 obj.setCodigo(row.getCell(0).getStringCellValue());
			    		// System.out.println(obj.getCodigo());
			    		 }catch(Exception a) { 
			    		 }
			    	 }
			    	 try {
			    		 int num=(int) row.getCell(1).getNumericCellValue();
			    		
			    		 obj.setTitutloGeneral(String.valueOf(num));
			    	 }catch(Exception e) {
			    		 try {
			    		 obj.setTitutloGeneral(row.getCell(1).getStringCellValue());
			    		 }catch(Exception a) { 
			    		 }
			    	 }
			  	 

			      reg.add(obj);
			      cont++;
			      row=(HSSFRow) rows.next();
			     }catch(Exception e) {
			      e.printStackTrace();
			     }
		   cont++;
		    x++;
		   }while(rows.hasNext());
		   
		  }catch(Exception e) {
			e.printStackTrace();
		  }finally {
		  
		   try {
		    fis.close();
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		  }
		//  System.out.println(listafinal.get(2).getContenido());
		

//enlace=nombre codigo=codigo descripcion= peso

System.out.println(reg.size());

	CrearHtml(reg);
	}
	public static void CrearHtml(ArrayList<Ohaus4> reg){
		FileWriter fichero = null;
		PrintWriter pw = null;
		String cod, chapter, subchapter,nombre;
		
			try {
				fichero = new FileWriter("C:\\Users\\PQNSV2\\Desktop\\Agilent.jsp");
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
						"<link rel=\"stylesheet\" type=\"text/css\" href=\"/es/css/estilos.css\">\r\n" + 
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
						"					file=\"/es/cabecera.jsp\"%></div>\r\n" + 
						"			</div>\r\n </div> \r\n");
				//aqui empiezo a mter mis cosas
				
					//titulo
					
					//fin titulo
					//contenido

					//fincontenido
					//tabla
				
pw.println("<div class='container'> <div class='row' id='linea'><div class='col-xs-12 col-sm-12 col-md-8 col-lg-6 col-xl-6'>");
pw.println("<img  class=''height='250px' width='100%' SRC='fotoproducto/auxilabjpg'>");
pw.println("</div><div class='col-xs-12 col-sm-12 col-md-8 col-lg-6 col-xl-6'>");
pw.println("<table><tbody>");
pw.println("<tr class=''><th class='th1'>Codigo</th><th class='th1'>Producto</th><th class='th1'>Precio</th><th class='th1'>Comprar</th></tr>");;

					for(int e=0;e<reg.size();e++){
							if(e%2==0) {
				pw.println("<tr class='inpar'>");}else{pw.println("<tr clasparpar'>");
				}
							pw.println("<td class='produccel'>"+reg.get(e).getCodigo()+"</td>");
							pw.println("<td class='produccel'>"+reg.get(e).getTitutloGeneral()+"</td>");
							
				//Codigo,Largura,Diametro,Unidades,Espesor.Formato,Tubo,Precio,Comprar

							pw.println("<td class='produccel'><div id='divCargar"+e+"' name='divCargar"+e+"'> </div>"+
							"<div id='borrarr"+e+"' class='consultapre' onclick=\"cargarExterno3(`divCargar"+e+"`,'OH"+reg.get(e).getCodigo() +"','borrarr"+e+"')\">Consultar precio</div></td>"+
							"<td class='comprar'><form name='comprar' action='/es/pedido/tramitaPedido.jsp' method='post'>"+
							"<input type='hidden' name='numLineas' value='1'><input type='hidden' name='linea1' value='OH"+reg.get(e).getCodigo()+"'>"+
							"<input type='number' name='un1' min='1' size='1' class='cantidad'>"+
							"<input type='image' title='Añadir a cesta' src='/es/imagenes/carro/add.png' class='carrito' onclick='document.comprar.submit()' alt='Add'>"+
							"</form></td></tr>");
					
						
						}
					pw.println("</tbody></table></div></div></div></div></div></div></div></div>");
						
					
					
					//fin tabla
					
					
					
				//aqui termino
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
						"		</div></body></html>");
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
			
			
	/*
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet hoja = workbook.createSheet();
		int numero=0;
		for(int i=0;i<listaRegistrosDefinitiva.size();i++) {
			for(int u=0;u<listaRegistrosDefinitiva.get(i).getListaObjObjetoMilipore().size();u++) {
				HSSFRow row = hoja.createRow(numero);
				row.createCell(0);
				row.createCell(1);
				row.getCell(0).setCellValue(listaRegistrosDefinitiva.get(i).getListaObjObjetoMilipore().get(u).getCodigo());
				row.createCell(1).setCellValue(i+".jsp");
				row.createCell(2).setCellValue(listaRegistrosDefinitiva.get(i).getListaObjObjetoMilipore().get(u).getDescripcion());
				numero++;
			}
		}
		
		
			   FileOutputStream elFichero = new FileOutputStream("miliporemundo.xls");
			   workbook.write(elFichero);
			   elFichero.close();
		*/
	}
}
