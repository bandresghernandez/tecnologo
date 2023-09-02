package presentacion;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.ActividadDeportiva;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class IngresarInstitucionDeportiva extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextArea textAreaDescripcion;
	private JTextField textFieldUrl;
	private ArrayList<ActividadDeportiva> actividades;
	private JTextField textFieldActividadDeportiva;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public IngresarInstitucionDeportiva() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(29, 28, 80, 20);
		contentPane.add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(120, 29, 300, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setBounds(12, 63, 97, 20);
		contentPane.add(lblDescripcion);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 63, 300, 80);
		contentPane.add(scrollPane);

		textAreaDescripcion = new JTextArea();
		scrollPane.setViewportView(textAreaDescripcion);

		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setBounds(29, 154, 80, 20);
		contentPane.add(lblUrl);

		textFieldUrl = new JTextField();
		textFieldUrl.setBounds(120, 155, 300, 20);
		contentPane.add(textFieldUrl);
		textFieldUrl.setColumns(10);

		JLabel lblActividadDeportiva = new JLabel("Actividad Deportiva:");
		lblActividadDeportiva.setBounds(12, 192, 200, 20);
		contentPane.add(lblActividadDeportiva);

		textFieldActividadDeportiva = new JTextField();
		textFieldActividadDeportiva.setBounds(210, 193, 200, 20);
		contentPane.add(textFieldActividadDeportiva);
		textFieldActividadDeportiva.setColumns(10);

		actividades = new ArrayList<ActividadDeportiva>();

		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textFieldNombre.getText();
				String descripcion = textAreaDescripcion.getText();
				String url = textFieldUrl.getText();
				
				// Aquí puedes realizar acciones con los datos ingresados, como crear la institución deportiva
				// y agregar las actividades deportivas a la lista
				
				// Cerrar la ventana
				dispose();
			}
		});
		btnAceptar.setBounds(149, 230, 123, 23);
		contentPane.add(btnAceptar);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cerrar la ventana
				dispose();
			}
		});
		btnCancelar.setBounds(284, 230, 146, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblInstDeportiva = new JLabel("Alta Inst. Deportiva");
		lblInstDeportiva.setBounds(149, 2, 225, 15);
		contentPane.add(lblInstDeportiva);
	}
}
