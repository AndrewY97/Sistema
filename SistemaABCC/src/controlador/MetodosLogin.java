package controlador;
import conexionBD.ConexionBD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MetodosLogin {
    public String validar_ingreso(String u, String p){
        String resultado=null;
        //System.out.println(u);
        //System.out.println(p);
        String SSQL="SELECT * FROM usuarios WHERE usuario='"+u+"' AND contraseña='"+p+"'";
        Connection conect = null;
        try {
            ResultSet res = new ConexionBD().ejecutarConsultaRegistros(SSQL);
            if(res.next()){
                resultado="yes";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }

        return resultado;
    }
}
