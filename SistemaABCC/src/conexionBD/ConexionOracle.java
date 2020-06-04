package conexionBD;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionOracle {
    private Connection conexion;
    //private Statement stm; //problema: permite SQL INJECTION

    private PreparedStatement ps; //evita SQL INJECTION

    private ResultSet rs;

    private static Connection con=null;

    private static Connection getConnection(){
        try{
            if( con == null ){
                String driver="oracle.jdbc.driver.OracleDriver"; //el driver varia segun la DB que usemos
                String url="jdbc:oracle:thin:@localhost:1521:bdescuela";
                String pwd="Acevedoa97";
                String usr="SYSTEM";
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
            Connection c = ConexionOracle.getConnection();
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
            Connection c = ConexionOracle.getConnection();
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
