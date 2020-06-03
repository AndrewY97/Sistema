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
        setDefaultCloseOperation(HIDE_ON_CLOSE);
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

        JLabel lblcon = new JLabel();
        lblcon.setIcon(new ImageIcon("C:\\Users\\yero9\\IdeaProjects\\SistemaABCC\\src\\vista\\Imagenes\\contra.png"));
        lblcon.setBounds(5, 120, 150, 60);
        add(lblcon);

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
