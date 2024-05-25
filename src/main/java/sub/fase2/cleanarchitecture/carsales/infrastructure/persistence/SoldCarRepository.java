package sub.fase2.cleanarchitecture.carsales.infrastructure.persistence;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SoldCarRepository extends CrudRepository<SoldCarEntity, Long> {
    @Override
    Optional<SoldCarEntity> findById(Long id);

    @Query("SELECT * FROM sold_cars ORDER BY preco ASC")
    List<SoldCarEntity> findAll();

    @Query("SELECT * FROM sold_cars WHERE cod_vendas = :cod_vendas")
    SoldCarEntity findByCodVendas(String cod_vendas);

    @Query("SELECT * FROM sold_cars ORDER BY preco ASC")
    List<SoldCarEntity> findAllOrderByPriceAsc();

    @Override
    <S extends SoldCarEntity> S save(S entity);

    @Override
    void deleteById(Long id);

    @Override
    void deleteAll();
}
