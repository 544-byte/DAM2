public class Ej6ClinicaFurball {
    //region Atributos
    private String nombre;
    private String dueño;
    private String tipo;
    private String historial;
    private static int nPerros;
    private static int nGatos;
    //endregion

    //region Constructor/es

    public Ej6ClinicaFurball(){
        this.nombre="";
        this.dueño="";
        this.tipo="";
        this.historial="";
    }

    public Ej6ClinicaFurball(String nombre, String dueño, String tipo, String historial) {
        setNombre(nombre);
        setDueño(dueño);
        setTipo(tipo);
        setHistorial(historial);
    }

    public Ej6ClinicaFurball(Ej6ClinicaFurball animal){
        setNombre(animal.getNombre());
        setDueño(animal.getDueño());
        setTipo(animal.getTipo());
        setHistorial(animal.getHistorial());
    }

    //endregion

    //region Getter&Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño.replace(" ","");
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        tipo = tipo.toLowerCase();
        if (tipo.equals("perro") || tipo.equals("gato") || tipo.equals("exótico") || tipo.equals("exotico")) {
            this.tipo = tipo;
            switch (tipo){
                case "perro" -> nPerros++;
                case "gato" -> nGatos++;
                default -> {}
            }
        }

        else
            throw new IllegalArgumentException("Tipo de animal no válido");
    }

    public String getHistorial() {
        return historial;
    }

    public void setHistorial(String historial) {
        this.historial = historial.substring(0,499);
    }

    public static int getnPerros() {
        return nPerros;
    }

    public static int getnGatos() {
        return nGatos;
    }

    //endregion

    //region Overrides

    public Ej6ClinicaFurball clone(Ej6ClinicaFurball animal){
        return new Ej6ClinicaFurball(animal);
    }

    public boolean equals(Ej6ClinicaFurball animal) {
        return (getNombre().equals(animal.getNombre()) &&
            getDueño().equals(animal.getDueño()) &&
            getTipo().equals(animal.getTipo()) &&
            getHistorial().equals(animal.getHistorial())
        );
    }

    public String toString() {
        return STR."""
Nombre: \{getNombre()}
Dueño: \{getDueño()}
Tipo: \{getTipo()}
Historial: \{getHistorial()}""";
    }
    //endregion
}
