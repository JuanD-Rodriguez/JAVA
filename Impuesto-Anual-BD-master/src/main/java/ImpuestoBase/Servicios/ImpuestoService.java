//package ImpuestoBase.Servicios;
//import ImpuestoBase.Entidades.Impuesto;
//import ImpuestoBase.Entidades.Vehiculo;
//import ImpuestoBase.Repositorios.ImpuestoRepositorio;
//import ImpuestoBase.Repositorios.PropietarioRepositorio;
//import ImpuestoBase.Repositorios.VehiculoRepositorio;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class ImpuestoService implements  ImpuestoRepositorio {
//
//    private PropietarioRepositorio propietarioRepositorio;
//    private VehiculoRepositorio vehiculoRepositorio;
//
//    public ImpuestoService(PropietarioRepositorio propietarioRepositorio, VehiculoRepositorio vehiculoRepositorio) {
//        this.propietarioRepositorio = propietarioRepositorio;
//        this.vehiculoRepositorio = vehiculoRepositorio;
//    }
//
//    private List<Impuesto> cargarImpuestos() {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("impuestos.dat"))) {
//            return (List<Impuesto>) ois.readObject();
//        } catch (FileNotFoundException e) {
//            crearArchivoImpuestos();
//            return new ArrayList<>();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//            return new ArrayList<>();
//        }
//    }
//
//    private void crearArchivoImpuestos() {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("impuestos.dat"))) {
//            oos.writeObject(new ArrayList<>());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void guardarImpuestos(List<Impuesto> impuestos) {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("impuestos.dat"))) {
//            oos.writeObject(impuestos);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private double calcularDepreciacionAnual(Vehiculo vehiculo) {
//        double porcentajeDepreciacion = (vehiculo.getTipoVehiculo().equalsIgnoreCase("moto")) ? 0.08 : 0.1;
//
//        int añoRegistro = vehiculoRepositorio.obtenerAñoRegistroDesdeArchivo(vehiculo.getPlaca());
//        int añoActual = java.time.Year.now().getValue();
//
//        double valorActual = vehiculo.getValor();
//        for (int año = añoRegistro; año < añoActual; año++) {
//            valorActual -= valorActual * porcentajeDepreciacion;
//        }
//
//        return valorActual;
//    }
//
//    // Método agregado para calcular el valor del impuesto
//    @Override
//    public double calcularValorImpuesto(String documentoPropietario, String placa, int año) {
//        Vehiculo vehiculo = vehiculoRepositorio.buscarVehiculo(placa);
//
//        if (vehiculo != null && vehiculo.getDocumentoIdentidadPropietario().equals(documentoPropietario)) {
//            boolean impuestoPagado = verificarImpuestoPagado(documentoPropietario, placa, año);
//
//            if (impuestoPagado) {
//                System.out.println("El impuesto para el año " + año + " ya ha sido pagado.");
//                // Devuelve 0 o algún valor que indique que el impuesto ya ha sido pagado
//                return 0;
//            } else {
//                double valorDepreciado = calcularDepreciacionAnual(vehiculo);
//                return valorDepreciado * 0.02; // Ajusta según la fórmula específica que desees usar
//            }
//        } else {
//            System.out.println("No se encontró el vehículo asociado con la placa o no pertenece al propietario");
//            // Devuelve 0 o algún valor que indique que no se pudo calcular el impuesto
//            return 0;
//        }
//    }
//
//    @Override
//    public void pagarImpuesto(String documentoPropietario, String placa, int año) {
//        Vehiculo vehiculo = vehiculoRepositorio.buscarVehiculo(placa);
//
//        if (vehiculo != null && vehiculo.getDocumentoIdentidadPropietario().equals(documentoPropietario)) {
//            List<Impuesto> impuestos = cargarImpuestos();
//
//            boolean impuestoPagado = verificarImpuestoPagado(documentoPropietario, placa, año);
//
//            if (impuestoPagado) {
//                System.out.println("El impuesto para el año " + año + " ya ha sido pagado.");
//            } else {
//                double valorDepreciado = calcularDepreciacionAnual(vehiculo);
//                double valorImpuesto = valorDepreciado * 0.02;
//
//                Impuesto impuesto = new Impuesto(documentoPropietario, placa, año, true, valorImpuesto);
//                impuestos.add(impuesto);
//
//                guardarImpuestos(impuestos);
//
//                System.out.println("Impuesto pagado exitosamente para el año " + año + ". Valor del impuesto: $" + valorImpuesto);
//            }
//        } else {
//            System.out.println("No se encontró el vehículo asociado con la placa o no pertenece al propietario");
//        }
//    }
//
//    @Override
//    public List<String> obtenerPlacasPorPropietario(String documentoPropietario) {
//        List<String> placas = new ArrayList<>();
//        List<Vehiculo> vehiculos = vehiculoRepositorio.buscarVehiculosPorPropietario(documentoPropietario);
//
//        for (Vehiculo vehiculo : vehiculos) {
//            placas.add(vehiculo.getPlaca());
//        }
//
//        return placas;
//    }
//
//    @Override
//    public int obtenerAñoRegistro(String placa) {
//        return vehiculoRepositorio.obtenerAñoRegistroDesdeArchivo(placa);
//    }
//
//    @Override
//    public boolean verificarImpuestoPagado(String documentoPropietario, String placa, int año) {
//        List<Impuesto> impuestos = cargarImpuestos();
//
//        for (Impuesto impuesto : impuestos) {
//            if (impuesto.getDocumentoPropietario().equals(documentoPropietario)
//                    && impuesto.getPlacaVehiculo().equals(placa)
//                    && impuesto.getAño() == año
//                    && impuesto.isPagado()) {
//                return true; // Impuesto pagado
//            }
//        }
//
//        return false; // Impuesto no pagado
//    }
//
//    @Override
//    public List<Impuesto> consultarImpuestos(String documentoPropietario) {
//        List<Impuesto> impuestos = cargarImpuestos();
//        List<Impuesto> impuestosConsultados = new ArrayList<>();
//
//        for (Impuesto impuesto : impuestos) {
//            if (impuesto.getDocumentoPropietario().equals(documentoPropietario)) {
//                impuestosConsultados.add(impuesto);
//            }
//        }
//
//        return impuestosConsultados;
//    }
//
//    @Override
//    public Impuesto buscarImpuesto(String documentoPropietario, String placaVehiculo, int año) {
//        List<Impuesto> impuestos = cargarImpuestos();
//
//        for (Impuesto impuesto : impuestos) {
//            if (impuesto.getDocumentoPropietario().equals(documentoPropietario)
//                    && impuesto.getPlacaVehiculo().equals(placaVehiculo)
//                    && impuesto.getAño() == año) {
//                return impuesto;
//            }
//        }
//
//        return null;
//    }
//}
