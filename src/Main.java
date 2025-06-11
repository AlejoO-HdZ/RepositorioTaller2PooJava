import java.util.Scanner;
// CLASE PRINCIPAL PARA EJECUTAR EL PROGRAMA DE CLASIFICACION Y OPERACIONES
/** Permite elegir y añadir desde consola: clasificaciones animales y/o personas
 * - Muestra un menú interactivo para elegir opciones.
 * - Llama a `ClasePrincipalAnimales` para ejecutar la clasificación.
 * - Llama a `ClasePrincipalPersonas` para ejecutar la clasificación y las Operaciones (lambda y streams).
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nSELECCIONE UNA OPCION:");
            System.out.println("1. Clasificación de Animales");
            System.out.println("2. Gestión de Personas");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    new ClasePrincipalAnimales().ejecutar();
                    break;
                case 2:
                    new ClasePrincipalPersonas().ejecutar();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
