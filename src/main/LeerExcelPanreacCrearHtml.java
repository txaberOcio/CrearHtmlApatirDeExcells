package main;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import clases.Registro;

public class LeerExcelPanreacCrearHtml {

	public static void main(String[] args) {
		String ruta="D:\\Panreac.xls";
		ArrayList<Registro> listaRegistros= new ArrayList<Registro>();
		  FileInputStream fis=null;
		  try {
		   fis=new FileInputStream(ruta);
		   HSSFWorkbook wb=new HSSFWorkbook(fis);
		   HSSFSheet hoja=wb.getSheetAt(0);
		   Iterator rows=hoja.rowIterator();
		   rows.next();
		   int x=0;
		   int u=0;
		   while(rows.hasNext()) {
		   
		     HSSFRow row = (HSSFRow) rows.next();
		     Registro reg= new Registro();
		     try{
		      reg.setCodigo(row.getCell(0).getStringCellValue());
		      reg.setEnlace(row.getCell(1).getStringCellValue());
		      reg.setDescripcion(row.getCell(2).getStringCellValue());
		      if(x==0) {
		    	  listaRegistros.add(reg);
		    	  
		      }else {
		      if(reg.getDescripcion().equals(listaRegistros.get(u).getDescripcion())){
		    	  //no introducimos el producto
		      }else {
		    	  listaRegistros.add(reg);
		    	  u++;
		    	
		      }
		      }
		     }catch(Exception e) {
		      reg.setCodigo("eror");
		      reg.setDescripcion("error");
		      reg.setEnlace("error");
		     }
		    
		    x++;
		   }
		  }catch(Exception e) {
			e.printStackTrace();
		  }finally {
		  
		   try {
		    fis.close();
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		  }
		  
for(int i =0; i<listaRegistros.size();i++) {
//enlace=nombre codigo=codigo descripcion= peso
System.out.println("nombre:"+listaRegistros.get(i).getEnlace());
System.out.println("codigo:"+listaRegistros.get(i).getCodigo());
System.out.println("peso:"+listaRegistros.get(i).getDescripcion());
}

}

}
