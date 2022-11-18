package Clases;

import Interfaces.Reporte;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Club implements Reporte {
    private String nombre;
    private List<Deporte> deportes = new ArrayList<>();
    private double cuota;
    private List<Socio> socios = new ArrayList<>();
    private List<Profesor> profesores = new ArrayList<>();
    private List<Torneo> torneos = new ArrayList<>();



    public Club(String nombre, double cuota) {
        this.nombre = nombre;
        this.cuota = cuota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Deporte> getDeportes() {
        return deportes;
    }

    public void setDeportes(List<Deporte> deportes) {
        this.deportes = deportes;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public List<Socio> getSocios() {
        return socios;
    }

    public void setSocios(List<Socio> socios) {
        this.socios = socios;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    @Override
    public String toString() {
        return "Club{" +
                "nombre='" + nombre + '\'' +
                ", deportes=" + deportes +
                ", cuota=" + cuota +
                ", socios=" + socios +
                ", profesores=" + profesores +
                '}';
    }

    @Override
    public void listarSocios() {
        for (Socio socio: this.getSocios()) {
            System.out.println("Nombre: " + socio.getNombre() + ", DNI: " + socio.getDni() + ", Numero de socio: " + socio.getNroSocio());
        }
    }

    @Override
    public void listarProfesores() {
        for (Profesor profesor: this.getProfesores()) {
            System.out.println("Nombre: " + profesor.getNombre() + ", DNI: " + profesor.getDni() +", Deporte: " + profesor.getDeporte().getNombre());
        }
    }

    public void listarDeportes() {
        for (Deporte deporte: this.deportes) {
            System.out.println("Deporte: " + deporte.getNombre() + ", Cuota: " + deporte.getCuota());
        }
    }


    // METODOS AGREGAR

    public void agregarSocio(){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nombre:");
            String nombre = sc.nextLine();
            System.out.println("DNI:");
            int dni = sc.nextInt();
            System.out.println("Numero de socio: ");
            int nroSocio = sc.nextInt();
            Socio newSocio = new Socio(nombre, dni, nroSocio);
            this.socios.add(newSocio);
        } catch (Exception e) {
            System.out.println("Ingreso un dato erroneo");
        }
    }

    public void agregarDeporte(){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nombre:");
            String nombre = sc.nextLine();
            System.out.println("Precio Cuota:");
            double cuota = sc.nextInt();

            Deporte newDeporte = new Deporte(nombre, cuota);
            deportes.add(newDeporte);

        }catch (Exception e) {
            System.out.println("Ingresó un dato erroneo");
        }

    }


    /* public void agregarProfesor() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Nombre:");
            String nombre = sc.nextLine();
            System.out.println("DNI:");
            int dni = sc.nextInt();
            sc.nextLine();
            System.out.println("Basico: ");
            double basico = sc.nextDouble();
            sc.nextLine();
            Deporte deporte = null;
            do {
                System.out.println("Deporte: ");
                String nombreDeporte = sc.nextLine();
                for (Deporte dpte : this.deportes) {
                    if (dpte.getNombre().equals(nombreDeporte)) {
                        deporte = dpte;
                        break;
                    }
                }
            } while (deporte == null);
            System.out.println("Antiguedad: ");
            int antiguedad = sc.nextInt();
            sc.nextLine();
            Profesor nuevoProfesor = new Profesor(nombre, dni, basico, deporte, antiguedad);
            this.profesores.add(nuevoProfesor);
        } catch (Exception e) {
            System.out.println("Ingresó un dato erroneo");
        }
        sc.close();
    } */

    public void agregarProfesor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();

        System.out.println("DNI: ");
        int dni = sc.nextInt();

        System.out.println("Basico: ");
        double basico = sc.nextDouble();
        sc.nextLine();

        Deporte deporte = null;

        do{
            System.out.println("Deporte: ");
            String nombreDeporte = sc.nextLine();

            for (Deporte dpte:deportes) {
                if (dpte.getNombre().equals(nombreDeporte)){
                    deporte = dpte;
                    break;
                }
            }

        }while (deporte == null);

        System.out.println("Antiguedad: ");
        int antiguedad = sc.nextInt();

        this.profesores.add(new Profesor(nombre, dni, basico, deporte, antiguedad));
    }

    public void agregarTorneo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre del Torneo:");
        String nombre = sc.nextLine();

        Deporte deporte = null;
        do {
            System.out.println("Deporte: ");
            String nombreDeporte = sc.nextLine();
            for (Deporte dpte : this.deportes) {
                if (dpte.getNombre().equals(nombreDeporte)) {
                    deporte = dpte;
                    break;
                }
            }
        } while (deporte == null);


        System.out.println("Costo de inscripción:");
        double costo = sc.nextDouble();

        System.out.println("Número máximo de integrantes en el equipo: ");
        int maximo = sc.nextInt();

        System.out.println("Premio (Dinero): ");
        double premio =sc.nextDouble();

        Torneo newTorneo = new Torneo(nombre,deporte,costo,maximo,premio);
        this.torneos.add(newTorneo);
    }


    // METODOS BUSCAR

    public Socio buscarSocio(int nroSocio) {
        for(Socio socio: socios) {
            if (socio.getNroSocio() == nroSocio) {
                return socio;
            }
        }
        return null;
    }

    public Profesor buscarProfesor(int dni) {
        for(Profesor profe: this.profesores) {
            if (profe.getDni() == dni) {
                return profe;
            }
        }
        return null;
    }

    public Deporte buscarDeporte() {
        Scanner scanner = new Scanner(System.in);
        try {
            String nombreDeporte = scanner.nextLine();

            for (Deporte deporte : this.deportes) {
                if (deporte.getNombre().equals(nombreDeporte)) {
                    return deporte;
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println("Ingreso un dato erroneo");
            return null;
        }
    }

    public Torneo buscarTorneo() {
        Scanner scanner = new Scanner(System.in);
        try {
            String nombreTorneo = scanner.nextLine();

            for (Torneo torneo : this.torneos) {
                if (torneo.getNombre().equals(nombreTorneo)) {
                    return torneo;
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println("Ingreso un dato erroneo");
            return null;
        }
    }

    // METODOS ELIMINAR

    public void eliminarProfesor(int dni) {
        Profesor profe = buscarProfesor(dni);
        if (profe != null) {
            for (Deporte deporte : deportes) {
                Iterator<Profesor> profesorIterator = this.profesores.iterator();
                while (profesorIterator.hasNext()) {
                    if (profesorIterator.next().equals(profe)) {
                        profesorIterator.remove();
                    } else {
                        System.out.println(profesorIterator.next().getNombre() + "no trabaja en este club");
                    }
                }
            }
        } else {
            System.out.println("No existe un profesor con ese DNI");
        }
    }

    public void eliminarSocio(int nroSocio) {
        Socio socio = buscarSocio(nroSocio);
        if (socio != null) {
            Iterator<Socio> iterator = this.socios.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().equals(socio)) {
                    iterator.remove();
                    break;
                }
            }

            for (Deporte deporte : this.deportes) {
                Iterator<Socio> iteratorDeporte = deporte.getSocios().iterator();
                while (iteratorDeporte.hasNext()) {
                    if (iteratorDeporte.next().equals(socio)) {
                        iteratorDeporte.remove();
                        break;
                    }
                }
            }

            for (Torneo torneo : this.torneos) {
                for (Equipo equipo : torneo.getParticipantes()) {
                    Iterator<Socio> iteratorTorneo = equipo.getParticipantes().iterator();
                    while (iteratorTorneo.hasNext()) {
                        if (iteratorTorneo.next().equals(socio)) {
                            iteratorTorneo.remove();
                            break;
                        }
                    }
                }
            }
        } else {
            System.out.println("No existe un socio con ese numero");
        }
    }

    public void eliminarDeporte(String nombreDeporte) {
        Iterator<Deporte> iterator = this.deportes.iterator();
        boolean existe = false;
        while (iterator.hasNext()) {
            if (iterator.next().getNombre().equals(nombreDeporte)) {
                iterator.remove();
                existe = true;
                break;
            }
        }
        if (!existe) {
            System.out.println("El deporte no existe");
        }
    }

    public List<Torneo> getTorneos() {
        return this.torneos;
    }

    public void setTorneos(List<Torneo> torneos) {
        this.torneos = torneos;
    }

}