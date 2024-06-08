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

    public EstudianteModel obtenerProfesor(int profesor_id) throws SQLException {
        String query = "SELECT * FROM `profesor_AliEli` WHERE `profesor_id` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, profesor_id);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    String salario = String.valueOf(resultSet.getDouble("salario"));
                    return new EstudianteModel(profesor_id,salario);
                }
            }
        }
        return null;
    }
}
