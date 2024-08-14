package ImpuestoBase.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Propietario")
@Table(name = "PROPIETARIO")
public class Propietario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "PROPI_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "PROPI_APELLIDOS", nullable = false)
    private String apellidos;

    @Column(name = "PROPI_TIPODOCUMENTO", nullable = false)
    private String tipoDocumento;

    @Id // Asumiendo que el documento de identidad es único para cada propietario
    @Column(name = "PROPI_DOCIDENTIDAD", nullable = false)
    private String documentoIdentidad;

    @Column(name = "PROPI_CORREO", nullable = false)
    private String correo;

    @Column(name = "PROPI_DIRECCION", nullable = false)
    private String direccionResidencia;

    @Column(name = "PROPI_PLACAVEHI", nullable = false)
    private String placaVehiculo; }