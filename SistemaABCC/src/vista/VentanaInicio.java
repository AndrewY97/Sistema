package vista;

import javax.swing.*;

import controlador.AlumnoDAO;
import modelo.Alumno;

public class VentanaInicio extends JFrame {

    public static void mian(String[] args) {

        String nc = "3";
        String n = "3";
        String pa = "3";
        String sa = "3";
        byte e = 3 ;
        byte s = 3;
        String c = "3";

        boolean res = new AlumnoDAO().agregarAlumno(new Alumno());


        //----------------------------ELIMINAR----------------------------------------

        nc = "1";
        res = new AlumnoDAO().eliminarAlumno(nc);

        System.out.println(res ? "Exito!!! " : "Fallo en eliminacion");

        //-----------------------------ACTUALIZAR-------------------------------------


    }
}
