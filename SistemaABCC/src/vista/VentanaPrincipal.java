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
        getContentPane().setLayout(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Sistema ABCC");
        setSize(800, 800);
        this.getContentPane().setBackground(Color.darkGray);
        setLocationRelativeTo(null);
        setVisible(true);

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
                //System.out.println(modeloTabla.getColumnCount());
                //public modeloTabla2= modeloTabla;

            }
        });
        menuInicio.add(menuItemConsultas);
        menuBar.add(menuInicio);
        menuConversores = new JMenu("Maestros");
        menuBar.add(menuConversores);
        setJMenuBar(menuBar);

        JLabel lblTitulo = new JLabel();
        lblTitulo.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\BIENVENIDO.png"));;
        lblTitulo.setBounds(140, 250, 500, 120);
        add(lblTitulo);


}//classe VentanaInicio

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}










