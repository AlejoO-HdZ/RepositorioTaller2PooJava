/*2) CREAR UNA CLASE PERSONA CON ATRIBUTOS (nombre, apellido, edad, género, sueldo por hora y cargo.)
  - Contiene atributos para almacenar información de la persona.
  - Se usa un constructor para inicializar los valores.
  - Se incluyen métodos `getters` y `setters` para acceder y modificar los atributos. */
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String genero; // "M" o "F"
    private double sueldoHora;
    private String cargo;

    /**
     * Constructor para inicializar una persona con sus atributos.
     * @param nombre Nombre de la persona.
     * @param apellido Apellido de la persona.
     * @param edad Edad de la persona.
     * @param genero Género de la persona ("M" o "F").
     * @param sueldoHora Sueldo por hora de la persona.
     * @param cargo Cargo de la persona.
     */
    // PLUS ACTIVIDAD VALIDACION EN CONSTRUCTOR DE ENTRADAS ADECUADAS Y CORRECTAS (nombre, apellido, edad, genero y sueldo)
    // Constructor para inicializar los valores.
    public Persona(String nombre, String apellido, int edad, String genero, double sueldoHora, String cargo) {
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            throw new IllegalArgumentException("Error: El nombre solo debe contener letras.");
        }
        if (!apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            throw new IllegalArgumentException("Error: El apellido solo debe contener letras.");
        }
        if (edad <= 0 || edad > 120) {
            throw new IllegalArgumentException("Error: La edad debe ser un número positivo menor a 120.");
        }
        if (!genero.equalsIgnoreCase("M") && !genero.equalsIgnoreCase("F")) {
            throw new IllegalArgumentException("Error: El género debe ser 'M' o 'F'.");
        }
        if (sueldoHora <= 0) {
            throw new IllegalArgumentException("Error: El sueldo por hora debe ser un número positivo.");
        }

        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.sueldoHora = sueldoHora;
        this.cargo = cargo;
    }


    // Getters y Setters, Se incluyen los métodos Getters para acceder a los atributos.
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getEdad() { return edad; }
    public String getGenero() { return genero; }
    public double getSueldoHora() { return sueldoHora; }
    public String getCargo() { return cargo; }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + cargo;
    }
}


