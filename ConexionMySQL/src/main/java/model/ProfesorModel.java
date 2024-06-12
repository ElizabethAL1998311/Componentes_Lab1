package model;

public class ProfesorModel extends UsuarioModel{
    private  double salario;

    public ProfesorModel(int id, String nombre, String identificacion, String correo, double salario) {
        super(id, nombre, identificacion, correo);
        this.salario = salario;
    }

    public ProfesorModel(int id, double salario) {
        super(id, "", "", "");
        this.salario = salario;

    private double salario;

    public ProfesorModel(String nombre, String identificacion, String correo) {
        super(nombre, identificacion, correo);
        this.salario= salario;
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
                "salario='" + salario + '\'' +
                '}';
    }
}
