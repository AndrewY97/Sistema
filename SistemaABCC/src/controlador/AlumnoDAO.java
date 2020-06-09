package controlador;

import conexionBD.ConexionBD;
import modelo.Alumno;
import modelo.Usuario;
import org.jfree.data.general.DefaultPieDataset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Data Access Object
public class AlumnoDAO {

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

        boolean resultado = new ConexionBD().ejecutarInstruccion(sql);
        System.out.println("ALUMNO DAO: " + resultado);
        return resultado;
    }


    public boolean eliminarAlumno(String numControl){

        //DELETE FROM Alumnos WHERE Num_Control = '3';
        String sql = "DELETE FROM Alumnos WHERE Num_Control = '"+numControl+"'";
        return new ConexionBD().ejecutarInstruccion(sql);
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

        boolean resultado = new ConexionBD().ejecutarInstruccion(sql);
        System.out.println("ALUMNO DAO: " + resultado);

        return resultado;
    }

    public Alumno buscarAlumno(int valor,String numControl){
        //SELECT * FROM Alumnos WHERE Num_Control = '2';
        String sql=null;
        String campo = null;
        if(valor==2){
            sql = "SELECT * FROM Alumnos WHERE Num_Control = '"+numControl+"'";
            campo = "Num_Control";
        }if(valor==3){
            sql = "SELECT * FROM Alumnos WHERE Nombre_Alumno = '"+numControl+"'";
            campo ="Nombre_Alumno";
        }if(valor==1){
            sql = "SELECT * FROM Alumnos WHERE Carrera = '"+numControl+"'";
            campo ="Carrera";
        }

        ResultSet res = new ConexionBD().ejecutarConsultaRegistros(sql);

        try {
            res.last();

            return new Alumno(res.getString(campo),
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

        ResultSet rs = new ConexionBD().ejecutarConsultaRegistros(sql);

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


    public boolean agregausuario(Usuario a) {
        //INSERT INTO Alumnos VALUES("1", '1', '1', '1', 1, 1, '1');
        String sql = "INSERT INTO usuarios VALUES('"+a.getNumControl()
                +"','" + a.getNombre()+ "')";

        boolean resultado = new ConexionBD().ejecutarInstruccion(sql);
        System.out.println("ALUMNO DAO: " + resultado);
        return resultado;
    }

    public int  graficas1(Double s) throws SQLException {
        String con1 = "SELECT COUNT(*) FROM alumnos WHERE Carrera = 'ING. Sistemas';";

        ResultSet resultado = new ConexionBD().ejecutarConsultaRegistros(con1);
        DefaultPieDataset dataset = new DefaultPieDataset();

        int N_Registros = 0;
        if (resultado.next()) {
            N_Registros = resultado.getInt("count(*)");
        }
        return N_Registros;
    }

    public int  graficas2(Double m) throws SQLException {
        String con1 = "SELECT COUNT(*) FROM alumnos WHERE Carrera = 'ING. Mecatrónica';";

        ResultSet resultado = new ConexionBD().ejecutarConsultaRegistros(con1);
        DefaultPieDataset dataset = new DefaultPieDataset();

        int N_Registros = 0;
        if (resultado.next()) {
            N_Registros = resultado.getInt("count(*)");
        }
        return N_Registros;
    }

    public int  graficas3(Double a) throws SQLException {
        String con1 = "SELECT COUNT(*) FROM alumnos WHERE Carrera = 'Administración';";

        ResultSet resultado = new ConexionBD().ejecutarConsultaRegistros(con1);
        DefaultPieDataset dataset = new DefaultPieDataset();

        int N_Registros = 0;
        if (resultado.next()) {
            N_Registros = resultado.getInt("count(*)");
        }
        return N_Registros;
    }

    public int  graficas4(Double c) throws SQLException {
        String con1 = "SELECT COUNT(*) FROM alumnos WHERE Carrera = 'Contaduría';";

        ResultSet resultado = new ConexionBD().ejecutarConsultaRegistros(con1);
        DefaultPieDataset dataset = new DefaultPieDataset();

        int N_Registros = 0;
        if (resultado.next()) {
            N_Registros = resultado.getInt("count(*)");
        }
        return N_Registros;
    }

    public int  graficas5(Double ali) throws SQLException {
        String con1 = "SELECT COUNT(*) FROM alumnos WHERE Carrera = 'ING. Alimentos';";

        ResultSet resultado = new ConexionBD().ejecutarConsultaRegistros(con1);
        DefaultPieDataset dataset = new DefaultPieDataset();

        int N_Registros = 0;
        if (resultado.next()) {
            N_Registros = resultado.getInt("count(*)");
        }
        return N_Registros;
    }
}
