package presentacion;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaces.ICInstitucion;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ConsultaActividadDeportiva extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	//Variables 
	private ICInstitucion iinst;
	private JPanel contentPane;
	private JComboBox comboBoxClase;
	private JComboBox comboBoxSocio;
	private JComboBox comboBoxActividad;
	private JComboBox comboBoxInstituto;

	

	/**
	 * Create the frame.
	 */
	public ConsultaActividadDeportiva(ICInstitucion iinst) {
		this.iinst=iinst;

		setResizable(true);//permite cambiar el tamaño del jframe
        setIconifiable(true);//permite poner iconos
        setMaximizable(true);//permite maximizar y minimizar el jframe
        //setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// se oculta jframe en lugar de cerrarse
        setClosable(true);// permite que el usuario cierre la ventana
        setTitle("Constula Activdad Deportiva");//setteo el titulo
		
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxInstituto = new JComboBox();			
		comboBoxInstituto.setBounds(10, 57, 328, 22);	
		contentPane.add(comboBoxInstituto);
	
		
		
		comboBoxActividad = new JComboBox();
		comboBoxActividad.setBounds(10, 152, 328, 22);
		comboBoxActividad.addItem("<Seleccionar Actividad Deportiva");
		contentPane.add(comboBoxActividad);
		
		comboBoxClase = new JComboBox();
		comboBoxClase.setBounds(10, 254, 328, 22);
		comboBoxClase.addItem("<Seleccionar Clase");
		comboBoxClase.setEnabled(false);
		contentPane.add(comboBoxClase);
		
		JLabel lblComboInstituto = new JLabel("Institutos:");
		lblComboInstituto.setBounds(10, 32, 194, 14);
		contentPane.add(lblComboInstituto);
		
		JLabel lblComboActividad = new JLabel("Actividades:");
		lblComboActividad.setBounds(10, 127, 282, 14);
		contentPane.add(lblComboActividad);
		
		JLabel lblComboClase = new JLabel("Clases:");
		lblComboClase.setBounds(10, 216, 183, 14);
		contentPane.add(lblComboClase);
		
		JTextPane textInfoClase = new JTextPane();
		textInfoClase.setEnabled(false);
		textInfoClase.setText("Detalles de las clase . . .");
		textInfoClase.setBounds(10, 310, 372, 135);
		contentPane.add(textInfoClase);
		
		JTextPane textInfoActividad = new JTextPane();
		textInfoActividad.setEnabled(false);
		textInfoActividad.setText("Informacion de Actividad . . .");
		textInfoActividad.setBounds(385, 32, 372, 314);
		contentPane.add(textInfoActividad);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(131, 469, 117, 25);
		contentPane.add(btnCancelar);
		
		comboBoxInstituto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				comboBoxInstituto.removeAllItems();
				
				ArrayList<String> instituciones = iinst.listarInstitucionDeportiva();
				if(instituciones.isEmpty()) {
					comboBoxInstituto.addItem("<Sin intituciones creadas>");
					comboBoxInstituto.setSelectedItem("<Sin intituciones creadas>");
				}else {
					comboBoxInstituto.addItem("<Seleccionar institucion>");
					comboBoxInstituto.setSelectedItem("<Seleccionar institucion>");
				}
				// miro si me trae algo
				for (String s : instituciones) {
					System.out.print(s);
				}
				
				for (String s : instituciones) {
					comboBoxInstituto.addItem(s);
				}	
			
			}
			
			
		});
		// Desabilitar/habilitar combo actividades segun lo que se seleccione en el combo instituto
		comboBoxInstituto.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(comboBoxInstituto.getSelectedIndex()==0) {
					comboBoxActividad.setEnabled(false);
				}else {
					comboBoxActividad.setEnabled(true);
				}
			}
			
		});
		
		// Desabilitar/habilitar combo Clases segun lo que se seleccione en el combo Actividad
		comboBoxActividad.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(comboBoxActividad.getSelectedIndex()==0) {
					comboBoxClase.setEnabled(false);
				}else {
					comboBoxClase.setEnabled(true);
				}
			}
			
		});
		
		comboBoxActividad.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				comboBoxActividad.removeAllItems();
				
				Set<String> actividades = iinst.selectInstitucionDeportiva(comboBoxInstituto.getSelectedItem().toString());
				if(actividades.isEmpty()) {
					comboBoxActividad.addItem("<Sin intituciones creadas>");
					comboBoxActividad.setSelectedItem("<Sin intituciones creadas>");
				}else {
					comboBoxActividad.addItem("<Seleccionar institucion>");
					comboBoxActividad.setSelectedItem("<Seleccionar institucion>");
				}
				// miro si me trae algo
				for (String s : actividades) {
					System.out.print(s);
				}
				
				for (String s : actividades) {
					comboBoxActividad.addItem(s);
				}	
			
			}
			
			
		});
		
		comboBoxClase.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				comboBoxClase.removeAllItems();
				String [] clases =  iinst.listarClases((String)comboBoxInstituto.getSelectedItem(),(String)comboBoxActividad.getSelectedItem());
 
			//ArrayList<String> socios = (ArrayList<String>) iinst();
				if(clases.length==0) {
					comboBoxClase.addItem("<Sin clses ingresadas >");
					comboBoxClase.setSelectedItem("<Sin clases ingresadas>");
				}else {
					comboBoxClase.addItem("<Seleccionar clase>");
					comboBoxClase.setSelectedItem("<Seleccionar clase>");
				}
				// miro si me trae algo
				for (String c : clases) {
					System.out.print(c);
				}
				
				for (String c : clases) {
					comboBoxClase.addItem(c);
				}	
			
			}
			
			
		});
		
	}
}
