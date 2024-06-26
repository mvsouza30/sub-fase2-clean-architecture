package sub.fase2.cleanarchitecture.carsales.infrastructure.persistence;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends CrudRepository<CarEntity, Long> {

    @Modifying
    @Query("DELETE FROM cars WHERE preco = :preco AND descricao = :descricao")
    void deleteByPriceAndDescription(@Param("preco") double preco, @Param("descricao") String descricao);

    @Query("SELECT * FROM cars c ORDER BY c.preco ASC")
    List<CarEntity> findAllOrderByPriceAsc();
}
