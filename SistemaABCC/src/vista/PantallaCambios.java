package vista;

import javax.swing.*;
import controlador.AlumnoDAO;
import controlador.AlumnoDAORACLE;
import modelo.Alumno;


import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaCambios extends JFrame implements ActionListener {
    JButton btnEnviar, btncancel, btnBuscar;
    JTextField cajac;
    JTextField cajaNumControl, cajaNombre, cajaSegundoAp, cajaPrimerAp;
    JComboBox<String> combocarrera;
    JComboBox<Byte> combosemestre, comboEdad;
    String nombre1;

    public PantallaCambios() {
        //configuracion ventana principal
        getContentPane().setLayout(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Cambios/ Bajas Alumno");
        setSize(450, 470);
        this.getContentPane().setBackground(Color.darkGray);
        setLocationRelativeTo(null);
        setVisible(true);

        //agregar componentes graficos al JFrame
        // SIEMPRE EN TRES PASOS:  Creacion, Configuracion y Agregacion al JFrame
        JLabel lblTitulo = new JLabel();
        lblTitulo.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\TITULOCB.png"));;
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

        JLabel lblNumeroControl = new JLabel();
        lblNumeroControl.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\nc.PNG"));
        lblNumeroControl.setBounds(150, 85, 150, 20);
        add(lblNumeroControl);
        cajaNumControl = new JTextField(10);
        cajaNumControl.setBounds(130, 105, 170, 20);
        cajaNumControl.setEditable(false);
        add(cajaNumControl);

        JLabel lblPrimerAp = new JLabel();
        lblPrimerAp.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\nom.png"));
        lblPrimerAp.setBounds(150, 125, 130, 20);
        add(lblPrimerAp);
        cajaNombre = new JTextField(10);
        cajaNombre.setBounds(130, 145, 170, 20);
        ValidaCaracter valChar= new ValidaCaracter();
        cajaNombre.addKeyListener(valChar);
        add(cajaNombre);

        JLabel lblSegundoAp = new JLabel();
        lblSegundoAp.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\ap.png"));
        lblSegundoAp.setBounds(150, 165, 130, 20);
        add(lblSegundoAp);
        cajaPrimerAp = new JTextField(10);
        cajaPrimerAp.setBounds(130, 185, 170, 20);
        ValidaCaracter valChar2=new ValidaCaracter();
        cajaNombre.addKeyListener(valChar2);
        add(cajaPrimerAp);

        JLabel lblSegundoAp2 = new JLabel();
        lblSegundoAp2.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\am.png"));;
        lblSegundoAp2.setBounds(150, 205, 130, 20);
        add(lblSegundoAp2);
        cajaSegundoAp = new JTextField(10);
        cajaSegundoAp.setBounds(130, 225, 170, 20);
        ValidaCaracter valChar3=new ValidaCaracter();
        cajaNombre.addKeyListener(valChar3);
        add(cajaSegundoAp);

        JLabel lblcarrera = new JLabel();
        lblcarrera.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\car.png"));;
        lblcarrera.setBounds(150, 245, 170, 20);
        add(lblcarrera);
        //add(new JLabel("Carrera: ")).;
        ;
        combocarrera = new JComboBox<>();
        combocarrera.addItem("ING. Sistemas");
        combocarrera.addItem("ING. Mecatrónica");
        combocarrera.addItem("Administración");
        combocarrera.addItem("Contaduría");
        combocarrera.addItem("ING. Alimentaria");
        combocarrera.setBounds(130, 265, 170, 20);
        add(combocarrera);

        JLabel lblSmestre = new JLabel();
        lblSmestre.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\sem.png"));;
        lblSmestre.setBounds(150, 285, 170, 20);
        add(lblSmestre);

        combosemestre = new JComboBox<>();
        for (byte i = 1; i <= 13; i = (byte) (i + 1)) {
            combosemestre.addItem(i);
        }
        combosemestre.setBounds(130, 305, 170, 20);
        add(combosemestre);

        JLabel lblEdad = new JLabel();
        lblEdad.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\ed.png"));;
        lblEdad.setBounds(150, 325, 170, 20);
        add(lblEdad);

        comboEdad = new JComboBox<>();
        for (byte i = 1; i <= 100; i = (byte) (i + 1)) {
            comboEdad.addItem(i);
        }
        comboEdad.setBounds(130, 345, 170, 20);
        add(comboEdad);

        btncancel = new JButton();
        btncancel.setBounds(120, 385, 40, 40);
        btncancel.addActionListener(this);
        btncancel.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\E.PNG"));
        add(btncancel);

        btnEnviar = new JButton();
        btnEnviar.setBounds(270, 385, 40, 40);
        btnEnviar.addActionListener(this);
        btnEnviar.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\C.PNG"));
        add(btnEnviar);
    }

    @Override
    public void actionPerformed(ActionEvent x) {
        //Paso 3: Verificar que commponente genera el evento
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
                dispose();
            }
        //System.out.println( res ? "EXITO MODIFICADO !!!" : "Fallo en la MODIFICACION !!!" );
        }if(x.getSource()==btncancel){
            //System.out.println("Hola");
            String nUc = cajaNombre.getText();
            boolean res = new AlumnoDAO().eliminarAlumno(cajac.getText());

            //System.out.println( res ? "EXITO ELIMINADO !!!" : "Fallo en la ELIMINACION !!!" );
            JOptionPane.showMessageDialog(null, NuC+" Dado de baja con exito");
            dispose();
        }if(x.getSource()==btnBuscar){
            int valor=2;
            String nnc= cajac.getText();
            Alumno a = new AlumnoDAO().buscarAlumno(valor,cajac.getText());
            Alumno a2 = new AlumnoDAORACLE().buscarAlumno(cajac.getText());
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
class ValidaCaracterr extends KeyAdapter {
    public void keyPressed(KeyEvent ev){
        int codigo=(int) ev.getKeyChar();
        if(codigo>=33 && codigo<=64){
            ev.setKeyChar((char) KeyEvent.VK_CLEAR);//Limpiar el caracter ingresado
            JOptionPane.showMessageDialog(null, "Caracteres Invalidos!!!", "Validando Datos",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}

