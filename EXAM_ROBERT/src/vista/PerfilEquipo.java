package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import modelo.ModeloCadete;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;

public class PerfilEquipo extends JPanel {
	
	//DECLARAMOS LAS VARIABLES DONDE GUARDAREMOS LOS COMPONENTES
	private JLabel lblEquipo,lblNombre,lblId,lblerApellido,lblApellido,lblNacionalidad;
	private JTextField cajaNombre,cajaId,cajaApellido,cajaApellido2,cajaNacionalidad;
	private JComboBox comboBox;
	private JButton botonAtras,botonSiguiente;

	//DECLARAMOS UNA VARIABLE DONDE GUARDAREMOS LA CLASE MODELOCADETE PARA PODER INTERACTUAR CON ELLA
	private ModeloCadete cadete;

	public PerfilEquipo() {
		
		//INICIALIZAMOS VARIABLE CADETE
		cadete=new ModeloCadete();
		setLayout(null);
		
		lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(41, 51, 78, 14);
		add(lblEquipo);
		
		comboBox = new JComboBox();
		comboBox.setBounds(41, 76, 122, 20);
		add(comboBox);
		
		//PASAMOS NUESTRO ARRAYLIST DE CADETES CON EQUIPO=1 A UN ITERATOR Y RELLENAMOS EL COMBOBOX CON EL
		Iterator <Object> it = cadete.getUsuarios().iterator();
		while(it.hasNext()){
			comboBox.addItem((Object)it.next());
		}
		
		//ACCION QUE RELLENA LAS CASILLAS DE TEXTO CON LOS DATOS CORRESPONDIENTES AL CADETE SELECCIONADO
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a = comboBox.getSelectedIndex();
				if(a==0){
					rellenarCajas(0);
				}
				if(a==1){
					rellenarCajas(9);
				}
				if(a==2){
					rellenarCajas(17);
				}
				if(a==3){
					rellenarCajas(24);
				}
				if(a==4){
					rellenarCajas(27);
				}
				if(a==5){
					rellenarCajas(33);
				}
				
			}
		});	
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(216, 51, 63, 14);
		add(lblNombre);
		
		cajaNombre = new JTextField();
		cajaNombre.setEditable(false);
		cajaNombre.setBounds(216, 76, 122, 20);
		add(cajaNombre);
		cajaNombre.setColumns(10);
		
		lblId = new JLabel("Id");
		lblId.setBounds(365, 51, 46, 14);
		add(lblId);
		
		cajaId = new JTextField();
		cajaId.setEditable(false);
		cajaId.setBounds(365, 76, 54, 20);
		add(cajaId);
		cajaId.setColumns(10);
		
		lblerApellido = new JLabel("1er Apellido");
		lblerApellido.setBounds(216, 112, 89, 14);
		add(lblerApellido);
		
		cajaApellido = new JTextField();
		cajaApellido.setEditable(false);
		cajaApellido.setColumns(10);
		cajaApellido.setBounds(216, 137, 122, 20);
		add(cajaApellido);
		
		lblApellido = new JLabel("2\u00BA Apellido");
		lblApellido.setBounds(216, 175, 89, 14);
		add(lblApellido);
		
		cajaApellido2 = new JTextField();
		cajaApellido2.setEditable(false);
		cajaApellido2.setColumns(10);
		cajaApellido2.setBounds(216, 200, 122, 20);
		add(cajaApellido2);
		
		lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(216, 247, 110, 14);
		add(lblNacionalidad);
		
		cajaNacionalidad = new JTextField();
		cajaNacionalidad.setEditable(false);
		cajaNacionalidad.setColumns(10);
		cajaNacionalidad.setBounds(216, 272, 122, 20);
		add(cajaNacionalidad);
		
		botonAtras = new JButton("<<Atr\u00E1s");
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonAtras.setBounds(10, 339, 122, 23);
		add(botonAtras);
		
		botonSiguiente = new JButton("Siguiente>>");
		botonSiguiente.setBounds(335, 339, 130, 23);
		add(botonSiguiente);

	}
	
	//METODO QUE ME SIRVE PARA RELLENAR LAS CAJAS DE TEXTO CON LOS DATOS
	//LE PASO UN ENTERO QUE SERA LA POSICION DE LA FILA DE MI ARRAYLIST DONDE ALMACENO TODA LA TABLA
	public void rellenarCajas (int a){
		
		cajaNombre.repaint();
		cajaNombre.setText(cadete.getDatos(a, 1));
		cajaApellido.repaint();
		cajaApellido.setText(cadete.getDatos(a, 2));
		cajaApellido2.repaint();
		cajaApellido2.setText(cadete.getDatos(a, 2));
		cajaNacionalidad.repaint();
		cajaNacionalidad.setText(cadete.getDatos(a, 4));
		cajaId.repaint();
		cajaId.setText(cadete.getDatos(a, 0));
		
		
	}


	//GETTERS PARA ACCEDER A ESTOS BOTONES DESDE OTRAS CLASES
	public JButton getBotonAtras() {
		return botonAtras;
	}


	public JButton getBotonSiguiente() {
		return botonSiguiente;
	}
	
	
}
