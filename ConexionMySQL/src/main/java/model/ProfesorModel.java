package model;

public class ProfesorModel extends PersonaModel {
    private  double salario;

    public ProfesorModel(int id, String nombre, String apellido, String telefono, String identificacion, String correo, double salario) {
        super(id, nombre, apellido, telefono, identificacion, correo);
        this.salario = salario;
    }

    public ProfesorModel(int id, double salario) {
        super(id, "", "", "","","");
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "ProfesorModel{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", identificacion='" + getIdentificacion() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                ", salario=" + salario +
                '}';
    }
}