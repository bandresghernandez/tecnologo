package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class IngresarActividadDeportiva2 extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextArea textAreaDescripcion;
	private JTextField textFieldDuracion;
	private JSpinner spinnerDia;
	private JSpinner spinnerMes;
	private JSpinner spinnerAnio;
	private JTextField textFieldCosto;
	private JTextField textFieldClase;
	private ArrayList<Clase> clases;

	/**
	 * Create the frame.
	 */
	public IngresarActividadDeportiva2() {
		setClosable(true);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 450);
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

		JLabel lblDuracion = new JLabel("Duración:");
		lblDuracion.setBounds(29, 154, 80, 20);
		contentPane.add(lblDuracion);

		textFieldDuracion = new JTextField();
		textFieldDuracion.setBounds(120, 155, 40, 20);
		contentPane.add(textFieldDuracion);
		textFieldDuracion.setColumns(10);

		JLabel lblFechaReg = new JLabel("Fecha de Registro:");
		lblFechaReg.setBounds(12, 192, 176, 20);
		contentPane.add(lblFechaReg);

		spinnerDia = new JSpinner();
		spinnerDia.setBounds(206, 193, 40, 20);
		contentPane.add(spinnerDia);

		spinnerMes = new JSpinner();
		spinnerMes.setBounds(258, 193, 40, 20);
		contentPane.add(spinnerMes);

		spinnerAnio = new JSpinner();
		spinnerAnio.setBounds(310, 193, 60, 20);
		contentPane.add(spinnerAnio);

		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setBounds(29, 230, 80, 20);
		contentPane.add(lblCosto);

		textFieldCosto = new JTextField();
		textFieldCosto.setBounds(120, 231, 124, 20);
		contentPane.add(textFieldCosto);
		textFieldCosto.setColumns(10);

		JLabel lblClase = new JLabel("Clase:");
		lblClase.setBounds(29, 270, 80, 20);
		contentPane.add(lblClase);

		textFieldClase = new JTextField();
		textFieldClase.setBounds(120, 271, 124, 20);
		contentPane.add(textFieldClase);

		clases = new ArrayList<Clase>();

		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textFieldNombre.getText();
				String descripcion = textAreaDescripcion.getText();
				int duracion = Integer.parseInt(textFieldDuracion.getText());
				int dia = (int) spinnerDia.getValue();
				int mes = (int) spinnerMes.getValue();
				int anio = (int) spinnerAnio.getValue();
				String fechaReg = dia + "/" + mes + "/" + anio;
				int costo = Integer.parseInt(textFieldCosto.getText());
				String clase = textFieldClase.getText();

				// Aquí puedes realizar acciones con los datos ingresados

				dispose();
			}
		});
		btnAceptar.setBounds(210, 320, 100, 23);
		contentPane.add(btnAceptar);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(310, 320, 120, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblActividadDeportiva = new JLabel("Alta Actividad Deportiva");
		lblActividadDeportiva.setBounds(136, 0, 251, 15);
		contentPane.add(lblActividadDeportiva);
	}
}
