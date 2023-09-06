package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import logica.Clase;
import datatypes.DtFecha;
import excepciones.ActividadDeportivaRepetidaExcepcion;
import interfaces.ICInstitucion;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class IngresarActividadDeportiva extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private ICInstitucion iinst;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextArea textAreaDescripcion;
	private JTextField textFieldDuracion;
	private JSpinner spinnerDia;
	private JSpinner spinnerMes;
	private JSpinner spinnerAnio;
	private JTextField textFieldCosto;
	private JComboBox<String> comboBoxInst;
	private ArrayList<Clase> clases;

	/**
	 * Create the frame.
	 * @param iinst 
	 */
	public IngresarActividadDeportiva(ICInstitucion icinst) {
		this.iinst = icinst;
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(29, 103, 80, 20);
		contentPane.add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(119, 103, 300, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setBounds(29, 154, 97, 20);
		contentPane.add(lblDescripcion);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 135, 300, 80);
		contentPane.add(scrollPane);

		JLabel lblDuracion = new JLabel("Duración:");
		lblDuracion.setBounds(29, 226, 80, 20);
		contentPane.add(lblDuracion);

		textFieldDuracion = new JTextField();
		textFieldDuracion.setBounds(120, 226, 40, 20);
		contentPane.add(textFieldDuracion);
		textFieldDuracion.setColumns(10);

		JLabel lblFechaReg = new JLabel("Fecha de Registro:");
		lblFechaReg.setBounds(29, 257, 150, 20);
		contentPane.add(lblFechaReg);

		spinnerDia = new JSpinner();
		spinnerDia.setBounds(206, 257, 40, 20);
		contentPane.add(spinnerDia);

		spinnerMes = new JSpinner();
		spinnerMes.setBounds(256, 257, 40, 20);
		contentPane.add(spinnerMes);

		spinnerAnio = new JSpinner();
		spinnerAnio.setBounds(306, 257, 60, 20);
		contentPane.add(spinnerAnio);

		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setBounds(29, 288, 80, 20);
		contentPane.add(lblCosto);

		textFieldCosto = new JTextField();
		textFieldCosto.setBounds(122, 288, 124, 20);
		contentPane.add(textFieldCosto);
		textFieldCosto.setColumns(10);
		
		JLabel lblActividadDeportiva = new JLabel("Alta Actividad Deportiva");
		lblActividadDeportiva.setBounds(136, 0, 251, 15);
		contentPane.add(lblActividadDeportiva);
		
		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBounds(120, 137, 298, 78);
		contentPane.add(textAreaDescripcion);
				
		JLabel lblNewLabel = new JLabel("Institucion:");
		lblNewLabel.setBounds(29, 78, 80, 14);
		contentPane.add(lblNewLabel);
		
		
		comboBoxInst = new JComboBox<String>();
		comboBoxInst.setBounds(119, 70, 127, 22);
		getContentPane().add(comboBoxInst);

		clases = new ArrayList<Clase>();

		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaActividadDeportivaActionPerformed(e);
			}
		});
		btnAceptar.setBounds(210, 320, 100, 23);
		contentPane.add(btnAceptar);


				//nw
		comboBoxInst.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				comboBoxInst.removeAllItems();
				HashSet<String> instituciones = new HashSet<>(iinst.listarInstitucionDeportiva());

				//ArrayList<String> socios = (ArrayList<String>) iusu.listarSocios();
				if(instituciones.isEmpty()) {
					comboBoxInst.addItem("<Sin instituciones ingresadas >");
					comboBoxInst.setSelectedItem("<Sin instituciones ingresadas>");
				}else {
					comboBoxInst.addItem("<Seleccionar intitucion>");
					comboBoxInst.setSelectedItem("<Sin instituciones ingresadas>");
				}
				// miro si me trae algo
				for (String i : instituciones) {
					System.out.print(i);
				}
				
				for (String i : instituciones) {
					comboBoxInst.addItem(i);
				}	
			
			}
		});
		


		


		

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(310, 320, 120, 23);
		contentPane.add(btnCancelar);
	
	}
	
	public void inicializarComboBox() {
		DefaultComboBoxModel<String> modelInst = new DefaultComboBoxModel<String>(this.iinst.listarInstitucion());
		comboBoxInst.addItem("Actividad 1");
		comboBoxInst.setModel(modelInst);
	}
	
	private boolean checkFormulario() {
		String nombre = textFieldNombre.getText();
		String descripcion = textAreaDescripcion.getText();
		String duracion = textFieldDuracion.getText();
		String dia = (String) spinnerDia.getValue();
		String mes = (String) spinnerMes.getValue();
		String anio = (String) spinnerAnio.getValue();
		String costo = textFieldCosto.getText();
		if(nombre.isEmpty() || descripcion.isEmpty() || duracion.isEmpty() || dia.isEmpty() || mes.isEmpty() || anio.isEmpty() || costo.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			Integer.parseInt(duracion);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "La duracion debe ser un numero", "Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			Float.parseFloat(costo);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "El costo debe ser un numero", "Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			Integer.parseInt(dia);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "El dia debe ser un numero", "Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			Integer.parseInt(mes);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "El mes debe ser un numero", "Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			Integer.parseInt(anio);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "El anio debe ser un numero", "Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void limpiarFormulario() {
		textFieldNombre.setText("");
		textAreaDescripcion.setText("");
		textFieldDuracion.setText("");
		spinnerDia.setValue(null);
		spinnerMes.setValue(null);
		spinnerAnio.setValue(null);
		textFieldCosto.setText("");
	}
	protected void altaActividadDeportivaActionPerformed(ActionEvent e) {
		String nombre_inst = (String) comboBoxInst.getSelectedItem();
		String nombre = textFieldNombre.getText();
		String descripcion = textAreaDescripcion.getText();
		int duracion = Integer.parseInt(textFieldDuracion.getText());
		int dia = (int) spinnerDia.getValue();
		int mes = (int) spinnerMes.getValue();
		int anio = (int) spinnerAnio.getValue();
		//String fechaReg = dia + "/" + mes + "/" + anio;
		DtFecha dtf = new DtFecha(dia, mes, anio);
		float costo = Float.parseFloat(textFieldCosto.getText());
		
		if(checkFormulario()) {
			try {
				iinst.altaActividadDeportiva(nombre_inst, nombre, descripcion, duracion, costo, dtf);
				JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Actividad Deportiva", JOptionPane.INFORMATION_MESSAGE);
			} catch (ActividadDeportivaRepetidaExcepcion e1){
				JOptionPane.showMessageDialog(this, e1.getMessage(), "Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
				}
			limpiarFormulario();
			setVisible(false);
		}
		dispose();
	}
	
	
	// Aquí puedes realizar acciones con los datos ingresados
}
