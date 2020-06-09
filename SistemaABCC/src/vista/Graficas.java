package vista;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import controlador.AlumnoDAO;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
class Graficas {
    public Graficas() throws SQLException {
        Double s = null, m = null, a = null, c = null, ali = null;
        int carr1 = new AlumnoDAO().graficas1(s);
        int carr2 = new AlumnoDAO().graficas2(m);
        int carr3 = new AlumnoDAO().graficas3(a);
        int carr4 = new AlumnoDAO().graficas4(c);
        int carr5 = new AlumnoDAO().graficas5(ali);
        DefaultPieDataset dataset = new DefaultPieDataset();
        System.out.println(carr1);
        dataset.setValue("ING. Sistemas", carr1);
        dataset.setValue("ING. Mecatrónica", carr2);
        dataset.setValue("Administración", carr3);
        dataset.setValue("Contaduría", carr4);
        dataset.setValue("ING. Alimentaria", carr5);

        JFreeChart chart = ChartFactory.createPieChart(// char t

                "Carreras Cursadas",// title
                dataset, // data
                true, // include legend
                true, false);


        ChartPanel panel = new ChartPanel(chart);


        //Creamos la ventana
        JFrame ventana = new JFrame("Graficas de Carreras");
        ventana.setVisible(true);
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


        ventana.add(panel);
    }
}
