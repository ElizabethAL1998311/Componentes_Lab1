package controller;

import model.ClaseDAO;
import model.ClaseModel;
import model.conexion;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

public class ClaseController {
    private ConsoleView viewConsole;

    private ClaseDAO claseDAO;

    public ClaseController (ConsoleView viewConsole){
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.claseDAO = new ClaseDAO(connection);
    }

    public void agregarCurso(String nombre, int estado){
        ClaseModel datos = new ClaseModel(nombre, estado);

        try
        {
            claseDAO.agregarClase(datos);
            viewConsole.showMessage("Insercion de datos correcta");
        }catch (SQLException e){
            viewConsole.errorMessage("Error al insertar datos: " + e.getMessage());
        }
    }

}
