package model;

public class EstudianteModel extends UsuarioModel{
    private String estado;

    public EstudianteModel(int id, String nombre, String identificacion, String correo, String estado) {
        super(id, nombre, identificacion, correo);
        this.estado = estado;
    }


    public EstudianteModel(int id, String estado) {
        super(id, "", "", ""); // Llamar al constructor de la clase base con valores vacíos para nombre, identificación y correo
        this.estado = estado;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "EstudianteModel{" +
                "estado='" + estado + '\'' +
                '}';
    }
}
