package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

}
