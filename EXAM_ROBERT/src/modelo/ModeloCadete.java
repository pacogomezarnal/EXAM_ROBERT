package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloCadete {

	//ME GUARDO EN DOS VARIABLES ESTATICAS LAS CONSULTAS QUE NECESITO
	private static String LISTADO_CADETES = "select * from cadetes";
	private static String LISTADO_CADETES_EQUIPO1 = "select * from cadetes where equipo=1";
	
	//ME GUARDO EN VRIABLES ESTATICAS LOS CAMPOS DE LA TABLA
	private static String ID = "id";
	private static String NOMBRE = "nombre";
	private static String APELLIDOS = "apellidos";
	private static String EDAD = "edad";
	private static String NACIONALIDAD = "nacionalidad";
	private static String EQUIPO = "equipo";
	
	//DECLARO UN ARRAY Y UN ARRAYLIST DONDE GUARDARE DATOS
	private ArrayList<String[]> datos;
	private String titulos[]={ID,NOMBRE,APELLIDOS,EDAD,NACIONALIDAD,EQUIPO};
	private ArrayList<String> cadetesEquipo1=null;
	
	//DECLARO UNA VARIABLE DONDE GUARDO LA CLASE CONEXIONDB
	private ConexionDB conex;
	
	//CONEXION
	Connection conexion=null;
	Statement instruccion=null;
	ResultSet conjuntoResultados=null;
	
	
	
	public ModeloCadete() {
		
		//INICIALIZO CONEXION Y ARRAY LIST
		conexion = ConexionDB.getConexion();
		datos=new ArrayList<String[]>();
		cadetesEquipo1 = new ArrayList<String>();
		//PASO EL METODO VOID AL CONSTRUCTORPARA ACTUE
		todosLosDatos();
		
	}
	
	public void todosLosDatos(){
		
		try{
			instruccion=conexion.createStatement();
			conjuntoResultados=instruccion.executeQuery(LISTADO_CADETES);
			
			
			while(conjuntoResultados.next()){
				//ME CREO UN ARRAY DE LONGITUD IGUAL A LOS CAMPOS DE LA TABLA
				String x[]=new String[titulos.length];
				
				//RECORRO EL ARRAY Y LOS GUARDO EN EL ARRAYLIST
					for(int f=0;f<titulos.length;f++){
						x[f]=conjuntoResultados.getString(titulos[f]);
					}
					
				datos.add(x);
			}
		}
		catch(SQLException sqlException){
			sqlException.printStackTrace();
			
		}
		finally{
			try{
				instruccion.close();
				conjuntoResultados.close();
			}
			catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
		}

	}
	
	public ArrayList<Cadete> guardaCadetes() {
		
		ArrayList<Cadete> cadetes = new ArrayList<Cadete>();
		try {
			ResultSet r = conexion.createStatement().executeQuery(LISTADO_CADETES);
			
			while (r.next()) {
				int id = r.getInt(ID);
				String nom = r.getString(NOMBRE);
				String apellidos = r.getString(APELLIDOS);
				int edad = r.getInt(EDAD);
				String nacionalidad = r.getString(NACIONALIDAD);
				int equipo = r.getInt(EQUIPO);
				
				Cadete d = new Cadete(id,nom,apellidos,edad,nacionalidad,equipo);
				cadetes.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cadetes;
	}
	
	public ArrayList getUsuarios(){
		try{
			instruccion=conexion.createStatement();
			conjuntoResultados=instruccion.executeQuery(LISTADO_CADETES_EQUIPO1);
			
			//LISTAREMOS POR PANTALLA LOS DATOS
			while(conjuntoResultados.next()){
				cadetesEquipo1.add(conjuntoResultados.getString(NOMBRE));
			}
			return cadetesEquipo1;
		}
		catch(SQLException sqlException){
			sqlException.printStackTrace();
			return cadetesEquipo1;
		}
		finally{
			try{
				instruccion.close();
				conjuntoResultados.close();
			}
			catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
		}
	}
	
	//GETTER PARA ACCEDER AL ARRAYLIST DE TODOS MIS DATOD
	public String  getDatos(int x,int y){
		return datos.get(x)[y];
	}
	
}

