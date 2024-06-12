package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RolDAO {
    private Connection connection;

    public RolDAO(Connection connection){
        this.connection = connection;
    }

    public void agregarRol(RolModel rol) throws SQLException {
        String query = "INSERT INTO rol_AliEli ( rol_id, nombre,descripcion) VALUES (?, ?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, rol.getId());
            stmt.setString(2, rol.getNombre());
            stmt.setString(2, rol.getDescripcion());
            stmt.executeUpdate();
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
                    return new RolModel(rol_id, nombre, descripcion);
                }
            }
        }
        return null;
    }

    public void editarRol(int rol_id, String nombre, String descripcion) throws SQLException {
        String query = "UPDATE rol_AliEli SET nombre,descripcion = ? WHERE rol_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.setString(1, descripcion);
            stmt.setInt(2, rol_id);
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
