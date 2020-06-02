package vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JButton btnOK,btncancel;
    JTextField cajau,cajapass;
    public Login(){
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Login");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
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
