package gestion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Medalleria {
    private List<Medallista> medallistas;
    private final String archivo = "medallistas.txt"; // Cambiado a .txt

    public Medalleria() {
        medallistas = new ArrayList<>();
        cargarMedallistas();
    }

    public void agregarMedallista(Medallista medallista) {
        medallistas.add(medallista);
        guardarMedallistas();
    }

    public List<Medallista> listarMedallistas() {
        return medallistas;
    }

    public List<Medallista> listarMedallistasPorPais(String pais) {
        return medallistas.stream()
                .filter(m -> m.getPais().equalsIgnoreCase(pais))
                .collect(Collectors.toList());
    }

    public List<Medallista> listarMedallistasPorMedalla(String tipoMedalla) {
        return medallistas.stream()
                .filter(m -> m.getTipoMedalla().equalsIgnoreCase(tipoMedalla))
                .collect(Collectors.toList());
    }

    private void guardarMedallistas() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Medallista medallista : medallistas) {
                bw.write(medallista.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarMedallistas() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                medallistas.add(Medallista.fromFileString(linea));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, iniciando nuevo registro.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
