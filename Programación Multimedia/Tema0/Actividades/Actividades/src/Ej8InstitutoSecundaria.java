public class Ej8InstitutoSecundaria extends Ej7CentroEducativo {
    //region Atributos
    private String categoria;
    //endregion

    //region Constructores
    public Ej8InstitutoSecundaria() {
        super();
        this.categoria = "";
    }

    public Ej8InstitutoSecundaria(String nombre, int nEstudiantes, int nProfesores, int codPos) {
        super(nombre, nEstudiantes, nProfesores, codPos);
    }

    public Ej8InstitutoSecundaria(Ej8InstitutoSecundaria instituto) {
        super(instituto);
        this.categoria = instituto.getCategoria();
    }
    //endregion

    //region Métodos
    public String anuncioCompeticion(int participantes) {
        if (participantes < 1 || participantes > 30)
            throw new IllegalArgumentException("El grupo debe tener entre 1 y 30 estudiantes");
        return STR."Competición en \{getNombre()}: participan \{participantes} alumnos.";
    }

    public String anuncioCompeticion(int participantes, int participantesDeOtrosCentros) {
        if (participantes < 1 || participantes > 30)
            throw new IllegalArgumentException("El grupo debe tener entre 1 y 30 estudiantes");
        if (participantesDeOtrosCentros < 0)
            throw new IllegalArgumentException("Número de alumnos de otros centros no válido");
        return STR."Competición en \{getNombre()}: participan \{participantes} alumnos de este centro y \{participantesDeOtrosCentros} de otros institutos.";
    }

    private String calcularCategoria(int nEstudiantes) {
        if (nEstudiantes < 0) return "";
        if (nEstudiantes <= 400) return "A";
        if (nEstudiantes <= 700) return "B";
        if (nEstudiantes <= 1000) return "C";
        return "D";
    }
    //endregion

    //region Getter&Setter
    public String getCategoria() {
        return categoria;
    }

    public void setnEstudiantes(int nEstudiantes) {
        super.setnEstudiantes(nEstudiantes);
        this.categoria = calcularCategoria(nEstudiantes);
    }
    //endregion

    //region Overrides
    public Ej8InstitutoSecundaria clone(Ej8InstitutoSecundaria instituto) {
        return new Ej8InstitutoSecundaria(instituto);
    }

    public boolean equals(Ej8InstitutoSecundaria instituto) {
        return (
            getNombre().equals(instituto.getNombre()) &&
            getnEstudiantes()==instituto.getnEstudiantes() &&
            getnProfesores()==instituto.getnProfesores() &&
            getCodPos()==instituto.getCodPos() &&
            getCategoria().equals(instituto.getCategoria())
        );
    }

    public String toString() {
        return STR."""
Nombre: \{getNombre()}
Número de Estudiantes: \{getnEstudiantes()}
Número de profesores: \{getnProfesores()}
Código Postal: \{getCodPos()}
Categoría: \{getCategoria()}""";
    }
    //endregion
}
