package ImpuestoBase;

import ImpuestoBase.Servicios.PropietarioService;
import ImpuestoBase.Servicios.VehiculoService;
import ImpuestoBase.dto.PropietarioDto;
import ImpuestoBase.dto.VehiculoDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(VehiculoService vehiculoService, PropietarioService propietarioService) {
        return args -> {
            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;
            while (continuar) {
                System.out.println("\nSeleccione una opción:");
                System.out.println("1. Operaciones con Vehículos");
                System.out.println("2. Operaciones con Propietarios");
                System.out.println("3. Salir");
                int opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        operacionesVehiculos(scanner, vehiculoService);
                        break;
                    case 2:
                        operacionesPropietarios(scanner, propietarioService);
                        break;
                    case 3:
                        continuar = false;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            }
        };
    }

    private void operacionesVehiculos(Scanner scanner, VehiculoService vehiculoService) {
        System.out.println("Operaciones sobre Vehículos:");
        System.out.println("1. Registrar Vehículo");
        System.out.println("2. Modificar Vehículo");
        System.out.println("3. Eliminar Vehículo");
        System.out.println("4. Buscar Vehículo por Placa");
        System.out.println("5. Listar todos los Vehículos");
        System.out.println("Seleccione una opción:");
        String opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                registrarVehiculo(scanner, vehiculoService);
                break;
            case "2":
                modificarVehiculo(scanner, vehiculoService);
                break;
            case "3":
                eliminarVehiculo(scanner, vehiculoService);
                break;
            case "4":
                buscarVehiculoPorPlaca(scanner, vehiculoService);
                break;
            case "5":
                listarTodosLosVehiculos(vehiculoService);
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    private void operacionesPropietarios(Scanner scanner, PropietarioService propietarioService) {
        System.out.println("Operaciones sobre Propietarios:");
        System.out.println("1. Registrar Propietario");
        System.out.println("2. Modificar Propietario");
        System.out.println("3. Eliminar Propietario");
        System.out.println("4. Buscar Propietario por Documento");
        System.out.println("5. Listar todos los Propietarios");
        System.out.println("Seleccione una opción:");
        String opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                registrarPropietario(scanner, propietarioService);
                break;
            case "2":
                modificarPropietario(scanner, propietarioService);
                break;
            case "3":
                eliminarPropietario(scanner, propietarioService);
                break;
            case "4":
                buscarPropietarioPorDocumento(scanner, propietarioService);
                break;
            case "5":
                listarTodosLosPropietarios(propietarioService);
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
    private void registrarVehiculo(Scanner scanner, VehiculoService vehiculoService) {
        VehiculoDto vehiculoDto = new VehiculoDto();
        System.out.println("Registrando un nuevo vehículo...");
        System.out.print("Placa: ");
        vehiculoDto.setPlaca(scanner.nextLine());
        System.out.print("Marca: ");
        vehiculoDto.setMarca(scanner.nextLine());
        System.out.print("Color: ");
        vehiculoDto.setColor(scanner.nextLine());
        System.out.print("Año de Registro: ");
        vehiculoDto.setAñoRegistro(Integer.parseInt(scanner.nextLine()));
        System.out.print("Municipio/Ciudad: ");
        vehiculoDto.setMunicipioCiudad(scanner.nextLine());
        System.out.print("Tipo de Vehículo: ");
        vehiculoDto.setTipoVehiculo(scanner.nextLine());
        System.out.print("Cilindraje: ");
        vehiculoDto.setCilindraje(Integer.parseInt(scanner.nextLine()));
        System.out.print("Valor: ");
        vehiculoDto.setValor(Double.parseDouble(scanner.nextLine()));
        System.out.print("Documento de Identidad del Propietario: ");
        vehiculoDto.setDocumentoIdentidadPropietario(scanner.nextLine());

        vehiculoService.registrarVehiculo(vehiculoDto);
        System.out.println("Vehículo registrado exitosamente.\n");
    }

    private void modificarVehiculo(Scanner scanner, VehiculoService vehiculoService) {
        System.out.print("Placa del vehículo a modificar: ");
        String placa = scanner.nextLine();
        VehiculoDto vehiculoExistente = vehiculoService.buscarVehiculoPorPlaca(placa);
        if (vehiculoExistente == null) {
            System.out.println("Vehículo no encontrado.");
            return;
        }
    }

    private void eliminarVehiculo(Scanner scanner, VehiculoService vehiculoService) {
        System.out.print("Placa del vehículo a eliminar: ");
        String placa = scanner.nextLine();
        vehiculoService.eliminarVehiculo(placa);
        System.out.println("Vehículo eliminado exitosamente.");
    }

    private void buscarVehiculoPorPlaca(Scanner scanner, VehiculoService vehiculoService) {
        System.out.print("Placa del vehículo a buscar: ");
        String placa = scanner.nextLine();
        VehiculoDto vehiculo = vehiculoService.buscarVehiculoPorPlaca(placa);
        if (vehiculo != null) {
            System.out.println("Vehículo encontrado: " + vehiculo);
        } else {
            System.out.println("Vehículo no encontrado.");
        }
    }

    private void listarTodosLosVehiculos(VehiculoService vehiculoService) {
        List<VehiculoDto> vehiculos = vehiculoService.obtenerTodos();
        vehiculos.forEach(System.out::println);
    }

    private void registrarPropietario(Scanner scanner, PropietarioService propietarioService) {
        System.out.println("Ingrese los datos del propietario:");
        System.out.print("Documento de Identidad: ");
        String documentoIdentidad = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        PropietarioDto propietarioDto = new PropietarioDto();
        propietarioDto.setDocumentoIdentidad(documentoIdentidad);
        propietarioDto.setNombre(nombre);
      
        propietarioService.registrarPropietario(propietarioDto);
        System.out.println("Propietario registrado exitosamente.");
    }
    private void modificarPropietario(Scanner scanner, PropietarioService propietarioService) {
        System.out.print("Documento de Identidad del propietario a modificar: ");
        String documentoIdentidad = scanner.nextLine();
        PropietarioDto propietarioExistente = propietarioService.buscarPorDocumentoIdentidad(documentoIdentidad);
        if (propietarioExistente == null) {
            System.out.println("Propietario no encontrado.");
            return;
        }

    }

    private void eliminarPropietario(Scanner scanner, PropietarioService propietarioService) {
        System.out.print("Documento de Identidad del propietario a eliminar: ");
        String documentoIdentidad = scanner.nextLine();
        propietarioService.eliminarPropietario(documentoIdentidad);
        System.out.println("Propietario eliminado exitosamente.");
    }

    private void buscarPropietarioPorDocumento(Scanner scanner, PropietarioService propietarioService) {
        System.out.print("Documento de Identidad del propietario a buscar: ");
        String documentoIdentidad = scanner.nextLine();
        PropietarioDto propietario = propietarioService.buscarPorDocumentoIdentidad(documentoIdentidad);
        if (propietario != null) {
            System.out.println("Propietario encontrado: " + propietario);
        } else {
            System.out.println("Propietario no encontrado.");
        }
    }

    private void listarTodosLosPropietarios(PropietarioService propietarioService) {
        List<PropietarioDto> propietarios = propietarioService.obtenerTodos();
        propietarios.forEach(System.out::println);
    }

}
