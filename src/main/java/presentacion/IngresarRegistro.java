package presentacion;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import datatypes.DtClase;
import datatypes.DtFecha;
import excepciones.RegistroUsuarioClaseException;
import excepciones.UsuarioEnUsoExcepcion;
import interfaces.ICInstitucion;
import interfaces.ICUsuario;
import logica.CUsuario;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDateTime;

public class IngresarRegistro extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	//Variables 
	private ICUsuario iusu;

	//private ICInstitucion iinst;
	private ICInstitucion iinst;

	private JPanel contentPane;
	private JTextField textFieldFECHA;
	private JComboBox comboBoxInstituto;
	private JComboBox comboBoxActividad;
	private JComboBox comboBoxClase;
	private JComboBox comboBoxSocio;
	
	/**
	 * Create the frame.
	 */
	public IngresarRegistro(ICUsuario iusu, ICInstitucion iinst) {
		this.iusu=iusu;
		this.iinst=iinst;
		 //public ConsultaActividadDeportiva(ICInstitucion iinst) {
		//	this.iinst=iinst;}
		
		
		setResizable(true);//permite cambiar el tamaño del jframe
        setIconifiable(true);//permite poner iconos
        setMaximizable(true);//permite maximizar y minimizar el jframe
        //setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// se oculta jframe en lugar de cerrarse
        setClosable(true);// permite que el usuario cierre la ventana
        setTitle("Registro de Usuario a Clase");//setteo el titulo
		
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxSocio = new JComboBox();			
		comboBoxSocio.setBounds(10, 321, 328, 22);	
		contentPane.add(comboBoxSocio);
	
		
	
		comboBoxClase = new JComboBox();
		comboBoxClase.setBounds(10, 198, 328, 22);
		comboBoxClase.addItem("<Seleccionar Clase>");
		comboBoxClase.setEnabled(true);
		contentPane.add(comboBoxClase);
		
		JLabel lblComboSocio = new JLabel("Socios:");
		lblComboSocio.setBounds(10, 297, 194, 14);
		contentPane.add(lblComboSocio);
		
		JLabel lblComboClase = new JLabel("Clases:");
		lblComboClase.setBounds(10, 174, 183, 14);
		contentPane.add(lblComboClase);
		
		JTextPane textInfoClase = new JTextPane();
		textInfoClase.setEnabled(false);
		textInfoClase.setText("Detalles de las clase . . .");
		textInfoClase.setBounds(394, 230, 328, 137);
		contentPane.add(textInfoClase);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					registroActionPerformed(e);
				} catch (RegistroUsuarioClaseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRegistrar.setBounds(76, 455, 117, 25);
		contentPane.add(btnRegistrar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(235, 455, 117, 25);
		contentPane.add(btnCancelar);
		
		comboBoxInstituto = new JComboBox();
		comboBoxInstituto.setBounds(10, 48, 328, 24);
		contentPane.add(comboBoxInstituto);
		
		comboBoxActividad = new JComboBox();
		comboBoxActividad.setBounds(10, 123, 328, 24);
		contentPane.add(comboBoxActividad);
		
		JLabel lblNewLabel_1 = new JLabel("Actividad deportiva:");
		lblNewLabel_1.setBounds(10, 98, 162, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Institución:");
		lblNewLabel_2.setBounds(10, 23, 104, 15);
		contentPane.add(lblNewLabel_2);
		
		JButton btnVerDatosC = new JButton("Ver Datos de la Clase");
		btnVerDatosC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textInfoClase.setText("");
				
				//String datos = "INFO_DE_LA_CLASE_SELECCIONADA";
				DtClase dtc = iinst.selectClase((String)comboBoxInstituto.getSelectedItem(),(String)comboBoxActividad.getSelectedItem(),(String)comboBoxClase.getSelectedItem());
				//datos = datos + "\n\n" + dtc.toString();
				textInfoClase.setText(dtc.toString());
			}
		});
		btnVerDatosC.setBounds(394, 199, 155, 21);
		contentPane.add(btnVerDatosC);
		

		
		//instituto
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
		
		////actvidad
		
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
		
		
		
		
		
		
		// socio
		
		comboBoxSocio.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				comboBoxSocio.removeAllItems();
				HashSet<String> socios = new HashSet<>(iusu.listarSocios());
 
				//ArrayList<String> socios = (ArrayList<String>) iusu.listarSocios();
				if(socios.isEmpty()) {
					comboBoxSocio.addItem("<Sin socios ingresados >");
					comboBoxSocio.setSelectedItem("<Sin socios ingresados>");
				}else {
					comboBoxSocio.addItem("<Seleccionar socio>");
					comboBoxSocio.setSelectedItem("<Seleccionar socio>");
				}
				// miro si me trae algo
				for (String s : socios) {
					System.out.print(s);
				}
				
				for (String s : socios) {
					comboBoxSocio.addItem(s);
				}	
			
			}
			
			
		});

		//clase
		
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
	
	public void registroActionPerformed(ActionEvent e) throws RegistroUsuarioClaseException {
		LocalDateTime fechaHoraActual = LocalDateTime.now();
	    int dia = fechaHoraActual.getDayOfMonth();
	    int mes = fechaHoraActual.getMonthValue();
	    int anio = fechaHoraActual.getYear();
		DtFecha dtf = new DtFecha(dia, mes, anio);
		//System.out.print((String)comboBoxSocio.getSelectedItem()+ "\n");
		//System.out.print((String)comboBoxClase.getSelectedItem()+ "\n");
		
		//iusu.selecDatos((String) comboBoxInstituto.getSelectedItem(), (String) comboBoxActividad.getSelectedItem(), (String) comboBoxSocio.getSelectedItem(), (String) comboBoxClase.getSelectedItem(), dtf);
	
	
	if (checkFormulario()) {
        this.iusu.selecDatos((String) comboBoxInstituto.getSelectedItem(), (String) comboBoxActividad.getSelectedItem(), (String) comboBoxSocio.getSelectedItem(), (String) comboBoxClase.getSelectedItem(), dtf);
  	
		JOptionPane.showMessageDialog(this, "El Usuario se ha registrado con éxito a la clase", "Agregar Socio", JOptionPane.INFORMATION_MESSAGE);
       // limpiarFormulario();
        setVisible(false);
    }
		}



private boolean checkFormulario() {
    String nickname = (String) this.comboBoxSocio.getSelectedItem();
   // String email = this.textFieldEmail.getText();
   // if (nickname.isEmpty() || email.isEmpty()) {
    if (nickname.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar Usuario a clase",
                JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    return true;
}
}