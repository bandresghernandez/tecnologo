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
import logica.CUsuario2;

public class IngresarUsuario2 extends JInternalFrame {

    private JTextField textFieldNickname;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldEmail;
    private JTextField textFieldDia;
    private JTextField textFieldMes;
    private JTextField textFieldAnio;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IngresarUsuario2 frame = new IngresarUsuario2();
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
    public IngresarUsuario2() {
        setTitle("Ingresar Usuario");

        setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNickname = new JLabel("Nickname:");
        lblNickname.setBounds(30, 30, 100, 20);
        contentPane.add(lblNickname);

        textFieldNickname = new JTextField();
        textFieldNickname.setBounds(140, 30, 200, 20);
        contentPane.add(textFieldNickname);
        textFieldNickname.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 60, 100, 20);
        contentPane.add(lblNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(140, 60, 200, 20);
        contentPane.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(30, 90, 100, 20);
        contentPane.add(lblApellido);

        textFieldApellido = new JTextField();
        textFieldApellido.setBounds(140, 90, 200, 20);
        contentPane.add(textFieldApellido);
        textFieldApellido.setColumns(10);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 120, 100, 20);
        contentPane.add(lblEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(140, 120, 200, 20);
        contentPane.add(textFieldEmail);
        textFieldEmail.setColumns(10);

        JLabel lblFecha = new JLabel("Fecha de Nacimiento:");
        lblFecha.setBounds(69, 152, 179, 20);
        contentPane.add(lblFecha);

        textFieldDia = new JTextField();
        textFieldDia.setBounds(235, 151, 40, 20);
        contentPane.add(textFieldDia);
        textFieldDia.setColumns(10);

        textFieldMes = new JTextField();
        textFieldMes.setBounds(287, 152, 40, 20);
        contentPane.add(textFieldMes);
        textFieldMes.setColumns(10);

        textFieldAnio = new JTextField();
        textFieldAnio.setBounds(339, 153, 34, 20);
        contentPane.add(textFieldAnio);
        textFieldAnio.setColumns(10);

        JButton btnAceptar = new JButton("ACEPTAR");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nickname = textFieldNickname.getText();
                String nombre = textFieldNombre.getText();
                String apellido = textFieldApellido.getText();
                String email = textFieldEmail.getText();
                int dia = Integer.parseInt(textFieldDia.getText());
                int mes = Integer.parseInt(textFieldMes.getText());
                int anio = Integer.parseInt(textFieldAnio.getText());

        		
             
          
                // Crear una instancia de la clase CUsuario y llamar al método ingresarSocio con los datos ingresados
                CUsuario2 CUsuario2 = new CUsuario2();
                CUsuario2.ingresarSocio(nickname, nombre, apellido, email, new DtFecha(dia, mes, anio));
                
                
               CUsuario2.listarSocio();

               JFrame frame = new JFrame("Mensaje de Éxito");

               // Mostrar un cuadro de diálogo con el mensaje
               JOptionPane.showMessageDialog(frame, "Socio ingresado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                // Mostrar mensaje de éxito o realizar otras acciones
             //  System.out.println("Socio ingresado exitosamente");

                
                // Cerrar la ventana
                dispose();
            }
        });
        btnAceptar.setBounds(88, 190, 121, 23);
        contentPane.add(btnAceptar);

        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar acciones para el botón CANCELAR si lo necesitas
                dispose(); // Cierra la ventana
            }
        });
        btnCancelar.setBounds(231, 190, 129, 23);
        contentPane.add(btnCancelar);
        
        JLabel lblAltaUsuario = new JLabel("Alta Usuario");
        lblAltaUsuario.setBounds(160, 0, 140, 15);
        contentPane.add(lblAltaUsuario);
        
          
    }
    
	
	private boolean checkFormulario() {
        String id = this.textFieldNickname.getSelectedText().toString();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Agregar Inscripcion",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(id);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un numero", "Agregar Inscripción",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    
    
    
}
