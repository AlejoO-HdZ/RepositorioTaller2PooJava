import java.util.*;
import java.util.stream.Collectors;

// PUNTO 3) OPERACIONES: Clase que realiza operaciones avanzadas con Streams y Lambdas UTILIZANDO la CLASE PERSONAS.
public class OperacionesPersonas {
    private final List<Persona> personas;

    /**
     * Constructor que recibe la lista de personas.
     * @param personas Lista de personas almacenadas.
     */
    public OperacionesPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    /**
     * Metodo para ejecutar todas las operaciones avanzadas.
     */
    public void ejecutarOperaciones() {
        calcularSueldosDirectores();
        mostrarPrimeraDesarrolladoraFemenina();
        mostrarDesarrolladorQueMasGana();
        mostrarMujeresOrdenadasPorNombre();
    }

    //PUNTO 3a) Sueldo de 8 horas para personas de cargo directores masculinos (métodos intermedios map y filter y terminal forEach).
    //EXTRA: Mejorado con PEEK.
    private void calcularSueldosDirectores() {
        System.out.println("\nSueldos de directores masculinos por 8 horas:");
        personas.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("Director") && p.getGenero().equalsIgnoreCase("M"))
                .peek(p -> System.out.println("Nombre: " + p.getNombre() + " " + p.getApellido())) //mejora peek, muestra Nombre, Sueldo por 8 horas y Valor.
                .map(p -> p.getSueldoHora() * 8)
                .forEach(sueldo -> System.out.println("Sueldo por 8 horas: $" + sueldo));
    }

    //PUNTO 3b) Muestra la primera persona que sea "Desarrollador" y de género femenino. (findFirst, filter)
    private void mostrarPrimeraDesarrolladoraFemenina() {
        Optional<Persona> primeraDesarrolladora = personas.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("Desarrollador") && p.getGenero().equalsIgnoreCase("F"))
                .findFirst();
        primeraDesarrolladora.ifPresent(p -> System.out.println("\nPrimera desarrolladora femenina: " + p));
    }

    //PUNTO 3c) Muestra el desarrollador que más gana por hora (stream, usa filter como operación intermedia y max como función terminal)
    private void mostrarDesarrolladorQueMasGana() {
        Optional<Persona> masGana = personas.stream() // Atributo llamado "masGana" de tiempo Optional
                .filter(p -> p.getCargo().equalsIgnoreCase("Desarrollador"))
                .max(Comparator.comparingDouble(Persona::getSueldoHora));
        masGana.ifPresent(p -> System.out.println("\nDesarrollador que más gana por hora: " + p)); // Condicional TRUE que evalua e imprime masGana.isPresent()
    }

    //PUNTO 3d) Muestra todas las mujeres ordenadas por nombre. (sorted muestra todas las mujeres ordenadas por su nombre.)
    private void mostrarMujeresOrdenadasPorNombre() {
        System.out.println("\nMujeres ordenadas por nombre:");
        personas.stream()
                .filter(p -> p.getGenero().equalsIgnoreCase("F"))
                .sorted(Comparator.comparing(Persona::getNombre)) // Sorted para ordenar streams y lista con metodo comparing
                .forEach(System.out::println);
    }
}