package sub.fase2.cleanarchitecture.carsales.infrastructure.gateways;

import sub.fase2.cleanarchitecture.carsales.application.gateways.SellCarGateway;
import sub.fase2.cleanarchitecture.carsales.domain.entity.Sell;
import sub.fase2.cleanarchitecture.carsales.infrastructure.persistence.SellCarRepository;
import sub.fase2.cleanarchitecture.carsales.infrastructure.persistence.SellEntity;

public class SellRepositoryGateway implements SellCarGateway {
private final SellCarRepository sellCarRepository;
private final SellEntityMapper sellEntityMapper;

public SellRepositoryGateway(SellCarRepository sellCarRepository, SellEntityMapper sellEntityMapper){
    this.sellCarRepository = sellCarRepository;
    this.sellEntityMapper = sellEntityMapper;
}
    @Override
    public Sell sellCar (Sell sellDomainObj) {
        SellEntity sellEntity = sellEntityMapper.toEntity(sellDomainObj);
        SellEntity savedObj = sellCarRepository.save(sellEntity);
        return sellEntityMapper.toDomainObj(savedObj);
    }
}
