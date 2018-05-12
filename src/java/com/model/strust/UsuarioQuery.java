
package com.model.strust;

import com.core.struts.ConexionDB;
import com.form.struts.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Erick Pereda
 */
public class UsuarioQuery {
   Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Usuario existeUsuario(String email, String contrasenia) {
        Usuario ur = new Usuario();
        try {
            conn = new ConexionDB().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM usuario\n"
                    + "WHERE (email= ? and password= ?);");
            ps = conn.prepareStatement(sb.toString());
            ps.setString(1, email);
            ps.setString(2, contrasenia);

            rs = ps.executeQuery();
  
            while (rs.next()) {
                ur.setId(rs.getInt("idusuario"));
                ur.setNombre(rs.getString("nombre"));
                ur.setEmail(rs.getString("email"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ignore) {
                }
            }
        }

        return ur;
    }
    public Boolean existeEmail(String email) {
        boolean busca = false;
        try {
            conn = new ConexionDB().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT idusuario , nombre FROM usuario \n"
                    + " WHERE email= ?;");
            ps = conn.prepareStatement(sb.toString());
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                busca = true;
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ignore) {
                }
            }
        }
        return busca;
    }
    
}
