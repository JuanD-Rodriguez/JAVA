package gestion;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Medallista implements Serializable {
    private String pais;
    private String nombre;
    private String disciplina;
    private String categoria;
    private String subcategoria;
    private String tipoMedalla;
    private int año;
    private int edad; 
    private String hobbie;
    private Date fechaNacimiento;

    public Medallista(String pais, String nombre, String disciplina, String categoria,
                      String subcategoria, String tipoMedalla, int año, String hobbie, Date fechaNacimiento) {
        this.pais = pais;
        this.nombre = nombre;
        this.disciplina = disciplina;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.tipoMedalla = tipoMedalla;
        this.año = año;
        this.hobbie = hobbie;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = calcularEdad(fechaNacimiento);
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

    public String getHobbie() {
        return hobbie;
    }

    public void setHobbie(String hobbie) {
        this.hobbie = hobbie;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        this.edad = calcularEdad(fechaNacimiento); 
    }

    private int calcularEdad(Date fechaNacimiento) {
        Calendar fechaNac = Calendar.getInstance();
        fechaNac.setTime(fechaNacimiento);
        Calendar hoy = Calendar.getInstance();

        int edad = hoy.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);

        if (hoy.get(Calendar.MONTH) < fechaNac.get(Calendar.MONTH) ||
            (hoy.get(Calendar.MONTH) == fechaNac.get(Calendar.MONTH) && hoy.get(Calendar.DAY_OF_MONTH) < fechaNac.get(Calendar.DAY_OF_MONTH))) {
            edad--;
        }

        return edad;
    }

    public String toFileString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return pais + "," + nombre + "," + disciplina + "," + categoria + "," +
                subcategoria + "," + tipoMedalla + "," + año + "," + hobbie + "," + dateFormat.format(fechaNacimiento);
    }

    public static Medallista fromFileString(String fileString) {
        String[] datos = fileString.split(",");
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNacimiento = dateFormat.parse(datos[8]);
            return new Medallista(datos[0], datos[1], datos[2], datos[3], datos[4],
                    datos[5], Integer.parseInt(datos[6]), datos[7], fechaNacimiento);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "País: " + pais + ", Nombre: " + nombre + ", Disciplina: " + disciplina +
               ", Categoría: " + categoria + ", Subcategoría: " + subcategoria +
               ", Tipo de Medalla: " + tipoMedalla + ", Año: " + año + ", Edad: " + edad +
               ", Fecha de Nacimiento: " + dateFormat.format(fechaNacimiento) + ", Hobbie: " + hobbie;
    }
}
