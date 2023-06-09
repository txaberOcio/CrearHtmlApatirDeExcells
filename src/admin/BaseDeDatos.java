package admin;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.LinkedList;

import clases.Conexion;

 /**
 * Clase que permite gestionar de una manera sencilla la conexion al Servidor de Base de Datos
 * Utiliza el fichero de configuraci�n 'bbdd' para leer y modificar los datos del servidor al que conectarse
 */

public class BaseDeDatos{
	
	/**
	 *  String de conexi�n al servidor, usuario y contrase�a
	 *  Permite establecer una conexi�n al Servidor de Base de Datos indicado
	 *  en el fichero de configuraci�n. Si no encuentra ning�n servidor v�lido
	 *  intenta establecer una conexi�n SQL local.
	 *  @return Conexion String de conexi�n al Servidor MySQL, usuario y contrase�a
	 *  */
	public static Conexion getParametros(){
		
		Conexion conexion = new Conexion();
		String IPServidor = "",puerto="",esquema="",instancia="";
		String direccion = "",user="",pass="";
		try{
			//Se lee el fichero de configuraci�n. Una vez le�do, se comprobar� la validez de datos
		//	File archivo = new File (Localizacion.getLocalizacion()+"\\webadmin\\bbdd");
		    File archivo = new File (Localizacion.getLocalizacion()+"/webadmin/bbdd");
			FileReader fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);
			br.readLine();//[Servidor MySQL]
			br.readLine();//[IP del servidor]
			IPServidor = br.readLine();
			br.readLine();//[Puerto]
			puerto = br.readLine();
			br.readLine();//[Esquema]
			esquema = br.readLine();
			//Si no hay un servidor v�lido, intenta establecer una conexi�n local
			if (IPServidor.length()==0){
				IPServidor="localhost";
			}
			//Si el puerto no es v�lido, usamos el puerto SQL por defecto
			if (puerto.length()==0){
				puerto = "3306";
			}
			br.readLine();//[Usuario]
			user = br.readLine();
			br.readLine();//[Password]
			pass = br.readLine();
			//Usuario por defecto
			if (user.length()==0){
				user="root";
			}
			br.readLine();//[Instancia]
			instancia=br.readLine();
			Calendar c=Calendar.getInstance();
			String anyo=String.valueOf(c.get(Calendar.YEAR));
			esquema=anyo+"NO";
			IPServidor="jdbc:sqlserver://"+IPServidor;
			direccion = IPServidor+":"+puerto+";instance="+instancia+";database="+esquema+";";
			conexion.setServidor(direccion);
			conexion.setUser(user);
			conexion.setPass(pass);
			conexion.setEsquema(esquema);
			br.close();
			fr.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return conexion;
	}
	
	/***
	 * Su funci�n es obtener individualmente los par�metros de conexi�n a la Base de Datos.
	 * Utilizado en admin para permitir al Administrador del Sistema mostrar los par�metros actuales.
	 * @return Conexion
	 */
	public static Conexion getParametrosIndividuales(){
		Conexion conexion = new Conexion();
		String IPServidor = "",puerto="",esquema="";
		String user="",pass="";
		try{
//			File archivo = new File (Localizacion.getLocalizacion()+"\\webadmin\\bbdd");
			File archivo =new File (Localizacion.getLocalizacion()+"/webadmin/bbdd");
			FileReader fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);
			br.readLine();//[Servidor MySQL]
			br.readLine();//[IP del servidor]
			IPServidor = br.readLine();
			br.readLine();//[Puerto]
			puerto = br.readLine();
			br.readLine();//[Esquema]
			esquema = br.readLine();
			if (IPServidor.length()==0){
				IPServidor="localhost";
			}
			if (puerto.length()==0){
				puerto = "3306";
			}
			
			br.readLine();//[Usuario]
			user = br.readLine();
			br.readLine();//[Password]
			pass = br.readLine();
			if (user.length()==0){
				user="root";
			}
			
			conexion.setIp(IPServidor);
			conexion.setPuerto(puerto);
			Calendar c=Calendar.getInstance();
			String anyo=String.valueOf(c.get(Calendar.YEAR));
			esquema=anyo+"NO";
			conexion.setEsquema(esquema);
			conexion.setUser(user);
			conexion.setPass(pass);
			br.close();
			fr.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return conexion;
	}
	
	/**
	 * Permite cambiar los par�metros utilizados para conectarse a la Base de Datos. 
	 * @param IPServidor Direcci�n IP del Servidor. Por defecto, localhost
	 * @param puerto Puerto de conexi�n. Por defecto, 3306
	 * @param esquema Esquema actual
	 * @param user Nombre de Usuario. Por defecto, root
	 * @param pass Contrase�a de Usuario. Puede estar vac�a
	 */
	public static void setParametros(String IPServidor,String puerto,String esquema, String user, String pass){
	//	File archivo = new File (Localizacion.getLocalizacion()+"\\webadmin\\bbdd");
	        File archivo = new File (Localizacion.getLocalizacion()+"/webadmin/bbdd");
		try{
			if(!archivo.exists()){
				archivo.createNewFile();
			}
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter (fw);
			bw.write("[Servidor MySQL]\n");
			bw.write("[IP del Servidor]\n");
			bw.write(IPServidor+"\n");
			bw.write("[Puerto]\n");
			bw.write(puerto+"\n");
			bw.write("[Esquema]\n");
			bw.write(esquema+"\n");
			bw.write("[Usuario]\n");
			bw.write(user+"\n");
			bw.write("[Password]\n");
			bw.write(pass+"\n");
			bw.close();
			fw.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Devuelve los esquemas utilizables (Sin Ordenar)
	 * @param conexion Conexi�n con la base de datos ya establecida
	 * @return Lista de Esquemas ordenados
	 */
	public static LinkedList<String> getEsquemas (Connection conexion){
		LinkedList<String> esquemas = new LinkedList<String>();
	    try{
	    	PreparedStatement ps = conexion.prepareStatement("SELECT name FROM master..sysdatabases");
	    	ResultSet rs = ps.executeQuery();
	    	while (rs.next()) {
	    		String esquema = rs.getString(1);
	    		if ((esquema.startsWith("20"))&&(esquema.endsWith("no"))){
	    			esquemas.add(esquema);
	    		}
		    }
		    rs.close();
		    ps.close();
	    }
	    catch (Exception e){
	    	e.printStackTrace();
	    }
	    //esquemas.removeLast();//Eliminamos el actual
	    return esquemas;
	}
	/**
	 * Devuelve ordenados de m�s recientes a m�s antiguos los esquemas utilizables
	 * @param conexion Conexi�n con la base de datos ya establecida
	 * @return Lista de Esquemas ordenados
	 */
	public static LinkedList<String> getEsquemasOrdenados (Connection conexion){
		LinkedList<String> esquemas = new LinkedList<String>();
	    try{
	    	PreparedStatement ps = conexion.prepareStatement("SELECT name FROM master..sysdatabases ORDER BY name");
	    	ResultSet rs = ps.executeQuery();
	    	while (rs.next()) {
	    		String esquema = rs.getString(1);
	    		if ((esquema.startsWith("20"))&&(esquema.endsWith("NO"))){
	    			esquemas.addFirst(esquema);
	    		}
		    }
		    rs.close();
		    ps.close();
	    }
	    catch (Exception e){
	    	e.printStackTrace();
	    }
	    //esquemas.removeLast();//Eliminamos el actual
	    return esquemas;
	}
	
	/**
	 * Permite conocer los esquemas anteriores. �til para buscar datos de 
	 * los historiales de cliente. Pensado para recorrer todos los esquemas 
	 * necesarios con una �nica conexi�n.
	 * @param conexion Conexi�n establecida contra la base de datos
	 * @return Listado de esquemas anteriores
	 */
	public static LinkedList<Integer> getAnteriores (Connection conexion){
		LinkedList<Integer> esquemas = new LinkedList<Integer>();
	    try{
	    	PreparedStatement ps = conexion.prepareStatement("SELECT name FROM master..sysdatabases");
	    	ResultSet rs = ps.executeQuery();
	    	while (rs.next()) {
	    		String esquema = rs.getString(1);
	    		if (esquema.startsWith("20")){
	    			esquema = esquema.substring(0,4);
	    			int anyo = Integer.parseInt(esquema);
	    			esquemas.addFirst(anyo);
	    		}
		    }
		    rs.close();
		    ps.close();
	    }
	    catch (Exception e){
	    	e.printStackTrace();
	    }
	    //esquemas.removeLast();//Eliminamos el actual
	    return esquemas;
	}
	
}
