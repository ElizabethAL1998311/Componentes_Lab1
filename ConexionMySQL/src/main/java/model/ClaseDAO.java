package model;
import java.sql.*;


public class ClaseDAO {
    private Connection connection;
    public ClaseDAO(Connection connection){
        this.connection = connection;
    }

    public void agregarClase(ClaseModel clase) throws SQLException {
        String query = "INSERT INTO clases_AliEli (clase_id, profesor_id, fecha_clase, hora_inicio, hora_fin) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, clase.getId());
            stmt.setInt(2, clase.getProfesorId());
            stmt.setDate(3, clase.getFechaClase());
            stmt.setTime(4, clase.getHoraInicio());
            stmt.setTime(5, clase.getHoraFin());
            stmt.executeUpdate();
        }
    }

    public ClaseModel obtenerClase(int claseId) throws SQLException {
        String query = "SELECT clase_id, profesor_id, fecha_clase, hora_inicio, hora_fin FROM clases_AliEli WHERE clase_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, claseId);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("clase_id");
                    int profesorId = resultSet.getInt("profesor_id");
                    Date fechaClase = resultSet.getDate("fecha_clase");
                    Time horaInicio = resultSet.getTime("hora_inicio");
                    Time horaFin = resultSet.getTime("hora_fin");

                    return new ClaseModel(id, profesorId, fechaClase, horaInicio, horaFin);
                }
            }
        }
        return null;
    }

    public void editarClase(int claseId, int profesorId, Date fechaClase, Time horaInicio, Time horaFin) throws SQLException {
        String query = "UPDATE clases_AliEli SET profesor_id = ?, fecha_clase = ?, hora_inicio = ?, hora_fin = ? WHERE clase_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, profesorId);
            stmt.setDate(2, fechaClase);
            stmt.setTime(3, horaInicio);
            stmt.setTime(4, horaFin);
            stmt.setInt(5, claseId);
            stmt.executeUpdate();
        }
    }

    public void eliminarClase(int claseId) throws SQLException {
        String query = "DELETE FROM clases_AliEli WHERE clase_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, claseId);
            stmt.executeUpdate();
        }
    }
}
