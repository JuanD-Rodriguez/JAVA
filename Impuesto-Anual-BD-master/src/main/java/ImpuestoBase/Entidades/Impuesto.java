//package ImpuestoBase.Entidades;
//import jakarta.persistence.Column;
//import java.io.Serializable;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//
//@Entity(name = "Impuesto")
//@Table(name = "IMPUESTO")
//public class Impuesto implements Serializable {
//
//
//    @Column(name = "IMPU_DOCPROPIETARIO", nullable = false)
//    private String documentoPropietario;
//    @Column(name = "IMPU_PLACAVEHICULO", nullable = false)
//    private String placaVehiculo;
//    @Column(name = "IMPU_AÑO", nullable = false)
//    private int año;
//    @Column(name = "IMPU_PAGADO", nullable = false)
//    private boolean pagado;
//    @Column(name = "IMPU_MONTO", nullable = false)
//    private double monto;
//
//}