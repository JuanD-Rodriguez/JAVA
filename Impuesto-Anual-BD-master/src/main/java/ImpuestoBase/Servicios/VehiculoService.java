package ImpuestoBase.Servicios;

import ImpuestoBase.Entidades.Vehiculo;
import ImpuestoBase.Repositorios.VehiculoRepositorio;
import ImpuestoBase.dto.VehiculoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepositorio vehiculoRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    public void registrarVehiculo(VehiculoDto vehiculoDto) {
        Vehiculo vehiculo = modelMapper.map(vehiculoDto, Vehiculo.class);
        vehiculoRepositorio.save(vehiculo);
    }

    public List<VehiculoDto> obtenerTodos() {
        List<Vehiculo> vehiculos = vehiculoRepositorio.findAll();
        return vehiculos.stream()
                .map(vehiculo -> modelMapper.map(vehiculo, VehiculoDto.class))
                .collect(Collectors.toList());
    }

    public VehiculoDto buscarVehiculoPorPlaca(String placa) {
        Optional<Vehiculo> vehiculo = vehiculoRepositorio.findById(placa);
        return vehiculo.map(value -> modelMapper.map(value, VehiculoDto.class)).orElse(null);
    }

    public void eliminarVehiculo(String placa) {
        vehiculoRepositorio.deleteById(placa);
    }

    public VehiculoDto modificarVehiculo(VehiculoDto vehiculoDto) {
        Vehiculo vehiculoExistente = vehiculoRepositorio.findById(vehiculoDto.getPlaca())
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado con la placa: " + vehiculoDto.getPlaca()));
        modelMapper.map(vehiculoDto, vehiculoExistente);
        Vehiculo vehiculoActualizado = vehiculoRepositorio.save(vehiculoExistente);
        return modelMapper.map(vehiculoActualizado, VehiculoDto.class);
    }

    // Métodos adicionales según sea necesario
}
