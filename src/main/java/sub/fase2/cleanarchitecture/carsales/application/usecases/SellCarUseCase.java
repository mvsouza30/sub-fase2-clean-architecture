package sub.fase2.cleanarchitecture.carsales.application.usecases;

import sub.fase2.cleanarchitecture.carsales.application.contracts.SellCollection;
import sub.fase2.cleanarchitecture.carsales.application.gateways.SellCarGateway;
import sub.fase2.cleanarchitecture.carsales.domain.entity.Sell;
import sub.fase2.cleanarchitecture.carsales.infrastructure.persistence.CarRepository;
import sub.fase2.cleanarchitecture.carsales.infrastructure.persistence.SellCarRepository;

import java.util.List;
import java.util.stream.Collectors;

public class SellCarUseCase {
    private SellCarGateway sellCarGateway;
    private final CarRepository carRepository;
    private final SellCarRepository sellCarRepository;

    public SellCarUseCase (SellCarGateway sellCarGateway, CarRepository carRepository,
                           SellCarRepository sellCarRepository){
        this.sellCarGateway = sellCarGateway;
        this.carRepository = carRepository;
        this.sellCarRepository = sellCarRepository;
    }

    public Sell createSell(Sell sell){
        Sell savedSell = sellCarGateway.sellCar(sell);
        carRepository.deleteByPriceAndDescription(sell.preco(), sell.descricao());
        return savedSell;
    }

    public SellCollection getAllSoldCarsOrderedByPrice() {
        List<Sell> soldCars = sellCarRepository.findAllOrderByPriceAsc().stream()
                .map(sell -> new Sell(sell.getCpf(), sell.getData(), sell.getMarca(), sell.getModelo(),
                        sell.getCor(), sell.getAno(), sell.getPreco(), sell.getDescricao()))
                .collect(Collectors.toList());
        return new SellCollection(soldCars);
    }
}
