package vista;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.IngresoLaby;

public class VistaApp extends JFrame {

	//DECLARO VARIABLE JPANEL DONDE ME GUARDO UN JPANEL
	private JPanel contentPane;
	
	//DECLARO EN TRES VARIABLES LAS TRES CLASES DE JPNEL QUE ME HE CREADO PARA PODER INTERACTUAR CON ELLAS
	private PerfilUsuario perfilUsuario;
	private PerfilEquipo perfilEquipo;
	private Comprobacion comprobacion;
	
	private IngresoLaby laby;


	public VistaApp() {
		
		//INICIALIZO LAS TRES VARIABLES
		perfilUsuario = new PerfilUsuario();
		perfilEquipo = new PerfilEquipo();
		comprobacion = new Comprobacion(this);
		
		laby=new IngresoLaby();
		
		//LE PONGO TITULO A MI VENTANA
		setTitle(							"                                                      THE LABY");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//LE PONGO CARDLAYOUT A MI PANEL
		contentPane.setLayout(new CardLayout(0, 0));
		
		//AÑADO A MI CARDLAYOUT LOS TRES PANELS QUE LE E PASAO CON SU INDICE DE NOMBRE PARA PODER LAMARLO CUANDO LO NECESITE
		contentPane.add(perfilUsuario,"perfilUsuario");
		contentPane.add(perfilEquipo,"perfilEquipo");
		contentPane.add(comprobacion,"comprobacion");
		
		/*CUANDO APRETO AL BOTON SIGUIENTE DE PERFIL USUARIO CAMBIO EL CARDLAYOUT Y COLOCO PERFIL EQUIPO*/
		perfilUsuario.getBtnSiguiente().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c = (CardLayout) contentPane.getLayout();
				c.show(contentPane, "perfilEquipo");
			}
		});
		
		/*CUANDO APRETO AL BOTON ATRAS DE PERFIL EQUIPO CAMBIO EL CARDLAYOUT Y COLOCO PERFIL USUARIO*/
		perfilEquipo.getBotonAtras().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout d = (CardLayout) contentPane.getLayout();
				d.show(contentPane, "perfilUsuario");
			}
		});
		
		/*CUANDO APRETO AL BOTON SIGUIENTE DE PERFIL EQUIPO CAMBIO EL CARDLAYOUT Y COLOCO COMPROBACION*/
		perfilEquipo.getBotonSiguiente().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout e = (CardLayout) contentPane.getLayout();
				e.show(contentPane, "comprobacion");
			}
		});
		
		/*CUANDO APRETO AL BOTON ATRAS DE COMPROBACION CAMBIO EL CARDLAYOUT Y COLOCO PERFIL EQUIPO*/
		comprobacion.getBotonAtras().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout i = (CardLayout) contentPane.getLayout();
				i.show(contentPane, "perfilEquipo");
			}
		});
		
	}
	
	public IngresoLaby getLaby() {
		return laby;
	}

}
