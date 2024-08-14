package co.vinni.soapproyectobase.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Jugador")
@Table(name = "JUGADORES")
public class Jugadores implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_JUGADORES")
    @SequenceGenerator(name = "SEQ_JUGADORES", sequenceName = "SEQ_JUGADORES", allocationSize = 1)
    @Column(name = "JUG_CODIGO", nullable = false)
    private long serial;

    @Column(name = "JUG_NOMBRE", nullable = false)
    private String nombre;

    

}
