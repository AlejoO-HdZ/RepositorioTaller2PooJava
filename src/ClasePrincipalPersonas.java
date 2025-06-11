import java.util.*;
import java.util.stream.Collectors;

/* PUNTO 2) CREAR UNA CLASE PRINCIPAL PERSONAS : Gestiona lista de personas, realiza operaciones con Streams y Lambdas.
 * - Usa un `ArrayList<Persona>` llamado `personas` para almacenar los datos ingresados.
 * - Implementa métodos para agregar personas y realizar cálculos con Streams. */

public class ClasePrincipalPersonas {
    private final List<Persona> personas = new ArrayList<>(); // `ArrayList<Persona>` llamado `personas`, almacena datos ingresados.
    private final Scanner scanner = new Scanner(System.in); // Datos Consola

    // Metodo principal para ejecutar el programa.
    public void ejecutar() {
        System.out.println("INGRESE LA CANTIDAD DE PERSONAS:");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        for (int i = 0; i < cantidad; i++) {
            agregarPersona(); // Llenar la lista de personas
        }
        realizarOperaciones(); // Realizar operaciones básicas con Streams

        // Llamar a la clase `OperacionesPersonas` para ejecutar operaciones avanzadas
        OperacionesPersonas operaciones = new OperacionesPersonas(personas);
        operaciones.ejecutarOperaciones();
    }

    /**
     * Metodo para agregar una persona a la lista.
     * - Solicita datos por consola.
     * - Crea un objeto `Persona` y lo agrega a la lista.
     */
    private void agregarPersona() {
        System.out.println("Ingrese nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese apellido:");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese edad:");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese género (M/F):");
        String genero = scanner.nextLine().toUpperCase();
        System.out.println("Ingrese sueldo por hora:");
        double sueldoHora = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Ingrese cargo:");
        String cargo = scanner.nextLine();

        personas.add(new Persona(nombre, apellido, edad, genero, sueldoHora, cargo));
    }
    /**
     * 2) Metodo para realizar operaciones con Streams y Lambdas.
     */
    private void realizarOperaciones() {
        // Punto 2a) Cantidad de personas almacenadas
        System.out.println("\nCantidad de personas: " + personas.size());

        // Punto 2b) Promedio de edades de personas (average)
        double promedioEdad = personas.stream().mapToInt(Persona::getEdad).average().orElse(0);
        System.out.println("Promedio de edades: " + promedioEdad);

        // Punto 2c) Cantidad de personas mayores de edad (mayor o igual a 18 años)
        long mayoresEdad = personas.stream().filter(p -> p.getEdad() >= 18).count();
        System.out.println("Cantidad de mayores de edad: " + mayoresEdad);

        // Punto 2d) Personas cuyos nombres empiezan con "A"
        System.out.println("Personas con nombre que empieza con 'A':");
        personas.stream().filter(p -> p.getNombre().startsWith("A")).forEach(System.out::println);

    }
    /**
     * Metodo principal para ejecutar la aplicación.
     */
    public static void main(String[] args) {
        new ClasePrincipalPersonas().ejecutar();
    }
}
