package Clases;

import java.util.List;

public class Socio extends Persona {
    private int nroSocio;
    private List<Deporte> deportes;
    private double cuota = 5000;
    private boolean cuotaPagada = false;

    public double calcularCuota() {
        double cuota = 0;
        for (Deporte deporte: deportes) {
            cuota += deporte.getCuota();
        }
        return cuota + 1200;
    }

    public void pagarCuota(){
        if (cuotaPagada){
            System.out.println("La cuota ya esta pagada");
        }else{
            System.out.println("Total a abonar: " + calcularCuota());
            cuotaPagada = true;
        }
    }

    public Socio(String nombre, int dni, int nroSocio) {
        super(nombre, dni);
        this.nroSocio = nroSocio;
        this.cuota = cuota;
    }

    public int getNroSocio() {
        return nroSocio;
    }

    public void setNroSocio(int nroSocio) {
        this.nroSocio = nroSocio;
    }

    public List<Deporte> getDeportes() {
        return deportes;
    }

    public void setDeportes(List<Deporte> deportes) {
        this.deportes = deportes;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "nroSocio=" + nroSocio +
                ", deportes=" + deportes +
                ", cuota=" + cuota +
                ", cuotaPagada=" + cuotaPagada +
                '}';
    }
}
