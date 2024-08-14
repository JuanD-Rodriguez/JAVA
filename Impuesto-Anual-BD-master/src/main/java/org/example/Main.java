//package org.example;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import ImpuestoBase.Servicios.VehiculoService;
//import ImpuestoBase.dto.VehiculoDto;
//
//@SpringBootApplication
//public class MainApplication implements CommandLineRunner {
//
//    @Autowired
//    private VehiculoService vehiculoService;
//
//    public static void main(String[] args) {
//        SpringApplication.run(MainApplication.class, args);
//    }
//
//    @Override
//    public void run(String... args) {
//        // Crear y registrar un vehículo usando setters en lugar del constructor
//        VehiculoDto nuevoVehiculo = new VehiculoDto();
//        nuevoVehiculo.setPlaca("ABC123");
//        nuevoVehiculo.setMarca("Toyota");
//        nuevoVehiculo.setColor("Rojo");
//        nuevoVehiculo.setAñoRegistro(2020);
//        nuevoVehiculo.setMunicipioCiudad("Medellín");
//        nuevoVehiculo.setTipoVehiculo("Sedán");
//        nuevoVehiculo.setCilindraje(1800);
//        nuevoVehiculo.setValor(50000.0);
//        nuevoVehiculo.setDocumentoIdentidadPropietario("123456789");
//
//        vehiculoService.registrarVehiculo(nuevoVehiculo);
//
//        // Buscar un vehículo por placa
//        VehiculoDto vehiculoEncontrado = vehiculoService.buscarVehiculoPorPlaca("ABC123");
//        System.out.println("Vehículo encontrado: " + vehiculoEncontrado);
//
//        // Eliminar un vehículo
//        vehiculoService.eliminarVehiculo("ABC123");
//        System.out.println("Vehículo eliminado.");
//    }
//}
