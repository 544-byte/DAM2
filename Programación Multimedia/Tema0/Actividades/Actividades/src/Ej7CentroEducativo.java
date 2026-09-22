public class Ej7CentroEducativo {
    //region Atributos
    private String nombre;
    private int nEstudiantes;
    private int nProfesores;
    private int codPos;
    //endregion

    //region Constructores
    public Ej7CentroEducativo() {
        this.nombre = "";
        this.nEstudiantes = -1;
        this.nProfesores = -1;
        this.codPos = -1;
    }
    public Ej7CentroEducativo(String nombre, int nEstudiantes, int nProfesores, int codPos) {
        setNombre(nombre);
        setnEstudiantes(nEstudiantes);
        setnProfesores(nProfesores);
        setCodPos(codPos);
    }
    public Ej7CentroEducativo(Ej7CentroEducativo centro){
        setNombre(centro.getNombre());
        setnEstudiantes(centro.getnEstudiantes());
        setnProfesores(centro.getnProfesores());
        setCodPos(centro.getCodPos());
    }
    //endregion

    //region Getter&Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length()>= 10 && nombre.length() <=30)
            this.nombre = nombre;
        else throw new IllegalArgumentException("Tamaño del campo no admitido");
    }

    public int getnEstudiantes() {
        return nEstudiantes;
    }

    public void setnEstudiantes(int nEstudiantes) {
        if (nEstudiantes >= 50 && nEstudiantes <= 1200)
            this.nEstudiantes = nEstudiantes;
        else throw new IllegalArgumentException("Tamaño del campo no admitido");
    }

    public int getnProfesores() {
        return nProfesores;
    }

    public void setnProfesores(int nProfesores) {
        if (nProfesores >= 5 && nProfesores <= 200)
            this.nProfesores = nProfesores;
        else throw new IllegalArgumentException("Tamaño del campo no admitido");
    }

    public int getCodPos() {
        return codPos;
    }

    public void setCodPos(int codPos) {
        if (codPos >= 0 && codPos <= 52999)
            this.codPos = codPos;
        else throw new IllegalArgumentException("Tamaño del campo no admitido");
    }

    //endregion

    //region Overrides
    public Ej7CentroEducativo clone(Ej7CentroEducativo centro){
        return new Ej7CentroEducativo(centro);
    }

    public boolean equals(Ej7CentroEducativo centro) {
        return (
            getNombre().equals(centro.getNombre()) &&
            getnEstudiantes()==centro.getnEstudiantes() &&
            getnProfesores()==centro.getnProfesores() &&
            getCodPos()==centro.getCodPos()
        );
    }

    public String toString() {
        return STR."""
Nombre: \{getNombre()}
Número de Estudiantes: \{getnEstudiantes()}
Número de profesores: \{getnProfesores()}
Código Postal: \{getCodPos()}""";
    }
    //endregion
}
