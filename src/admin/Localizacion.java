package admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//import javax.mail.Session;

/**
 * Permite determinar la ubicaci�n en disco de la P�gina Web y de las
 * p�ginas de los cat�logos que estar�n accesibles a los usuarios.<br>
 * Se basa en un fichero de configuraci�n ubicado en una carpeta fija, por
 * lo que se debe modificar este m�todo si se cambia la ruta actual.
 */
public class Localizacion {

	/**
	 * Edita la informaci�n sobre la informaci�n en disco de la carpeta de la P�gina Web.
	 * <br>Si se cambia el directorio de uso actual, hay que cambiar este m�todo.
	 * @param localizacion Ubicaci�n en disco de la carpeta que contiene la P�gina Web
	 */
	public static void setLocalizacion(String localizacion){
		try{
			//File archivo = new File("\\\\Pqnsv2\\webpage\\Proqui2\\webadmin\\general");
			File archivo = new File ("/var/lib/tomcat7/webapps/ROOT/webadmin/general");
			//File archivo = new File("/var/lib/tomcat7/webapps/proqui");			
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("[Directorio raiz de la p�gina web]\n");
			bw.write(localizacion+"\n");
			bw.close();
			fw.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Devuelve la ubicaci�n en disco de la carpeta que contiene la P�gina Web
	 * <br>Si se cambia el directorio de uso actual, hay que cambiar este m�todo.
	 * @return Ubicaci�n en disco de la carpeta que contiene la P�gina Web
	 */
	public static String getLocalizacion(){
	 	String localizacion = "";
	 	
		try{
	 		//File archivo = new File("\\\\Pqnsv2\\proqui\\webadmin\\general");
		/*	File archivo = new File ("/var/lib/tomcat7/webapps/ROOT/webadmin/general");	
			
			FileReader fr = new FileReader(archivo);
		 	BufferedReader br = new BufferedReader(fr);
		 	br.readLine();//[Directorio raiz de la p�gina web]
		 	localizacion = br.readLine();*/
		 	//cambio para desplegar
			localizacion="C:\\xampp\\tomcat\\webapps\\ROOT";
			//localizacion="C:\\tomcat7\\webapps\\ROOT";
	/*	 	br.close();
		 	fr.close();*/
	 	}
	 	catch (Exception e){
	 		e.printStackTrace();
	 	}
	 	return localizacion;
	 } 
	public static String getLocalizacionServidor(){
	 	String localizacion = "";
	 	
		try{
	 		File archivo = new File("\\\\Pqnsv2\\proqui\\webadmin\\general");
		/*	File archivo = new File ("/var/lib/tomcat7/webapps/ROOT/webadmin/general");	*/
			
			FileReader fr = new FileReader(archivo);
		 	BufferedReader br = new BufferedReader(fr);
		 	br.readLine();//[Directorio raiz de la p�gina web]
		 	localizacion = br.readLine();
		// 	localizacion="C:\\xampp\\tomcat\\webapps\\ROOT";
		 	br.close();
		 	fr.close();
	 	}
	 	catch (Exception e){
	 		e.printStackTrace();
	 	}
	 	return localizacion;
	 } 
	/**
	 * Permite editar la ubicaci�n en disco de la carpeta que contiene las p�ginas de los cat�logos.
	 * <br>Si se cambia el directorio de uso actual, hay que cambiar este m�todo.
	 * @param rutaCatalogo Ubicaci�n en disco de la carpeta que contiene las hojas de cat�logos
	 */
	 public static void setCatalogo(String rutaCatalogo){
		 try{
				//File archivo = new File("\\\\Pqnsv2\\webpage\\Proqui2\\webadmin\\general");
				File archivo = new File ("/var/lib/tomcat7/webapps/ROOT/webadmin/general");				
				FileWriter fw = new FileWriter(archivo,true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("[Ubicacion del Catalogo]\n");
				bw.write(rutaCatalogo+"\n");
				bw.close();
				fw.close();
			}
			catch (Exception e){
				e.printStackTrace();
			}
	 }
	 
	 /**
	  * Devuelve la la ubicaci�n en disco del directorio que contiene las p�ginas de los cat�logos.
	  * <br>Si se cambia el directorio de uso actual, hay que cambiar este m�todo.
	  * @return Ubicaci�n en disco de la carpeta que contiene las hojas de cat�logos
	  */
	 public static String getCatalogo(){
		 	String catalogo = "";
		 	try{
		 		//File archivo = new File("\\\\Pqnsv2\\webpage\\Proqui2\\webadmin\\general");
				File archivo = new File ("/var/lib/tomcat7/webapps/ROOT/webadmin/general");			 	
				FileReader fr = new FileReader(archivo);
			 	BufferedReader br = new BufferedReader(fr);
			 	br.readLine();//[Directorio raiz de la p�gina web]
			 	br.readLine();//Directorio raiz de la p�gina web
			 	br.readLine();//[Ubicacion del catalogo]
			 	catalogo = br.readLine();
			 	br.close();
			 	fr.close();
		 	}
		 	catch (Exception e){
		 		e.printStackTrace();
		 	}
		 	return catalogo;
		 } 
	
}
