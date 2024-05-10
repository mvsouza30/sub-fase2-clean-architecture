package sub.fase2.cleanarchitecture.carsales.infrastructure.gateways;

import sub.fase2.cleanarchitecture.carsales.application.gateways.CarGateway;
import sub.fase2.cleanarchitecture.carsales.domain.entity.Car;
import sub.fase2.cleanarchitecture.carsales.infrastructure.persistence.CarEntity;
import sub.fase2.cleanarchitecture.carsales.infrastructure.persistence.CarRepository;

import java.util.logging.Logger;

public class CarRepositoryGateway implements CarGateway {
    private final Logger logger = Logger.getLogger(CarRepositoryGateway.class.getName());
    private final CarRepository carRepository;
    private final CarEntityMapper carEntityMapper;


    public CarRepositoryGateway(CarRepository carRepository, CarEntityMapper carEntityMapper) {
        this.carRepository = carRepository;
        this.carEntityMapper = carEntityMapper;
    }

    public Car createCar(Car carDomainObj){
        CarEntity carEntity = carEntityMapper.toEntity(carDomainObj);
        CarEntity savedObj = carRepository.save(carEntity);
        logger.info("Carro criado com sucesso: " + carDomainObj);
        return carEntityMapper.toDomainObj(savedObj);
    }

    public Car getCarById(Long carId) {
        CarEntity carEntity = carRepository.findById(carId).orElse(null);
        return carEntity != null ? carEntityMapper.toDomainObj(carEntity) : null;
    }

    public Car editCar(Long carId, Car updatedCar) {

        CarEntity existingEntity = carRepository.findById(carId).orElse(null);
        if (existingEntity == null) {
            return null;
        }
        existingEntity.setMarca(updatedCar.marca());
        existingEntity.setModelo(updatedCar.modelo());
        existingEntity.setCor(updatedCar.cor());
        existingEntity.setAno(updatedCar.ano());
        existingEntity.setPreco(updatedCar.preco());
        existingEntity.setDescricao(updatedCar.descricao());

        CarEntity savedEntity = carRepository.save(existingEntity);

        logger.info("Editando carro com ID: " + carId + ", Novo carro: " + updatedCar);
        return carEntityMapper.toDomainObj(savedEntity);
    }
}
