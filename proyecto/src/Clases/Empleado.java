package Clases;

public class Empleado extends Persona {
    private double basico;
    private int antiguedad;
    private boolean sueldoPagado = false;

    public Empleado(String nombre, int dni, double basico, int antiguedad){
        super(nombre, dni);
        this.basico = basico;
        this.antiguedad = antiguedad;
    }

    public double getBasico() {
        return basico;
    }

    public void setBasico(double basico) {
        this.basico = basico;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public double calcularSueldo(){
        double sueldoFinal = this.getBasico() + (this.getBasico() * (0.1 * this.getAntiguedad()));
        return  sueldoFinal;
    }

    public void pagarSueldo(){
        if(sueldoPagado){
            System.out.println("Sueldo mensual pagado");
        }else{
            System.out.println("Total a depositar: " + calcularSueldo());
            sueldoPagado = true;
        }
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "basico=" + basico +
                ", antiguedad=" + antiguedad +
                '}' + super.toString();
    }
}