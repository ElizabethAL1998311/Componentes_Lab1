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

    public EstudianteModel obtenerEstudiante(int estudiante_id) throws SQLException {
        String query = "SELECT * FROM `estudiante_AliEli` WHERE `estudiante_id` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, estudiante_id);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    String estado = resultSet.getString("estado");
                    return new EstudianteModel(estudiante_id,estado);
                }
            }
        }
        return null;
    }

}
