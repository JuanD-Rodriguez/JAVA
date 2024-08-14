package ImpuestoBase.Entidades;
import jakarta.persistence.Column;
import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "Vehiculo")
@Table(name = "VEHICULO")

public class Vehiculo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "VEHI_PLACA", nullable = false)
    private String placa;
    @Column(name = "VEHI_MARCA", nullable = false)
    private String marca;
    @Column(name = "VEHI_COLOR", nullable = false)
    private String color;
    @Column(name = "VEHI_AÑOREGISTRO", nullable = false)
    private int añoRegistro;
    @Column(name = "VEHI_MUNICIPIOCIUDAD", nullable = false)
    private String municipioCiudad;
    @Column(name = "VEHI_TIPOVEHICULO", nullable = false)
    private String tipoVehiculo;
    @Column(name = "VEHI_CILINDRAJE", nullable = false)
    private int cilindraje;
    @Column(name = "VEHI_VALOR", nullable = false)
    private double valor;
    @Column(name = "VEHI_DOCIDENTIDAD", nullable = false)
    private String documentoIdentidadPropietario; // Nuevo atributo para almacenar el documento de identidad del propietario asociado

}