package Clases;

public class Profesor extends Empleado {
    private Deporte deporte;


    public Profesor(String nombre, int dni, double basico, Deporte deporte, int antiguedad) {
        super(nombre, dni, basico, antiguedad);
        this.deporte = deporte;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "deporte=" + deporte.getNombre() +
                "} " + super.toString();
    }

}
