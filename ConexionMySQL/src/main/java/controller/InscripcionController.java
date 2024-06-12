package controller;
import model.InscripcionDAO;
import model.InscripcionModel;
import model.conexion;
import view.ConsoleView;

import java.sql.*;

public class InscripcionController {
    private ConsoleView viewConsole;
    private InscripcionDAO inscripcionDAO;

    public InscripcionController(ConsoleView viewConsole) {
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.inscripcionDAO = new InscripcionDAO(connection);

    }
    public void agregarInscripcion(int estudianteId, int profesorId, int claseId) {
    }

    public void leerInscripcion(int id) {
    }

    public void editarInscripcion(int id, int estudianteId, int profesorId, int claseId) {
    }

    public void eliminarInscripcion(int id) {
    }
}
