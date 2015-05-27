package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionDB {

	//DATOS DE LA CONEXION
	static final String CONTROLADOR_MYSQL="com.mysql.jdbc.Driver";
	
	//DATOS DE LA BASE DE DATOS
	private String host;
	private String bbdd;
	private String user;
	private String password;
	
	//CONEXION
	static Connection conexion = null; //MANEJA LA CONEXION
	
	public ConexionDB(String host,String bbdd,String user,String password) {
		
		this.host=host;
		this.bbdd=bbdd;
		this.user=user;
		this.password=password;
	}
	
	public boolean conectDB (){
		try{
			//LO PRIMERO ES CARGAR EL CONTROLADOR MYSQL EL CUAL AUTOMATICAMENTE SE REGISTRA
			Class.forName(CONTROLADOR_MYSQL);
			
			//CONECTAREMOSA A LA BASE DE DATOS
			conexion=DriverManager.getConnection("jdbc:mysql://"+this.host+"/"+this.bbdd,this.user,this.password);
			}
		catch(SQLException sqlException){
			sqlException.printStackTrace();
			return false;
		}
		catch(ClassNotFoundException claseNoEncontrada){
			claseNoEncontrada.printStackTrace();
			return false;
		}
		return true;
		
		}

	public static Connection getConexion(){
		return conexion;
	}
}
