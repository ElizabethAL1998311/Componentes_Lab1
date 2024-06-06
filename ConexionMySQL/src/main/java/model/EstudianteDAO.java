package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EstudianteDAO {
    private Connection connection;

    public EstudianteDAO(Connection connection){
        this.connection = connection;
    }

}
