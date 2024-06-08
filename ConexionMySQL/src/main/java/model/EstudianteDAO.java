package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstudianteDAO {
    private Connection connection;

    public EstudianteDAO(Connection connection){
        this.connection = connection;
    }

    public void agregarEstudiante(EstudianteModel estudiante) throws SQLException {
        String query = "INSERT INTO estudiante_AliEli (estudiante_id, estado) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, estudiante.getId()); // Aquí deberías pasar el ID del estudiante
            stmt.setString(2, estudiante.getEstado());
            stmt.executeUpdate();
        }
    }

    public EstudianteModel obtenerEstudiante(int estudianteId) throws SQLException {
        String query = "SELECT e.estudiante_id, e.estado, u.usuario_id, u.nombre, u.identificacion, u.correo " +
                "FROM estudiante_AliEli e " +
                "JOIN usuario_AliEli u ON e.estudiante_id = u.usuario_id " +
                "WHERE e.estudiante_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, estudianteId);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    int usuarioId = resultSet.getInt("usuario_id");
                    String nombre = resultSet.getString("nombre");
                    String identificacion = resultSet.getString("identificacion");
                    String correo = resultSet.getString("correo");
                    String estado = resultSet.getString("estado");
                    return new EstudianteModel(usuarioId, nombre, identificacion, correo, estado);
                }
            }
        }
        return null;
    }

}
