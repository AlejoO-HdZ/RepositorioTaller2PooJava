import java.util.*;
/* PUNTO 1b) CREAR UNA CLASE PRINCIPAL CON ATRIBUTOS :
  - `TreeMap<String, List<Animal>>` llamado `clasificación` para almacenar los animales por tipo.
  - `ArrayList<Animal>` llamado `animales` para almacenar temporalmente los datos ingresados.
  -  Implementa métodos para agregar animales y mostrar la clasificación. */

public class ClasePrincipalAnimales { // Clase principal animal
    private final Map<String, List<Animal>> clasificacion = new TreeMap<>(); // llamado `clasificación`,almacena los animales por tipo.
    private final List<Animal> animales = new ArrayList<>(); //  Instancia ArrayList llamado `animales`,almacena temporalmente datos ingresados.
    private final Scanner scanner = new Scanner(System.in); // Datos Consola

    /* PUNTO 1c) LLENAR LISTA DE ANIMALES CON DATOS INGRESADOS POR CONSOLA :
         - Metodo principal para ejecutar el programa
         - Solicitar cantidad de animales a ingresar.
         - Llamar a `agregarAnimal()` para ingresar datos.
         - Metodo para agregar un animal a la lista y clasificarlo.
         - Llamar a `mostrarClasificacion()` para mostrar los resultados.*/
    public void ejecutar() {
        System.out.println("Ingrese la cantidad de animales:");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer para evitar errores.

        for (int i = 0; i < cantidad; i++) { // Llenar lista de animales
            agregarAnimal();
        }

        mostrarClasificacion(); // Mostrar clasificación de animales porc categoria
    }
// Punto 1c) Almacenamiento en el map la clase que muestra luego los animales.
    /** Metodo para agregar un animal a la lista y clasificarlo.
     * - Solicita datos por consola.
     * - Crea un objeto `Animal`.
     * - Usa `computeIfAbsent()` para agregarlo a la clasificación.
     */
    private void agregarAnimal() {
        System.out.println("Ingrese nombre del animal:");
        String nombre = scanner.nextLine();

        // PLUS ACTIVIDAD VALIDACION DEL TIPO (solo valores: terrestre, aereo, acuatico)
        String tipo;
        do {
            System.out.println("Ingrese tipo (terrestre, aereo, acuatico):");
            tipo = scanner.nextLine().toLowerCase();
            if (!tipo.equals("terrestre") && !tipo.equals("aereo") && !tipo.equals("acuatico")) {
                System.out.println("Error: Tipo inválido. Debe ser 'terrestre', 'aereo' o 'acuatico'.");
            }
        } while (!tipo.equals("terrestre") && !tipo.equals("aereo") && !tipo.equals("acuatico"));

        // PLUS ACTIVIDAD VALIDACION DEL GENERO (solo valores: masculino, femenino)
        String genero;
        do {
            System.out.println("Ingrese género (masculino, femenino):");
            genero = scanner.nextLine().toLowerCase();
            if (!genero.equals("masculino") && !genero.equals("femenino")) {
                System.out.println("Error: Género inválido. Debe ser 'masculino' o 'femenino'.");
            }
        } while (!genero.equals("masculino") && !genero.equals("femenino"));
        // Punto 1d) Almacena en el map la clase y clasifica como: terrestre, aéreo o acuático.
        Animal animal = new Animal(nombre, tipo, genero); // Crear objeto Animal y agregarlo a la lista
        animales.add(animal);

        clasificacion.computeIfAbsent(tipo, k -> new ArrayList<>()).add(animal); // Clasificar el animal en el mapa
    }

    /** Metodo para mostrar la clasificación de animales.
     * - Recorre el `TreeMap` y muestra los animales por categoría.
     * - Usa `substring(0,1).toUpperCase()` para capitalizar la primera letra del tipo.
     */
    //1d) Almacenamiento en el map la clase y muestra luego los animales.
    //1e) El resultado se muestra en consola al finalizar el pedido de datos:
    private void mostrarClasificacion() {
        System.out.println("\nClasificación de Animales:");
        clasificacion.forEach((tipo, listaAnimales) -> {
            System.out.println(tipo.substring(0, 1).toUpperCase() + tipo.substring(1) + ":"); // Recorre y muestra el mapa, muestra cada categoria con sus animales.
            listaAnimales.forEach(animal -> System.out.println("  " + animal.getNombre()));  // Recorre la lista de animales y mostrar cada uno
        });

    }

    public static void main(String[] args) {
        new ClasePrincipalAnimales().ejecutar();   //Metodo principal para ejecutar la aplicación
    }
}


