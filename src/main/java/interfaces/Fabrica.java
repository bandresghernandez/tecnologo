package presentacion;

import java.awt.EventQueue;

public class InfoSocios extends JInternalFrame {
	DefaultTableModel modeloTabla =new DefaultTableModel();
	private JTable tabla;


	public InfoSocios() {
		//setTitle("tabla");
		modeloTabla.setColumnIdentifiers(new Object[] {"Nombre", "apellido", "email"});
		tabla.setModel(modeloTabla);
		modeloTabla.setRowCount(10);
		//  CUsuario2 CUsuario2 = new CUsuario2();
       //   CUsuario2.listarSocio();

	//}
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JButton btnListarSocios = new JButton("Listar Socios");
		btnListarSocios.setBounds(0, 0, 440, 30);
		btnListarSocios.setPreferredSize(new Dimension(100, 30)); // Set preferred size here
		getContentPane().add(btnListarSocios);

		JPanel panel = new JPanel(); // Use BorderLayout for the panel
		panel.setBounds(0, 30, 440, 238);
		getContentPane().add(panel);

		JButton btnNewButton = new JButton("CANCELAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tabla = new JTable();
		scrollPane.setViewportView(tabla);
		
	
	
		
		// Set alignment for the "CANCELAR" button
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		
		// Add the "CANCELAR" button to the SOUTH region of the panel
		panel.add(btnNewButton);
		
	

		// ActionListener for the "Listar Socios" button
		btnListarSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				  CUsuario2 CUsuario2 = new CUsuario2();
	                CUsuario2.listarSocio();
	                
	                
	                CUsuario2.listarSocio();
				// Code for listing socios here
				
			}
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoSocios frame = new InfoSocios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
