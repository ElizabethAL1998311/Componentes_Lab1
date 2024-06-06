package model;

import java.sql.*;

public class UsuarioDAO {
    private Connection connection;

    public UsuarioDAO(Connection connection){
        this.connection = connection;
    }


    public void agregarUsuario( UsuarioModel objeto) throws SQLException {
        String query = "INSERT INTO `usuario_AliEli`( `nombre`, `identificacion`, `correo`) VALUES (?, ?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, objeto.getNombre());
            stmt.setString(2, objeto.getIdentificacion());
            stmt.setString(3, objeto.getCorreo());
            stmt.executeUpdate();
        }
    }
}
