package sub.fase2.cleanarchitecture.carsales.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sub.fase2.cleanarchitecture.carsales.application.gateways.SellCarGateway;
import sub.fase2.cleanarchitecture.carsales.application.usecases.PaymentProcessingService;
import sub.fase2.cleanarchitecture.carsales.application.usecases.SellCarUseCase;
import sub.fase2.cleanarchitecture.carsales.infrastructure.controllers.SellCarDTOMapper;
import sub.fase2.cleanarchitecture.carsales.infrastructure.gateways.SellEntityMapper;
import sub.fase2.cleanarchitecture.carsales.infrastructure.gateways.SellRepositoryGateway;
import sub.fase2.cleanarchitecture.carsales.infrastructure.persistence.CarRepository;
import sub.fase2.cleanarchitecture.carsales.infrastructure.persistence.SellCarRepository;
import sub.fase2.cleanarchitecture.carsales.infrastructure.persistence.SoldCarRepository;

@Configuration
public class SellCarConfig {

    @Bean
    SellCarUseCase sellCarUseCase(SellCarGateway sellCarGateway, CarRepository carRepository, SellCarRepository sellCarRepository){
        return new SellCarUseCase(sellCarGateway, carRepository, sellCarRepository);
    }

    @Bean
    SellCarGateway sellCarGateway(SellCarRepository sellCarRepository, SellEntityMapper sellEntityMapper){
        return new SellRepositoryGateway(sellCarRepository, sellEntityMapper);
    }

    @Bean
    SellEntityMapper sellEntityMapper() {
        return new SellEntityMapper();
    }

    @Bean
    SellCarDTOMapper sellCarDTOMapper(){
        return new SellCarDTOMapper();
    }

    @Bean
    PaymentProcessingService paymentProcessingService(SellCarRepository sellCarRepository, SoldCarRepository soldCarRepository, CarRepository carRepository)
    { return new PaymentProcessingService (sellCarRepository, soldCarRepository, carRepository);}

}
