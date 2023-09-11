package presentacion;

 //import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;

//import logica.ActividadDeportiva;
import interfaces.ICInstitucion;
import excepciones.InstitucionRepetidaExcepcion;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.util.ArrayList;

public class IngresarInstitucionDeportiva extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextArea textAreaDescripcion;
	private JTextField textFieldUrl;
	//private ArrayList<ActividadDeportiva> actividades;
	//private JTextField textFieldActividadDeportiva;
	private ICInstitucion iinst;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresarInstitucionDeportiva frame = new IngresarInstitucionDeportiva();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the frame.
	 */
	public IngresarInstitucionDeportiva(ICInstitucion iinst) {
		this.iinst=iinst;
		
		setResizable(true);//permite cambiar el tamaño del jframe
        setIconifiable(true);//permite poner iconos
        setMaximizable(true);//permite maximizar y minimizar el jframe
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// se oculta jframe en lugar de cerrarse
        setClosable(true);// permite que el usuario cierre la ventana
        setTitle("Alta de una Institucion");//setteo el titulo
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 28, 80, 20);
		contentPane.add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(120, 29, 225, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setBounds(12, 61, 97, 20);
		contentPane.add(lblDescripcion);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 63, 300, 80);
		contentPane.add(scrollPane);

		textAreaDescripcion = new JTextArea();
		scrollPane.setViewportView(textAreaDescripcion);

		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setBounds(55, 154, 80, 20);
		contentPane.add(lblUrl);

		textFieldUrl = new JTextField();
		textFieldUrl.setBounds(120, 155, 225, 20);
		contentPane.add(textFieldUrl);
		textFieldUrl.setColumns(10);

		//actividades = new ArrayList<ActividadDeportiva>();

		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarInstitucionAceptarActionPerformed(e);
				//dispose();
			}
		});
		btnAceptar.setBounds(149, 230, 123, 23);
		contentPane.add(btnAceptar);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarInstitucionCancelarActionPerformed(e);
				//dispose();
			}
		});
		btnCancelar.setBounds(284, 230, 146, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblInstDeportiva = new JLabel("Alta Institución deportiva");
		lblInstDeportiva.setBounds(149, 2, 225, 15);
		contentPane.add(lblInstDeportiva);
	}
	
	
	protected void agregarInstitucionAceptarActionPerformed(ActionEvent arg0) {
		String nombre = textFieldNombre.getText();
		String descripcion = textAreaDescripcion.getText();
		String url = textFieldUrl.getText();
		
		 if (checkFormulario()) {
	             try {
	            	this.iinst.altaInstitucionDeportiva(nombre,descripcion,url);
	                JOptionPane.showMessageDialog(this, "La institución se ha creado con éxito", "Agregar Institución",
	                        JOptionPane.INFORMATION_MESSAGE);
	            } catch (InstitucionRepetidaExcepcion e) {
	                JOptionPane.showMessageDialog(this, e.getMessage(), "Agregar Institución", JOptionPane.ERROR_MESSAGE);
	            }
	             
	        }
	 limpiarFormulario();
	 setVisible(false);

	}
	

	protected void agregarInstitucionCancelarActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
        setVisible(false);
	}
	
	private boolean checkFormulario() {
        String nombre = this.textFieldNombre.getText();
        String desc = this.textAreaDescripcion.getText();
        String url = this.textFieldUrl.getText();
        if (nombre.isEmpty() || desc.isEmpty() || url.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Agregar Institucion",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
	
	private void limpiarFormulario() {
        textFieldNombre.setText("");
        textAreaDescripcion.setText("");
        textFieldUrl.setText("");
 }
}
