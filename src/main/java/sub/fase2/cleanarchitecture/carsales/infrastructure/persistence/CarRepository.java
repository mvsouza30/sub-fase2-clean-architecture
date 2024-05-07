package sub.fase2.cleanarchitecture.carsales.infrastructure.persistence;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<CarEntity, Long> {

}
