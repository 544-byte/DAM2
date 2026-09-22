import java.nio.charset.MalformedInputException;

public class Libro {
    //region Atributos
    private String titulo;
    private String autor;
    private int nPag;
    private String genero;

    //endregion

    //region Métodos

    public boolean esAutor(String autor) {
        return autor.equals(this.autor);
    }

    public boolean esTitulo(String titulo) {
        return titulo.equals(this.titulo);
    }

    public boolean esNPags(int nPag) {
        return (nPag == this.nPag);
    }

    public String descripcion(){
        switch (genero){
            case "Fantasía" -> { return "Preparate para vivir una aventura fantástica"; }
            case "Ciencia Ficción" -> { return "Disfrutarás de una aventura más allá de tus expectativas"; }
            case "Misterio" -> { return "No serás capaz de soltarlo"; }
            default -> { return "Disfruta de la gran variedad de nuestra biblioteca"; }
        }
    }

    //endregion

    //region Setters&Getters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo.length() <= 20 ) {
            this.titulo = titulo;
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        for (char c : autor.toCharArray()){
            if(Character.isDigit(c)) throw new IllegalArgumentException("No se valen números en el autor");
        }
        this.autor = autor;
    }

    public int getnPag() {
        return nPag;
    }

    public void setnPag(int nPag) {
        if (nPag  >= 10 && nPag <= 2000){
            this.nPag = nPag;
        }
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if (genero.replaceAll(" ", "").toLowerCase().equals(genero)) {
            this.genero = genero;
        }
        /*
        this.genero = genero.replaceAll(" ","").toLowerCase()
         */
    }

    //endregion
}