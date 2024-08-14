package ImpuestoBase.Repositorios;
import ImpuestoBase.Entidades.Vehiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VehiculoRepositorio extends JpaRepository<Vehiculo, String>, JpaSpecificationExecutor<Vehiculo> {

}
