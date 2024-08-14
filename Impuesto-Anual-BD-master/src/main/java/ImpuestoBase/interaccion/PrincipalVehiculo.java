//package ImpuestoBase.interaccion;
//
//import ImpuestoBase.Entidades.Vehiculo;
//import ImpuestoBase.Servicios.VehiculoService;
//
//import java.util.List;
//import java.util.Scanner;
//
//public class PrincipalVehiculo {
//    private Scanner scanner;
//    private VehiculoService vehiculoService;
//
//    public PrincipalVehiculo(Scanner scanner) {
//        this.scanner = scanner;
//        this.vehiculoService = new VehiculoService();
//    }
//
//    public void mostrarMenu() {
//        int opcion;
//        do {
//            System.out.println("\n--- Menú de Interacción ---");
//            System.out.println("1. Registrar Vehículo");
//            System.out.println("2. Eliminar Vehículo");
//            System.out.println("3. Modificar Vehículo");
//            System.out.println("4. Buscar Vehículo");
//            System.out.println("5. Mostrar Todos los Vehículos");
//            System.out.println("0. Salir");
//            System.out.print("Seleccione una opción: ");
//            opcion = scanner.nextInt();
//            scanner.nextLine(); // Consumir la nueva línea pendiente
//
//            switch (opcion) {
//                case 1:
//                    registrarVehiculo();
//                    break;
//                case 2:
//                    eliminarVehiculo();
//                    break;
//                case 3:
//                    modificarVehiculo();
//                    break;
//                case 4:
//                    buscarVehiculo();
//                    break;
//                case 5:
//                    mostrarTodos();
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
//    private void registrarVehiculo() {
//        System.out.println("\n--- Registro de Vehículo ---");
//        System.out.println("---------------------------");
//
//        System.out.print("Placa: ");
//        String placa = scanner.nextLine();
//
//        System.out.print("Marca: ");
//        String marca = scanner.nextLine();
//
//        System.out.print("Color: ");
//        String color = scanner.nextLine();
//
//        System.out.print("Año de Registro: ");
//        int añoRegistro = scanner.nextInt();
//        scanner.nextLine();  // Consumir la nueva línea pendiente después de nextInt()
//
//        System.out.print("Municipio o Ciudad: ");
//        String municipioCiudad = scanner.nextLine();
//
//        System.out.print("Tipo de Vehículo: ");
//        String tipoVehiculo = scanner.nextLine();
//
//        System.out.print("Cilindraje: ");
//        int cilindraje = scanner.nextInt();
//        scanner.nextLine();  // Consumir la nueva línea pendiente después de nextInt()
//
//        System.out.print("Valor: ");
//        double valor = scanner.nextDouble();
//        scanner.nextLine();  // Consumir la nueva línea pendiente después de nextDouble()
//
//        System.out.print("Documento de Identidad del Propietario: ");
//        String documentoIdentidadPropietario = scanner.nextLine();
//
//        // Crear un objeto Vehiculo con los datos recopilados
//        Vehiculo vehiculo = new Vehiculo(placa, marca, color, añoRegistro, municipioCiudad, tipoVehiculo, cilindraje, valor, documentoIdentidadPropietario);
//
//        // Registrar el vehículo usando el servicio
//        vehiculoService.registrarVehiculo(vehiculo);
//
//        System.out.println("Vehículo registrado correctamente:");
//        System.out.println(vehiculo);
//    }
//
//    private void eliminarVehiculo() {
//        System.out.print("Ingrese la placa del vehículo a eliminar: ");
//        String placa = scanner.nextLine();
//        vehiculoService.eliminarVehiculo(placa);
//        System.out.println("Vehículo eliminado correctamente.");
//    }
//
//    private void modificarVehiculo() {
//        System.out.print("Ingrese la placa del vehículo a modificar: ");
//        String placa = scanner.nextLine();
//        Vehiculo vehiculo = vehiculoService.buscarVehiculo(placa);
//
//        if (vehiculo != null) {
//            System.out.println("Ingrese los nuevos datos del vehículo (deje en blanco para mantener el valor actual):");
//            System.out.print("Marca [" + vehiculo.getMarca() + "]: ");
//            String marca = scanner.nextLine();
//            if (!marca.isEmpty()) {
//                vehiculo.setMarca(marca);
//            }
//
//            System.out.print("Color [" + vehiculo.getColor() + "]: ");
//            String color = scanner.nextLine();
//            if (!color.isEmpty()) {
//                vehiculo.setColor(color);
//            }
//
//            System.out.print("Año de Registro [" + vehiculo.getAñoRegistro() + "]: ");
//            String añoRegistroStr = scanner.nextLine();
//            if (!añoRegistroStr.isEmpty()) {
//                try {
//                    int añoRegistro = Integer.parseInt(añoRegistroStr);
//                    vehiculo.setAñoRegistro(añoRegistro);
//                } catch (NumberFormatException e) {
//                    System.out.println("Ingrese un año válido. No se realizaron cambios en el año de registro.");
//                }
//            }
//
//            System.out.print("Municipio o Ciudad [" + vehiculo.getMunicipioCiudad() + "]: ");
//            String municipioCiudad = scanner.nextLine();
//            if (!municipioCiudad.isEmpty()) {
//                vehiculo.setMunicipioCiudad(municipioCiudad);
//            }
//
//            System.out.print("Tipo de Vehículo [" + vehiculo.getTipoVehiculo() + "]: ");
//            String tipoVehiculo = scanner.nextLine();
//            if (!tipoVehiculo.isEmpty()) {
//                vehiculo.setTipoVehiculo(tipoVehiculo);
//            }
//
//            System.out.print("Cilindraje [" + vehiculo.getCilindraje() + "]: ");
//            String cilindrajeStr = scanner.nextLine();
//            if (!cilindrajeStr.isEmpty()) {
//                try {
//                    int cilindraje = Integer.parseInt(cilindrajeStr);
//                    vehiculo.setCilindraje(cilindraje);
//                } catch (NumberFormatException e) {
//                    System.out.println("Ingrese un cilindraje válido. No se realizaron cambios en el cilindraje.");
//                }
//            }
//
//            System.out.print("Valor [" + vehiculo.getValor() + "]: ");
//            String valorStr = scanner.nextLine();
//            if (!valorStr.isEmpty()) {
//                try {
//                    double valor = Double.parseDouble(valorStr);
//                    vehiculo.setValor(valor);
//                } catch (NumberFormatException e) {
//                    System.out.println("Ingrese un valor válido. No se realizaron cambios en el valor.");
//                }
//            }
//
//            vehiculoService.modificarVehiculo(vehiculo);
//            System.out.println("Vehículo modificado correctamente.");
//        } else {
//            System.out.println("No se encontró ningún vehículo con la placa especificada.");
//        }
//    }
//
//    private void buscarVehiculo() {
//        System.out.print("Ingrese la placa del vehículo a buscar: ");
//        String placa = scanner.nextLine();
//
//        Vehiculo vehiculoEncontrado = vehiculoService.buscarVehiculo(placa);
//        if (vehiculoEncontrado != null) {
//            System.out.println("Vehículo encontrado:");
//            System.out.println(vehiculoEncontrado);
//        } else {
//            System.out.println("No se encontró ningún vehículo con la placa especificada.");
//        }
//    }
//
//    private void mostrarTodos() {
//        List<Vehiculo> vehiculos = vehiculoService.obtenerTodos();
//        if (!vehiculos.isEmpty()) {
//            System.out.println("Listado de Vehículos:");
//            for (Vehiculo vehiculo : vehiculos) {
//                System.out.println(vehiculo);
//            }
//        } else {
//            System.out.println("No hay vehículos registrados.");
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        PrincipalVehiculo principalVehiculo = new PrincipalVehiculo(scanner);
//
//        principalVehiculo.mostrarMenu();
//    }
//}
