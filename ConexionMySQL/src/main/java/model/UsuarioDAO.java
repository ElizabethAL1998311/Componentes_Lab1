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

    public UsuarioModel obtenerUsuario(int usuario_id) throws SQLException {
        String query = "SELECT * FROM `usuario_AliEli` WHERE `usuario_id` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, usuario_id);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    String correo = resultSet.getString("correo");
                    String identificacion = resultSet.getString("identificacion");
                    return new UsuarioModel(usuario_id,nombre, identificacion, correo);
                }
            }
        }
        return null;
    }
}
