package presentacion;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import datatypes.DtFecha;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import excepciones.UsuarioEnUsoExcepcion;
import interfaces.ICInstitucion;
import interfaces.ICUsuario;
import logica.CUsuario;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import interfaces.ICUsuario;

public class IngresarUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private ICUsuario icon;
	private JTextField textFieldNickname;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldEmail;
    private JTextField textFieldDia;
    private JTextField textFieldMes;
    private JTextField textFieldAnio;
    private JTextField textFieldDescripcion;
    private JTextField textFieldBiografia;
    private JTextField textFieldSitioWeb;
    private JRadioButton rdbtnSocio;
    private JRadioButton rdbtnProfesor;
    
  
   /* public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IngresarUsuario frame = new IngresarUsuario();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public IngresarUsuario(ICUsuario icon) {
        this.icon=icon;
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
    	setClosable(true);
    	setTitle("Ingresar Usuario");
    	
    	setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNickname = new JLabel("Nickname:");
        lblNickname.setBounds(10, 70, 121, 20);
        contentPane.add(lblNickname);

        textFieldNickname = new JTextField();
        textFieldNickname.setBounds(104, 73, 151, 15);
        contentPane.add(textFieldNickname);
        textFieldNickname.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 89, 100, 20);
        contentPane.add(lblNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(104, 92, 151, 15);
        contentPane.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(10, 116, 100, 20);
        contentPane.add(lblApellido);

        textFieldApellido = new JTextField();
        textFieldApellido.setBounds(104, 121, 151, 15);
        contentPane.add(textFieldApellido);
        textFieldApellido.setColumns(10);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(10, 138, 100, 20);
        contentPane.add(lblEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(104, 141, 151, 15);
        contentPane.add(textFieldEmail);
        textFieldEmail.setColumns(10);

        JLabel lblFecha = new JLabel("Fecha Nacimiento:");
        lblFecha.setBounds(10, 167, 140, 20);
        contentPane.add(lblFecha);

        textFieldDia = new JTextField();
        textFieldDia.setBounds(142, 168, 40, 20);
        contentPane.add(textFieldDia);
        textFieldDia.setColumns(10);

        textFieldMes = new JTextField();
        textFieldMes.setBounds(194, 168, 40, 19);
        contentPane.add(textFieldMes);
        textFieldMes.setColumns(10);

        

        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar acciones para el botón CANCELAR si lo necesitas
                dispose(); // Cierra la ventana
            }
        });
        btnCancelar.setBounds(291, 88, 111, 23);
        contentPane.add(btnCancelar);
        
        JLabel lblAltaUsuario = new JLabel("Alta Usuario");
        lblAltaUsuario.setBounds(160, 0, 140, 15);
        contentPane.add(lblAltaUsuario);
        
        textFieldAnio = new JTextField();
        textFieldAnio.setColumns(10);
        textFieldAnio.setBounds(246, 168, 40, 20);
        contentPane.add(textFieldAnio);
        
        JLabel lblTipoU = new JLabel("Tipo Usuario");
        lblTipoU.setHorizontalAlignment(SwingConstants.TRAILING);
        lblTipoU.setBounds(0, 31, 92, 13);
        contentPane.add(lblTipoU);
        
       
        
       
        
   
        
        
        JLabel lblDescripcion = new JLabel("Descripción");
        lblDescripcion.setBounds(10, 204, 100, 13);
        contentPane.add(lblDescripcion);
        
        JLabel lblBiografia = new JLabel("Biografía");
        lblBiografia.setBounds(152, 204, 85, 13);
        contentPane.add(lblBiografia);
        
        JLabel lblSitioWeb = new JLabel("Sitio Web");
        lblSitioWeb.setBounds(281, 204, 72, 13);
        contentPane.add(lblSitioWeb);
        
      
        textFieldDescripcion = new JTextField();
        textFieldDescripcion.setEnabled(false);
        textFieldDescripcion.setBounds(10, 226, 100, 16);
        contentPane.add(textFieldDescripcion);
        textFieldDescripcion.setColumns(10);
        
        textFieldBiografia = new JTextField();
        textFieldBiografia.setEnabled(false);
        textFieldBiografia.setBounds(142, 225, 121, 19);
        contentPane.add(textFieldBiografia);
        textFieldBiografia.setColumns(10);
        
        textFieldSitioWeb = new JTextField();
        textFieldSitioWeb.setEnabled(false);
        textFieldSitioWeb.setBounds(273, 225, 129, 17);
        contentPane.add(textFieldSitioWeb);
        textFieldSitioWeb.setColumns(10);
        
        JButton btnAceptar = new JButton("ACEPTAR");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	agregarIngresarUsuarioAceptarActionPerformed(e);
   
            }
        });
        btnAceptar.setBounds(291, 43, 111, 23);
        contentPane.add(btnAceptar);
        
        rdbtnSocio = new JRadioButton("Socio");
        rdbtnSocio.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		rdbtnSocio.setSelected(true);
        		rdbtnProfesor.setSelected(false);
        		textFieldDescripcion.setText("");
				textFieldDescripcion.setEnabled(false);
				textFieldBiografia.setText("");
				textFieldBiografia.setEnabled(false);
				textFieldSitioWeb.setText("");
				textFieldSitioWeb.setEnabled(false);
        	}
        });
        rdbtnSocio.setSelected(true);
        textFieldDescripcion.setEnabled(false);
        textFieldBiografia.setEnabled(false);
        textFieldSitioWeb.setEnabled(false);
        
        rdbtnSocio.setBounds(98, 21, 103, 21);
        contentPane.add(rdbtnSocio);
        
        rdbtnProfesor = new JRadioButton("Profesor");
        rdbtnProfesor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		rdbtnSocio.setSelected(false);
        		rdbtnProfesor.setSelected(true);
        		textFieldDescripcion.setText("");
				textFieldDescripcion.setEnabled(true);
				textFieldBiografia.setText("");
				textFieldBiografia.setEnabled(true);
				textFieldSitioWeb.setText("");
				textFieldSitioWeb.setEnabled(true);
        	
        	}
        });
        rdbtnProfesor.setSelected(false);
        rdbtnProfesor.setBounds(98, 43, 103, 21);
        contentPane.add(rdbtnProfesor);
        
    }
    
    
    protected void agregarIngresarUsuarioAceptarActionPerformed(ActionEvent arg0) {
		//String nombre = this.textFieldNombre.getText();
       // String ci = this.textFieldCI.getText();
    	String nickname = textFieldNickname.getText();
        String nombre = textFieldNombre.getText();
        String apellido = textFieldApellido.getText();
        String email = textFieldEmail.getText();
        int dia = Integer.parseInt(textFieldDia.getText());
        int mes = Integer.parseInt(textFieldMes.getText());
        int anio = Integer.parseInt(textFieldAnio.getText());
        String descripcion = textFieldDescripcion.getText();
        String biografia = textFieldBiografia.getText();
        String sitioWeb = textFieldSitioWeb.getText();
        DtFecha fechaNac = new DtFecha(dia,mes,anio); 
        DtUsuario dtusuario=null;;
        
        
        if(rdbtnSocio.isSelected()) {
        dtusuario = new DtSocio(nickname,nombre,apellido,email,fechaNac);
        } else if(rdbtnProfesor.isSelected()) {
        	dtusuario = new DtProfesor(nickname,nombre,apellido,email,fechaNac,descripcion,biografia,sitioWeb);
        }
        
    	if (checkFormulario()) {
            try {
                this.icon.agregarUsuario(dtusuario);
                JOptionPane.showMessageDialog(this, "El Usuario se ha creado con éxito", "Agregar Socio", JOptionPane.INFORMATION_MESSAGE);
            } catch (UsuarioEnUsoExcepcion e) {
                //JOptionPane.showMessageDialog(this, e.getMessage(), "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
            }
            limpiarFormulario();
            setVisible(false);
        }
		
	} 
	
	
	
	private boolean checkFormulario() {
        String nickname = this.textFieldNickname.getText();
        String email = this.textFieldEmail.getText();
        if (nickname.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Agregar Usuario",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
	
	private void limpiarFormulario() {
		textFieldNickname.setText("");
        textFieldNombre.setText("");
        textFieldApellido.setText("");
        textFieldEmail.setText("");
        textFieldDia.setText("");
        textFieldMes.setText("");
        textFieldAnio.setText("");
        textFieldDescripcion.setText("");
        textFieldBiografia.setText("");
        textFieldSitioWeb.setText("");
       
 }
}
