public class Ej8CentroFP extends Ej7CentroEducativo {
    //region Atributos
    private String empresaAsociada;
    private String empresaExterna;
    //endregion

    //region Constructores
    public Ej8CentroFP() {
        super();
        this.empresaAsociada = "";
        this.empresaExterna = "";
    }

    public Ej8CentroFP(String nombre, int nEstudiantes, int nProfesores, int codPos, String empresaAsociada, String empresaExterna) {
        super(nombre, nEstudiantes, nProfesores, codPos);
        setEmpresaAsociada(empresaAsociada);
        setEmpresaExterna(empresaExterna);
    }

    public Ej8CentroFP(Ej8CentroFP centro) {
        super(centro);
        setEmpresaAsociada(centro.getEmpresaAsociada());
        setEmpresaExterna(centro.getEmpresaExterna());
    }
    //endregion

    //region Métodos
    public String practicas() {
        return STR."Alumnado en prácticas en \{empresaAsociada}.";
    }

    public String practicas(String empresa) {
        if (empresa == null || empresa.isBlank())
            throw new IllegalArgumentException("La empresa no puede estar vacía");
        return STR."Alumnado en prácticas en \{empresa}, distinta de la asociada \{empresaAsociada}.";
    }
    //endregion

    //region Getter&Setter
    public String getEmpresaAsociada() {
        return empresaAsociada;
    }

    public void setEmpresaAsociada(String empresaAsociada) {
        if (empresaAsociada != null && !empresaAsociada.isBlank())
            this.empresaAsociada = empresaAsociada;
        else throw new IllegalArgumentException("La empresa asociada no puede estar vacía");
    }

    public String getEmpresaExterna() {
        return empresaExterna;
    }

    public void setEmpresaExterna(String empresaExterna) {
        this.empresaExterna = (empresaExterna == null) ? "" : empresaExterna;
    }
    //endregion

    //region Overrides
    public Ej8CentroFP clone(Ej8CentroFP centro) {
        return new Ej8CentroFP(centro);
    }

    public boolean equals(Ej8CentroFP centro) {
        return (
            getNombre().equals(centro.getNombre()) &&
            getnEstudiantes()==centro.getnEstudiantes() &&
            getnProfesores()==centro.getnProfesores() &&
            getCodPos()==centro.getCodPos() &&
            getEmpresaAsociada().equals(centro.getEmpresaAsociada()) &&
            getEmpresaExterna().equals(centro.getEmpresaExterna())
        );
    }

    public String toString() {
        return STR."""
Nombre: \{getNombre()}
Número de Estudiantes: \{getnEstudiantes()}
Número de profesores: \{getnProfesores()}
Código Postal: \{getCodPos()}
Empresa asociada: \{getEmpresaAsociada()}
Empresa externa: \{getEmpresaExterna()}""";
    }
    //endregion
}
