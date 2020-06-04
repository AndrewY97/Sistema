package vista;

import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.AlumnoDAO;
import modelo.Alumno;
import vista.VentanaPrincipal;
import conexionBD.ConexionBD;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class PantallaConsultas extends JFrame implements ActionListener {
    JTextField cajac;
    JButton btnBuscar;
    JTable tabla;

    public PantallaConsultas() {
        getContentPane().setLayout(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Consultas");
        setSize(770, 470);
        this.getContentPane().setBackground(Color.darkGray);
        setLocationRelativeTo(null);
        setVisible(true);

        //agregar componentes graficos al JFrame
        // SIEMPRE EN TRES PASOS:  Creacion, Configuracion y Agregacion al JFrame
        JLabel lblTitulo = new JLabel();
        lblTitulo.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\TITULOC.png"));;
        lblTitulo.setBounds(55, 5, 350, 50);
        add(lblTitulo);

        JLabel lblbNumeroControl = new JLabel();
        lblbNumeroControl.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\nc.png"));
        lblbNumeroControl.setBounds(2, 65, 150, 20);
        add(lblbNumeroControl);
        cajac = new JTextField(10);
        cajac.setBounds(130, 65, 170, 20);
        add(cajac);

        btnBuscar = new JButton();
        btnBuscar.setBounds(310, 55, 40, 40);
        btnBuscar.addActionListener(this);
        //btnBuscar.setBackground(Color.darkGray);
        btnBuscar.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\b.PNG"));
        add(btnBuscar);

        /*Object titulos[] = {"Numero Control", "Nombre", "Apellido P", "Apellido M", ""};
        Object celdas[][] = new Object[4][5];
        JScrollPane scroll = new JScrollPane();
        tablaalumnos = new JTable(celdas, titulos);
        scroll.setViewportView(tablaalumnos);
        scroll.setBounds(50, 70, 400, 100);
        getContentPane().add(scroll);*/
        //System.out.println("Hola");

        String CONTROLADOR_JDBC = "com.mysql.cj.jdbc.Driver";
        String URL_BASEDEDATOS = "jdbc:mysql://localhost/BD_Escuela?useTimezone=true&serverTimezone=UTC";
        String CONSULTA_PREDETERMINADA = "SELECT * FROM alumnos ORDER BY Num_Control";
        ResultSetTableModel modeloTabla = null;
        try {
            modeloTabla = new ResultSetTableModel(CONTROLADOR_JDBC, URL_BASEDEDATOS, CONSULTA_PREDETERMINADA);

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(getContentPane(), ex);
        }

        DefaultTableModel model = new DefaultTableModel();
        //System.out.println("Hola");
        int v1=modeloTabla.getColumnCount();
        int v2=modeloTabla.getRowCount();
        String[][] valor = new String[v1][v2];
        String[][] valor2 = new String[valor[0].length][valor.length];
        //System.out.println(v2);
        for (int i = 0; i <v1 ; i++) {
            model.addColumn(modeloTabla.getColumnName(i));
            for (int j = 0; j < v2; j++) {
                //valor.add(String.valueOf(modeloTabla.getValueAt(j, i)));
                valor[i][j]=String.valueOf(modeloTabla.getValueAt(j,i));
                //model.addRow(valor);
            }
        }
        Object titulos[] = {"Núm. Control", "Nombre(s)", "Ap. Paterno", "Ap. Materno", "Edad","Semestre","Carrera"};
        String celdas[][] = new String[valor[0].length][valor.length];
        JScrollPane scroll = new JScrollPane();

        for (int i = 0; i <valor.length ; i++) {
            for (int j = 0; j <valor[i].length ; j++) {
                celdas[j][i]=valor[i][j];
            }
        }

        for (int i = 0; i <v1 ; i++) {
            for (int j = 0; j <v2 ; j++) {
                //celdas[i][j]=valor[i][j];
            }
        }

        tabla = new JTable(celdas, titulos);
        //tabla.setModel(valor);
        scroll.setViewportView(tabla);
        scroll.setBounds(10, 100, 700, 120);
        getContentPane().add(scroll);

        //model.addRow(valor);
        //System.out.println(model.getColumnCount());
        //System.out.println(model.getRowCount());
        //tabla.setModel(model);
        //tabla.setBounds(10,10,100,10);
        //JScrollPane scroll = new JScrollPane();
        //scroll.setViewportView(tabla);
        //croll.setBounds(50, 70, 400, 100);
        //getContentPane().add(scroll);
        //String[] dato = new String[7];

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Alumno a = new AlumnoDAO().buscarAlumno(cajac.getText());
        if ( a == null )
            //System.out.println("Error");
            JOptionPane.showMessageDialog(null, "Numero de Control no encontrado");
        else {
            //System.out.println(a);
            //JOptionPane.showMessageDialog(null, a);
            Object titulos2[] = {"Núm. Control", "Nombre(s)", "Ap. Paterno", "Ap. Materno", "Edad","Semestre","Carrera"};
            String celdas2[][] = new String[1][7];
            celdas2[0][0]=a.getNumControl();
            celdas2[0][1]=a.getNombre();
            celdas2[0][2]=a.getPrimerAp();
            celdas2[0][3]=a.getSegundoAp();
            celdas2[0][4]= String.valueOf(a.getEdad());
            celdas2[0][5]= String.valueOf(a.getSemestre());
            celdas2[0][6]=a.getCarrera();
            JScrollPane scroll = new JScrollPane();
            tabla = new JTable(celdas2, titulos2);
            //tabla.setModel(valor);
            scroll.setViewportView(tabla);
            scroll.setBounds(10, 100, 700, 70);
            getContentPane().add(scroll);
        }

    }

}

