package sub.fase2.cleanarchitecture.carsales.application.usecases;

import sub.fase2.cleanarchitecture.carsales.application.gateways.SellCarGateway;
import sub.fase2.cleanarchitecture.carsales.domain.entity.Sell;
import sub.fase2.cleanarchitecture.carsales.infrastructure.persistence.CarRepository;

public class SellCarUseCase {
    private SellCarGateway sellCarGateway;
    private final CarRepository carRepository;

    public SellCarUseCase (SellCarGateway sellCarGateway, CarRepository carRepository){
        this.sellCarGateway = sellCarGateway;
        this.carRepository = carRepository;
    }

    public Sell createSell(Sell sell){
        //ESSE É O CÓDIGO BOM return sellCarGateway.sellCar(sell);
        Sell savedSell = sellCarGateway.sellCar(sell);
        carRepository.deleteByPriceAndDescription(sell.preco(), sell.descricao());
        return savedSell;
    }
}
