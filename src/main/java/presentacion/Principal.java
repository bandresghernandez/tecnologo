package presentacion;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Dimension;

import interfaces.Fabrica;
import interfaces.ICInstitucion;
import interfaces.ICUsuario;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
//import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Dimension;

import interfaces.Fabrica;
import interfaces.ICInstitucion;
import interfaces.ICUsuario;
import java.awt.BorderLayout;

public class Principal {

    private JFrame frame;//frame principal
    
    //private JDesktopPane desktopPane;
    //private IngresarInstitucionDeportiva ingresarInstDepInternalFrame;
    
    private IngresarUsuario ingresarUsuarioInternalFrame;
	private IngresarInstitucionDeportiva ingresarInstDepInternalFrame;
	private IngresarActividadDeportiva ingresarActividadDeportivaInternalFrame;
	private IngresarClase ingresarClaseInternalFrame;
	private ConsultaUsuario consultaUsuarioInternalFrame;
	private ConsultaActividadDeportiva consultaActividadDepInternalFrame;
    private IngresarRegistro IngresarRegistroFrame;
	
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal window = new Principal();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Principal() {
        initialize();
        
        Fabrica fabrica = Fabrica.getInstancia();
        ICUsuario iusu = fabrica.getICUsuario();
        ICInstitucion iinst = fabrica.getICInstitucion();
        
        Dimension desktopSize = frame.getSize();
		Dimension jInternalFrameSize;
		
		ingresarUsuarioInternalFrame = new IngresarUsuario(iusu);
		jInternalFrameSize = ingresarUsuarioInternalFrame.getSize();
		ingresarUsuarioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height- jInternalFrameSize.height)/2);
		//ingresarUsuarioInternalFrame.setSize(450, 300);
		ingresarUsuarioInternalFrame.setVisible(false);
		frame.getContentPane().add(ingresarUsuarioInternalFrame);
		//ingresarInstDepInternalFrame.getContentPane().add(ingresarUsuarioInternalFrame);
		
		
        ingresarInstDepInternalFrame = new IngresarInstitucionDeportiva(iinst);//lo instancio
        jInternalFrameSize = ingresarInstDepInternalFrame.getSize();
        ingresarInstDepInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,//lo pongo en el medio de la pantalla
		    (desktopSize.height- jInternalFrameSize.height)/2);
        ingresarInstDepInternalFrame.setVisible(false);//lo hago invisible
		frame.getContentPane().add(ingresarInstDepInternalFrame);//lo agrego
		
		
		
		
		ingresarActividadDeportivaInternalFrame = new IngresarActividadDeportiva(iinst);//lo instancio
        jInternalFrameSize = ingresarActividadDeportivaInternalFrame.getSize();
        ingresarActividadDeportivaInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,//lo pongo en el medio de la pantalla
		    (desktopSize.height- jInternalFrameSize.height)/2);
        ingresarActividadDeportivaInternalFrame.setVisible(false);//lo hago invisible
		frame.getContentPane().add(ingresarActividadDeportivaInternalFrame);//lo agrego
		
		ingresarClaseInternalFrame = new IngresarClase();//lo instancio
        jInternalFrameSize = ingresarClaseInternalFrame.getSize();
        ingresarClaseInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,//lo pongo en el medio de la pantalla
		    (desktopSize.height- jInternalFrameSize.height)/2);
        ingresarClaseInternalFrame.setVisible(false);//lo hago invisible
		frame.getContentPane().add(ingresarClaseInternalFrame, BorderLayout.NORTH);
		
		consultaUsuarioInternalFrame = new ConsultaUsuario(iusu);//lo instancio
        jInternalFrameSize = consultaUsuarioInternalFrame.getSize();
        consultaUsuarioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,//lo pongo en el medio de la pantalla
		    (desktopSize.height- jInternalFrameSize.height)/2);
        consultaUsuarioInternalFrame.setVisible(false);//lo hago invisible
		frame.getContentPane().add(consultaUsuarioInternalFrame, BorderLayout.NORTH);
		
		consultaActividadDepInternalFrame = new ConsultaActividadDeportiva(iinst);//lo instancio
        jInternalFrameSize = consultaActividadDepInternalFrame.getSize();
        consultaActividadDepInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,//lo pongo en el medio de la pantalla
		    (desktopSize.height- jInternalFrameSize.height)/2);
        consultaActividadDepInternalFrame.setVisible(false);//lo hago invisible
		frame.getContentPane().add(consultaActividadDepInternalFrame, BorderLayout.NORTH);
    
		//registro
		IngresarRegistroFrame = new IngresarRegistro(iusu);//lo instancio
        jInternalFrameSize = IngresarRegistroFrame.getSize();
        IngresarRegistroFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,//lo pongo en el medio de la pantalla
		    (desktopSize.height- jInternalFrameSize.height)/2);
        IngresarRegistroFrame.setVisible(false);//lo hago invisible
		frame.getContentPane().add(IngresarRegistroFrame);//lo agrego
    
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(200, 200, 900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        //desktopPane = new JDesktopPane();
        //frame.getContentPane().add(desktopPane);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu mnAltas = new JMenu("Altas");
        menuBar.add(mnAltas);

        JMenuItem mntmUsuario = new JMenuItem("Usuario");
        mntmUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //IngresarUsuario ingresoUsuario = new IngresarUsuario();
                //desktopPane.add(ingresoUsuario);
                //ingresoUsuario.setVisible(true);
            	ingresarUsuarioInternalFrame.setVisible(true);
            }
        });
        mnAltas.add(mntmUsuario);
        
        JMenuItem mntmInstDeportiva = new JMenuItem("Inst. Deportiva");
        mntmInstDeportiva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	ingresarInstDepInternalFrame.setVisible(true);
            }
        });
        
        //IngresarActividadDeportiva2
        
        mnAltas.add(mntmInstDeportiva);
        

        
        JMenuItem mntmActDeportivaa = new JMenuItem("Act. Deportiva");
        mntmActDeportivaa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ingresarActividadDeportivaInternalFrame.setVisible(true);
            }
        });
        
        
        
        mnAltas.add(mntmActDeportivaa);
        
        
        
        JMenuItem mntmClase = new JMenuItem("Clase");
        mntmClase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ingresarClaseInternalFrame.setVisible(true);
            }
        });
        
        
        
        mnAltas.add(mntmClase);
        
        JMenu mnInformacion = new JMenu("Información");
        menuBar.add(mnInformacion);
        
        JMenuItem mntmSocioInfo = new JMenuItem("Socio");
        mntmSocioInfo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		consultaUsuarioInternalFrame.setVisible(true);
        		consultaUsuarioInternalFrame.iniciarlizarComboBoxes();
        	}
        });
        
        
        mnInformacion.add(mntmSocioInfo);
        
        JMenuItem mntmActividadDepInfo = new JMenuItem("ActividadDeportiva");
        mntmActividadDepInfo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		consultaActividadDepInternalFrame.setVisible(true);
        		//iniciarlizarComboBoxes
        	}
        });
        mnInformacion.add(mntmActividadDepInfo);
        
        
        
        
      JMenu mnRegistro = new JMenu("Registro");
        
        
        menuBar.add(mnRegistro);
        
        JMenuItem mntmAgregar = new JMenuItem("Agregar");
        mntmAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	IngresarRegistro l = new IngresarRegistro(null);
                 //desktopPane.add(l);
                //IngresarRegistroFrame.setVisible(true);
            	IngresarRegistroFrame.setVisible(true);

            }
        });
        mnRegistro.add(mntmAgregar);
        
        
        
        
        
        JMenu mnSalir = new JMenu("Salir");
        mnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        
        	//falta implementar
        		
        	}
        });
        menuBar.add(mnSalir);
        
        JMenuItem mntmSalirSistema = new JMenuItem("Salir sistema");
        mnSalir.add(mntmSalirSistema);

        
        frame.setLocationRelativeTo(null);
        
        
        mntmSalirSistema.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Agrega aquí cualquier código adicional que desees ejecutar antes de salir.
                // Por ejemplo, guardar datos, cerrar conexiones, etc.
                System.exit(0); // Cierra la aplicación
            }
        });

  
        /*
        JMenuItem mntmSocio = new JMenuItem("Socios");
    
        mntmSocio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	InfoSocios a = new InfoSocios();
                desktopPane.add(a);
                a.setVisible(true);
            }
        });
        
        mnInformacion.add(mntmSocio);
    }*/
}
}



