package will.designpatterns.repository;

import will.designpatterns.model.Automovel;
import org.springframework.data.repository.CrudRepository;

public interface AutomovelRepository extends CrudRepository<Automovel, Long> {
}
