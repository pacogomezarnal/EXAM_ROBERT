package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.ModeloCadete;

public class PerfilUsuario extends JPanel {
	
	//DECLARAMOS LAS VARIABLES DONDE GUARDAMOS NUESTROS COMPONENTES
	private JLabel foto,lblNombre,lblId,lblApellidos,lblEdad,lblNacionalidad;
	private JTextField cajaNombre,cajaId,cajaApellidos,cajaEdad,cajaNacionalidad;
	private JButton btnSiguiente;
	private ImageIcon imagen;
	
	//GUARDAMOS EN UNA VARIABLE LA CLASE DE MODELOCADETE PARA PODER INTERACTUAR CON ELLA
	private ModeloCadete cadete;


	public PerfilUsuario() {
		
		//INICIALIZAMOS VARIABLE CADETE
		cadete=new ModeloCadete();
		setLayout(null);
		
		//INICIALIZAMOS EL IMAGECON INDICANCOLE LA RUTA DE DONDE ESTA LA IMAGEN QUE QUIERO AGREGARLE
		imagen=new ImageIcon(PerfilUsuario.class.getResource("/imagenes/foto.jpg.png"));
		setLayout(null);
		
		foto = new JLabel("New label");
		foto.setBounds(21, 39, 147, 127);
		//METO EL IMAGEICON DNTRO DE UN LABEL
		foto.setIcon(imagen);
		add(foto);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(206, 39, 58, 14);
		add(lblNombre);
		
		lblId = new JLabel("Id");
		lblId.setBounds(372, 39, 58, 14);
		add(lblId);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(206, 113, 76, 14);
		add(lblApellidos);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(206, 182, 58, 14);
		add(lblEdad);
		
		lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(206, 248, 76, 14);
		add(lblNacionalidad);
		
		cajaNombre = new JTextField();
		cajaNombre.setEditable(false);
		cajaNombre.setBounds(206, 64, 135, 20);
		//RELLENO LA CAJA DE TEXTO CON LOS DATOS CORRESPONDIENTES
		cajaNombre.setText(cadete.getDatos(33, 1));
		add(cajaNombre);
		cajaNombre.setColumns(10);
		
		cajaId = new JTextField();
		cajaId.setEditable(false);
		cajaId.setBounds(372, 64, 58, 20);
		//RELLENO LA CAJA DE TEXTO CON LOS DATOS CORRESPONDIENTES
		cajaId.setText(cadete.getDatos(33, 0));
		add(cajaId);
		cajaId.setColumns(10);
		
		cajaApellidos = new JTextField();
		cajaApellidos.setEditable(false);
		cajaApellidos.setColumns(10);
		cajaApellidos.setBounds(206, 138, 135, 20);
		//RELLENO LA CAJA DE TEXTO CON LOS DATOS CORRESPONDIENTES
		cajaApellidos.setText(cadete.getDatos(33, 2));
		add(cajaApellidos);
		
		cajaEdad = new JTextField();
		cajaEdad.setEditable(false);
		cajaEdad.setColumns(10);
		cajaEdad.setBounds(206, 207, 135, 20);
		//RELLENO LA CAJA DE TEXTO CON LOS DATOS CORRESPONDIENTES
		cajaEdad.setText(cadete.getDatos(33, 3));
		add(cajaEdad);
		
		cajaNacionalidad = new JTextField();
		cajaNacionalidad.setEditable(false);
		cajaNacionalidad.setColumns(10);
		cajaNacionalidad.setBounds(206, 273, 135, 20);
		//RELLENO LA CAJA DE TEXTO CON LOS DATOS CORRESPONDIENTES
		cajaNacionalidad.setText(cadete.getDatos(33, 4));
		add(cajaNacionalidad);
		
		btnSiguiente = new JButton("Siguiente >>");
		btnSiguiente.setBounds(310, 337, 135, 23);
		add(btnSiguiente);
		
	}

	
	
	//GETTER PARA ACCEDER A ESTE BOTON DESDE OTRA CLASE
	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}
	
	
}


