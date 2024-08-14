package ImpuestoBase.Repositorios;
import ImpuestoBase.Entidades.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PropietarioRepositorio extends JpaRepository<Propietario, String>, JpaSpecificationExecutor<Propietario> {

}
