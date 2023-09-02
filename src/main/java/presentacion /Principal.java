package presentacion;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Principal {

    private JFrame frame;
    private JDesktopPane desktopPane;

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
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        desktopPane = new JDesktopPane();
        frame.getContentPane().add(desktopPane);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu mnAltas = new JMenu("Altas");
        menuBar.add(mnAltas);

        JMenuItem mntmUsuario = new JMenuItem("Usuario");
        mntmUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                IngresarUsuario2 ingresoUsuario = new IngresarUsuario2();
                desktopPane.add(ingresoUsuario);
                ingresoUsuario.setVisible(true);
            }
        });
        mnAltas.add(mntmUsuario);
        
        JMenuItem mntmInstDeportiva = new JMenuItem("Inst. Deportiva");
        mntmInstDeportiva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	IngresarInstitucionDeportiva2 ingresoInst = new IngresarInstitucionDeportiva2();
                desktopPane.add(ingresoInst);
                ingresoInst.setVisible(true);
            }
        });
        
        //IngresarActividadDeportiva2
        
        mnAltas.add(mntmInstDeportiva);
        
        
        
        
        
        
        JMenuItem mntmActDeportivaa = new JMenuItem("Act. Deportiva");
        mntmActDeportivaa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	IngresarActividadDeportiva2 a = new IngresarActividadDeportiva2();
                desktopPane.add(a);
                a.setVisible(true);
            }
        });
        
        
        
        mnAltas.add(mntmActDeportivaa);
        
        
        
        JMenuItem mntmClase = new JMenuItem("Clase");
        mntmClase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	IngresarClase2 B = new IngresarClase2();
                desktopPane.add(B);
                B.setVisible(true);
            }
        });
        
        
        
        mnAltas.add(mntmClase);
        
        JMenu mnInformacion = new JMenu("Información");
        menuBar.add(mnInformacion);
        
        
        
        JMenuItem mntmSocio = new JMenuItem("Socios");
        /*
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

