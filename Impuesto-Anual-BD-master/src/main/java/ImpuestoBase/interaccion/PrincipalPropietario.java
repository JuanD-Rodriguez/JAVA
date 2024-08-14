//package ImpuestoBase.interaccion;
//
//import ImpuestoBase.Entidades.Propietario;
//import ImpuestoBase.Servicios.PropietarioService;
//
//import java.util.Scanner;
//
//public class PrincipalPropietario {
//    private Scanner scanner;
//    private PropietarioService propietarioService;
//
//    public PrincipalPropietario(Scanner scanner, PropietarioService propietarioService) {
//        this.scanner = scanner;
//        this.propietarioService = propietarioService;
//    }
//    public void mostrarMenu() {
//        int opcion;
//        do {
//            System.out.println("\n--- Menú de Propietarios ---");
//            System.out.println("1. Registrar Propietario");
//            System.out.println("2. Eliminar Propietario");
//            System.out.println("3. Modificar Propietario");
//            System.out.println("4. Buscar Propietario");
//            System.out.println("5. Mostrar Todos los Propietarios");
//            System.out.println("0. Salir");
//            System.out.print("Seleccione una opción: ");
//            opcion = scanner.nextInt();
//            scanner.nextLine(); // Consumir la nueva línea pendiente
//
//            switch (opcion) {
//                case 1:
//                    registrarPropietario();
//                    break;
//                case 2:
//                    eliminarPropietario();
//                    break;
//                case 3:
//                    modificarPropietario();
//                    break;
//                case 4:
//                    buscarPropietario();
//                    break;
//                case 5:
//                    propietarioService.mostrarPropietarios();
//                    break;
//                case 0:
//                    System.out.println("Saliendo del programa...");
//                    break;
//                default:
//                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
//                    break;
//            }
//        } while (opcion != 0);
//    }
//
//    private void registrarPropietario() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Ingrese el nombre del propietario: ");
//        String nombre = scanner.nextLine();
//
//        System.out.println("Ingrese los apellidos del propietario: ");
//        String apellidos = scanner.nextLine();
//
//        System.out.println("Ingrese el tipo de documento del propietario: ");
//        String tipoDocumento = scanner.nextLine();
//
//        System.out.println("Ingrese el número de documento del propietario: ");
//        String documentoIdentidad = scanner.nextLine();
//
//        System.out.println("Ingrese el correo del propietario: ");
//        String correo = scanner.nextLine();
//
//        System.out.println("Ingrese la dirección de residencia del propietario: ");
//        String direccionResidencia = scanner.nextLine();
//
//        System.out.println("Ingrese la placa del vehículo asociado al propietario: ");
//        String placaVehiculo = scanner.nextLine();
//
//        Propietario propietario = new Propietario(nombre, apellidos, tipoDocumento, documentoIdentidad, correo, direccionResidencia, placaVehiculo);
//        propietarioService.registrar(propietario, placaVehiculo);
//        System.out.println("Propietario registrado exitosamente.");
//    }
//
//    private void eliminarPropietario() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Ingrese el número de documento del propietario a eliminar: ");
//        String documentoIdentidad = scanner.nextLine();
//
//        propietarioService.eliminar(documentoIdentidad);
//        System.out.println("Propietario eliminado exitosamente.");
//    }
//
//    private void modificarPropietario() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Ingrese el número de documento del propietario a modificar: ");
//        String documentoIdentidad = scanner.nextLine();
//
//        Propietario propietarioExistente = propietarioService.buscar(documentoIdentidad);
//
//        if (propietarioExistente != null) {
//            System.out.println("Propietario actual:");
//            System.out.println(propietarioExistente);
//
//            System.out.println("Ingrese el nuevo nombre del propietario (o Enter para mantener el actual): ");
//            String nuevoNombre = scanner.nextLine();
//            if (!nuevoNombre.isEmpty()) {
//                propietarioExistente.setNombre(nuevoNombre);
//            }
//
//            System.out.println("Ingrese los nuevos apellidos del propietario (o Enter para mantener los actuales): ");
//            String nuevosApellidos = scanner.nextLine();
//            if (!nuevosApellidos.isEmpty()) {
//                propietarioExistente.setApellidos(nuevosApellidos);
//            }
//
//            System.out.println("Ingrese el nuevo tipo de documento del propietario (o Enter para mantener el actual): ");
//            String nuevoTipoDocumento = scanner.nextLine();
//            if (!nuevoTipoDocumento.isEmpty()) {
//                propietarioExistente.setTipoDocumento(nuevoTipoDocumento);
//            }
//
//            System.out.println("Ingrese el nuevo correo del propietario (o Enter para mantener el actual): ");
//            String nuevoCorreo = scanner.nextLine();
//            if (!nuevoCorreo.isEmpty()) {
//                propietarioExistente.setCorreo(nuevoCorreo);
//            }
//
//            System.out.println("Ingrese la nueva dirección de residencia del propietario (o Enter para mantener la actual): ");
//            String nuevaDireccion = scanner.nextLine();
//            if (!nuevaDireccion.isEmpty()) {
//                propietarioExistente.setDireccionResidencia(nuevaDireccion);
//            }
//
//            System.out.println("Ingrese la nueva placa del vehículo del propietario (o Enter para mantener la actual): ");
//            String nuevaPlaca = scanner.nextLine();
//            if (!nuevaPlaca.isEmpty()) {
//                propietarioExistente.setPlacaVehiculo(nuevaPlaca);
//            }
//
//            // Aplica los cambios
//            propietarioService.modificarPropietario(propietarioExistente);
//
//            System.out.println("Propietario modificado exitosamente.");
//        } else {
//            System.out.println("No se encontró un propietario con el documento ingresado.");
//        }
//    }
//
//    private void buscarPropietario() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Ingrese el número de documento del propietario a buscar: ");
//        String documentoIdentidad = scanner.nextLine();
//
//        Propietario propietario = propietarioService.buscar(documentoIdentidad);
//
//        if (propietario != null) {
//            System.out.println("Propietario encontrado:");
//            System.out.println(propietario);
//        } else {
//            System.out.println("No se encontró un propietario con el documento ingresado.");
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        // Asegúrate de crear una instancia de PropietarioService aquí
//        PropietarioService propietarioService = new PropietarioService();
//        // Ahora pasas ambos, scanner y propietarioService, al constructor
//        PrincipalPropietario principalPropietario = new PrincipalPropietario(scanner, propietarioService);
//
//        principalPropietario.mostrarMenu();
//    }
//
//}