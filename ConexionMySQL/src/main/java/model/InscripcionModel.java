package model;

public class InscripcionModel {
    private int id;
    private int estudianteId;
    private int profesorId;
    private int claseId;

    public InscripcionModel(int id, int estudianteId, int profesorId, int claseId) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.profesorId = profesorId;
        this.claseId = claseId;
    }

    public InscripcionModel(int estudianteId, int profesorId, int claseId) {
        this.estudianteId = estudianteId;
        this.profesorId = profesorId;
        this.claseId = claseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(int estudianteId) {
        this.estudianteId = estudianteId;
    }

    public int getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(int profesorId) {
        this.profesorId = profesorId;
    }

    public int getClaseId() {
        return claseId;
    }

    public void setClaseId(int claseId) {
        this.claseId = claseId;
    }

    @Override
    public String toString() {
        return "InscripcionModel{" +
                "id=" + id +
                ", estudianteId=" + estudianteId +
                ", profesorId=" + profesorId +
                ", claseId=" + claseId +
                '}';
    }
}
