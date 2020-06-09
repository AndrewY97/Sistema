package vista;

import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.CallableStatement;
import controlador.AlumnoDAO;
import controlador.AlumnoDAORACLE;
import modelo.Alumno;
import modelo.Usuario;
import vista.VentanaPrincipal;
import conexionBD.ConexionBD;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;


class VentanaPrincipal extends JFrame implements ActionListener{

    JTextField cajac,cajac2,cajaNumControl, cajaNombre, cajaSegundoAp, cajaPrimerAp;
    JButton btnBuscar,btnBuscar2,btnEnviar, btncancel,btngraficas;
    JTable tabla;
    JComboBox<String> combocarrera;
    JComboBox<Byte> combosemestre, comboEdad;
    JRadioButton a,cb,n,c,cn;
    ButtonGroup grupo,grupo2;

    public VentanaPrincipal(){
        getContentPane().setLayout(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Sistema ABCC");
        setSize(1000, 570);
        this.getContentPane().setBackground(Color.darkGray);
        setLocationRelativeTo(null);
        setVisible(true);

        JLabel lblTitulo = new JLabel();
        lblTitulo.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\BIENVENIDO.png"));;
        lblTitulo.setBounds(250, 0, 500, 120);
        add(lblTitulo);

        JLabel lblbdat = new JLabel();
        lblbdat.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\dato.png"));
        lblbdat.setBounds(570, 120, 150, 20);
        add(lblbdat);
        cajac = new JTextField(10);
        cajac.setBounds(630, 120, 100, 20);
        add(cajac);

        btnBuscar = new JButton();
        btnBuscar.setBounds(740, 115, 40, 40);
        btnBuscar.addActionListener(this);
        //btnBuscar.setBackground(Color.darkGray);
        btnBuscar.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\b.PNG"));
        add(btnBuscar);

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
        scroll.setBounds(400, 170, 550, 120);
        getContentPane().add(scroll);

        btngraficas = new JButton();
        btngraficas.setBounds(400, 400, 40, 40);
        btngraficas.addActionListener(this);
        btngraficas.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\graf.PNG"));
        add(btngraficas);

        JLabel lblbNumeroControl = new JLabel();
        lblbNumeroControl.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\nc.png"));
        lblbNumeroControl.setBounds(2, 120, 150, 20);
        add(lblbNumeroControl);
        cajac2 = new JTextField(10);
        cajac2.setBounds(130, 120, 170, 20);
        add(cajac2);

        btnBuscar2 = new JButton();
        btnBuscar2.setBounds(310, 115, 40, 40);
        btnBuscar2.addActionListener(this);
        //btnBuscar.setBackground(Color.darkGray);
        btnBuscar2.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\b.PNG"));
        add(btnBuscar2);

        JLabel lblNumeroControl = new JLabel();
        lblNumeroControl.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\nc.PNG"));
        lblNumeroControl.setBounds(150, 140, 150, 20);
        add(lblNumeroControl);
        cajaNumControl = new JTextField(10);
        cajaNumControl.setBounds(130, 160, 170, 20);
        //cajaNumControl.setEditable(false);
        add(cajaNumControl);

        JLabel lblPrimerAp = new JLabel();
        lblPrimerAp.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\nom.png"));
        lblPrimerAp.setBounds(150, 180, 130, 20);
        add(lblPrimerAp);
        cajaNombre = new JTextField(10);
        cajaNombre.setBounds(130, 200, 170, 20);
        ValidaCaracter valChar= new ValidaCaracter();
        cajaNombre.addKeyListener(valChar);
        add(cajaNombre);

        JLabel lblSegundoAp = new JLabel();
        lblSegundoAp.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\ap.png"));
        lblSegundoAp.setBounds(150, 220, 130, 20);
        add(lblSegundoAp);
        cajaPrimerAp = new JTextField(10);
        cajaPrimerAp.setBounds(130, 240, 170, 20);
        ValidaCaracter valChar2=new ValidaCaracter();
        cajaNombre.addKeyListener(valChar2);
        add(cajaPrimerAp);

        JLabel lblSegundoAp2 = new JLabel();
        lblSegundoAp2.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\am.png"));;
        lblSegundoAp2.setBounds(150, 260, 130, 20);
        add(lblSegundoAp2);
        cajaSegundoAp = new JTextField(10);
        cajaSegundoAp.setBounds(130, 280, 170, 20);
        ValidaCaracter valChar3=new ValidaCaracter();
        cajaNombre.addKeyListener(valChar3);
        add(cajaSegundoAp);

        JLabel lblcarrera = new JLabel();
        lblcarrera.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\car.png"));;
        lblcarrera.setBounds(150, 300, 170, 20);
        add(lblcarrera);
        //add(new JLabel("Carrera: ")).;
        ;
        combocarrera = new JComboBox<>();
        combocarrera.addItem("ING. Sistemas");
        combocarrera.addItem("ING. Mecatrónica");
        combocarrera.addItem("Administración");
        combocarrera.addItem("Contaduría");
        combocarrera.addItem("ING. Alimentaria");
        combocarrera.setBounds(130, 320, 170, 20);
        add(combocarrera);

        JLabel lblSmestre = new JLabel();
        lblSmestre.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\sem.png"));;
        lblSmestre.setBounds(150, 340, 170, 20);
        add(lblSmestre);

        combosemestre = new JComboBox<>();
        for (byte i = 1; i <= 13; i = (byte) (i + 1)) {
            combosemestre.addItem(i);
        }
        combosemestre.setBounds(130, 360, 170, 20);
        add(combosemestre);

        JLabel lblEdad = new JLabel();
        lblEdad.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\ed.png"));;
        lblEdad.setBounds(150, 380, 170, 20);
        add(lblEdad);

        comboEdad = new JComboBox<>();
        for (byte i = 1; i <= 100; i = (byte) (i + 1)) {
            comboEdad.addItem(i);
        }
        comboEdad.setBounds(130, 400, 170, 20);
        add(comboEdad);

        btncancel = new JButton();
        btncancel.setBounds(120, 440, 40, 40);
        btncancel.addActionListener(this);
        btncancel.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\E.PNG"));
        add(btncancel);

        btnEnviar = new JButton();
        btnEnviar.setBounds(270, 440, 40, 40);
        btnEnviar.addActionListener(this);
        btnEnviar.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\C.PNG"));
        add(btnEnviar);

        grupo=new ButtonGroup();
        a=new JRadioButton();
        //a.setText("Radio1");
        a.setBounds(10, 150, 20, 30);
        a.setBackground(Color.darkGray);
        a.addActionListener(this);
        add(a);
        cb=new JRadioButton();
        //cb.setText("Radio2");
        cb.setBounds(10, 170, 20, 30);
        cb.setBackground(Color.darkGray);
        cb.addActionListener(this);
        add(cb);
        grupo.add(a);
        grupo.add(cb);



        JLabel lblA = new JLabel();
        lblA.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\alt.png"));;
        lblA.setBounds(30, 150, 170, 20);
        add(lblA);

        JLabel lblcb = new JLabel();
        lblcb.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\cb.png"));;
        lblcb.setBounds(30, 174, 170, 20);
        add(lblcb);

        grupo2=new ButtonGroup();
        n=new JRadioButton();
        //a.setText("Radio1");
        n.setBounds(790, 80, 20, 30);
        n.setBackground(Color.darkGray);
        n.addActionListener(this);
        add(n);
        c=new JRadioButton();
        //cb.setText("Radio2");
        c.setBounds(790, 100, 20, 30);
        c.setBackground(Color.darkGray);
        c.addActionListener(this);
        add(c);
        cn=new JRadioButton();
        //cb.setText("Radio2");
        cn.setBounds(790, 120, 20, 30);
        cn.setBackground(Color.darkGray);
        cn.addActionListener(this);
        add(cn);
        grupo2.add(n);
        grupo2.add(c);
        grupo2.add(cn);

        JLabel lblnumcontrol = new JLabel();
        lblnumcontrol.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\d2.png"));;
        lblnumcontrol.setBounds(810, 84, 170, 20);
        add(lblnumcontrol);

        JLabel lblcnombre = new JLabel();
        lblcnombre.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\d1.png"));;
        lblcnombre.setBounds(810, 104, 170, 20);
        add(lblcnombre);

        JLabel lblcarreras = new JLabel();
        lblcarreras.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\d3.png"));;
        lblcarreras.setBounds(810, 124, 170, 20);
        add(lblcarreras);


    }

    @Override
    public void actionPerformed(ActionEvent x) {
        if(cn.isSelected()){
            if (x.getSource()==btnBuscar){
                //System.out.println("cn");
                String CONTROLADOR_JDBC = "com.mysql.cj.jdbc.Driver";
                String URL_BASEDEDATOS = "jdbc:mysql://localhost/BD_Escuela?useTimezone=true&serverTimezone=UTC";
                String CONSULTA_PREDETERMINADA = "SELECT * FROM alumnos WHERE Carrera= '"+cajac.getText()+"'";
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
                System.out.println(v2);
                if(v2!=0){
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
                    scroll.setBounds(400, 170, 550, 120);
                    getContentPane().add(scroll);
                }else{
                    JOptionPane.showMessageDialog(null,"Datos no encontrados");
                }
            }
        }if(c.isSelected()){
            if (x.getSource()==btnBuscar){
                String CONTROLADOR_JDBC = "com.mysql.cj.jdbc.Driver";
                String URL_BASEDEDATOS = "jdbc:mysql://localhost/BD_Escuela?useTimezone=true&serverTimezone=UTC";
                String CONSULTA_PREDETERMINADA = "SELECT * FROM alumnos WHERE Nombre_Alumno= '"+cajac.getText()+"'";
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
                //System.out.println(v2);
                if(v2!=0){
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
                    scroll.setBounds(400, 170, 550, 120);
                    getContentPane().add(scroll);
                }else{
                    JOptionPane.showMessageDialog(null,"Datos no encontrados");
                }
            }
        }if(n.isSelected()){
            if (x.getSource()==btnBuscar){
                String CONTROLADOR_JDBC = "com.mysql.cj.jdbc.Driver";
                String URL_BASEDEDATOS = "jdbc:mysql://localhost/BD_Escuela?useTimezone=true&serverTimezone=UTC";
                String CONSULTA_PREDETERMINADA = "SELECT * FROM alumnos WHERE Num_Control= '"+cajac.getText()+"'";
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
                //System.out.println(v2);
                if(v2!=0){
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
                    scroll.setBounds(400, 170, 550, 120);
                    getContentPane().add(scroll);
                }else{
                    JOptionPane.showMessageDialog(null,"Datos no encontrados");
                }
            }
        }if(x.getSource()==btngraficas){
            try {
                Graficas g = new Graficas();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        if(a.isSelected()){
            System.out.println("Altas");
            cajaNumControl.setEditable(true);
            cajac2.setEditable(false);
            btnBuscar2.setEnabled(false);
            String NuC = cajaNumControl.getText();
            String NAME = cajaNombre.getText();
            String PA = cajaPrimerAp.getText();
            String SA = cajaSegundoAp.getText();
            byte E= (byte) comboEdad.getSelectedItem();
            byte S = (byte) combosemestre.getSelectedItem();
            String C = (String) combocarrera.getSelectedItem();
            if (x.getSource() == btnEnviar) {
                NuC=NuC.replaceAll(" ", "");
                NAME=NAME.replaceAll(" ", "");
                PA=PA.replaceAll(" ", "");
                SA=SA.replaceAll(" ", "");
                if (NuC.equals("")||NAME.equals("")||PA.equals("")||SA.equals("")){
                    JOptionPane.showMessageDialog(null,"Campos vacios");
                }else{
                    String nc = NuC;
                    String n = NAME;
                    String pa = PA;
                    String sa = SA;
                    byte e = E;
                    byte s = S;
                    String c = C;

                    boolean res = new AlumnoDAO().agregarAlumno(new Alumno(nc, n, pa, sa, e, s , c));
                    boolean ok = new AlumnoDAO().agregausuario(new Usuario(nc,n));
                    boolean res2= new AlumnoDAORACLE().agregarAlumno(new Alumno(nc,n,pa,sa,e,s,c));
                    if(!res){
                        JOptionPane.showMessageDialog(null,"Numero de control dupicado");
                    }else{
                        JOptionPane.showMessageDialog(null,NuC+" Dado de alta con exito");
                        //dispose();
                        cajaNumControl.setText("");
                        cajaNombre.setText("");
                        cajaPrimerAp.setText("");
                        cajaSegundoAp.setText("");

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
                        scroll.setBounds(400, 170, 550, 120);
                        getContentPane().add(scroll);
                    }
                }

            }if(x.getSource() == btncancel){
                cajaNumControl.setText("");
                cajaNombre.setText("");
                cajaPrimerAp.setText("");
                cajaSegundoAp.setText("");
            }
        }if(cb.isSelected()){
            System.out.println("Cambiosbajas");
            cajaNumControl.setEditable(false);
            cajac2.setEditable(true);
            btnBuscar2.setEnabled(true);
            String NuC = cajaNumControl.getText();
            String NAME = cajaNombre.getText();
            String PA = cajaPrimerAp.getText();
            String SA = cajaSegundoAp.getText();
            byte E= (byte) comboEdad.getSelectedItem();
            byte S = (byte) combosemestre.getSelectedItem();
            String C = (String) combocarrera.getSelectedItem();
            if (x.getSource() == btnEnviar) {
                NuC=NuC.replaceAll(" ", "");
                NAME=NAME.replaceAll(" ", "");
                PA=PA.replaceAll(" ", "");
                SA=SA.replaceAll(" ", "");
                if (NAME.equals("")||PA.equals("")||SA.equals("")){
                    JOptionPane.showMessageDialog(null,"Campos vacios");
                }else{
                    String nc = NuC;
                    String n = NAME;
                    String pa = PA;
                    String sa = SA;
                    byte e = E;
                    byte s = S;
                    String c = C;
                    boolean res = new AlumnoDAO().modificarAlumno(new Alumno(nc, n, pa, sa, e, s , c));
                    boolean resw = new AlumnoDAORACLE().modificarAlumno(new Alumno(nc, n, pa, sa, e, s , c));
                    JOptionPane.showMessageDialog(null, NuC+" Modificado con exito");
                    //dispose();
                    cajaNumControl.setText("");
                    cajaNombre.setText("");
                    cajaPrimerAp.setText("");
                    cajaSegundoAp.setText("");

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
                    scroll.setBounds(400, 170, 550, 120);
                    getContentPane().add(scroll);
                }
                //System.out.println( res ? "EXITO MODIFICADO !!!" : "Fallo en la MODIFICACION !!!" );
            }if(x.getSource()==btncancel){
                //System.out.println("Hola");
                String nUc = cajaNombre.getText();
                boolean BAJA = new AlumnoDAO().eliminarAlumno(cajac2.getText());

                //System.out.println( res ? "EXITO ELIMINADO !!!" : "Fallo en la ELIMINACION !!!" );
                JOptionPane.showMessageDialog(null, NuC+" Dado de baja con exito");
                //dispose();
                cajaNumControl.setText("");
                cajaNombre.setText("");
                cajaPrimerAp.setText("");
                cajaSegundoAp.setText("");

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
                scroll.setBounds(400, 170, 550, 120);
                getContentPane().add(scroll);
            }if(x.getSource()==btnBuscar2){
                int valor=2;
                String nnc= cajac.getText();
                Alumno a = new AlumnoDAO().buscarAlumno(valor,cajac2.getText());
                Alumno a2 = new AlumnoDAORACLE().buscarAlumno(cajac2.getText());
                int [] miArreglo=new int [30];
                if ( a == null ){
                    //System.out.println("Error");
                    cajaNombre.setText("");
                    JOptionPane.showMessageDialog(null, nnc+" No encontrado");}
                else {
                    cajaNumControl.setText(a.getNumControl());
                    String str = String.valueOf(a);
                    System.out.println(a);
                    cajaNombre.setText(a.getNombre());
                    cajaPrimerAp.setText(a.getPrimerAp());
                    cajaSegundoAp.setText(a.getSegundoAp());
                    combocarrera.setSelectedItem(a.getCarrera());
                    comboEdad.setSelectedItem(a.getEdad());
                    combosemestre.setSelectedItem(a.getSemestre());
                }

            }
        }
    }
}










