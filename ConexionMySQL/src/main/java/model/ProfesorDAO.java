package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfesorDAO {

    private Connection connection;

    public ProfesorDAO (Connection connection){
        this.connection = connection;
    }

    public void agregarProfesor( ProfesorModel objeto) throws SQLException {
        String query = "INSERT INTO `profesor_AliEli`( `salario`) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setDouble(1, objeto.getSalario());
            stmt.executeUpdate();
        }
    }

}
