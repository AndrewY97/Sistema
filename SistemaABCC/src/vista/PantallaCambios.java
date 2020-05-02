package vista;

import javax.swing.*;
import controlador.AlumnoDAO;
import modelo.Alumno;


import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaCambios extends JFrame implements ActionListener {
    JButton btnEnviar, btncancel, btnBuscar;
    JTextField cajac;
    JTextField cajaPrimerAp, cajaSegundoAp, cajaSegundoAp2, cajaNombre;
    JComboBox<String> combocarrera;
    JComboBox<Byte> combosemestre, comboEdad;

    public PantallaCambios() {
        //configuracion ventana principal
        getContentPane().setLayout(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Cambios/ Bajas Alumno");
        setSize(450, 450);
        setLocationRelativeTo(null);
        setVisible(true);

        //agregar componentes graficos al JFrame
        // SIEMPRE EN TRES PASOS:  Creacion, Configuracion y Agregacion al JFrame
        JLabel lblTitulo = new JLabel();
        lblTitulo.setText("Cambios/ Bajas Alumno");
        lblTitulo.setBounds(5, 5, 300, 20);
        add(lblTitulo);

        JLabel lblbNumeroControl = new JLabel();
        lblbNumeroControl.setText("Numero de Control: ");
        lblbNumeroControl.setBounds(5, 25, 150, 20);
        add(lblbNumeroControl);
        cajac = new JTextField(10);
        cajac.setBounds(120, 25, 170, 20);
        add(cajac);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(300, 25, 100, 20);
        btnBuscar.addActionListener(this);
        add(btnBuscar);

        JLabel lblNumeroControl = new JLabel();
        lblNumeroControl.setText("Numero de Control: ");
        lblNumeroControl.setBounds(150, 45, 150, 20);
        add(lblNumeroControl);
        cajaNombre = new JTextField(10);
        cajaNombre.setBounds(110, 65, 170, 20);
        cajaNombre.setEditable(false);
        add(cajaNombre);

        JLabel lblPrimerAp = new JLabel("Nombres: ");
        lblPrimerAp.setBounds(150, 85, 100, 20);
        add(lblPrimerAp);
        cajaPrimerAp = new JTextField(10);
        cajaPrimerAp.setBounds(110, 105, 170, 20);
        add(cajaPrimerAp);

        JLabel lblSegundoAp = new JLabel("Apellido Paterno: ");
        lblSegundoAp.setBounds(150, 125, 100, 20);
        add(lblSegundoAp);
        cajaSegundoAp = new JTextField(10);
        cajaSegundoAp.setBounds(110, 145, 170, 20);
        add(cajaSegundoAp);

        JLabel lblSegundoAp2 = new JLabel("Apellido Materno: ");
        lblSegundoAp2.setBounds(150, 165, 100, 20);
        add(lblSegundoAp2);
        cajaSegundoAp2 = new JTextField(10);
        cajaSegundoAp2.setBounds(110, 185, 170, 20);
        add(cajaSegundoAp2);

        add(new JLabel("Carrera: ")).setBounds(150, 205, 170, 20);
        ;
        combocarrera = new JComboBox<>();
        combocarrera.addItem("ING. Sistemas");
        combocarrera.addItem("ING. Mecatronica");
        combocarrera.addItem("Admministracion");
        combocarrera.addItem("Contaduria");
        combocarrera.addItem("ING. Alimentarias");
        combocarrera.setBounds(110, 225, 170, 20);
        add(combocarrera);

        add(new JLabel("Semestre: ")).setBounds(150, 245, 170, 20);
        ;
        combosemestre = new JComboBox<>();
        for (byte i = 1; i <= 13; i = (byte) (i + 1)) {
            combosemestre.addItem(i);
        }
        combosemestre.setBounds(110, 265, 170, 20);
        add(combosemestre);


        add(new JLabel("Edad: ")).setBounds(150, 285, 170, 20);
        ;
        comboEdad = new JComboBox<>();
        for (byte i = 1; i <= 100; i = (byte) (i + 1)) {
            comboEdad.addItem(i);
        }
        comboEdad.setBounds(110, 305, 170, 20);
        add(comboEdad);

        btncancel = new JButton("Elimiar R");
        btncancel.setBounds(50, 345, 100, 20);
        btncancel.addActionListener(this);
        add(btncancel);

        btnEnviar = new JButton("Modificar> ");
        btnEnviar.setBounds(200, 345, 140, 20);
        btnEnviar.addActionListener(this);
        add(btnEnviar);
    }

    @Override
    public void actionPerformed(ActionEvent x) {
        //Paso 3: Verificar que commponente genera el evento
        String NuC = cajaNombre.getText();
        String NAME = cajaPrimerAp.getText();
        String PA = cajaSegundoAp.getText();
        String SA = cajaSegundoAp2.getText();
        byte E= (byte) comboEdad.getSelectedItem();
        byte S = (byte) combosemestre.getSelectedItem();
        String C = (String) combocarrera.getSelectedItem();
        if (x.getSource() == btnEnviar) {
            String nc = NuC;
            String n = NAME;
            String pa = PA;
            String sa = SA;
            byte e = E;
            byte s = S;
            String c = C;

        boolean res = new AlumnoDAO().modificarAlumno(new Alumno(nc, n, pa, sa, e, s , c));
            JOptionPane.showMessageDialog(null, NuC+" Modificado con exito");
        //System.out.println( res ? "EXITO MODIFICADO !!!" : "Fallo en la MODIFICACION !!!" );
        }if(x.getSource()==btncancel){
            System.out.println("Hola");
            String nUc = cajaNombre.getText();
            boolean res = new AlumnoDAO().eliminarAlumno(nUc);

            //System.out.println( res ? "EXITO ELIMINADO !!!" : "Fallo en la ELIMINACION !!!" );
            JOptionPane.showMessageDialog(null, NuC+" Dado de baja con exito");
        }if(x.getSource()==btnBuscar){
            String nnc= cajac.getText();
            Alumno a = new AlumnoDAO().buscarAlumno(cajac.getText());
            int [] miArreglo=new int [30];
            if ( a == null ){
                //System.out.println("Error");
                cajaNombre.setText("");
                JOptionPane.showMessageDialog(null, nnc+" No encontrado");}
            else {
                cajaNombre.setText(nnc);
                String str = String.valueOf(a);
                char[] ch = new char[str.length()];
                for(int i =0; i < str.length(); i = i + 1)
                {
                    if(ch[i]=='='){

                    }else{

                    }
                    ch[i] = str.charAt(i);
                }
                System.out.println(ch[2]);
            }

        }
    }
}
    class Prueba2 {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PantallaCambios();
            }
        });
    }
}
