public class Ej9Persona {
    //region Atributos
    private String dni;
    private String apellidos;
    private String nombre;
    private String sexo;
    private int edad;
    private double peso;
    //endregion

    //region Constructores
    public Ej9Persona() {
        this.dni = "";
        this.apellidos = "";
        this.nombre = "";
        this.sexo = "";
        this.edad = -1;
        this.peso = -1;
    }

    public Ej9Persona(String dni, String apellidos, String nombre, String sexo, int edad, double peso) {
        setDni(dni);
        setApellidos(apellidos);
        setNombre(nombre);
        setSexo(sexo);
        setEdad(edad);
        setPeso(peso);
    }

    public Ej9Persona(Ej9Persona persona) {
        setDni(persona.getDni());
        setApellidos(persona.getApellidos());
        setNombre(persona.getNombre());
        setSexo(persona.getSexo());
        setEdad(persona.getEdad());
        setPeso(persona.getPeso());
    }
    //endregion

    //region Getter&Setter
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    //endregion

    //region Overrides
    public String toString() {
        return STR."""
DNI: \{getDni()}
Apellidos: \{getApellidos()}
Nombre: \{getNombre()}
Sexo: \{getSexo()}
Edad: \{getEdad()}
Peso: \{getPeso()}""";
    }
    //endregion
}
