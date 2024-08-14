package gestion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Medalleria {
    private List<Medallista> medallistas;
    private final String archivo = "medallistas.dat";

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

    private void guardarMedallistas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(medallistas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarMedallistas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            medallistas = (List<Medallista>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, iniciando nuevo registro.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
