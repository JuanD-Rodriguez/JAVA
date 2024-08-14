//package ImpuestoBase.Controladores;
//
//import ImpuestoBase.Entidades.Propietario;
//import ImpuestoBase.Servicios.PropietarioService;
//
//public class PropietarioController {
//    private PropietarioService propietarioService;
//
//    public PropietarioController(PropietarioService propietarioService) {
//        this.propietarioService = propietarioService;
//    }
//
//    public void registrarPropietario(Propietario propietario, String placaVehiculo) {
//        propietarioService.registrar(propietario, placaVehiculo);
//    }
//
//    public void eliminarPropietario(String documentoIdentidad) {
//        propietarioService.eliminar(documentoIdentidad);
//    }
//
//    public void modificarPropietario(Propietario propietario) {
//        propietarioService.modificarPropietario(propietario);
//    }
//
//    public Propietario buscarPropietario(String documentoIdentidad) {
//        return propietarioService.buscar(documentoIdentidad);
//    }
//
//    public void mostrarTodosPropietarios() {
//        propietarioService.mostrarPropietarios();
//    }
//}
