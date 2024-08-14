//package ImpuestoBase.Controladores;
//
//import ImpuestoBase.Entidades.Vehiculo;
//import ImpuestoBase.Servicios.VehiculoService;
//import ImpuestoBase.interaccion.PrincipalVehiculo;
//
//import java.util.Scanner;
//
//public class VehiculoController {
//    private VehiculoService vehiculoService;
//
//    public VehiculoController(VehiculoService vehiculoService) {
//        this.vehiculoService = vehiculoService;
//    }
//
//    public void registrarVehiculo(Vehiculo vehiculo) {
//        vehiculoService.registrarVehiculo(vehiculo);
//    }
//
//    public void eliminarVehiculo(String placa) {
//        vehiculoService.eliminarVehiculo(placa);
//    }
//
//    public void modificarVehiculo(Vehiculo vehiculo) {
//        vehiculoService.modificarVehiculo(vehiculo);
//    }
//
//    public Vehiculo buscarVehiculo(String placa) {
//        return vehiculoService.buscarVehiculo(placa);
//    }
//
//    public void mostrarTodos() {
//        vehiculoService.mostrarTodos();
//    }
//}