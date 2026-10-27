package SegundoApartado;

public record Registro (
        int id,
        int numero
){
    @Override
    public String toString() {
        return id+","+numero;
    }
}