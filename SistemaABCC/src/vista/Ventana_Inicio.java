package vista;

import controlador.AlumnoDAO;
import modelo.Alumno;

import javax.swing.*;
import java.util.ArrayList;

public class Ventana_Inicio extends JFrame {


    public static void main(String[] args) {

        //-------------------------------------AGREGAR---------------------------------------
        //Suponer que estos datos vienen desde la GUI
        String nc = "4";
        String n = "4";
        String pa = "4";
        String sa = "4";
        byte e = 4;
        byte s = 4;
        String c = "4";
/*
        boolean res = new AlumnoDAO().agregarAlumno(new Alumno(nc, n, pa, sa, e, s , c));

        System.out.println( res ? "EXITO !!!" : "Fallo en la INSERCION !!!" );

        //------------------------------------ELIMINAR-----------------------------------------------

        nc = "2";
        res = new AlumnoDAO().eliminarAlumno(nc);

        System.out.println( res ? "EXITO ELIMINADO !!!" : "Fallo en la ELIMINACION !!!" );


        //------------------------------------ACTUALIZAR-----------------------------------------------

        nc = "11"; //NO DEBE CAMBIAR

        n = "z";
        pa = "z";
        sa = "z";
        e = 0;
        s = 0;
        c = "z";

        boolean res = new AlumnoDAO().modificarAlumno(new Alumno(nc, n, pa, sa, e, s , c));
        System.out.println( res ? "EXITO MODIFICADO !!!" : "Fallo en la MODIFICACION !!!" );

*/
        //------------------------------------MOSTRAR UN ALUMNO  ---------------------------------------
        /*Alumno a = new AlumnoDAO().buscarAlumno(Num_Control,"2");
        if ( a == null )
            System.out.println("Error");
        else {
            System.out.println(a);
        }*/

        //------------------------------------MOSTRAR MUCHOS ALUMNOS-----------------------------------
        /*ArrayList<Alumno> listaAlumnos = new AlumnoDAO().buscarAlumnos("");
        for(Alumno alumno:listaAlumnos){
            System.out.println(alumno);
        }*/


    }

}
