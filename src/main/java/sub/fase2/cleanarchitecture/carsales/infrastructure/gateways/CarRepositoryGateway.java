package sub.fase2.cleanarchitecture.carsales.infrastructure.gateways;

import sub.fase2.cleanarchitecture.carsales.application.gateways.CarGateway;
import sub.fase2.cleanarchitecture.carsales.domain.entity.Car;
import sub.fase2.cleanarchitecture.carsales.infrastructure.persistence.CarEntity;
import sub.fase2.cleanarchitecture.carsales.infrastructure.persistence.CarRepository;

public class CarRepositoryGateway implements CarGateway {
    private final CarRepository carRepository;
    private final CarEntityMapper carEntityMapper;

    public CarRepositoryGateway(CarRepository carRepository, CarEntityMapper carEntityMapper){
        this.carRepository = carRepository;
        this.carEntityMapper = carEntityMapper;
    }

    @Override
    public Car createCar(Car carDomainObj){
        CarEntity carEntity = carEntityMapper.toEntity(carDomainObj);
        CarEntity savedObj = carRepository.save(carEntity);
        return carEntityMapper.toDomainObj(savedObj);
    }
}
