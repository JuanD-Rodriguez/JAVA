package co.vinni.soapproyectobase.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Presidente")
@Table(name = "PRESIDENTES")
public class Presidente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRESIDENTES")
    @SequenceGenerator(name = "SEQ_PRESIDENTES", sequenceName = "SEQ_PRESIDENTES", allocationSize = 1)
    @Column(name = "PRE_CODIGO", nullable = false)
    private long codigo;

    @Column(name = "PRE_NOMBRE", nullable = false)
    private String nombre;


    @OneToOne(mappedBy = "presidente")
    private Equipo equipo;
}
