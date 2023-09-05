package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaces.ICInstitucion;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

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
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// se oculta jframe en lugar de cerrarse
        setClosable(true);// permite que el usuario cierre la ventana
        setTitle("Alta de una Institucion");//setteo el titulo
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBoxInstituto = new JComboBox();
		comboBoxInstituto.setBounds(10, 34, 194, 22);
		contentPane.add(comboBoxInstituto);
		
		JComboBox comboBoxActividad = new JComboBox();
		comboBoxActividad.setBounds(10, 92, 194, 22);
		contentPane.add(comboBoxActividad);
		
		JComboBox comboBoxClase = new JComboBox();
		comboBoxClase.setBounds(10, 150, 194, 22);
		contentPane.add(comboBoxClase);
		
		JLabel lblComboInstituto = new JLabel("Institutos");
		lblComboInstituto.setBounds(10, 11, 46, 14);
		contentPane.add(lblComboInstituto);
		
		JLabel lblComboActividad = new JLabel("Actividades");
		lblComboActividad.setBounds(10, 67, 64, 14);
		contentPane.add(lblComboActividad);
		
		JLabel lblComboClase = new JLabel("Clases");
		lblComboClase.setBounds(10, 125, 46, 14);
		contentPane.add(lblComboClase);
		
		JTextPane textInfoClase = new JTextPane();
		textInfoClase.setText("Detalles de las clase . . .");
		textInfoClase.setBounds(10, 196, 414, 63);
		contentPane.add(textInfoClase);
		
		JTextPane textInfoActividad = new JTextPane();
		textInfoActividad.setText("Informacion de Actividad . . .");
		textInfoActividad.setBounds(214, 34, 210, 140);
		contentPane.add(textInfoActividad);
		
	}
}
