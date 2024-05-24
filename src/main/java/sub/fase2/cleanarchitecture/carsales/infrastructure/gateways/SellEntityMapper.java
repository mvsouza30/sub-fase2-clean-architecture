package sub.fase2.cleanarchitecture.carsales.infrastructure.gateways;

import sub.fase2.cleanarchitecture.carsales.domain.entity.Sell;
import sub.fase2.cleanarchitecture.carsales.infrastructure.persistence.SellEntity;

public class SellEntityMapper {
    SellEntity toEntity(Sell sellDomainObj){
        return new SellEntity(sellDomainObj.cpf(), sellDomainObj.data(), sellDomainObj.marca(), sellDomainObj.modelo(),
                sellDomainObj.cor(), sellDomainObj.ano(), sellDomainObj.preco(), sellDomainObj.descricao(), sellDomainObj.cod_vendas(), sellDomainObj.status());
    }

    Sell toDomainObj(SellEntity sellEntity){
        return new Sell(sellEntity.getCpf(), sellEntity.getData(), sellEntity.getMarca(), sellEntity.getModelo(),
                sellEntity.getCor(), sellEntity.getAno(), sellEntity.getPreco(), sellEntity.getDescricao(), sellEntity.getCod_vendas(), sellEntity.getStatus());
    }
}
