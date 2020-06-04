package controlador;

import conexionBD.ConexionOracle;
import modelo.Alumno;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Data Access Object
public class AlumnoDAORACLE {

    //========================Metodos que permiten realizar las operaciones ABCC ============================

    public boolean agregarAlumno(Alumno a){

        //INSERT INTO Alumnos VALUES("1", '1', '1', '1', 1, 1, '1');
        String sql = "INSERT INTO alumnos VALUES('"+a.getNumControl()
                +"','" + a.getNombre()
                +"','" + a.getPrimerAp()
                +"','" + a.getSegundoAp()
                +"', " + a.getEdad()
                +", " + a.getSemestre()
                +", '" + a.getCarrera()+ "')";

        boolean resultado = new ConexionOracle().ejecutarInstruccion(sql);
        System.out.println("ALUMNO DAO: " + resultado);

        return resultado;
    }

    public boolean eliminarAlumno(String numControl){

        //DELETE FROM Alumnos WHERE Num_Control = '3';
        String sql = "DELETE FROM Alumnos WHERE Num_Control = '"+numControl+"'";
        return new ConexionOracle().ejecutarInstruccion(sql);
    }


    public boolean modificarAlumno(Alumno a){
        //UPDATE Alumnos SET Nombre_Alumno='x', Primer_Ap_Alumno='x', Segundo_Ap_Alumno='x', Edad_Alumno=0, Semestre=0,
        //    Carrera='x' WHERE Num_Control='3';

        String sql = "UPDATE Alumnos SET Nombre_Alumno='"+a.getNombre()
                +"', Primer_Ap_Alumno='" + a.getPrimerAp()
                +"', Segundo_Ap_Alumno='" + a.getSegundoAp()
                +"', Edad_Alumno=" + a.getEdad()
                +", Semestre=" + a.getSemestre()
                +", Carrera='" + a.getCarrera()+ "' WHERE Num_Control='"+a.getNumControl()+"'";

        boolean resultado = new ConexionOracle().ejecutarInstruccion(sql);
        System.out.println("ALUMNO DAO: " + resultado);

        return resultado;
    }

    public Alumno buscarAlumno(String numControl){
        //SELECT * FROM Alumnos WHERE Num_Control = '2';
        String sql = "SELECT * FROM Alumnos WHERE Num_Control = '"+numControl+"'";

        ResultSet res = new ConexionOracle().ejecutarConsultaRegistros(sql);

        try {
            res.last();

            return new Alumno(res.getString("Num_Control"),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getByte(5),
                    res.getByte(6),
                    res.getString(7)
            );

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public ArrayList<Alumno> buscarAlumnos(Boolean filtro){
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        String sql = "SELECT * FROM Alumnos";

        ResultSet rs = new ConexionOracle().ejecutarConsultaRegistros(sql);

        try {
            rs.first();
            do{
                listaAlumnos.add(new Alumno(rs.getString("Num_Control"),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getByte(5),
                        rs.getByte(6),
                        rs.getString(7)
                ));
            }while (rs.next());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaAlumnos;
    }


}
