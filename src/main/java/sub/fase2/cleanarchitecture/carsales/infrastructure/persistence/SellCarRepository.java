package sub.fase2.cleanarchitecture.carsales.infrastructure.persistence;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SellCarRepository extends CrudRepository<SellEntity, Long> {

    @Query("SELECT * FROM pre_sales c ORDER BY c.preco ASC")
    List<SellEntity> findAllOrderByPriceAsc();


    @Query("SELECT * FROM pre_sales WHERE cod_vendas = :cod_vendas")
    SellEntity findByCodVendas(String cod_vendas);
}
