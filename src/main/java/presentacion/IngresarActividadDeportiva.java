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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.HashSet;

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

        SpinnerNumberModel diaModel = new SpinnerNumberModel(1, 1, 31, 1); 
        SpinnerNumberModel mesModel = new SpinnerNumberModel(1, 1, 12, 1);
        SpinnerNumberModel anioModel = new SpinnerNumberModel(2023, 0, Integer.MAX_VALUE, 1); 

        spinnerDia = new JSpinner(diaModel);
        spinnerDia.setBounds(206, 257, 40, 20);
        contentPane.add(spinnerDia);

        spinnerMes = new JSpinner(mesModel);
        spinnerMes.setBounds(256, 257, 40, 20);
        contentPane.add(spinnerMes);

        spinnerAnio = new JSpinner(anioModel);
        spinnerAnio.setBounds(306, 257, 60, 20);
        contentPane.add(spinnerAnio);

		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setBounds(29, 288, 80, 20);
		contentPane.add(lblCosto);

		textFieldCosto = new JTextField();
		textFieldCosto.setBounds(122, 288, 85, 20);
		contentPane.add(textFieldCosto);
		textFieldCosto.setColumns(10);
		
		JLabel lblActividadDeportiva = new JLabel("Alta Actividad Deportiva");
		lblActividadDeportiva.setBounds(136, 0, 251, 15);
		contentPane.add(lblActividadDeportiva);
		
		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBounds(120, 137, 298, 78);
		contentPane.add(textAreaDescripcion);
				
		JLabel lblNewLabel = new JLabel("Institución:");
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

				if (instituciones.isEmpty()) {
				    comboBoxInst.addItem("<Sin instituciones ingresadas >");
				    comboBoxInst.setSelectedItem("<Sin instituciones ingresadas>");
				} else {
				    comboBoxInst.addItem("<Seleccionar intitucion>");
				    comboBoxInst.setSelectedItem("<Sin instituciones ingresadas>");
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
		DefaultComboBoxModel<String> modelInst = new DefaultComboBoxModel<String>();
		comboBoxInst.addItem("Actividad 1");
		comboBoxInst.setModel(modelInst);
	}
	
	private boolean checkFormulario() {
		// falta chequear la combo box
		String nombre = textFieldNombre.getText();
		String descripcion = textAreaDescripcion.getText();
		String duracion = textFieldDuracion.getText();
		String dia =  spinnerDia.getValue().toString();
		String mes =  spinnerMes.getValue().toString();
		String anio =  spinnerAnio.getValue().toString();
		String costo = textFieldCosto.getText();
		if(nombre.isEmpty() || descripcion.isEmpty() || duracion.isEmpty() || dia.isEmpty() || mes.isEmpty() || anio.isEmpty() || costo.isEmpty()) {
			System.out.print("\ntoy dentro\n");
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
		spinnerDia.setValue(0);
		spinnerMes.setValue(0);
		spinnerAnio.setValue(0);
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
				JOptionPane.showMessageDialog(this, "Se dió de alta la actividad", "Actividad Deportiva", JOptionPane.INFORMATION_MESSAGE);
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
