package sub.fase2.cleanarchitecture.carsales.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sub.fase2.cleanarchitecture.carsales.application.gateways.CarGateway;
import sub.fase2.cleanarchitecture.carsales.application.usecases.CreateCarUseCase;
import sub.fase2.cleanarchitecture.carsales.application.usecases.EditCarUseCase;
import sub.fase2.cleanarchitecture.carsales.application.usecases.ListCarsUseCaseImpl;
import sub.fase2.cleanarchitecture.carsales.infrastructure.controllers.CarDTOMapper;
import sub.fase2.cleanarchitecture.carsales.infrastructure.gateways.CarEntityMapper;
import sub.fase2.cleanarchitecture.carsales.infrastructure.gateways.CarRepositoryGateway;
import sub.fase2.cleanarchitecture.carsales.infrastructure.persistence.CarRepository;

@Configuration
public class CarConfig {

    @Bean
    CreateCarUseCase createCarUseCase(CarGateway carGateway) {
        return new CreateCarUseCase(carGateway);
    }

    @Bean
    CarGateway carGateway(CarRepository carRepository, CarEntityMapper carEntityMapper) {
        return new CarRepositoryGateway(carRepository, carEntityMapper);
    }

    @Bean
    CarEntityMapper carEntityMapper() {
        return new CarEntityMapper();
    }

    @Bean
    CarDTOMapper carDTOMapper() {
        return new CarDTOMapper();
    }

    @Bean
    EditCarUseCase editCarUseCase (CarGateway carGateway){ return new EditCarUseCase(carGateway); }

    @Bean
    public ListCarsUseCaseImpl listCarsUseCaseImpl (CarGateway carGateway) {
        return new ListCarsUseCaseImpl(carGateway);
    }
}
