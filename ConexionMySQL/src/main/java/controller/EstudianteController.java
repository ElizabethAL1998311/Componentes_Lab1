package controller;

import model.*;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

public class EstudianteController {

    private ConsoleView viewConsole;

    private EstudianteDAO estudianteDAO;

    public EstudianteController (ConsoleView viewConsole){
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.estudianteDAO = new EstudianteDAO(connection);
    }

    public void agregarEstudiante(int id,String estado){
        EstudianteModel datos = new EstudianteModel(id,estado);

        try
        {
            estudianteDAO.agregarEstudiante(datos);
            viewConsole.showMessage("Insercion de datos correcta");
        }catch (SQLException e){
            viewConsole.errorMessage("Error al insertar datos: " + e.getMessage());
        }
    }

    public void obtenerEstudiante(int estudiante_id) {
        try {
            EstudianteModel estudiante = estudianteDAO.obtenerEstudiante(estudiante_id);
            if (estudiante != null) {
                viewConsole.showMessage("Información del usuario: " + estudiante.toString());
            } else {
                viewConsole.showMessage("Usuario no encontrado.");
            }
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al leer usuario: " + e.getMessage());
        }
    }
}
