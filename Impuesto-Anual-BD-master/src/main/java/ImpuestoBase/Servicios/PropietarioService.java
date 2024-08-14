package ImpuestoBase.Servicios;

import ImpuestoBase.Entidades.Propietario;
import ImpuestoBase.Repositorios.PropietarioRepositorio;
import ImpuestoBase.dto.PropietarioDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropietarioService {

    @Autowired
    private PropietarioRepositorio propietarioRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    public void registrarPropietario(PropietarioDto propietarioDto) {
        Propietario propietario = modelMapper.map(propietarioDto, Propietario.class);
        propietarioRepositorio.save(propietario);
    }

    public List<PropietarioDto> obtenerTodos() {
        List<Propietario> propietarios = propietarioRepositorio.findAll();
        return propietarios.stream()
                .map(propietario -> modelMapper.map(propietario, PropietarioDto.class))
                .collect(Collectors.toList());
    }

    public PropietarioDto buscarPorDocumentoIdentidad(String documentoIdentidad) {
        Optional<Propietario> propietario = propietarioRepositorio.findById(documentoIdentidad);
        return propietario.map(value -> modelMapper.map(value, PropietarioDto.class)).orElse(null);
    }

    public void eliminarPropietario(String documentoIdentidad) {
        propietarioRepositorio.deleteById(documentoIdentidad);
    }

    public PropietarioDto modificarPropietario(PropietarioDto propietarioDto) {
        Propietario propietarioExistente = propietarioRepositorio.findById(propietarioDto.getDocumentoIdentidad())
                .orElseThrow(() -> new RuntimeException("Propietario no encontrado con el documento: " + propietarioDto.getDocumentoIdentidad()));
        modelMapper.map(propietarioDto, propietarioExistente);
        Propietario propietarioActualizado = propietarioRepositorio.save(propietarioExistente);
        return modelMapper.map(propietarioActualizado, PropietarioDto.class);
    }
}
