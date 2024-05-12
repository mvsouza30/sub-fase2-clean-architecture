package sub.fase2.cleanarchitecture.carsales.infrastructure.persistence;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SellCarRepository extends CrudRepository<SellEntity, Long> {

    @Query("SELECT * FROM carsales c ORDER BY c.preco ASC")
    List<SellEntity> findAllOrderByPriceAsc();
}