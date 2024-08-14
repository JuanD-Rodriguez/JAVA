package co.vinni.soapproyectobase.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class EquipoDto implements Serializable{
    private long serial;
    //@NotBlank(message = "El nombre es obligatorio")
    //private String nombre;
   // @NotBlank(message = "La descripción es obligatoria")
    //private String descripcion;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombreTecnico;

    @NotBlank(message = "El nombre del equipo es obligatorio")
    private String EquipoaCargo;

    @NotBlank(message = "Años de experiencia es obligatorio")
    private int AñosExp;
}
