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
        int cantidad = validarEnteroPositivo();

        for (int i = 0; i < cantidad; i++) {
            agregarPersona(); // Llenar la lista de personas
        }
        // Realizar operaciones básicas con Streams
        realizarOperaciones();
        // Llamar a la clase `OperacionesPersonas` para ejecutar operaciones avanzadas
        OperacionesPersonas operaciones = new OperacionesPersonas(personas);
        operaciones.ejecutarOperaciones();
    }

    /**
     * Metodo para agregar una persona a la lista con validaciones.
     * - Solicita datos por consola.
     * - Crea un objeto `Persona` y lo agrega a la lista.
     */
    private void agregarPersona() {
        System.out.println("Ingrese nombre:");
        String nombre = validarTexto();

        System.out.println("Ingrese apellido:");
        String apellido = validarTexto();

        System.out.println("Ingrese edad:");
        int edad = validarEnteroPositivo();

        System.out.println("Ingrese género (M/F):");
        String genero = validarGenero();

        System.out.println("Ingrese sueldo por hora:");
        double sueldoHora = validarDoublePositivo();

        System.out.println("Ingrese cargo:");
        String cargo = scanner.nextLine();

        personas.add(new Persona(nombre, apellido, edad, genero, sueldoHora, cargo));
    }
    // PLUS ACTIVIDAD VALIDACION ENTRADAS ADECUADAS Y CORRECTAS: TEXTO, ENTERO , DECIMAL o GENERO M/F (nombre, apellido, edad, genero y sueldo)
    /**
     * Metodo para realizar operaciones básicas con Streams y Lambdas.
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

        // Punto 2e) Personas cuyos apellidos contienen la letra "M"
        System.out.println("Personas con apellido que contiene 'M':");
        personas.stream().filter(p -> p.getApellido().contains("M")).forEach(System.out::println);
    }

// PLUS DE ACTIVIDAD VALIDACION EDAD (Entero Mayor a 0)
    /**
     * Metodo para validar que el usuario ingrese un número entero positivo.
     */
    private int validarEnteroPositivo() {
        int numero;
        while (true) {
            try {
                numero = Integer.parseInt(scanner.nextLine());
                if (numero > 0) {
                    return numero;
                } else {
                    System.out.println("Error: Debe ingresar un número positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
            }
        }
    }
// PLUS DE ACTIVIDAD VALIDACION NOMBRE Y APELLIDO (Solo valores texto)
    /**
     * Metodo para validar que el usuario ingrese un texto sin números.
     */
    private String validarTexto() {
        String texto;
        while (true) {
            texto = scanner.nextLine();
            if (texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                return texto;
            } else {
                System.out.println("Error: Solo se permiten letras.");
            }
        }
    }
// PLUS DE ACTIVIDAD VALIDACION GENERO (Solo M o F)
    /**
     * Metodo para validar que el usuario ingrese "M" o "F".
     */
    private String validarGenero() {
        String genero;
        while (true) {
            genero = scanner.nextLine().toUpperCase();
            if (genero.equals("M") || genero.equals("F")) {
                return genero;
            } else {
                System.out.println("Error: Debe ingresar 'M' o 'F'.");
            }
        }
    }
// PLUS DE ACTIVIDAD VALIDACION SUELDO (SolO numeros positivos)
    /**
     * Metodo para validar que el usuario ingrese un número decimal positivo.
     */
    private double validarDoublePositivo() {
        double numero;
        while (true) {
            try {
                numero = Double.parseDouble(scanner.nextLine());
                if (numero > 0) {
                    return numero;
                } else {
                    System.out.println("Error: Debe ingresar un número positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
            }
        }
    }
}