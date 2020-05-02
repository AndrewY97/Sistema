package vista;

import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.AlumnoDAO;
import modelo.Alumno;
import conexionBD.ConexionBD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PantallaConsultas extends JFrame implements ActionListener {
    JTextField cajaNombre;
    JButton btnBuscar;
    JTable tabla;

    public PantallaConsultas() {
        getContentPane().setLayout(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Consulta Alumno");
        setSize(550, 450);
        setLocationRelativeTo(null);
        setVisible(true);

        JLabel lblTitulo = new JLabel();
        lblTitulo.setText("Consultar  Alumno");
        lblTitulo.setBounds(5, 5, 150, 20);
        add(lblTitulo);

        JLabel lblNumeroControl = new JLabel();
        lblNumeroControl.setText("Numero de Control: ");
        lblNumeroControl.setBounds(5, 25, 150, 20);
        add(lblNumeroControl);
        cajaNombre = new JTextField(10);
        cajaNombre.setBounds(120, 25, 170, 20);
        add(cajaNombre);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(300, 25, 100, 20);
        btnBuscar.addActionListener(this

        );
        add(btnBuscar);

        /*Object titulos[] = {"Numero Control", "Nombre", "Apellido P", "Apellido M", ""};
        Object celdas[][] = new Object[4][5];
        JScrollPane scroll = new JScrollPane();
        tablaalumnos = new JTable(celdas, titulos);
        scroll.setViewportView(tablaalumnos);
        scroll.setBounds(50, 70, 400, 100);
        getContentPane().add(scroll);*/
    }
    public void mostrar(){
        DefaultTableModel modelo = new DefaultTableModel();
        //ResultSet rs = ConexionBD.ejecutarConsultaRegistros("SELECT * FROM alumnos ORDER BY Num_Control");
        boolean filtro = true;
        ArrayList<Alumno> listaAlumnos = new AlumnoDAO().buscarAlumnos(filtro);
        modelo.setColumnIdentifiers(new Object[]{"Num_Control","Nombre_Alumno"});
        try{
            //System.out.println(listaAlumnos);
            //tabla.setModel(modelo);
            for(Alumno alumno:listaAlumnos) {
                System.out.println(alumno);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        //modelo.setColumnIdentifiers(new Object[]{rs.getString("nombres"),rs.getString("apellidos")});
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Alumno a = new AlumnoDAO().buscarAlumno(cajaNombre.getText());
        if ( a == null )
            //System.out.println("Error");
            JOptionPane.showMessageDialog(null, "Numero de Control no encontrado");
        else {
            //System.out.println(a);
            JOptionPane.showMessageDialog(null, a);
        }

    }

}

class pantallaconsulta {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PantallaConsultas();
            }
        });
    }
    }
