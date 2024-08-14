//package ImpuestoBase.interaccion;
//
//import ImpuestoBase.Entidades.Impuesto;
//import ImpuestoBase.Servicios.ImpuestoService;
//import ImpuestoBase.Servicios.PropietarioService;
//import ImpuestoBase.Servicios.VehiculoService;
//
//import java.util.List;
//import java.util.Scanner;
//
//public class PrincipalImpuesto {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // Suponiendo que ya tienes tus servicios e inicializados los repositorios adecuadamente
//        PropietarioService propietarioService = new PropietarioService();
//        VehiculoService vehiculoService = new VehiculoService();
//        ImpuestoService impuestoService = new ImpuestoService(propietarioService, vehiculoService);
//
//        int opcion;
//        do {
//            System.out.println("\n--- Menú Principal de Gestión de Impuestos ---");
//            System.out.println("1. Realizar pago de impuesto");
//            System.out.println("2. Consultar impuestos por propietario");
//            System.out.println("0. Salir");
//            System.out.print("Seleccione una opción: ");
//            opcion = scanner.nextInt();
//            scanner.nextLine(); // Limpiar buffer
//
//            switch (opcion) {
//                case 1:
//                    realizarPagoImpuesto(scanner, impuestoService);
//                    break;
//                case 2:
//                    consultarImpuestosPorPropietario(scanner, impuestoService);
//                    break;
//                case 0:
//                    System.out.println("Saliendo del sistema...");
//                    break;
//                default:
//                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
//                    break;
//            }
//        } while (opcion != 0);
//
//        scanner.close();
//    }
//
//    private static void realizarPagoImpuesto(Scanner scanner, ImpuestoService impuestoService) {
//        System.out.println("\n--- Pago de Impuesto ---");
//        System.out.println("Ingrese su documento de identidad: ");
//        String documentoPropietario = scanner.nextLine();
//
//        System.out.println("Ingrese la placa de su vehículo: ");
//        String placa = scanner.nextLine();
//
//        System.out.println("Ingrese el año para el cual desea pagar el impuesto: ");
//        int año = scanner.nextInt();
//        scanner.nextLine(); // Limpiar buffer
//
//        double valorImpuesto = impuestoService.calcularValorImpuesto(documentoPropietario, placa, año);
//
//        System.out.println("Información del impuesto:");
//        System.out.println("El valor estimado del impuesto a pagar es: $" + valorImpuesto);
//
//        System.out.println("¿Desea confirmar el pago? (S/N): ");
//        String confirmacion = scanner.nextLine().toUpperCase();
//
//        if (confirmacion.equals("S")) {
//            impuestoService.pagarImpuesto(documentoPropietario, placa, año);
//            System.out.println("¡Pago exitoso!");
//        } else {
//            System.out.println("Pago cancelado.");
//        }
//    }
//
//    private static void consultarImpuestosPorPropietario(Scanner scanner, ImpuestoService impuestoService) {
//        System.out.println("\n--- Consulta de Impuestos por Propietario ---");
//        System.out.println("Ingrese su documento de identidad: ");
//        String documentoPropietario = scanner.nextLine();
//
//        List<Impuesto> impuestos = impuestoService.consultarImpuestos(documentoPropietario);
//
//        if (!impuestos.isEmpty()) {
//            System.out.println("Impuestos pagados por el propietario con documento " + documentoPropietario + ":");
//            for (Impuesto impuesto : impuestos) {
//                System.out.println(impuesto);
//            }
//        } else {
//            System.out.println("El propietario no tiene impuestos pagados.");
//        }
//    }
//}
