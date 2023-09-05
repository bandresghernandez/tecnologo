package presentacion;

import java.awt.EventQueue;

public class IngresarRegistro extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	//Variables 
	private ICUsuario iusu;

	//private ICInstitucion iinst;
	private JPanel contentPane;
	private JTextField textFieldFECHA;
	private JSpinner spinnerDia;
	private JSpinner spinnerMes;
	private JSpinner spinnerAnio;

	/**
	 * Create the frame.
	 */
	public IngresarRegistro(ICUsuario iusu) {
		this.iusu=iusu;

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
		
		JComboBox comboBoxSocio = new JComboBox();			
		comboBoxSocio.setBounds(10, 57, 328, 22);	
		contentPane.add(comboBoxSocio);
	
		
	
		JComboBox comboBoxClase = new JComboBox();
		comboBoxClase.setBounds(10, 132, 328, 22);
		comboBoxClase.addItem("<Seleccionar Clase>");
		comboBoxClase.setEnabled(true);
		contentPane.add(comboBoxClase);
		
		JLabel lblComboSocio = new JLabel("Socios");
		lblComboSocio.setBounds(10, 32, 194, 14);
		contentPane.add(lblComboSocio);
		
		JLabel lblComboClase = new JLabel("Clases");
		lblComboClase.setBounds(10, 106, 183, 14);
		contentPane.add(lblComboClase);
		
		JTextPane textInfoClase = new JTextPane();
		textInfoClase.setEnabled(false);
		textInfoClase.setText("Detalles de las clase . . .");
		textInfoClase.setBounds(23, 291, 328, 104);
		contentPane.add(textInfoClase);
		
		JTextPane textInfoActividad = new JTextPane();
		textInfoActividad.setEnabled(false);
		textInfoActividad.setText("Detalle de socio. . .");
		textInfoActividad.setBounds(385, 32, 372, 314);
		contentPane.add(textInfoActividad);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	

			}
		});
		btnRegistrar.setBounds(84, 455, 117, 25);
		contentPane.add(btnRegistrar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(235, 455, 117, 25);
		contentPane.add(btnCancelar);

		spinnerDia = new JSpinner();
		spinnerDia.setBounds(116, 193, 40, 20);
		contentPane.add(spinnerDia);

		spinnerMes = new JSpinner();
		spinnerMes.setBounds(168, 193, 40, 20);
		contentPane.add(spinnerMes);

		spinnerAnio = new JSpinner();
		spinnerAnio.setBounds(220, 193, 41, 20);
		contentPane.add(spinnerAnio);
		
		
		
		
		JLabel lblNewLabel = new JLabel("Fecha:");
		lblNewLabel.setBounds(58, 195, 70, 15);
		contentPane.add(lblNewLabel);
		
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

		
		
		comboBoxClase.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				comboBoxClase.removeAllItems();
				HashSet<String> clases = new HashSet<>(iusu.listarSocios());
 
				//ArrayList<String> socios = (ArrayList<String>) iusu.listarSocios();
				if(clases.isEmpty()) {
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
