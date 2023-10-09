package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import excepciones.LoginExcepcion;
import interfaces.ICUsuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ICUsuario iusu;
	private JTextField textFieldNick;
	private JTextField textFieldPass;
	
	public Login(ICUsuario iusu) {
		this.iusu = iusu;
		
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nickname");
		lblNewLabel.setBounds(39, 87, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(39, 142, 58, 14);
		getContentPane().add(lblNewLabel_1);
		
		textFieldNick = new JTextField();
		textFieldNick.setBounds(107, 84, 86, 20);
		getContentPane().add(textFieldNick);
		textFieldNick.setColumns(10);
		
		textFieldPass = new JTextField();
		textFieldPass.setBounds(107, 139, 86, 20);
		getContentPane().add(textFieldPass);
		textFieldPass.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logear(iusu);
			}
		});
		btnAceptar.setBounds(104, 194, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(224, 194, 89, 23);
		getContentPane().add(btnCancelar);
	}

	protected void logear(ICUsuario iusu) {
		String nick = textFieldNick.getText();
		String pass = textFieldPass.getText();
		if (checkFormulario()) {
            try {
           	this.iusu.login(nick, pass);
               JOptionPane.showMessageDialog(this, "Se a logeado con exito", "Ingreso",
                       JOptionPane.INFORMATION_MESSAGE);
           } catch (LoginExcepcion e) {
               JOptionPane.showMessageDialog(this, e.getMessage(), "Ingreso", JOptionPane.ERROR_MESSAGE);
           }
            
       }
limpiarFormulario();
setVisible(false);
	}
	
	protected void loginCancelarActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
        setVisible(false);
	}
	
	private void limpiarFormulario() {
		textFieldNick.setText("");
        textFieldPass.setText("");
    }
	
	private boolean checkFormulario() {
        String nickname = this.textFieldNick.getText();
        String pass = this.textFieldPass.getText();
        if (nickname.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Agregar Usuario",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
}
