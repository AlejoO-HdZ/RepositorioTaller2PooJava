/* PUNTO 1a) CREAR UNA CLASE ANIMAL CON ATRIBUTOS (nombre,tipo,genero), EL CONSTRUCTOR, CREAR LOS GETTER Y SETTERS RESPECTIVOS.
// Clase Animal contiene atributos para almacenar información del animal.*/
public class Animal { // Clase animal con atributos privados: nombre, tipo y género.
    private String nombre; //Cadena texto nombre del animal
    private String tipo; // Cadena texto para tipo animal (terrestre, aéreo, acuático)
    private String genero; // Cadena texto para Genero (masculino, femenino)

    /**
     * Constructor para inicializar un animal con sus atributos.
     * @param nombre Nombre del animal.
     * @param tipo Tipo de animal (terrestre, aéreo, acuático).
     * @param genero Género del animal (masculino, femenino).
     */
    // Constructor para inicializar los valores.
    public Animal(String nombre, String tipo, String genero) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.genero = genero;
    }

    // Se incluyen los métodos Getters para acceder a los atributos.
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getGenero() {
        return genero;
    }

    //Se sobreescribe `toString()` con @Override para mostrar validar y asegurar reemplazando correctamente. nombre del animal.
    /**
     * Método toString para representar el animal como una cadena de texto.
     * @return Nombre del animal.
     */
    @Override
    public String toString() {
        return nombre;
    }
}

