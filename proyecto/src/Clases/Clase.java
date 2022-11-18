package Clases;

import java.util.ArrayList;
import java.util.List;

public class Clase {
    private Profesor profesor;
    List<Insumo> insumos = new ArrayList<>();

    public Clase(Profesor profesor) {
        this.profesor = profesor;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Insumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<Insumo> insumos) {
        this.insumos = insumos;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "profesor=" + profesor +
                ", insumos=" + insumos +
                '}';
    }
}