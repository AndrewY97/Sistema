package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import controlador.AlumnoDAO;
import modelo.Alumno;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class VentanaPrincipal extends JFrame implements ActionListener{

    JMenuBar menuBar;
    JMenu menuInicio, menuConversores;
    JMenuItem menuItemaltas, menuItemCambios, menuItemConsultas;

    JInternalFrame IF_Altas, IF_Cambios, IF_Consultas;

    public VentanaPrincipal(){
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sistema ABCC");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);

        JDesktopPane desktopPane = new JDesktopPane();

        menuBar = new JMenuBar();
        menuInicio = new JMenu("Alumnos");
        menuItemaltas = new JMenuItem("Altas");
        menuItemaltas.setMnemonic(KeyEvent.VK_A);
        menuItemaltas.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        //menuItemCalcSencilla.setIcon(new Image());
        menuItemaltas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PantallaPrincipal IF_Altas = new PantallaPrincipal();
                IF_Altas.setVisible(true);

            }
        });
        //desktopPane.add(IF_Altas);
        menuInicio.add(menuItemaltas);
        menuItemCambios = new JMenuItem("Cambios/B");
        menuItemCambios.setMnemonic(KeyEvent.VK_B);
        menuItemCambios.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        menuItemCambios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Hola");
                PantallaCambios IF_Cambios = new PantallaCambios();
                IF_Cambios.setVisible(true);


            }
        });
        menuInicio.add(menuItemCambios);
        menuItemConsultas = new JMenuItem("Consultas");
        menuItemConsultas.setMnemonic(KeyEvent.VK_C);
        menuItemConsultas.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        menuItemConsultas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Hola");
                PantallaConsultas IF_Consultas = new PantallaConsultas();
                IF_Consultas.setVisible(true);

                //System.out.println(modeloTabla);
            }
        });
        menuInicio.add(menuItemConsultas);
        menuBar.add(menuInicio);
        menuConversores = new JMenu("Conversores");
        menuBar.add(menuConversores);
        setJMenuBar(menuBar);
        // ----------------------   MENU ----------------------------

        //---------------- INTERNALFRAMES ----------------------
        /*JDesktopPane desktopPane = new JDesktopPane();

        IF_CalcSencilla = new JInternalFrame();
        IF_CalcSencilla.getContentPane().setLayout(null);
        IF_CalcSencilla.setDefaultCloseOperation(HIDE_ON_CLOSE);
        IF_CalcSencilla.setTitle("InternalFrames");
        IF_CalcSencilla.setSize(300, 300);

        IF_CalcSencilla.setMaximizable(true);
        IF_CalcSencilla.setIconifiable(true);
        IF_CalcSencilla.setClosable(true);
        IF_CalcSencilla.setResizable(true);

        //IF_CalcSencilla.setVisible(true);

        JPanel panelCalculadora = new JPanel();
        panelCalculadora.add(new JLabel("Calculadora SENCILLA"));
        JTextField cajaMantisa = new JTextField(10);
        panelCalculadora.add(cajaMantisa);
        panelCalculadora.setBounds(0,0, 100, 100);
        IF_Altas.add(panelCalculadora);

        desktopPane.add(IF_Altas); // agregar InternalFrame al DesktopPane

        add(desktopPane, BorderLayout.CENTER); //agreagr desktopPane al JFrame principal

    }//constructor*/

}//classe VentanaInicio

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}

class Inicio {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaPrincipal();
            }
        });

    }
}








