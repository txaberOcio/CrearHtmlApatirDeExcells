package main;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import clases.MedidoresPH;

public class HTMLSoloTabla {

	public static void main(String[] args) {
		String ruta="C:\\casetes1\\hornoselecta.xls";

		ArrayList<MedidoresPH> reg= new ArrayList();
		  MedidoresPH obj=new MedidoresPH();	
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
			    	 obj=new MedidoresPH();
			    	 try {
			    		 long num=(long) row.getCell(0).getNumericCellValue();
			    		
			    		 obj.setCodigo(String.valueOf(num));
			    	 }catch(Exception e) {
			    		 try {
			    		 obj.setCodigo(row.getCell(0).getStringCellValue());
			    		 }catch(Exception a) { 
			    		 }
			    	 }
			    	
			    	
			    	 try {
			    		 int num=(int) row.getCell(1).getNumericCellValue();
			    		 obj.setNombreProducto(String.valueOf(num));
			    	 }catch(Exception e) {
			    		 try {
			    		 obj.setNombreProducto(row.getCell(1).getStringCellValue());
			    		 }catch(Exception a) { 
			    		 }
			    		 }
			    	 try {
			    		 int num=(int) row.getCell(2).getNumericCellValue();
			    		 obj.setFoto(String.valueOf(num));
			    	 }catch(Exception e) {
			    		 try {
			    		 obj.setFoto(row.getCell(2).getStringCellValue());
			    		 }catch(Exception a) { 
			    		 }
			    		 }
			    	 try {
			    		 int num=(int) row.getCell(3).getNumericCellValue();
			    		 obj.setDescripcion(String.valueOf(num));
			    	 }catch(Exception e) {
			    		 try {
			    		 obj.setDescripcion(row.getCell(3).getStringCellValue());
			    		 }catch(Exception a) { 
			    		 }
			    		 }

			    	 row=(HSSFRow) rows.next();
			      reg.add(obj);
			      cont++;
			     }catch(Exception e) {
			      e.printStackTrace();
			     }
		   cont++;
		    x++;
		   }while(rows.hasNext());
		  
		    	 obj=new MedidoresPH();
		    	 try {
		    		 long num=(long) row.getCell(0).getNumericCellValue();
		    		
		    		 obj.setCodigo(String.valueOf(num));
		    	 }catch(Exception e) {
		    		 try {
		    		 obj.setCodigo(row.getCell(0).getStringCellValue());
		    		 }catch(Exception a) { 
		    		 }
		    	 }
		    	
		    	
		    	 try {
		    		 int num=(int) row.getCell(1).getNumericCellValue();
		    		 obj.setNombreProducto(String.valueOf(num));
		    	 }catch(Exception e) {
		    		 try {
		    		 obj.setNombreProducto(row.getCell(1).getStringCellValue());
		    		 }catch(Exception a) { 
		    		 }
		    		 }
		    	 try {
		    		 int num=(int) row.getCell(2).getNumericCellValue();
		    		 obj.setFoto(String.valueOf(num));
		    	 }catch(Exception e) {
		    		 try {
		    		 obj.setFoto(row.getCell(2).getStringCellValue());
		    		 }catch(Exception a) { 
		    		 }
		    		 }
		    	 try {
		    		 int num=(int) row.getCell(3).getNumericCellValue();
		    		 obj.setDescripcion(String.valueOf(num));
		    	 }catch(Exception e) {
		    		 try {
		    		 obj.setDescripcion(row.getCell(3).getStringCellValue());
		    		 }catch(Exception a) { 
		    		 }
		    		 }
		      reg.add(obj);
		  }catch(Exception e) {
			e.printStackTrace();
		  }finally {
		  
		   try {
			   
		    fis.close();
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		  }

	CrearHtml(reg);
	}
	public static void CrearHtml(ArrayList<MedidoresPH> reg){
		FileWriter fichero = null;
		PrintWriter pw = null;
		String cod, chapter, subchapter,nombre;
		
			try {
				fichero = new FileWriter("C:\\Users\\PQNSV2\\Desktop\\Agilent.jsp");
				pw = new PrintWriter(fichero);
				
					//tabla
				String anterior="";	
			
				pw.println("<div class='container'><div class='row' id='linea'><div class='col-xs-12 col-sm-12 col-md-4 col-lg-4 col-xl-4'><img width='200px' height='200px' src='fotoproducto/"+reg.get(0).getFoto()+"b.jpg'></div></div></div><div class='col-xs-12 col-sm-12 col-md-8 col-lg-8 col-xl-8'>");

				for(int e=0;e<reg.size();e++){
					if(e>0) {
						String uu=reg.get(e).getFoto();
						System.out.println(uu);System.out.println(reg.get(e-1).getFoto());
					if(uu.equals(reg.get(e-1).getFoto())) {}else {
						pw.println("</div></div></div><div class='container'><div class='row' id='linea'><div class='col-xs-12 col-sm-12 col-md-4 col-lg-4 col-xl-4'><img width='200px' height='200px' src='fotoproducto/"+reg.get(0).getFoto()+"b.jpg'></div><div class='col-xs-12 col-sm-12 col-md-8 col-lg-8 col-xl-8'>");
					}
					}
				pw.println("<table align='center' class='stilosTabla'><tr class='contenido'>");
							pw.println("<td class='titulito'>"+reg.get(e).getCodigo()+"</td><td class='produccel2'><div id='divCargar"+e+"' name='divCargar"+e+"'> </div>"+
							"<div id='borrarr"+e+"' class='consultapre' onclick=\"cargarExterno3(`divCargar"+e+"`,'"+reg.get(e).getCodigo() +"','borrarr"+e+"')\">Consultar precio</div></td>"+
							"<td class='comprar'><form name='comprar' action='/es/pedido/tramitaPedido.jsp' method='post'>"+
							"<input type='hidden' name='numLineas' value='1'><input type='hidden' name='linea1' value='"+reg.get(e).getCodigo()+"'>"+
							"<input type='number' name='un1' min='1' size='1' class='cantidad'>"+
							"<input type='image' title='Añadir a cesta' src='/es/imagenes/carro/add.png' class='carrito' onclick='document.comprar.submit()' alt='Add'>"+
							"</form></td></tr>");
							pw.println("</tbody></table>");
						}			
				pw.println("</div>");
				
			} catch (Exception e) {
				
				e.printStackTrace();
			} finally {
				try {
					if (null != fichero)
						fichero.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
	}
}
