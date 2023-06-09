package main;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import clases.ClaseLista;
import clases.RegistroLibro;

public class HTMLCASSETTE {

	public static void main(String[] args) {
		ArrayList<RegistroLibro> listafinal=new <RegistroLibro>ArrayList();
		for(int r=1;r<=18;r++) {
		String ruta="C:\\casetes\\Libro"+r+".xls";
		System.out.println("libro"+r);
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
		   RegistroLibro reg= new RegistroLibro();
		   
		  do{
		   if(cont==0){
			   
			     try{
			      reg.setTitulo(row.getCell(0).getStringCellValue());
			     
			     }catch(Exception e) {
			      reg.setTitulo("error");
			      
			 
			     }
		   
		   }else if(cont==1) {   
			     try{
			    	 row=(HSSFRow) rows.next();
			      reg.setContenido(row.getCell(0).getStringCellValue());
			      cont++;
			     }catch(Exception e) {
			      reg.setContenido("error");
			      
			 
			     }
		   
		   }else if(cont>1) {
			   int num = 0;
		     try{
		    	
		    	 row=(HSSFRow) rows.next();
		    	 ClaseLista obj=new ClaseLista();
		    	 obj.setCodigo(row.getCell(0).getStringCellValue());
		    	 try {
		    	 obj.setUno(row.getCell(1).getStringCellValue());
		    	 }catch(Exception e) {
		    		 num=(int) row.getCell(1).getNumericCellValue();
		    		 obj.setUno(String.valueOf(num));
		    	 }
		    	 
		    	 
		    	 try {
			    	 obj.setDos(row.getCell(2).getStringCellValue());
			    	 }catch(Exception e) {
			    		 num=(int) row.getCell(2).getNumericCellValue();
			    		 obj.setDos(String.valueOf(num));
			    	 }
		    	 
		    	 
		    	 try {
			    	 obj.setTres(row.getCell(3).getStringCellValue());
			    	 
			    	 }catch(Exception e) {
			    		try {
			    		num=(int) row.getCell(3).getNumericCellValue();
			    		obj.setTres(String.valueOf(num));
			    		}catch(Exception d) {
			    			obj.setTres("");
			    		}
			    		 
			    	 }
		    	
		    	 reg.getListaCeldas().add(obj);
		    
		     }catch(Exception e) {
		    	 e.printStackTrace();
		     }
		     }
		   cont++;
		    x++;
		   }while(rows.hasNext());
		   listafinal.add(reg);
		  }catch(Exception e) {
			e.printStackTrace();
		  }finally {
		  
		   try {
		    fis.close();
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		  }}
		//  System.out.println(listafinal.get(2).getContenido());
		/*
for(int i =0; i<listafinal.size();i++) {
//enlace=nombre codigo=codigo descripcion= peso
	System.out.println(listafinal.get(i).getTitulo());
	System.out.println(listafinal.get(i).getContenido());
	System.out.println("|||||||");
	for(int h=0;h<listafinal.get(i).getListaCeldas().size();h++) {
		System.out.println(listafinal.get(i).getListaCeldas().get(h).getCodigo());
		System.out.println(listafinal.get(i).getListaCeldas().get(h).getUno());
		System.out.println(listafinal.get(i).getListaCeldas().get(h).getDos());
		System.out.println(listafinal.get(i).getListaCeldas().get(h).getTres());
	}
	System.out.println("-------");
}
		*/
	CrearHtml(listafinal);
	}
	public static void CrearHtml(ArrayList<RegistroLibro> listaRegistrosDefinitiva){
		FileWriter fichero = null;
		PrintWriter pw = null;
		String cod, chapter, subchapter,nombre;
		
			try {
				fichero = new FileWriter("C:\\Users\\PQNSV2\\Desktop\\cassettes.jsp");
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
				
				pw.println("<div class=\"container\">\r\n <div class=\"row\">\r\n");
				for(int i=0;i<listaRegistrosDefinitiva.size();i++) {
					//titulo
					pw.println("<div class='col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12' id='divproducto'>"+
					"<h1 class='prodtitulo2'>"+listaRegistrosDefinitiva.get(i).getTitulo() +"</h1></div></div></div>");
					//fin titulo
					//contenido
					pw.println("<div class=\"container\">	\r\n <div class=\"row\" id=\"linea\">\r\n" +
							"			<div class=\"col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-8\">\r\n" + 
							"				<div class=\"DescripcionLarga\">\r\n" + 
							"<div class=\"prodtitulo2\">Descripción:</div>\r\n"
							+listaRegistrosDefinitiva.get(i).getContenido()+ 
							"</div>\r\n" + 
							"</div>\r\n" +
							"<div class=\"col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-4\">\r\n"+
							"<img src='fotoproducto/"+(i+1)+".png' class='fotodelproducto'></div>"+
							"</div>\r\n" + 
							"</div>\r\n");
					//fincontenido
					//tabla
					pw.println("<div class='container'><div class='row' id='linea'><div class='col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12'>"+
					"<div class='tabla'><table><tbody><tr class=''>"+
						"<th class='th1'>Codigo</th><th class='th1'>Unidades</th><th class='th1'>Información</th>");if(listaRegistrosDefinitiva.get(i).getListaCeldas().get(0).getTres()!=""){pw.println("<th class='th1'>Nombre</th>");}pw.println("<th class='th1'>Precio</th><th class='th1'>Comprar</th></tr>");
						for(int e=0;e<listaRegistrosDefinitiva.get(i).getListaCeldas().size();e++) {	
				if(e%2==0) {pw.println("<tr class='inpar'>");}else{pw.println("<tr class=''>");};pw.println("<td class='produccel'>"+listaRegistrosDefinitiva.get(i).getListaCeldas().get(e).getCodigo()+"</td><td class='produccel'>"+listaRegistrosDefinitiva.get(i).getListaCeldas().get(e).getUno()+
							"</td><td class='produccel'>"+listaRegistrosDefinitiva.get(i).getListaCeldas().get(e).getDos()+"</td>");if(listaRegistrosDefinitiva.get(i).getListaCeldas().get(0).getTres()!="") {pw.println("<td class='produccel'>"+listaRegistrosDefinitiva.get(i).getListaCeldas().get(e).getTres()+"</td>");}pw.println("<td>"+
							"<div id='divCarga"+i+e+"' name='divCarga"+i+e+"'> </div>"+
							"<div id='borrar"+i+e+"' class='consultapre' onclick=\"cargarExterno3(`divCarga"+i+e+"`,'CEL"+listaRegistrosDefinitiva.get(i).getListaCeldas().get(e).getCodigo()+"','borrar"+i+e+"')\">Consultar precio</div></td>"+
							"<td class='comprar'><form name='comprar' action='/es/pedido/tramitaPedido.jsp' method='post'>"+
							"<input type='hidden' name='numLineas' value='1'><input type='hidden' name='linea1' value='CEL"+listaRegistrosDefinitiva.get(i).getListaCeldas().get(e).getCodigo()+"'>"+
							"<input type='number' name='un1' min='1' size='1' class='cantidad'>"+
							"<input type='image' title='Añadir a cesta' src='/es/imagenes/carro/add.png' class='carrito' onclick='document.comprar.submit()' alt='Add'>"+
							"</form></td></tr>");
						}
							
						pw.println("</tbody></table></div></div></div></div>");
					
						
					
					//fin tabla
					
					
				}	
				
				pw.println("		</div>\r\n" + 
						"			</div>\r\n");
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
