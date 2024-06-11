package controller;
import model.InscripcionModel;
import view.ConsoleView;
import java.util.ArrayList;
import java.util.List;

public class InscripcionController {
    private ConsoleView view;
    private List<InscripcionModel> inscripciones;

    public InscripcionController(ConsoleView view) {
        this.view = view;
        this.inscripciones = new ArrayList<>();
    }

    public void agregarInscripcion(int estudianteId, int profesorId, int claseId) {
        InscripcionModel inscripcion = new InscripcionModel(estudianteId, profesorId, claseId);
        inscripciones.add(inscripcion);
        view.showMessage("Inscripción agregada: " + inscripcion);
    }

    public void leerInscripcion(int id) {
        for (InscripcionModel inscripcion : inscripciones) {
            if (inscripcion.getId() == id) {
                view.showMessage(inscripcion.toString());
                return;
            }
        }
        view.showMessage("Inscripción no encontrada.");
    }

    public void editarInscripcion(int id, int estudianteId, int profesorId, int claseId) {
        for (InscripcionModel inscripcion : inscripciones) {
            if (inscripcion.getId() == id) {
                inscripcion.setEstudianteId(estudianteId);
                inscripcion.setProfesorId(profesorId);
                inscripcion.setClaseId(claseId);
                view.showMessage("Inscripción actualizada: " + inscripcion);
                return;
            }
        }
        view.showMessage("Inscripción no encontrada.");
    }

    public void eliminarInscripcion(int id) {
        inscripciones.removeIf(inscripcion -> inscripcion.getId() == id);
        view.showMessage("Inscripción eliminada con id: " + id);
    }
}
