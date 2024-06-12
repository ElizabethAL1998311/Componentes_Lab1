package controller;

import model.*;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

public class PersonaController {

    private ConsoleView viewConsole;

    private PersonaDAO usuarioDAO;
    private ProfesorDAO profesorDAO;
    private EstudianteDAO estudianteDAO;

    public PersonaController(ConsoleView viewConsole){
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.usuarioDAO = new PersonaDAO(connection);
        this.profesorDAO = new ProfesorDAO(connection);
        this.estudianteDAO = new EstudianteDAO(connection);
    }


    public void agregarUsuario(String nombre, String identificacion, String correo,String apellido,String telefono){
        PersonaModel datos = new PersonaModel(nombre,identificacion,correo,apellido,telefono);

        try
        {
            usuarioDAO.agregarUsuario(datos);
            viewConsole.showMessage("Insercion de datos correcta");
        }catch (SQLException e){
            viewConsole.errorMessage("Error al insertar datos: " + e.getMessage());
        }
    }

    public void leerUsuario(int usuario_id) {
        try {
            PersonaModel usuario = usuarioDAO.obtenerUsuario(usuario_id);
            if (usuario != null) {
                viewConsole.showMessage("Información del usuario: " + usuario.toString());
            } else {
                viewConsole.showMessage("Usuario no encontrado.");
            }
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al leer usuario: " + e.getMessage());
        }
    }

    public void editarUsuario(int usuario_id,String nombre, String identificacion, String correo,String apellido,String telefono) {
        PersonaModel datos = new PersonaModel(usuario_id, nombre, identificacion, correo,apellido,telefono);
        try {
            usuarioDAO.editarUsuario(datos);
            viewConsole.showMessage("Actualización de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al actualizar datos: " + e.getMessage());
        }
    }

    public void eliminarUsuario(int usuario_id) {
        try {
            // Antes de eliminar al usuario, eliminamos al profesor correspondiente (si existe)
            profesorDAO.eliminarProfesorPorUsuario(usuario_id);

            // Antes de eliminar al usuario, eliminamos al estudiante correspondiente (si existe)
            estudianteDAO.eliminarEstudiantePorUsuario(usuario_id);

            // Luego, eliminamos al usuario
            usuarioDAO.eliminarUsuario(usuario_id);

            viewConsole.showMessage("Usuario eliminado correctamente");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al eliminar usuario: " + e.getMessage());
        }
    }

}
