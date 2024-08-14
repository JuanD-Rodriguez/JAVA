package ImpuestoBase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PropietarioDto implements Serializable {
    private String nombre;
    private String apellidos;
    private String tipoDocumento;
    private String documentoIdentidad;
    private String correo;
    private String direccionResidencia;
    private String placaVehiculo;
}
