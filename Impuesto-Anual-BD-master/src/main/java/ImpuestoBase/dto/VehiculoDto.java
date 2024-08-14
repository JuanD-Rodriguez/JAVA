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
public class VehiculoDto implements Serializable {
    private Long id;
    private String placa;
    private String marca;
    private String color;
    private int añoRegistro;
    private String municipioCiudad;
    private String tipoVehiculo;
    private int cilindraje;
    private double valor;
    private String documentoIdentidadPropietario;
}
