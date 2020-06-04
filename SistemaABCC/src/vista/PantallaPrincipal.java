package vista;

import controlador.AlumnoDAO;
import modelo.Alumno;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PantallaPrincipal extends JFrame implements ActionListener {
    JButton btnEnviar, btncancel;
    JTextField cajaNumControl, cajaNombre, cajaSegundoAp, cajaPrimerAp;
    JComboBox<String> combocarrera;
    JComboBox<Byte> combosemestre, comboEdad;

    public PantallaPrincipal() {
        //configuracion ventana principal
        getContentPane().setLayout(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Registro");
        setSize(450, 470);
        this.getContentPane().setBackground(Color.darkGray);
        setLocationRelativeTo(null);
        setVisible(true);

        //agregar componentes graficos al JFrame
        // SIEMPRE EN TRES PASOS:  Creacion, Configuracion y Agregacion al JFrame
        JLabel lblTitulo = new JLabel();
        lblTitulo.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\TITULOA.png"));;
        lblTitulo.setBounds(55, 5, 350, 50);
        add(lblTitulo);

        JLabel lblNumeroControl = new JLabel();
        lblNumeroControl.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\nc.PNG"));
        lblNumeroControl.setBounds(150, 45, 150, 20);
        add(lblNumeroControl);
        cajaNumControl = new JTextField(10);
        cajaNumControl.setBounds(130, 65, 170, 20);
        //cajaNumControl.setEditable(false);
        add(cajaNumControl);

        JLabel lblPrimerAp = new JLabel();
        lblPrimerAp.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\nom.png"));
        lblPrimerAp.setBounds(150, 85, 130, 20);
        add(lblPrimerAp);
        cajaNombre = new JTextField(10);
        cajaNombre.setBounds(130, 105, 170, 20);
        ValidaCaracter valChar=new ValidaCaracter();
        cajaNombre.addKeyListener(valChar);
        add(cajaNombre);

        JLabel lblSegundoAp = new JLabel();
        lblSegundoAp.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\ap.png"));
        lblSegundoAp.setBounds(150, 125, 130, 20);
        add(lblSegundoAp);
        cajaPrimerAp = new JTextField(10);
        cajaPrimerAp.setBounds(130, 145, 170, 20);
        ValidaCaracter valChar2=new ValidaCaracter();
        cajaPrimerAp.addKeyListener(valChar2);
        add(cajaPrimerAp);

        JLabel lblSegundoAp2 = new JLabel();
        lblSegundoAp2.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\am.png"));;
        lblSegundoAp2.setBounds(150, 165, 130, 20);
        add(lblSegundoAp2);
        cajaSegundoAp = new JTextField(10);
        cajaSegundoAp.setBounds(130, 185, 170, 20);
        ValidaCaracter valChar3=new ValidaCaracter();
        cajaSegundoAp.addKeyListener(valChar3);
        add(cajaSegundoAp);

        JLabel lblcarrera = new JLabel();
        lblcarrera.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\car.png"));;
        lblcarrera.setBounds(150, 205, 170, 20);
        add(lblcarrera);
        //add(new JLabel("Carrera: ")).;
        ;
        combocarrera = new JComboBox<>();
        combocarrera.addItem("ING. Sistemas");
        combocarrera.addItem("ING. Mecatronica");
        combocarrera.addItem("Admministracion");
        combocarrera.addItem("Contaduria");
        combocarrera.addItem("ING. Alimentarias");
        combocarrera.setBounds(130, 225, 170, 20);
        add(combocarrera);

        JLabel lblSmestre = new JLabel();
        lblSmestre.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\sem.png"));;
        lblSmestre.setBounds(150, 245, 170, 20);
        add(lblSmestre);

        combosemestre = new JComboBox<>();
        for (byte i = 1; i <= 13; i = (byte) (i + 1)) {
            combosemestre.addItem(i);
        }
        combosemestre.setBounds(130, 265, 170, 20);
        add(combosemestre);

        JLabel lblEdad = new JLabel();
        lblEdad.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\ed.png"));;
        lblEdad.setBounds(150, 285, 170, 20);
        add(lblEdad);

        comboEdad = new JComboBox<>();
        for (byte i = 1; i <= 100; i = (byte) (i + 1)) {
            comboEdad.addItem(i);
        }
        comboEdad.setBounds(130, 305, 170, 20);
        add(comboEdad);

        btncancel = new JButton();
        btncancel.setBounds(120, 345, 40, 40);
        btncancel.addActionListener(this);
        btncancel.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\cancelar.PNG"));
        add(btncancel);

        btnEnviar = new JButton();
        btnEnviar.setBounds(270, 345, 40, 40);
        btnEnviar.addActionListener(this);
        btnEnviar.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\a.PNG"));
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

                //System.out.println( res ? "EXITO !!!" : "Fallo en la INSERCION !!!" );
                JOptionPane.showMessageDialog(null,NuC+" Dado de alta con exito");
            }

        }if(x.getSource() == btncancel){
            cajaNumControl.setText("");
            cajaNombre.setText("");
            cajaPrimerAp.setText("");
            cajaSegundoAp.setText("");
        }
    }

}
class ValidaCaracter extends KeyAdapter {
    public void keyPressed(KeyEvent ev){
        int codigo=(int) ev.getKeyChar();
        if(codigo>=33 && codigo<=64){
            ev.setKeyChar((char) KeyEvent.VK_CLEAR);//Limpiar el caracter ingresado
            JOptionPane.showMessageDialog(null, "Caracteres Invalidos!!!", "Validando Datos",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}





