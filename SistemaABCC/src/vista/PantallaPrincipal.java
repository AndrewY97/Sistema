package vista;

import controlador.AlumnoDAO;
import modelo.Alumno;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PantallaPrincipal extends JFrame implements ActionListener {
    JButton btnEnviar, btncancel;
    JTextField cajaPrimerAp, cajaSegundoAp, cajaSegundoAp2, cajaNombre;
    JComboBox<String> combocarrera;
    JComboBox<Byte> combosemestre, comboEdad;

    public PantallaPrincipal() {
        //configuracion ventana principal
        getContentPane().setLayout(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Registro de Alumno");
        setSize(450, 450);
        setLocationRelativeTo(null);
        setResizable(true);
        //setVisible(true);

        //agregar componentes graficos al JFrame
        // SIEMPRE EN TRES PASOS:  Creacion, Configuracion y Agregacion al JFrame
        JLabel lblTitulo = new JLabel();
        lblTitulo.setText("Registrar Alumno");
        lblTitulo.setBounds(5, 5, 100, 20);
        add(lblTitulo);

        JLabel lblNumeroControl = new JLabel();
        lblNumeroControl.setText("Numero de Control: ");
        lblNumeroControl.setBounds(150, 25, 150, 20);
        add(lblNumeroControl);
        cajaNombre = new JTextField(10);
        cajaNombre.setBounds(110, 45, 170, 20);
        add(cajaNombre);

        JLabel lblPrimerAp = new JLabel("Nombres: ");
        lblPrimerAp.setBounds(150, 65, 100, 20);
        add(lblPrimerAp);
        cajaPrimerAp = new JTextField(10);
        cajaPrimerAp.setBounds(110, 85, 170, 20);
        add(cajaPrimerAp);

        JLabel lblSegundoAp = new JLabel("Apellido Paterno: ");
        lblSegundoAp.setBounds(150, 105, 100, 20);
        add(lblSegundoAp);
        cajaSegundoAp = new JTextField(10);
        cajaSegundoAp.setBounds(110, 125, 170, 20);
        add(cajaSegundoAp);

        JLabel lblSegundoAp2 = new JLabel("Apellido Materno: ");
        lblSegundoAp2.setBounds(150, 145, 100, 20);
        add(lblSegundoAp2);
        cajaSegundoAp2 = new JTextField(10);
        cajaSegundoAp2.setBounds(110, 165, 170, 20);
        add(cajaSegundoAp2);

        add(new JLabel("Carrera: ")).setBounds(150, 185, 170, 20);
        ;
        combocarrera = new JComboBox<>();
        combocarrera.addItem("ING. Sistemas");
        combocarrera.addItem("ING. Mecatronica");
        combocarrera.addItem("Admministracion");
        combocarrera.addItem("Contaduria");
        combocarrera.addItem("ING. Alimentarias");
        combocarrera.setBounds(110, 205, 170, 20);
        add(combocarrera);

        add(new JLabel("Semestre: ")).setBounds(150, 225, 170, 20);
        ;
        combosemestre = new JComboBox<>();
        for (byte i = 1; i <= 13; i = (byte) (i + 1)) {
            combosemestre.addItem(i);
        }
        combosemestre.setBounds(110, 245, 170, 20);
        add(combosemestre);


        add(new JLabel("Edad: ")).setBounds(150, 265, 170, 20);
        ;
        comboEdad = new JComboBox<>();
        for (byte i = 1; i <= 100; i = (byte) (i + 1)) {
            comboEdad.addItem(i);
        }
        comboEdad.setBounds(110, 285, 170, 20);
        add(comboEdad);

        btncancel = new JButton("Cancelar");
        btncancel.setBounds(50, 325, 100, 20);
        add(btncancel);

        btnEnviar = new JButton("Registrar >> ");
        btnEnviar.setBounds(200, 325, 140, 20);
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

            boolean res = new AlumnoDAO().agregarAlumno(new Alumno(nc, n, pa, sa, e, s , c));

            System.out.println( res ? "EXITO !!!" : "Fallo en la INSERCION !!!" );
        }
    }

}
    class PruebaPrincipal {
        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new PantallaPrincipal();
                }
            });

        }
    }




