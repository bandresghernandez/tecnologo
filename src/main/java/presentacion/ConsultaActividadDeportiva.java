package presentacion;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaces.ICInstitucion;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaActividadDeportiva extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	//Variables 
	private ICInstitucion iinst;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public ConsultaActividadDeportiva(ICInstitucion iinst) {
		this.iinst=iinst;

		setResizable(true);//permite cambiar el tamaño del jframe
        setIconifiable(true);//permite poner iconos
        setMaximizable(true);//permite maximizar y minimizar el jframe
        //setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// se oculta jframe en lugar de cerrarse
        setClosable(true);// permite que el usuario cierre la ventana
        setTitle("Constula Activdad Deportiva");//setteo el titulo
		
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBoxInstituto = new JComboBox();
		comboBoxInstituto.setBounds(10, 57, 328, 22);	
		contentPane.add(comboBoxInstituto);
		
		
		JComboBox comboBoxActividad = new JComboBox();
		comboBoxActividad.setBounds(10, 152, 328, 22);
		contentPane.add(comboBoxActividad);
		
		JComboBox comboBoxClase = new JComboBox();
		comboBoxClase.setBounds(10, 254, 328, 22);
		contentPane.add(comboBoxClase);
		
		JLabel lblComboInstituto = new JLabel("Institutos");
		lblComboInstituto.setBounds(10, 32, 194, 14);
		contentPane.add(lblComboInstituto);
		
		JLabel lblComboActividad = new JLabel("Actividades");
		lblComboActividad.setBounds(10, 127, 64, 14);
		contentPane.add(lblComboActividad);
		
		JLabel lblComboClase = new JLabel("Clases");
		lblComboClase.setBounds(10, 216, 46, 14);
		contentPane.add(lblComboClase);
		
		JTextPane textInfoClase = new JTextPane();
		textInfoClase.setEnabled(false);
		textInfoClase.setText("Detalles de las clase . . .");
		textInfoClase.setBounds(10, 357, 747, 141);
		contentPane.add(textInfoClase);
		
		JTextPane textInfoActividad = new JTextPane();
		textInfoActividad.setEnabled(false);
		textInfoActividad.setText("Informacion de Actividad . . .");
		textInfoActividad.setBounds(385, 32, 372, 314);
		contentPane.add(textInfoActividad);
		
		JButton btnRecargar = new JButton("Recargar");
		btnRecargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBoxInstituto.removeAllItems();
				ArrayList<String> instituciones = iinst.listarInstitucionDeportiva();
				// miro si me trae algo
				for (String s : instituciones) {
					System.out.print(s);
				}
				
				for (String s : instituciones) {
					comboBoxInstituto.addItem(s);
				}
			comboBoxInstituto.addItem("cosa 1");
			}
		});
		btnRecargar.setBounds(10, 303, 89, 23);
		contentPane.add(btnRecargar);
		
	}
}
