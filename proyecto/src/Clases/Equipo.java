package Clases;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private List<Socio> participantes = new ArrayList<>();

    public void agregarParticipante(Socio participante) {
        this.participantes.add(participante);
    }

    public Equipo() {
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Socio> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Socio> participantes) {
        this.participantes = participantes;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", participantes=" + participantes +
                '}';
    }
}
