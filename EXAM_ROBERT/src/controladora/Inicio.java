package controladora;

import modelo.Cadete;
import modelo.ConexionDB;
import modelo.ModeloCadete;
import vista.VistaApp;

public class Inicio {

	public static void main(String[] args) {
		
		ConexionDB conexion = new ConexionDB("localhost","thelaby","root","tonphp");
		
		if(conexion.conectDB()==true){
			System.out.println("Conectado");
		}
		else{
			System.out.println("No conectado");
		}
		
		
		
		VistaApp vista = new VistaApp();
		vista.setVisible(true);

	}

}
