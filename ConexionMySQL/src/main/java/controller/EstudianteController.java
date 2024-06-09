package controller;

import model.*;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

public class EstudianteController {

    private ConsoleView viewConsole;

    private EstudianteDAO estudianteDAO;
    private UsuarioDAO usuarioDAO;

    public EstudianteController (ConsoleView viewConsole){
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.estudianteDAO = new EstudianteDAO(connection);
        this.usuarioDAO = new UsuarioDAO(connection);
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

    public void editarEstudiante(int estudiante_id, String nombre, String identificacion, String correo, String estado) {
        UsuarioModel datosUsuario = new UsuarioModel(estudiante_id, nombre, identificacion, correo);
        try {
            // Actualizar la información del usuario
            usuarioDAO.editarUsuario(datosUsuario);

            // Actualizar la información del estudiante
            estudianteDAO.editarEstudiante(estudiante_id, estado);

            viewConsole.showMessage("Actualización de estudiante correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al actualizar estudiante: " + e.getMessage());
        }
    }

    public void eliminarEstudiante(int estudiante_id) {
        try {
            // Primero, eliminamos al estudiante
            estudianteDAO.eliminarEstudiante(estudiante_id);

            viewConsole.showMessage("Estudiante eliminado correctamente");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al eliminar estudiante: " + e.getMessage());
        }
    }
}
