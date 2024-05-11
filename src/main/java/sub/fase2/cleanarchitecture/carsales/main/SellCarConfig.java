package sub.fase2.cleanarchitecture.carsales.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sub.fase2.cleanarchitecture.carsales.application.gateways.SellCarGateway;
import sub.fase2.cleanarchitecture.carsales.application.usecases.SellCarUseCase;
import sub.fase2.cleanarchitecture.carsales.infrastructure.controllers.SellCarDTOMapper;
import sub.fase2.cleanarchitecture.carsales.infrastructure.gateways.SellEntityMapper;
import sub.fase2.cleanarchitecture.carsales.infrastructure.gateways.SellRepositoryGateway;
import sub.fase2.cleanarchitecture.carsales.infrastructure.persistence.CarRepository;
import sub.fase2.cleanarchitecture.carsales.infrastructure.persistence.SellCarRepository;

@Configuration
public class SellCarConfig {

    @Bean
    SellCarUseCase sellCarUseCase(SellCarGateway sellCarGateway, CarRepository carRepository){
        return new SellCarUseCase(sellCarGateway, carRepository);
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
}
