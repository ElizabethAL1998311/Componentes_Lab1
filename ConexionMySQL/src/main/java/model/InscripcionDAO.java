package model;

import java.sql.*;

public class InscripcionDAO {

    private Connection connection;

    public InscripcionDAO(Connection connection) {
        this.connection = connection;
    }

    public void agregarInscripcion(InscripcionModel inscripcion) throws SQLException {
        String query = "INSERT INTO inscripciones_AliEli (estudiante_id, fecha_inscripcion, precio) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, inscripcion.getEstudianteId());
            stmt.setDate(2, inscripcion.getInscripcionDate());
            stmt.setDouble(3, inscripcion.getInscripcionPrice());
            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                inscripcion.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("No se pudo obtener el ID de la inscripción generada.");
            }
        }
    }

    public InscripcionModel obtenerInscripcion(int inscripcionId) throws SQLException {
        String query = "SELECT inscripcion_id, estudiante_id, fecha_inscripcion, precio FROM inscripciones_AliEli WHERE inscripcion_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, inscripcionId);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("inscripcion_id");
                    int estudianteId = resultSet.getInt("estudiante_id");
                    Date inscripcionDate = resultSet.getDate("fecha_inscripcion");
                    double inscripcionPrice = resultSet.getDouble("precio");

                    return new InscripcionModel(id, estudianteId, inscripcionDate, inscripcionPrice);
                }
            }
        }
        return null;
    }

    public void editarInscripcion(InscripcionModel inscripcion) throws SQLException {
        String query = "UPDATE inscripciones_AliEli SET estudiante_id = ?, fecha_inscripcion = ?, precio = ? WHERE inscripcion_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, inscripcion.getEstudianteId());
            stmt.setDate(2, inscripcion.getInscripcionDate());
            stmt.setDouble(3, inscripcion.getInscripcionPrice());
            stmt.setInt(4, inscripcion.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminarInscripcion(int inscripcionId) throws SQLException {
        String query = "DELETE FROM inscripciones_AliEli WHERE inscripcion_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, inscripcionId);
            stmt.executeUpdate();
        }
    }
}
