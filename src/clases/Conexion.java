package clases;

/**
 * Clase que permite manejar los parámetros necesarios para establecer
 * una conexión SQL contra el servidor de Base de Datos.
 */
public class Conexion {

	/**IP del servidor de Base de Datos*/
	String IP;
	/**Puerto SQL*/
	String puerto;
	/**Esquema predeterminado*/
	String esquema;
	/**String de conexión. Formato: jdbc:mysql://'IP':'<puerto'/'esquema'*/
	String servidor;
	/**Nombre de usuario SQL*/
	String user;
	/**Contraseña de usuario SQL*/
	String pass;
	
	/**
	 * Fija la dirección IP del servidor de Base de Datos.
	 * @param IP IP del servidor
	 */
	public void setIp(String IP){
		this.IP = IP;
	}
	
	/**
	 * Devuelve la dirección IP del servidor de Base de Datos.
	 * @return IP del servidor de Base de Datos
	 */
	public String getIp(){
		return IP;
	}
	
	/**
	 * Fija el puerto contra el que se intenta hacer la conexión.
	 * @param puerto Puerto SQL
	 */
	public void setPuerto (String puerto){
		this.puerto = puerto;
	}
	
	/**
	 * Devuelve el puerto contra el que se intenta hacer la conexión.
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
	 * Retorna el esquema contra el que se hará la consulta.
	 * @return Esquema SQL
	 */
	public String getEsquema(){
		return esquema;
	}
	
	/**
	 * Crea el String de conexión al servidor.
	 * @param servidor String de conexión al servidor.
	 */
	public void setServidor(String servidor){
		this.servidor = servidor;
	}
	
	/**
	 * Retorna el String de conexión al servidor.
	 * @return String de conexión al servidor
	 */
	public String getServidor(){
		return servidor;
	}
	
	/**
	 * Establece el usuario con el que se abrirá la conexión SQL.
	 * @param user Usuario MySQL
	 */
	public void setUser(String user){
		this.user = user;
	}
	
	/**
	 * Devuelve el usuario del servidor SQL con el que se hará la conexión.
	 * @return Usuario MySQL
	 */
	public String getUser(){
		return user;
	}
	
	/**
	 * Fija la contraseña del usuario en el servidor SQL.
	 * @param pass Contraseña de usuario MySQL
	 */
	public void setPass(String pass){
		this.pass = pass;
	}
	
	/**
	 * Devuelve la contraseña de usuario para establecer la conexión SQL.
	 * @return Contraseña de usuario MySQL
	 */
	public String getPass(){
		return pass;
	}

}
