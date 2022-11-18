package Clases;

import Interfaces.Reporte;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Deporte implements Reporte {
    private List<Profesor> profesores = new ArrayList<>();
    private String nombre;
    private List<Socio> socios = new ArrayList<>();
    private double cuota;
    private List<Insumo> insumos = new ArrayList<>();
    private List<Clase> clases = new ArrayList<>();

    public Socio buscarSocio(int nroSocio) {
        for(Socio socio: socios) {
            if (socio.getNroSocio() == nroSocio) {
                return socio;
            }
        }
        return null;
    }

    public void agregarInsumo(Insumo insumoNuevo) {
        boolean existe = false;
        for (Insumo insumo: this.insumos) {
            if (insumo.getNombre().equals(insumoNuevo.getNombre())) {
                System.out.println("Ya existe este insumo");
                existe = true;
            }
        }
        if (!existe) {
            this.insumos.add(insumoNuevo);
        }
    }

    public int verCantidadInsumo(String nombreInsumo) {
        for (Insumo insumo: insumos) {
            if (insumo.getNombre().equals(nombreInsumo)) {
                return insumo.getCantidad();
            }
        }
        return 0; // Si no existe
    }

    public void comenzarClase(Profesor profesor) {
        Scanner sc = new Scanner(System.in);
        Clase clase = new Clase(profesor);
        int opcion;
        do {
            System.out.println("¿Que insumo desea ocupar?: ");
            String nombreInsumo = sc.nextLine();
            for (Insumo insumo : this.insumos) {
                if (insumo.getNombre().equals(nombreInsumo) && insumo.getCantidad() > 0) {
                    System.out.println("Ingrese la cantidad que desea ocupar: ");
                    int cantidad = sc.nextInt();
                    insumo.setCantidad(insumo.getCantidad() - cantidad);
                    clase.insumos.add(new Insumo(insumo.getNombre(), cantidad));
                } else if (insumo.getCantidad() == 0) {
                    System.out.println("No hay disponibilidad de " + nombreInsumo);
                } else {
                    System.out.println("No existe ese insumo");
                }
            }
            System.out.println("Ingrese 1 para seguir: ");
            opcion = sc.nextInt();
        } while (opcion == 1);
    }

    public void terminarClase(Profesor profesor) {
        Iterator<Clase> iterator = this.clases.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getProfesor().equals(profesor)) {
                for (Insumo insumo: this.insumos) {
                    for (Insumo insumoClase: iterator.next().getInsumos()) {
                        if (insumoClase.getNombre().equals(insumo.getNombre())) {
                            insumo.setCantidad(insumo.getCantidad() + insumoClase.getCantidad());
                            iterator.remove();
                        }
                    }
                }
            }
        }

    }

    public Deporte(String nombre, double cuota) {
        this.nombre = nombre;
        this.cuota = cuota;
    }

    public void agregarSocio(Socio socio) {
        if (socios.contains(socio)) {
            System.out.println("El socio ya está inscripto a " + this.nombre);
        } else {
            socios.add(socio);
        }
    }

    public void eliminarSocio(Socio socio) {
        Iterator<Socio> socioIterator = this.socios.iterator();
        while (socioIterator.hasNext()) {
            if (socioIterator.next().equals(socio)) {
                socioIterator.remove();
                break;
            }
        }
    }

    public void eliminarInsumo(String nombreInsumo) {
        Iterator<Insumo> insumoIterator = this.insumos.iterator();
        while (insumoIterator.hasNext()) {
            if (insumoIterator.next().getNombre().equals(nombreInsumo)) {
                insumoIterator.remove();
                break;
            }
        }
    }

    public void eliminarProfesor(Profesor profesor) {
        Iterator<Profesor> profesorIterator = this.profesores.iterator();
        while (profesorIterator.hasNext()) {
            if (profesorIterator.next().equals(profesor)) {
                profesorIterator.remove();
                break;
            }
        }
    }

    public void agregarProfesor(Profesor profesor) {
        if (profesores.contains(profesor)) {
            System.out.println("Ya es profesor de " + this.nombre);
        } else {
            this.profesores.add(profesor);
        }
    }


    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Socio> getSocios() {
        return socios;
    }

    public void setSocios(List<Socio> socios) {
        this.socios = socios;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    @Override
    public String toString() {
        String cadena = "Deporte{" +
                "nombre='" + this.nombre + '\'' +
                ", socios=" + this.socios +
                ", cuota=" + this.cuota +
                ", Profesores[";
        for (Profesor p: this.profesores) {
            cadena += "{Nombre: " + p.getNombre() + ", Deporte: " + p.getDeporte() +
                    "}";
        }
        return cadena + "]}";
    }

    @Override
    public void listarSocios() {
        for (Socio socio: this.getSocios()) {
            System.out.println(socio.toString());
        }
    }

    public void listarProfesores() {
        for (Profesor profesor: this.profesores) {
            System.out.println(profesor.toString());
        }
    }
}