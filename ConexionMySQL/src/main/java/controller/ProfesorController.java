package controller;

import model.*;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

public class ProfesorController {

    private ConsoleView viewConsole;

    private ProfesorDAO profesorDAO;
    private UsuarioDAO usuarioDAO;

    public ProfesorController (ConsoleView viewConsole){
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.profesorDAO = new ProfesorDAO(connection);
        this.usuarioDAO = new UsuarioDAO(connection);
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
    public void editarProfesor(int profesor_id , String nombre, String identificacion, String correo, Double salario) {
        UsuarioModel datosUsuario = new UsuarioModel(profesor_id , nombre, identificacion, correo);
        try {
            // Actualizar la información del usuario
            usuarioDAO.editarUsuario(datosUsuario);

            // Actualizar la información del estudiante
            profesorDAO.editarProfesor(profesor_id, salario);

            viewConsole.showMessage("Actualización de profesor correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al actualizar profesor: " + e.getMessage());
        }
    }
    public void eliminarProfesor(int profesor_id) {
        try {

            profesorDAO.eliminarProfesor(profesor_id);

            viewConsole.showMessage("Profesor eliminado correctamente");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al eliminar profesor: " + e.getMessage());
        }
    }
}
