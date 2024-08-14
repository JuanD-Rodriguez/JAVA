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
public class ImpuestoDto implements Serializable{
    private String documentoPropietario;
    private String placaVehiculo;
    private int año;
    private boolean pagado;
    private double monto;

}
