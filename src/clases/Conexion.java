package clases;

/**
 * Clase que permite manejar los par�metros necesarios para establecer
 * una conexi�n SQL contra el servidor de Base de Datos.
 */
public class Conexion {

	/**IP del servidor de Base de Datos*/
	String IP;
	/**Puerto SQL*/
	String puerto;
	/**Esquema predeterminado*/
	String esquema;
	/**String de conexi�n. Formato: jdbc:mysql://'IP':'<puerto'/'esquema'*/
	String servidor;
	/**Nombre de usuario SQL*/
	String user;
	/**Contrase�a de usuario SQL*/
	String pass;
	
	/**
	 * Fija la direcci�n IP del servidor de Base de Datos.
	 * @param IP IP del servidor
	 */
	public void setIp(String IP){
		this.IP = IP;
	}
	
	/**
	 * Devuelve la direcci�n IP del servidor de Base de Datos.
	 * @return IP del servidor de Base de Datos
	 */
	public String getIp(){
		return IP;
	}
	
	/**
	 * Fija el puerto contra el que se intenta hacer la conexi�n.
	 * @param puerto Puerto SQL
	 */
	public void setPuerto (String puerto){
		this.puerto = puerto;
	}
	
	/**
	 * Devuelve el puerto contra el que se intenta hacer la conexi�n.
	 * @return Puerto SQL
	 */
	public String getPuerto(){
		return puerto;
	}
	
	/**
	 * Establece el esquema contra el que hacer la consulta.
	 * @param esquema Esquema SQL
	 */
	public void setEsquema (String esquema){
		this.esquema=esquema;
	}
	
	/**
	 * Retorna el esquema contra el que se har� la consulta.
	 * @return Esquema SQL
	 */
	public String getEsquema(){
		return esquema;
	}
	
	/**
	 * Crea el String de conexi�n al servidor.
	 * @param servidor String de conexi�n al servidor.
	 */
	public void setServidor(String servidor){
		this.servidor = servidor;
	}
	
	/**
	 * Retorna el String de conexi�n al servidor.
	 * @return String de conexi�n al servidor
	 */
	public String getServidor(){
		return servidor;
	}
	
	/**
	 * Establece el usuario con el que se abrir� la conexi�n SQL.
	 * @param user Usuario MySQL
	 */
	public void setUser(String user){
		this.user = user;
	}
	
	/**
	 * Devuelve el usuario del servidor SQL con el que se har� la conexi�n.
	 * @return Usuario MySQL
	 */
	public String getUser(){
		return user;
	}
	
	/**
	 * Fija la contrase�a del usuario en el servidor SQL.
	 * @param pass Contrase�a de usuario MySQL
	 */
	public void setPass(String pass){
		this.pass = pass;
	}
	
	/**
	 * Devuelve la contrase�a de usuario para establecer la conexi�n SQL.
	 * @return Contrase�a de usuario MySQL
	 */
	public String getPass(){
		return pass;
	}

}
