package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfesorDAO {

    private Connection connection;

    public ProfesorDAO(Connection connection){
        this.connection = connection;
    }

    public void agregarProfesor(ProfesorModel profesor) throws SQLException {
        String query = "INSERT INTO profesor_AliEli ( profesor_id, salario) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, profesor.getId()); // Aquí deberías pasar el ID del estudiante
            stmt.setDouble(2, profesor.getSalario());
            stmt.executeUpdate();
        }
    }

    public ProfesorModel obtenerProfesor(int profesorId) throws SQLException {
        String query = "SELECT p.profesor_id, p.salario, u.usuario_id, u.nombre, u.identificacion, u.correo " +
                "FROM profesor_AliEli p " +
                "JOIN usuario_AliEli u ON p.profesor_id = u.usuario_id " +
                "WHERE p.profesor_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, profesorId);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    int usuarioId = resultSet.getInt("usuario_id");
                    String nombre = resultSet.getString("nombre");
                    String identificacion = resultSet.getString("identificacion");
                    String correo = resultSet.getString("correo");
                    double salario = resultSet.getDouble("salario");
                    return new ProfesorModel(usuarioId, nombre, identificacion, correo, salario);
                }
            }
        }
        return null;
    }

    public void eliminarProfesorPorUsuario(int usuario_id) throws SQLException {
        String query = "DELETE FROM profesor_AliEli WHERE profesor_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, usuario_id);
            stmt.executeUpdate();
        }
    }
}
