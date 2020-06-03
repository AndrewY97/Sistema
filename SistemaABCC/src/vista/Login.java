package vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JButton btnOK,btncancel;
    JTextField cajau,cajapass;

    public Login(){
        getContentPane().setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Login");
        this.getContentPane().setBackground(Color.darkGray);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        JLabel lblTitulo = new JLabel();
        lblTitulo.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\Log.png"));
        lblTitulo.setBounds(105, 5, 150, 60);
        add(lblTitulo);

        JLabel lblus = new JLabel();
        lblus.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\us.png"));
        lblus.setBounds(5, 70, 150, 60);
        add(lblus);
        cajau = new JTextField(10);
        cajau.setBounds(87, 93, 170, 20);
        add(cajau);

        JLabel lblcon = new JLabel();
        lblcon.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\contra.png"));
        lblcon.setBounds(5, 120, 150, 60);
        add(lblcon);
        cajapass = new JTextField(10);
        cajapass.setBounds(124, 142, 170, 20);
        add(cajapass);

        btnOK = new JButton();
        btnOK.setBounds(260, 190, 40, 40);
        btnOK.addActionListener(this);
        //btnBuscar.setBackground(Color.darkGray);
        btnOK.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\si.PNG"));
        add(btnOK);

        btncancel = new JButton();
        btncancel.setBounds(100, 190, 40, 40);
        btncancel.addActionListener(this);
        //btnBuscar.setBackground(Color.darkGray);
        btncancel.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\no.PNG"));
        add(btncancel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String usuario="Andrew";
        String pass="Acevedoa97";
        String u=cajau.getText();
        String p=cajapass.getText();
        if (e.getSource()==btnOK) {
            //System.out.println(cajau.getText());
            if(usuario.equals(u) && pass.equals(p)){
                VentanaPrincipal VP= new VentanaPrincipal();
                VP.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"Datos erroneos");
            }
        }else{
            cajau.setText("");
            cajapass.setText("");
        }

    }
}

class log {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login();
            }
        });

    }
}
