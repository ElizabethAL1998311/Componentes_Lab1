package model;

import java.sql.*;

public class PersonaDAO {
    private Connection connection;

    public PersonaDAO(Connection connection){
        this.connection = connection;
    }

/*
    private String nombre;
    private String apellido;
    private String telefono;
    private String identificacion;
    private String correo;*/
    public void agregarUsuario( PersonaModel objeto) throws SQLException {
        String query = "INSERT INTO `persona_AliEli`( `nombre`, `identificacion`, `correo`,`apellido`,`telefono`) VALUES (?, ?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, objeto.getNombre());
            stmt.setString(2, objeto.getIdentificacion());
            stmt.setString(3, objeto.getCorreo());
            stmt.setString(4, objeto.getApellido());
            stmt.setString(5, objeto.getTelefono());
            stmt.executeUpdate();
        }
    }

    public PersonaModel obtenerUsuario(int usuario_id) throws SQLException {
        String query = "SELECT * FROM `persona_AliEli` WHERE `usuario_id` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, usuario_id);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    String identificacion = resultSet.getString("identificacion");
                    String correo = resultSet.getString("correo");
                    String apellido = resultSet.getString("apellido");
                    String telefono = resultSet.getString("telefono");
                    return new PersonaModel(usuario_id, nombre, identificacion, correo, apellido, telefono);
                }
            }
        }
        return null;
    }

    public void editarUsuario(PersonaModel usuario) throws SQLException {
        String query = "UPDATE `persona_AliEli` SET `nombre` = ?, `identificacion` = ?, `correo` = ?, `apellido` = ?, `telefono` = ? WHERE `usuario_id` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getIdentificacion());
            stmt.setString(3, usuario.getCorreo());
            stmt.setString(4, usuario.getApellido());
            stmt.setString(5, usuario.getTelefono());
            stmt.setInt(6, usuario.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminarUsuario(int usuario_id) throws SQLException {
        String query = "DELETE FROM persona_AliEli WHERE usuario_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, usuario_id);
            stmt.executeUpdate();
        }
    }

}
