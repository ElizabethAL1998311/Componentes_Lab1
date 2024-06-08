package controller;

import model.*;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

public class ProfesorController {

    private ConsoleView viewConsole;

    private ProfesorDAO profesorDAO;

    public ProfesorController (ConsoleView viewConsole){
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.profesorDAO = new ProfesorDAO(connection);
    }

    public void agregarProfesor(int id,Double salario){
        ProfesorModel datos = new ProfesorModel(id,salario);

        try
        {
            profesorDAO.agregarProfesor(datos);
            viewConsole.showMessage("Insercion de datos correcta");
        }catch (SQLException e){
            viewConsole.errorMessage("Error al insertar datos: " + e.getMessage());
        }
    }

    public void obtenerProfesor(int profesor_id) {
        try {
            ProfesorModel profesor = profesorDAO.obtenerProfesor(profesor_id);
            if (profesor != null) {
                viewConsole.showMessage("Información del usuario: " + profesor.toString());
            } else {
                viewConsole.showMessage("Usuario no encontrado.");
            }
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al leer usuario: " + e.getMessage());
        }
    }
}
