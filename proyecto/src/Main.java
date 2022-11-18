import Clases.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // MENU

        Club club1 = new Club("club1",5000);

        int eleccion = 0;
        int eleccion2 = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\nBienvenido al sistema de administración del Club");
            System.out.println("1) Agregar");
            System.out.println("2) Listar");
            System.out.println("3) Buscar");
            System.out.println("4) Eliminar");
            System.out.println("5) Torneo");
            System.out.println("6) Deporte");
            System.out.println("Ingrese cualquier otro numero para salir");

            eleccion = sc.nextInt();
            sc.nextLine();
            Scanner scanner = new Scanner(System.in);

            switch (eleccion){
                case 1:
                    System.out.println("1) Agregar Socio");
                    System.out.println("2) Agregar Deporte");
                    System.out.println("3) Agregar Profesor");

                    eleccion2 = scanner.nextInt();
                    scanner.nextLine();

                    switch (eleccion2){
                        case 1:
                            club1.agregarSocio();
                            break;
                        case 2:
                            club1.agregarDeporte();
                            break;
                        case 3:
                            club1.agregarProfesor();
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1) Listar Socios");
                    System.out.println("2) Listar Deportes");
                    System.out.println("3) Listar Profesores");

                    eleccion2 = scanner.nextInt();
                    scanner.nextLine();

                    switch (eleccion2){
                        case 1:
                            System.out.println("Lista de socios del club: ");
                            club1.listarSocios();
                            break;
                        case 2:
                            System.out.println("Lista de deportes: ");
                            club1.listarDeportes();
                            break;
                        case 3:
                            System.out.println("Lista de profesores del club: ");
                            club1.listarProfesores();
                        default:
                            break;
                    }
                    break;

                case 3:
                    System.out.println("1) Buscar Socio");
                    System.out.println("2) Buscar Deporte");
                    System.out.println("3) Buscar Profesor");

                    eleccion2 = scanner.nextInt();
                    scanner.nextLine();

                    switch (eleccion2){
                        case 1:
                            System.out.println("Ingrese el numero de socio: ");
                            int nroSocio = sc.nextInt();
                            Socio socio = club1.buscarSocio(nroSocio);
                            if (socio != null) {
                                System.out.println(socio);
                            } else {
                                System.out.println("No existe un socio con ese numero");
                            }
                            break;
                        case 2:
                            System.out.println("Ingrese el nombre del deporte: ");
                            Deporte deporte = club1.buscarDeporte();
                            if (deporte != null) {
                                System.out.println(deporte);
                            } else {
                                System.out.println("No existe un deporte con ese nombre");
                            }
                            break;
                        case 3:
                            System.out.println("Ingrese el numero de DNI: ");
                            int dni = sc.nextInt();
                            Profesor profesor = club1.buscarProfesor(dni);
                            if (profesor != null) {
                                System.out.println(profesor);
                            } else {
                                System.out.println("No existe un profesor con ese DNI");
                            }
                        default:
                            break;
                    }
                case 4:
                    System.out.println("1) Eliminar Socio");
                    System.out.println("2) Eliminar Deporte");
                    System.out.println("3) Eliminar Profesor");

                    eleccion2 = scanner.nextInt();
                    scanner.nextLine();

                    switch (eleccion2){
                        case 1:
                            int nroSocio = sc.nextInt();
                            club1.eliminarSocio(nroSocio);
                            break;
                        case 2:
                            String nombreDeporte = sc.nextLine();
                            club1.eliminarDeporte(nombreDeporte);
                            break;
                        case 3:
                            int dni = sc.nextInt();
                            club1.eliminarProfesor(dni);
                        default:
                            break;
                    }
                    break;

                case 5:
                    System.out.println("1) Crear Torneo");
                    System.out.println("2) Crear Equipo");
                    System.out.println("3) Eliminar equipo");
                    System.out.println("4) Listar participantes");
                    System.out.println("5) Listar arbitros");

                    eleccion2 = scanner.nextInt();
                    scanner.nextLine();

                    switch (eleccion2){
                        case 1:
                            club1.agregarTorneo();
                            break;
                        case 2:
                            System.out.println("Ingrese el nombre del torneo: ");
                            String nombreTorneo = scanner.nextLine();
                            boolean existe = false;
                            for (Torneo torneo: club1.getTorneos()) {
                                if (torneo.getNombre().equals(nombreTorneo)) {
                                    torneo.crearEquipo();
                                    existe = true;
                                }
                            }
                            if (!existe) {
                                System.out.println("No existe un torneo con ese nombre");
                            }
                            break;
                        case 3:
                            System.out.println("Ingrese el nombre del equipo: ");
                            String nombreEquipo = sc.nextLine();
                            for (Torneo torneo: club1.getTorneos()) {
                                if (torneo.getNombre().equals(nombreEquipo)) {
                                    torneo.eliminarEquipo(nombreEquipo);
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Ingrese el nombre del torneo: ");
                            nombreTorneo = scanner.nextLine();
                            existe = false;
                            for (Torneo torneo: club1.getTorneos()) {
                                if (torneo.getNombre().equals(nombreTorneo)) {
                                    torneo.listarSocios();
                                    existe = true;
                                }
                            }
                            if (!existe) {
                                System.out.println("No existe un torneo con ese nombre");
                            }
                            break;
                        case 5:
                            System.out.println("Ingrese el nombre del torneo: ");
                            nombreTorneo = scanner.nextLine();
                            existe = false;
                            for (Torneo torneo: club1.getTorneos()) {
                                if (torneo.getNombre().equals(nombreTorneo)) {
                                    torneo.listarProfesores();
                                    existe = true;
                                }
                            }
                            if (!existe) {
                                System.out.println("No existe un torneo con ese nombre");
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el nombre del deporte: ");
                    Deporte deporte = club1.buscarDeporte();
                    System.out.println("1) Agregar socio");
                    System.out.println("2) Agregar profesor");
                    System.out.println("3) Agregar insumo");
                    System.out.println("4) Eliminar socio");
                    System.out.println("5) Eliminar profesor");
                    System.out.println("6) Eliminar insumo");
                    System.out.println("7) Comenzar clase");
                    System.out.println("8) Terminar clase");
                    System.out.println("9) Listar socios");
                    System.out.println("10) Listar profesores");
                    System.out.println("11) Ver cantidad de un insumo");
                    Profesor profesor = null;
                    Socio socio = null;
                    eleccion2 = scanner.nextInt();
                    scanner.nextLine();
                    if (deporte != null) {
                        switch (eleccion2) {
                            case 1:
                                System.out.println("Ingrese el numero del socio: ");
                                int nroSocio = sc.nextInt();
                                socio = club1.buscarSocio(nroSocio);
                                if (socio != null) {
                                    for (Deporte dpte: club1.getDeportes()) {
                                        if (dpte.equals(deporte)) {
                                            dpte.agregarSocio(socio);
                                        }
                                    }
                                } else {
                                    System.out.println("No existe un socio con ese numero");
                                }
                                break;
                            case 2:
                                System.out.println("Ingrese el DNI del profesor: ");
                                int dni = sc.nextInt();
                                profesor = club1.buscarProfesor(dni);
                                if (profesor != null) {
                                    for (Deporte dpte: club1.getDeportes()) {
                                        if (dpte.equals(deporte)) {
                                            dpte.agregarProfesor(profesor);
                                        }
                                    }
                                } else {
                                    System.out.println("No existe un socio con ese numero");
                                }
                                break;
                            case 3:
                                System.out.println("Ingresar el nombre del insumo: ");
                                String nombreInsumo = sc.nextLine();
                                System.out.println("Ingresar la cantidad: ");
                                int cantidad = sc.nextInt();
                                for (Deporte dpte: club1.getDeportes())
                                    if (dpte.equals(deporte)) {
                                        dpte.agregarInsumo(new Insumo(nombreInsumo, cantidad));
                                    }
                                break;
                            case 4:
                                System.out.println("Ingrese el numero del socio: ");
                                int numeroSocio = sc.nextInt();
                                socio = club1.buscarSocio(numeroSocio);
                                for (Deporte dpte : club1.getDeportes()){
                                    if(dpte.equals(deporte)){
                                        dpte.eliminarSocio(socio);
                                        System.out.println("Socio eliminado");
                                    }
                                }
                                break;
                            case 5:
                                System.out.println("Ingrese el dni del profesor: ");
                                int dniProfesor = sc.nextInt();
                                profesor = club1.buscarProfesor(dniProfesor);
                                for (Deporte dpte : club1.getDeportes()){
                                    if(dpte.equals(deporte)){
                                        dpte.eliminarProfesor(profesor);
                                        System.out.println("Profesor eliminado");
                                    }
                                }
                                break;
                            case 6:
                                System.out.println("Ingrese el nombre del insumo: ");
                                nombreInsumo = sc.nextLine();
                                for (Deporte dpte : club1.getDeportes()){
                                    if(dpte.equals(deporte)){
                                        dpte.eliminarInsumo(nombreInsumo);
                                        System.out.println("Insumo eliminado");
                                    }
                                }

                                break;
                            case 7:
                                System.out.println("Ingrese el dni del profesor que va a iniciar la clase: ");
                                dni = sc.nextInt();
                                profesor = club1.buscarProfesor(dni);
                                if (profesor != null) {
                                    for (Deporte dpte : club1.getDeportes()) {
                                        if (dpte.equals(deporte)) {
                                            dpte.comenzarClase(profesor);
                                        }
                                    }
                                } else {
                                    System.out.println("No existe un profesor con ese DNI");
                                }
                                break;
                            case 8:
                                System.out.println("Ingrese el dni del profesor que va a terminar la clase: ");
                                dni = sc.nextInt();
                                profesor = club1.buscarProfesor(dni);
                                if (profesor != null) {
                                    for (Deporte dpte: club1.getDeportes()) {
                                        if (dpte.equals(deporte)) {
                                            dpte.terminarClase(profesor);
                                        }
                                    }
                                } else {
                                    System.out.println("No existe un profesor con ese DNI");
                                }
                                break;
                            case 9:
                                deporte.listarSocios();
                                break;
                            case 10:
                                deporte.listarProfesores();
                                break;
                            case 11:
                                System.out.println("Ingrese el nombre del insumo: ");
                                nombreInsumo = sc.nextLine();
                                cantidad = deporte.verCantidadInsumo(nombreInsumo);
                                if (cantidad == 0) {
                                    System.out.println("No existe ese insumo");
                                } else {
                                    System.out.println("La cantidad es de: " + cantidad);
                                }
                                break;
                            default:
                                break;
                        }
                    } else {
                        System.out.println("No existe ese deporte");
                    }
                    break;
                default:
                    System.out.println("Hasta luego!");
                    break;
            }

        }while (eleccion > 0 && eleccion < 7);

    }

}