package gestion;

import java.io.Serializable;

public class Medallista implements Serializable {
    private String pais;
    private String nombre;
    private String disciplina;
    private String categoria;
    private String subcategoria;
    private String tipoMedalla;
    private int año;
    private int edad;

    public Medallista(String pais, String nombre, String disciplina, String categoria, 
                      String subcategoria, String tipoMedalla, int año, int edad) {
        this.pais = pais;
        this.nombre = nombre;
        this.disciplina = disciplina;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.tipoMedalla = tipoMedalla;
        this.año = año;
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getTipoMedalla() {
        return tipoMedalla;
    }

    public void setTipoMedalla(String tipoMedalla) {
        this.tipoMedalla = tipoMedalla;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Método para convertir un Medallista en una cadena de texto para almacenar en un archivo
    public String toFileString() {
        return pais + "," + nombre + "," + disciplina + "," + categoria + "," +
                subcategoria + "," + tipoMedalla + "," + año + "," + edad;
    }

    // Método para crear un Medallista desde una cadena de texto del archivo
    public static Medallista fromFileString(String fileString) {
        String[] datos = fileString.split(",");
        return new Medallista(datos[0], datos[1], datos[2], datos[3], datos[4],
                datos[5], Integer.parseInt(datos[6]), Integer.parseInt(datos[7]));
    }

    @Override
    public String toString() {
        return "País: " + pais + ", Nombre: " + nombre + ", Disciplina: " + disciplina + 
               ", Categoría: " + categoria + ", Subcategoría: " + subcategoria + 
               ", Tipo de Medalla: " + tipoMedalla + ", Año: " + año + ", Edad: " + edad;
    }
}
