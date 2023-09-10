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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
	private JTextField textFieldActividad;
	
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
		setBounds(100, 100, 470, 324);
		getContentPane().setLayout(null);
		
		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setBounds(23, 10, 84, 15);
		getContentPane().add(lblNickname);
		
		JButton btnVerDatos = new JButton("Ver Datos");
		btnVerDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaUsuarioAceptarActionPerformed(e);
			}
		});
		btnVerDatos.setBounds(284, 35, 125, 21);
		getContentPane().add(btnVerDatos);
		
		JLabel lblnombre = new JLabel("Nombre:");
		lblnombre.setBounds(23, 37, 70, 13);
		getContentPane().add(lblnombre);
		
		JLabel lblapellido = new JLabel("Apellido:");
		lblapellido.setBounds(23, 64, 70, 13);
		getContentPane().add(lblapellido);
		
		JLabel lblemail = new JLabel("Email:");
		lblemail.setBounds(23, 89, 45, 13);
		getContentPane().add(lblemail);
		
		JLabel lblFechNac = new JLabel("Fecha Nac:");
		lblFechNac.setBounds(23, 127, 89, 13);
		getContentPane().add(lblFechNac);
		
		JLabel lblclasesR = new JLabel("Clases Registradas / Dictadas");
		lblclasesR.setBounds(12, 152, 239, 38);
		getContentPane().add(lblclasesR);
		
		JLabel lblactividadesDepAsoc = new JLabel("Actividad Deportiva:");
		lblactividadesDepAsoc.setBounds(240, 192, 208, 13);
		getContentPane().add(lblactividadesDepAsoc);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(284, 66, 125, 21);
		getContentPane().add(btnCancelar);
		
		textFieldNomb = new JTextField();
		textFieldNomb.setBounds(114, 35, 111, 21);
		getContentPane().add(textFieldNomb);
		textFieldNomb.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(114, 89, 111, 21);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(112, 60, 113, 21);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldAnio = new JTextField();
		textFieldAnio.setBounds(195, 124, 27, 19);
		getContentPane().add(textFieldAnio);
		textFieldAnio.setColumns(10);
		
		textFieldDia = new JTextField();
		textFieldDia.setColumns(10);
		textFieldDia.setBounds(114, 124, 27, 19);
		getContentPane().add(textFieldDia);
		
		textFieldMes = new JTextField();
		textFieldMes.setColumns(10);
		textFieldMes.setBounds(153, 124, 27, 19);
		getContentPane().add(textFieldMes);
		
		comboBoxNickname = new JComboBox();
		comboBoxNickname.setBounds(111, 8, 91, 18);
		getContentPane().add(comboBoxNickname);
		
		comboBoxClasesR = new JComboBox();
		comboBoxClasesR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldActividad.setText(icon.getActividad((String)comboBoxNickname.getSelectedItem(), (String)comboBoxClasesR.getSelectedItem() ));
			}
		});
		/*comboBoxClasesR.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldActividad.setText(icon.getActividad((String)comboBoxNickname.getSelectedItem(), (String)comboBoxClasesR.getSelectedItem() ));
			}
		});*/
		comboBoxClasesR.setBounds(240, 161, 158, 21);
		getContentPane().add(comboBoxClasesR);
		
		textFieldActividad = new JTextField();
		textFieldActividad.setBounds(242, 217, 156, 19);
		getContentPane().add(textFieldActividad);
		textFieldActividad.setColumns(10);
		
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
        	
        	
        	textFieldDia.setText(Integer.toString(dtu.getFechaNac().getDia()));
        	textFieldMes.setText(Integer.toString(dtu.getFechaNac().getMes()));
        	textFieldAnio.setText(Integer.toString(dtu.getFechaNac().getAnio()));
        	// textFieldDia ES STRING PASAR A INT COMO SE HACE? textFieldDia.setText(dtu.getFechaNac().getDia());
            //String strClasesD = this.comboBoxClasesR.getSelectedItem().toString();
            actualizarComboBoxR();
            }
       	
		
	
		
		
			 public void iniciarlizarComboBoxes() {
				DefaultComboBoxModel<String> modelclases = new DefaultComboBoxModel<String>(icon.listarUsuario());
				comboBoxNickname.setModel(modelclases);//nickname Usuario
		
			}	
			 
			public void actualizarComboBoxR() {
				DefaultComboBoxModel<String> modelclases3 = new DefaultComboBoxModel<String>(icon.devolverClases((String) comboBoxNickname.getSelectedItem()));
				comboBoxClasesR.setModel(modelclases3);
			}
			 
			 
			 
			 
			 
			 
}
