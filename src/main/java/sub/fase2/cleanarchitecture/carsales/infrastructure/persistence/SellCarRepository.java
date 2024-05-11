package sub.fase2.cleanarchitecture.carsales.infrastructure.persistence;

import org.springframework.data.repository.CrudRepository;

public interface SellCarRepository extends CrudRepository<SellEntity, Long> {
}
