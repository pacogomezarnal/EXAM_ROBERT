package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.IngresoLaby;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Comprobacion extends JPanel {
	
	//DECLARAMOS LAS VARIABLES PARA GUARDARNOS LOS COMPONENTES
	private JTextField cajaId,cajaApellido,cajaMensaje;
	private JLabel lblId,lblerApellido; 
	private JButton botonComprobar,botonAtras;
	
	//LE PASAMOS LA CLASE INGRESO LABY QUE INICIALIZAREMOS EN EL CONSTRUCTOR
	private IngresoLaby laby;

	public Comprobacion(VistaApp vista) {
		
		laby=new IngresoLaby();
		
		setLayout(null);
		
		lblId = new JLabel("Id");
		lblId.setBounds(50, 66, 72, 14);
		add(lblId);
		
		lblerApellido = new JLabel("1er Apellido");
		lblerApellido.setBounds(159, 66, 96, 14);
		add(lblerApellido);
		
		cajaId = new JTextField();
		cajaId.setBounds(50, 91, 61, 20);
		add(cajaId);
		cajaId.setColumns(10);
		
		cajaApellido = new JTextField();
		cajaApellido.setBounds(159, 91, 130, 20);
		add(cajaApellido);
		cajaApellido.setColumns(10);
		
		cajaMensaje = new JTextField();
		cajaMensaje.setBounds(50, 226, 394, 20);
		add(cajaMensaje);
		cajaMensaje.setColumns(10);
		
		
		//ACCION QUE PONDRIA EL MENSAJE DEVUELTO, PERO NO ME VA
		botonComprobar = new JButton("COMPROBAR");
		/*botonComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = vista.getLaby().getCod(Integer.valueOf(cajaId.getText()), cajaApellido.getText());		
				cajaMensaje.setText(msg);
			}
		});*/
		botonComprobar.setBounds(50, 168, 394, 23);
		add(botonComprobar);
		
		botonAtras = new JButton("<<Atr\u00E1s");
		botonAtras.setBounds(20, 333, 112, 23);
		add(botonAtras);

	}

	
	//GETTER PARA ACCEDER A ESTE BOTON DESDE OTRA CLASE

	public JButton getBotonAtras() {
		return botonAtras;
	}
}
