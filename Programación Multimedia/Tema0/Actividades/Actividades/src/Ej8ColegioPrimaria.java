public class Ej8ColegioPrimaria extends Ej7CentroEducativo {
    //region Atributos
    private String eventoMensual;
    private String eventoComplementario;
    //endregion

    //region Constructores
    public Ej8ColegioPrimaria() {
        super();
        this.eventoMensual = "";
        this.eventoComplementario = "";
    }

    public Ej8ColegioPrimaria(String nombre, int nEstudiantes, int nProfesores, int codPos, String eventoMensual, String eventoComplementario) {
        super(nombre, nEstudiantes, nProfesores, codPos);
        setEventoMensual(eventoMensual);
        setEventoComplementario(eventoComplementario);
    }

    public Ej8ColegioPrimaria(Ej8ColegioPrimaria colegio) {
        super(colegio);
        setEventoMensual(colegio.getEventoMensual());
        setEventoComplementario(colegio.getEventoComplementario());
    }
    //endregion

    //region Métodos
    public String anuncioMensual() {
        if (eventoComplementario.isEmpty())
            return STR."Anuncio mensual: \{eventoMensual}";
        return STR."Anuncio mensual: \{eventoMensual} | Evento complementario: \{eventoComplementario}";
    }

    public String anuncioMensual(String mes) {
        return STR."Anuncio de \{mes}: " + anuncioMensual();
    }
    //endregion

    //region Getter&Setter
    public String getEventoMensual() {
        return eventoMensual;
    }

    public void setEventoMensual(String eventoMensual) {
        if (eventoMensual != null && !eventoMensual.isBlank())
            this.eventoMensual = eventoMensual;
        else throw new IllegalArgumentException("El evento mensual no puede estar vacío");
    }

    public String getEventoComplementario() {
        return eventoComplementario;
    }

    public void setEventoComplementario(String eventoComplementario) {
        this.eventoComplementario = (eventoComplementario == null) ? "" : eventoComplementario;
    }

    public void setnEstudiantes(int nEstudiantes) {
        if (nEstudiantes >= 50 && nEstudiantes <= 600)
            super.setnEstudiantes(nEstudiantes);
        else throw new IllegalArgumentException("Tamaño del campo no admitido");
    }

    public void setnProfesores(int nProfesores) {
        if (nProfesores >= 5 && nProfesores <= 100)
            super.setnProfesores(nProfesores);
        else throw new IllegalArgumentException("Tamaño del campo no admitido");
    }
    //endregion

    //region Overrides
    public Ej8ColegioPrimaria clone(Ej8ColegioPrimaria centro) {
        return new Ej8ColegioPrimaria(centro);
    }

    public boolean equals(Ej8ColegioPrimaria centro) {
        return (
            getNombre().equals(centro.getNombre()) &&
            getnEstudiantes()==centro.getnEstudiantes() &&
            getnProfesores()==centro.getnProfesores() &&
            getCodPos()==centro.getCodPos() &&
            getEventoMensual().equals(centro.getEventoMensual()) &&
            getEventoComplementario().equals(centro.getEventoComplementario())
        );
    }

    public String toString() {
        return STR."""
Nombre: \{getNombre()}
Número de Estudiantes: \{getnEstudiantes()}
Número de profesores: \{getnProfesores()}
Código Postal: \{getCodPos()}
Evento mensual: \{getEventoMensual()}
Evento complementario: \{getEventoComplementario()}""";
    }
    //endregion
}
