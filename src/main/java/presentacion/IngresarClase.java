package presentacion;


import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import datatypes.DtFecha;
import datatypes.DtHora;
import excepciones.ActividadDeportivaRepetidaExcepcion;
import excepciones.ClaseRepetidaExcepcion;
import interfaces.ICInstitucion;

import java.text.ParseException;
import java.util.HashSet;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class IngresarClase extends JInternalFrame {

	private ICInstitucion iinst;
    private JTextField nombreField;
    private JFormattedTextField fechaRefDiaField_1;
    private JTextField horaField;
    private JTextField urlField;
    private JFormattedTextField fechaRefDiaField; // Separate fields for day, month, and year
    private JFormattedTextField fechaRefMesField;
    private JFormattedTextField fechaRefAnioField;
    private JComboBox<String> actividadComboBox;
    private JComboBox<String> institucionComboBox;
    private JButton btnNewButton;
    private JTextField profeField;
    private JTextField fechaRefMesField_1;
    private JTextField fechaRefAnioField_1;
    private JTextField minutoField;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_4;
    private JLabel label_2;

    /*public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IngresarClase frame = new IngresarClase();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/

    public IngresarClase(ICInstitucion iinst) {
    	this.iinst = iinst;
        setTitle("Ingresar Clase");
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(null);

        JLabel lblNombre = new JLabel("Nombre clase:");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNombre.setBounds(26, 77, 109, 14);
        getContentPane().add(lblNombre);

        nombreField = new JTextField();
        nombreField.setBounds(166, 76, 150, 20);
        getContentPane().add(nombreField);
        nombreField.setColumns(10);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblFecha.setBounds(26, 124, 80, 14);
        getContentPane().add(lblFecha);

        fechaRefDiaField_1 = new JFormattedTextField(); // Assuming you've integrated DtFecha appropriately
        fechaRefDiaField_1.setBounds(166, 123, 40, 20);
        getContentPane().add(fechaRefDiaField_1);

        JLabel lblHoraInicio = new JLabel("Hora Inicio (hh:mm):");
        lblHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblHoraInicio.setBounds(26, 149, 144, 14);
        getContentPane().add(lblHoraInicio);

        horaField = new JTextField();
        horaField.setBounds(166, 148, 30, 20);
        getContentPane().add(horaField);

        JLabel lblURL = new JLabel("URL:");
        lblURL.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblURL.setBounds(26, 174, 80, 14);
        getContentPane().add(lblURL);

        urlField = new JTextField();
        urlField.setBounds(166, 173, 150, 20);
        getContentPane().add(urlField);
        urlField.setColumns(10);

        JLabel lblFechaRef = new JLabel("Fecha Ref (dd/mm/aaaa):");
        lblFechaRef.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblFechaRef.setBounds(12, 207, 181, 14);
        getContentPane().add(lblFechaRef);

        try {
            MaskFormatter dayMask = new MaskFormatter("##");
            MaskFormatter monthMask = new MaskFormatter("##");
            MaskFormatter yearMask = new MaskFormatter("####");

            fechaRefDiaField = new JFormattedTextField(dayMask);
            fechaRefMesField = new JFormattedTextField(monthMask);
            fechaRefAnioField = new JFormattedTextField(yearMask);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        fechaRefDiaField.setBounds(253, 205, 30, 20);
        fechaRefMesField.setBounds(211, 205, 30, 20);
        fechaRefAnioField.setBounds(295, 205, 40, 20);

        getContentPane().add(fechaRefDiaField);
        getContentPane().add(fechaRefMesField);
        getContentPane().add(fechaRefAnioField);

        JLabel lblActividadDeportiva = new JLabel("Actividad Deportiva:");
        lblActividadDeportiva.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblActividadDeportiva.setBounds(26, 54, 144, 14);
        getContentPane().add(lblActividadDeportiva);

        actividadComboBox = new JComboBox<String>();
        actividadComboBox.setBounds(166, 51, 150, 20);
        // Agregar un ActionListener al comboBoxA para manejar la selección
        /*actividadComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarActividadComboBox();
            }
        });*/
        getContentPane().add(actividadComboBox);

        JButton btnGuardar = new JButton("GUARDAR");
        btnGuardar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		altaClaseActionPerformed();
        	}
        });
        btnGuardar.setBounds(103, 241, 122, 23);
        getContentPane().add(btnGuardar);
        
        btnNewButton = new JButton("CANCELAR");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Cerrar la ventana
				dispose();
        	}
        });
        

		
        
        btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
        btnNewButton.setBounds(250, 240, 117, 25);
        getContentPane().add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("Institución:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(26, 29, 115, 14);
        getContentPane().add(lblNewLabel);
        
        institucionComboBox = new JComboBox<String>();
        institucionComboBox.setBounds(166, 25, 150, 22);
        getContentPane().add(institucionComboBox);
        
        JLabel lblNewLabel_1 = new JLabel("Nombre profesor:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(26, 102, 130, 14);
        getContentPane().add(lblNewLabel_1);
        
        profeField = new JTextField();
        profeField.setBounds(166, 101, 150, 20);
        getContentPane().add(profeField);
        profeField.setColumns(10);
        
        fechaRefMesField_1 = new JTextField();
        fechaRefMesField_1.setBounds(218, 122, 46, 20);
        getContentPane().add(fechaRefMesField_1);
        fechaRefMesField_1.setColumns(10);
        
        fechaRefAnioField_1 = new JTextField();
        fechaRefAnioField_1.setBounds(276, 122, 40, 20);
        getContentPane().add(fechaRefAnioField_1);
        fechaRefAnioField_1.setColumns(10);
        
        minutoField = new JTextField();
        minutoField.setBounds(208, 147, 33, 20);
        getContentPane().add(minutoField);
        minutoField.setColumns(10);
        
        label = new JLabel("");
        label.setBounds(246, 206, 21, 14);
        getContentPane().add(label);
        
        label_1 = new JLabel("/");
        label_1.setBounds(246, 194, 9, 40);
        getContentPane().add(label_1);
        
        label_4 = new JLabel("/");
        label_4.setBounds(289, 207, 70, 15);
        getContentPane().add(label_4);
        
        label_2 = new JLabel(":");
        label_2.setBounds(197, 149, 21, 15);
        getContentPane().add(label_2);
        
        JLabel label_3 = new JLabel("/");
        label_3.setBounds(270, 124, 70, 15);
        getContentPane().add(label_3);
        
        JLabel label_5 = new JLabel("/");
        label_5.setBounds(259, 124, 70, 15);
        getContentPane().add(label_5);
        
        JLabel label_5_1 = new JLabel("/");
        label_5_1.setBounds(208, 124, 70, 15);
        getContentPane().add(label_5_1);
        
        institucionComboBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				institucionComboBox.removeAllItems();
				HashSet<String> instituciones = new HashSet<>(iinst.listarInstitucionDeportiva());

				//ArrayList<String> socios = (ArrayList<String>) iusu.listarSocios();
				if(instituciones.isEmpty()) {
					institucionComboBox.addItem("<Sin instituciones ingresadas>");
					institucionComboBox.setSelectedItem("<Sin instituciones ingresadas>");
				}else {
					institucionComboBox.addItem("<Seleccionar intitucion>");
					institucionComboBox.setSelectedItem("<Sin instituciones>");
				}
				// miro si me trae algo
				for (String i : instituciones) {
					System.out.print(i);
				}
				
				for (String i : instituciones) {
					institucionComboBox.addItem(i);
				}	
			
			}
		});
        
        institucionComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED && institucionComboBox.getSelectedItem() != "<Sin instituciones ingresadas>" && institucionComboBox.getSelectedItem() != "<Seleccionar intitucion>") {
                    actualizarActividadComboBox((String) institucionComboBox.getSelectedItem());
                }
            }
        });
        
    }
    
    public void inicializarComboBox() {
		DefaultComboBoxModel<String> modelInst1 = new DefaultComboBoxModel<String>(this.iinst.listarInstitucion());
		institucionComboBox.setModel(modelInst1);
	}

    private class ActividadDeportiva {
        // Define properties and methods for the ActividadDeportiva class
    }
    
    private void altaClaseActionPerformed() {
    	String nombre_inst = (String) institucionComboBox.getSelectedItem();
    	String act = (String) actividadComboBox.getSelectedItem();
		String nombre = nombreField.getText();
		int dia =  Integer.parseInt(fechaRefDiaField_1.getText());
		int mes = Integer.parseInt(fechaRefMesField_1.getText());
		int anio = Integer.parseInt(fechaRefAnioField_1.getText());
		//String fechaReg = dia + "/" + mes + "/" + anio;
		DtFecha dtf = new DtFecha(dia, mes, anio); //fecha de la clase
		int hora = Integer.parseInt(horaField.getText());
		int minuto = Integer.parseInt(minutoField.getText());
		DtHora dth = new DtHora(hora, minuto);
		int dia2 = Integer.parseInt(fechaRefDiaField.getText());
		int mes2 = Integer.parseInt(fechaRefMesField.getText());
		int anio2 = Integer.parseInt(fechaRefAnioField.getText());
		DtFecha dtf2 = new DtFecha(dia2, mes2, anio2); //fecha de alta
		String profe = profeField.getText();
		String url = urlField.getText();
		if(checkFormulario()) {
			try {
				iinst.altaClase(nombre_inst, act, nombre, dtf, dth, profe, url, dtf2);
				JOptionPane.showMessageDialog(this, "Alta de clase satisfactoria", "Clase", JOptionPane.INFORMATION_MESSAGE);
			} catch (ClaseRepetidaExcepcion e1){
				JOptionPane.showMessageDialog(this, e1.getMessage(), "Clase", JOptionPane.ERROR_MESSAGE);
				}
			limpiarFormulario();
			setVisible(false);
		}
		dispose();
    }
    
    private void actualizarActividadComboBox(String nombre_inst) {
        actividadComboBox.removeAllItems();
        DefaultComboBoxModel<String> modelInst2 = new DefaultComboBoxModel<String>(this.iinst.listarActividades(nombre_inst));
        actividadComboBox.setModel(modelInst2);
    }
    
    private void limpiarFormulario() {
		institucionComboBox.setSelectedItem("<Sin instituciones ingresadas>");
		actividadComboBox.setSelectedItem("<Sin instituciones ingresadas>");
		nombreField.setText("");
		fechaRefDiaField.setValue(null);
		fechaRefMesField.setValue(null);
		fechaRefAnioField.setValue(null);
	}
    
    private boolean checkFormulario() {
    	String nombre_inst = (String) institucionComboBox.getSelectedItem();
    	String act = (String) actividadComboBox.getSelectedItem();
		String nombre = nombreField.getText();
		String dia =  fechaRefDiaField_1.getText();
		String mes = fechaRefMesField_1.getText();
		String anio = fechaRefAnioField_1.getText();
		String hora = horaField.getText();
		String minuto = minutoField.getText();
		String dia2 = fechaRefDiaField.getText();
		String mes2 = fechaRefMesField.getText();
		String anio2 = fechaRefAnioField.getText();
		String profe = profeField.getText();
		String url = urlField.getText();
		if(nombre_inst.isEmpty() || act.isEmpty() || nombre.isEmpty() || dia.isEmpty() || mes.isEmpty() || anio.isEmpty() || hora.isEmpty() || minuto.isEmpty() || dia2.isEmpty() || mes2.isEmpty() || anio2.isEmpty() || profe.isEmpty() || url.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
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
		try {
			Integer.parseInt(dia2);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "El dia debe ser un numero", "Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			Integer.parseInt(mes2);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "El mes debe ser un numero", "Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			Integer.parseInt(anio2);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "El anio debe ser un numero", "Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			Integer.parseInt(hora);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "La hora debe ser un numero", "Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			Integer.parseInt(minuto);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Los minutos deben ser un numero", "Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
    }
}
