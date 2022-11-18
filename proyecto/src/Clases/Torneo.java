package Clases;

import Interfaces.Reporte;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Torneo implements Reporte {
    private String nombre;
    private Deporte deporte;
    private List<Profesor> arbitros = new ArrayList<>();
    private List<Equipo> participantes = new ArrayList<>();
    private double costoInscripcion;
    private int maximoEquipo;
    private double premio;
    private int minimoEquipo;

    public void crearEquipo() {
        Scanner scanner = new Scanner(System.in);
        try {
            Equipo equipo = new Equipo();
            System.out.print("Ingrese el nombre del equipo: ");
            String nombreEquipo = scanner.nextLine();
            equipo.setNombre(nombreEquipo);
            System.out.println("¿Cuantos participantes tiene el equipo? (Minimo: " + this.getMinimoEquipo() + ", Máximo: " + this.getMaximoEquipo());
            int participantes = scanner.nextInt();
            while (participantes < this.getMinimoEquipo() || participantes > this.getMaximoEquipo()) {
                System.out.println("Numero de participantes incorrecto, vuelva a ingresar: ");
                participantes = scanner.nextInt();
            }
            for (int i = 0; i < participantes; i++) {
                if (this.getDeporte().getSocios().size() == 0 || this.getDeporte().getSocios().size() < this.getMinimoEquipo()) {
                    System.out.println("No existe ningun socio relacionado a ese deporte");
                } else {
                    Socio socio = null;
                    while (socio == null) {
                        System.out.println("Ingrese el nro del socio: ");
                        int nroSocio = scanner.nextInt();
                        socio = this.getDeporte().buscarSocio(nroSocio);
                        if (socio != null) {
                            equipo.agregarParticipante(socio);
                        } else {
                            System.out.println("No existe un socio con ese nro");
                        }
                    }
                }
            }
            this.participantes.add(equipo);
        } catch (Exception e) {
            System.out.println("No se pudo crear el equipo");
        }
    }

    public void eliminarEquipo(String nombreEquipo) {
        Iterator<Equipo> iteratorEquipo = this.getParticipantes().iterator();
        while (iteratorEquipo.hasNext()) {
            if (iteratorEquipo.next().getNombre().equals(nombreEquipo)) {
                iteratorEquipo.remove();
                break;
            }
        }
    }

    public Torneo(String nombre, Deporte deporte, double costoInscripcion, int maximoEquipo, double premio) {
        this.nombre = nombre;
        this.deporte = deporte;
        this.costoInscripcion = costoInscripcion;
        this.maximoEquipo = maximoEquipo;
        this.premio = premio;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public List<Profesor> getArbitros() {
        return arbitros;
    }

    public void setArbitros(List<Profesor> arbitros) {
        this.arbitros = arbitros;
    }

    public List<Equipo> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Equipo> participantes) {
        this.participantes = participantes;
    }

    public double getCostoInscripcion() {
        return costoInscripcion;
    }

    public void setCostoInscripcion(double costoInscripcion) {
        this.costoInscripcion = costoInscripcion;
    }

    public int getMaximoEquipo() {
        return maximoEquipo;
    }

    public void setMaximoEquipo(int maximoEquipo) {
        this.maximoEquipo = maximoEquipo;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    public int getMinimoEquipo() {
        return minimoEquipo;
    }

    public void setMinimoEquipo(int mininoEquipo) {
        this.minimoEquipo = mininoEquipo;
    }

    @Override
    public String toString() {
        return "Torneo{" +
                "nombre='" + nombre + '\'' +
                ", deporte=" + deporte +
                ", arbitros=" + arbitros +
                ", participantes=" + participantes +
                ", costoInscripcion=" + costoInscripcion +
                ", maximoEquipo=" + maximoEquipo +
                '}';
    }

    @Override
    public void listarSocios() {
        for (Equipo equipo: this.getParticipantes()) {
            System.out.println(equipo.toString());
        }
    }

    @Override
    public void listarProfesores() {
        for (Profesor arbitros: this.getArbitros()) {
            System.out.println(arbitros.toString());
        }
    }
}