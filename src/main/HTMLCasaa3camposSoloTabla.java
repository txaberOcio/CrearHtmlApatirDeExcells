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

public class HTMLCasaa3camposSoloTabla {

	public static void main(String[] args) {
		//String ruta="C:\\casetes1\\Libro1.xls";
		//String ruta="C:\\casetes1\\icomed.xls";
		//String ruta="C:\\casetes1\\IncubadorIm.xls";
		//String ruta="C:\\casetes1\\incubador1.xls";
		//String ruta="C:\\casetes1\\utimo.xls";
		//String ruta="C:\\casetes1\\raypa2.xls";
		//String ruta="C:\\casetes1\\333.xls";
		//String ruta="C:\\casetes1\\444.xls";
		//String ruta="C:\\casetes1\\555.xls";
		//String ruta="C:\\casetes1\\666.xls";
	//	String ruta="C:\\casetes1\\888.xls";
		//String ruta="C:\\casetes1\\999.xls";
		//String ruta="C:\\casetes1\\c1.xls";
	//	String ruta="C:\\casetes1\\c2.xls";
		//String ruta="C:\\casetes1\\c3.xls";
		//String ruta="C:\\casetes1\\c4.xls";
		//String ruta="C:\\casetes1\\c5.xls";
		//String ruta="C:\\casetes1\\c6.xls";
	//	String ruta="C:\\casetes1\\c7.xls";
		//String ruta="C:\\casetes1\\c8.xls";
		String ruta="C:\\casetes1\\dod.xls";
		//batas de laboratorio, delantales y ropa
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
			    		 obj.setDescripcion(String.valueOf(num));
			    	 }catch(Exception e) {
			    		 
			    		 try{
			    			 obj.setDescripcion(row.getCell(2).getStringCellValue());
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
		    		 obj.setDescripcion(String.valueOf(num));
		    	 }catch(Exception e) {
		    		 
		    		 try{
		    			 obj.setDescripcion(row.getCell(2).getStringCellValue());
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
		//  System.out.println(listafinal.get(2).getContenido());
		

//enlace=nombre codigo=codigo descripcion= peso

	System.out.println("|||||||");


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
				System.out.println(reg.size());
				for(int e=0;e<reg.size();e++){
				pw.println("<table align='center' class='stilosTabla'><tr class='contenido'>");
							pw.println("<td class='titulito'>"+reg.get(e).getCodigo()+"</td><td class=''>"+reg.get(e).getNombreProducto()+"</td><td class='produccel2'><div id='divCargar"+e+"' name='divCargar"+e+"'> </div>"+
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
