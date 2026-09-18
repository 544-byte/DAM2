import java.nio.charset.MalformedInputException;

public class Libro {
    //region Atributos
    private String titulo;
    private String autor;
    private int nPag;
    private String genero;

    //endregion

    //region Métodos

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