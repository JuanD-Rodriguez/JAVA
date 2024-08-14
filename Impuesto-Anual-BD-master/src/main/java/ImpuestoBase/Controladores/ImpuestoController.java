//package ImpuestoBase.Controladores;
//
//import ImpuestoBase.Entidades.Impuesto;
//import ImpuestoBase.Servicios.ImpuestoService;
//
//import java.util.List;
//
//public class ImpuestoController {
//    private ImpuestoService impuestoService;
//
//    public ImpuestoController(ImpuestoService impuestoService) {
//        this.impuestoService = impuestoService;
//    }
//
//    public void pagarImpuesto(String documentoPropietario, String placa, int año) {
//        impuestoService.pagarImpuesto(documentoPropietario, placa, año);
//    }
//
//    public double calcularValorImpuesto(String documentoPropietario, String placa, int año) {
//        return impuestoService.calcularValorImpuesto(documentoPropietario, placa, año);
//    }
//
//    public List<Impuesto> consultarImpuestos(String documentoPropietario) {
//        return impuestoService.consultarImpuestos(documentoPropietario);
//    }
//
//    public Impuesto buscarImpuesto(String documentoPropietario, String placaVehiculo, int año) {
//        return impuestoService.buscarImpuesto(documentoPropietario, placaVehiculo, año);
//    }
//}
