package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

    private Connection conexion;
    //private Statement stm; //problema: permite SQL INJECTION

    private PreparedStatement ps; //evita SQL INJECTION

    private ResultSet rs;

    private static Connection con=null;

    private static Connection getConnection(){
        try{
            if( con == null ){
                String driver="com.mysql.cj.jdbc.Driver"; //el driver varia segun la DB que usemos
                String url="jdbc:mysql://localhost:3306/BD_Escuela?useTimezone=true&serverTimezone=UTC";
                String pwd="acevedoa97";
                String usr="Andrew";
                Class.forName(driver);
                con = DriverManager.getConnection(url,usr,pwd);
                System.out.println("Conectionesfull");
            }
        }
        catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
        return con;
    }


    //Metodo para ejecutar instrucciones DDL y DML (Altas, Bajas y Cambios, entre otras)
    public boolean ejecutarInstruccion(String sql) {
        try {
            Connection c = ConexionBD.getConnection();
            //PreparedStatement st;
            ps = c.prepareStatement(sql);
            int res = ps.executeUpdate(sql);
            System.out.println("CONEXION BD: " + res);
            return res==1 ? true : false;

        } catch (SQLException throwables) {
            System.out.println("Error en la instruccion SQL \n" + sql);
            throwables.printStackTrace();
            return false;
        }

    }

    //Metodo para CONSULTAS (instrucciones SQL, por ejemplo SELECT * FROM ....)
    public ResultSet ejecutarConsultaRegistros(String sql) {
        ResultSet rs = null;
        try {
            Connection c = ConexionBD.getConnection();
            //PreparedStatement st;
            ps = c.prepareStatement(sql);
            return ps.executeQuery(sql);
        } catch (SQLException throwables) {
            System.out.println("Error en la instruccion SQL \n" + sql);
            throwables.printStackTrace();
            return  rs;
        }
    }

    public void cerrarConexion(){
        try {
            ps.close();
            conexion.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


	/*public static void main(String[] args) {
		new ConexionBD();
	}*/


}
