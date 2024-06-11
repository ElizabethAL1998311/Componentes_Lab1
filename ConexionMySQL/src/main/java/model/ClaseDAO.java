package model;
import java.sql.*;


public class ClaseDAO {
    private Connection connection;
    public ClaseDAO(Connection connection){
        this.connection = connection;
    }

    public void agregarClase(ClaseModel clase) throws SQLException {
        String query = "INSERT INTO clases_AliEli (clase_id, curso_id, profesor_id, fecha_clase, hora_inicio, hora_fin) VALUES (?, ?, ?, ?, ?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, clase.getId());
            stmt.setInt(2, clase.getCursoId());
            stmt.setInt(3, clase.getProfesorId());
            stmt.setDate(4, clase.getFechaClase());
            stmt.setTime(5, clase.getHoraInicio());
            stmt.setTime(6, clase.getHoraFin());
            stmt.executeUpdate();
        }
    }

    public ClaseModel obtenerClase(int claseId) throws SQLException {
        String query = "SELECT clase_id, curso_id, profesor_id, fecha_clase, hora_inicio, hora_fin FROM clases_AliEli WHERE clase_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, claseId);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("clase_id");
                    int cursoId = resultSet.getInt("curso_id");
                    int profesorId = resultSet.getInt("profesor_id");
                    Date fechaClase = resultSet.getDate("fecha_clase");
                    Time horaInicio = resultSet.getTime("hora_inicio");
                    Time horaFin = resultSet.getTime("hora_fin");

                    return new ClaseModel(id, cursoId, profesorId, fechaClase, horaInicio, horaFin);
                }
            }
        }
        return null;
    }

    public void editarClase(int claseId, int cursoId, int profesorId, Date fechaClase, Time horaInicio, Time horaFin) throws SQLException {
        String query = "UPDATE clases_AliEli SET curso_id = ?, profesor_id = ?, fecha_clase = ?, hora_inicio = ?, hora_fin = ? WHERE clase_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, cursoId);
            stmt.setInt(2, profesorId);
            stmt.setDate(3, fechaClase);
            stmt.setTime(4, horaInicio);
            stmt.setTime(5, horaFin);
            stmt.setInt(6, claseId);
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






  /*  DELETE FROM `curso` WHERE 0

    UPDATE `curso` SET `id`='[value-1]',`nombre`='[value-2]',`estado`='[value-3]' WHERE 1

    INSERT INTO `curso`(`id`, `nombre`, `estado`) VALUES ('[value-1]','[value-2]','[value-3]')

    SELECT `id`, `nombre`, `estado` FROM `curso` WHERE 1*/
}
