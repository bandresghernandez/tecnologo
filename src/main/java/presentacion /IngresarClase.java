package presentacion;


import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import datatypes.DtFecha;
import datatypes.DtHora;

import java.text.ParseException;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class IngresarClase extends JInternalFrame {

    private JTextField nombreField;
    private JFormattedTextField fechaField;
    private JTextField horaInicioField;
    private JTextField urlField;
    private JFormattedTextField fechaRefDiaField; // Separate fields for day, month, and year
    private JFormattedTextField fechaRefMesField;
    private JFormattedTextField fechaRefAnioField;
    private JComboBox<ActividadDeportiva> actividadComboBox;
    private JLabel lblIngresarClase;
    private JButton btnNewButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IngresarClase2 frame = new IngresarClase2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public IngresarClase2() {
        setTitle("Ingresar Clase");
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNombre.setBounds(26, 30, 80, 14);
        getContentPane().add(lblNombre);

        nombreField = new JTextField();
        nombreField.setBounds(116, 28, 150, 20);
        getContentPane().add(nombreField);
        nombreField.setColumns(10);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblFecha.setBounds(26, 66, 80, 14);
        getContentPane().add(lblFecha);

        fechaField = new JFormattedTextField(); // Assuming you've integrated DtFecha appropriately
        fechaField.setBounds(116, 64, 150, 20);
        getContentPane().add(fechaField);

        JLabel lblHoraInicio = new JLabel("Hora Inicio:");
        lblHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblHoraInicio.setBounds(26, 102, 80, 14);
        getContentPane().add(lblHoraInicio);

        horaInicioField = new JTextField();
        horaInicioField.setBounds(116, 100, 150, 20);
        getContentPane().add(horaInicioField);

        JLabel lblURL = new JLabel("URL:");
        lblURL.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblURL.setBounds(26, 138, 80, 14);
        getContentPane().add(lblURL);

        urlField = new JTextField();
        urlField.setBounds(116, 136, 150, 20);
        getContentPane().add(urlField);
        urlField.setColumns(10);

        JLabel lblFechaRef = new JLabel("Fecha Ref:");
        lblFechaRef.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblFechaRef.setBounds(26, 174, 80, 14);
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

        fechaRefDiaField.setBounds(116, 172, 40, 20);
        fechaRefMesField.setBounds(166, 172, 40, 20);
        fechaRefAnioField.setBounds(216, 172, 32, 20);

        getContentPane().add(fechaRefDiaField);
        getContentPane().add(fechaRefMesField);
        getContentPane().add(fechaRefAnioField);

        JLabel lblActividadDeportiva = new JLabel("Actividad Deportiva:");
        lblActividadDeportiva.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblActividadDeportiva.setBounds(26, 210, 130, 14);
        getContentPane().add(lblActividadDeportiva);

        actividadComboBox = new JComboBox<ActividadDeportiva>();
        actividadComboBox.setBounds(166, 208, 150, 20);
        getContentPane().add(actividadComboBox);

        JButton btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBounds(103, 241, 122, 23);
        getContentPane().add(btnGuardar);
        
        lblIngresarClase = new JLabel("Alta de Clase");
        lblIngresarClase.setBounds(120, 1, 132, 15);
        getContentPane().add(lblIngresarClase);
        
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
    }

    private class ActividadDeportiva {
        // Define properties and methods for the ActividadDeportiva class
    }
}
