package model;

import java.sql.*;

public class RolDAO {
    private Connection connection;

    public RolDAO(Connection connection){
        this.connection = connection;
    }

    public void agregarRol(RolModel rol) throws SQLException {
        String query = "INSERT INTO rol_AliEli (nombre, descripcion) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, rol.getNombre());
            stmt.setString(2, rol.getDescripcion());
            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                rol.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("No se pudo obtener el ID del rol generado.");
            }
        }
    }


    public RolModel obtenerRol(int rol_id) throws SQLException {
        String query = "SELECT * FROM `rol_AliEli` WHERE `rol_id` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, rol_id);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    String descripcion = resultSet.getString("descripcion");
                    return new RolModel(nombre, descripcion);
                }
            }
        }
        return null;
    }

    public void editarRol(RolModel rol) throws SQLException {
        String query = "UPDATE rol_AliEli SET nombre = ?, descripcion = ? WHERE rol_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, rol.getNombre());
            stmt.setString(2, rol.getDescripcion());
            stmt.setInt(3, rol.getId());
            stmt.executeUpdate();
        }
    }


    public void eliminarRol(int  rol_id) throws SQLException {
        String query = "DELETE FROM rol_AliEli WHERE  rol_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1,  rol_id);
            stmt.executeUpdate();
        }
    }

}
