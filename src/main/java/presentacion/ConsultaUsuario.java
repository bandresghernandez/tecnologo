package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.ICUsuario;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import datatypes.DtFecha;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaUsuario extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	private static final long serialVersionUID = 1L;
	private ICUsuario icon; 
	private JTextField textFieldNomb;
	private JTextField textFieldEmail;
	private JTextField textFieldApellido;
	private JTextField textFieldAnio;
	private JTextField textFieldDia;
	private JTextField textFieldMes;
	private JComboBox<String> comboBoxNickname;
	private JComboBox<String> comboBoxClasesR;
	private JComboBox<String> comboBoxClasesD;
	
	/**
	 * Create the frame.
	 */
	public ConsultaUsuario(ICUsuario icon ) {
		this.icon = icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Ver Consulta de Usuario");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(37, 10, 70, 15);
		getContentPane().add(lblNickname);
		
		JButton btnVerDatos = new JButton("Ver Datos");
		btnVerDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaUsuarioAceptarActionPerformed(e);
			}
		});
		btnVerDatos.setBounds(311, 35, 85, 21);
		getContentPane().add(btnVerDatos);
		
		JLabel lblnombre = new JLabel("Nombre");
		lblnombre.setBounds(37, 43, 45, 13);
		getContentPane().add(lblnombre);
		
		JLabel lblapellido = new JLabel("Apellido");
		lblapellido.setBounds(37, 66, 45, 13);
		getContentPane().add(lblapellido);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setBounds(37, 89, 45, 13);
		getContentPane().add(lblemail);
		
		JLabel lblFechNac = new JLabel("Fecha Nacimiento");
		lblFechNac.setBounds(37, 112, 89, 13);
		getContentPane().add(lblFechNac);
		
		JLabel lblSOCIO = new JLabel("SOCIO :");
		lblSOCIO.setBounds(37, 151, 45, 13);
		getContentPane().add(lblSOCIO);
		
		JLabel lblclasesR = new JLabel("Clases Registradas");
		lblclasesR.setBounds(92, 151, 97, 13);
		getContentPane().add(lblclasesR);
		
		JLabel lblprofesor = new JLabel("PROFESOR :");
		lblprofesor.setBounds(38, 191, 58, 15);
		getContentPane().add(lblprofesor);
		
		JLabel lblClasesDic = new JLabel("Clases Dictadas");
		lblClasesDic.setBounds(111, 192, 97, 13);
		getContentPane().add(lblClasesDic);
		
		JLabel lblactividadesDepAsoc = new JLabel("Actividades Deportivas Asociadas");
		lblactividadesDepAsoc.setBounds(218, 192, 161, 13);
		getContentPane().add(lblactividadesDepAsoc);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(311, 66, 85, 21);
		getContentPane().add(btnCancelar);
		
		textFieldNomb = new JTextField();
		textFieldNomb.setBounds(81, 43, 79, 13);
		getContentPane().add(textFieldNomb);
		textFieldNomb.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(79, 89, 111, 13);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(81, 66, 96, 15);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldAnio = new JTextField();
		textFieldAnio.setBounds(207, 109, 27, 19);
		getContentPane().add(textFieldAnio);
		textFieldAnio.setColumns(10);
		
		textFieldDia = new JTextField();
		textFieldDia.setColumns(10);
		textFieldDia.setBounds(133, 109, 27, 19);
		getContentPane().add(textFieldDia);
		
		textFieldMes = new JTextField();
		textFieldMes.setColumns(10);
		textFieldMes.setBounds(170, 109, 27, 19);
		getContentPane().add(textFieldMes);
		
		 comboBoxNickname = new JComboBox();
		comboBoxNickname.setBounds(98, 7, 91, 18);
		getContentPane().add(comboBoxNickname);
		
		JComboBox comboBoxClasesR = new JComboBox();
		comboBoxClasesR.setBounds(180, 153, 89, 15);
		getContentPane().add(comboBoxClasesR);
		
		JComboBox comboBoxClasesD = new JComboBox();
		comboBoxClasesD.setBounds(111, 211, 78, 15);
		getContentPane().add(comboBoxClasesD);
		
		JComboBox comboBoxActividadesAsoc = new JComboBox();
		comboBoxActividadesAsoc.setBounds(216, 211, 142, 15);
		getContentPane().add(comboBoxActividadesAsoc);
		
		setBounds(100, 100, 450, 300);

	}
	protected void consultaUsuarioAceptarActionPerformed(ActionEvent arg0){
		String strNick = this.comboBoxNickname.getSelectedItem().toString();
		//System.out.println(strNick);
		DtUsuario dtu;
		DtSocio dtso;
		DtProfesor dtprof;
		
		
		
        	dtu = this.icon.obtenerUsuario(strNick);
        	textFieldNomb.setText(dtu.getNombre());
        	textFieldApellido.setText(dtu.getApellido());
        	textFieldEmail.setText(dtu.getEmail());
        	
        	
        	// textFieldDia ES STRING PASAR A INT COMO SE HACE? textFieldDia.setText(dtu.getFechaNac().getDia());
        	
            if (dtu instanceof DtSocio) {
            	String strClasesR = this.comboBoxClasesR.getSelectedItem().toString();
            }else if (dtu instanceof DtProfesor) {
            	String strClasesD = this.comboBoxClasesD.getSelectedItem().toString();
            }
            
            
            }
       
	
		
		
			 public void iniciarlizarComboBoxes() {
					
				 DefaultComboBoxModel<String> modelclases = new DefaultComboBoxModel<String>(icon.listarUsuario());
				 comboBoxNickname.setModel(modelclases);//nickname Usuario
				 /*DefaultComboBoxModel<String> modelclases = new DefaultComboBoxModel<String>(icon.listarProfesor());
					comboBoxClasesD.setModel(modelclases);
					DefaultComboBoxModel<String> modelclases = new DefaultComboBoxModel<String>(icon.listarSocios());
					comboBoxClasesR.setModel(modelclases);*/
			}	
		
	
}
