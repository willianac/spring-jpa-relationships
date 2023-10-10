package will.designpatterns.repository;

import org.springframework.data.repository.CrudRepository;
import will.designpatterns.model.Fabricante;

public interface FabricanteRepository extends CrudRepository<Fabricante, Long> {
}
