import java.util.*;
/* PUNTO 1b) CREAR UNA CLASE PRINCIPAL CON ATRIBUTOS :
  - `TreeMap<String, List<Animal>>` llamado `clasificación` para almacenar los animales por tipo.
  - `ArrayList<Animal>` llamado `animales` para almacenar temporalmente los datos ingresados.
  -  Implementa métodos para agregar animales y mostrar la clasificación. */

public class ClasePrincipalAnimales { // Clase principal animal
    private final Map<String, List<Animal>> clasificacion = new TreeMap<>(); // llamado `clasificación`,almacena los animales por tipo.
    private final List<Animal> animales = new ArrayList<>(); //  Instancia ArrayList llamado `animales`,almacena temporalmente datos ingresados.
    private final Scanner scanner = new Scanner(System.in); // Datos Consola
