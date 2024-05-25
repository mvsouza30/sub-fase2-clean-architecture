package sub.fase2.cleanarchitecture.carsales.infrastructure.gateways;

import sub.fase2.cleanarchitecture.carsales.application.contracts.CarCollection;
import sub.fase2.cleanarchitecture.carsales.domain.entity.Car;
import sub.fase2.cleanarchitecture.carsales.infrastructure.persistence.CarEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CarEntityMapper {
    CarEntity toEntity(Car carDomainObj) {
        return new CarEntity(carDomainObj.marca(), carDomainObj.modelo(), carDomainObj.cor(), carDomainObj.ano(), carDomainObj.preco(), carDomainObj.descricao());
    }

    Car toDomainObj(CarEntity carEntity) {
        return new Car(carEntity.getMarca(), carEntity.getModelo(), carEntity.getCor(), carEntity.getAno(), carEntity.getPreco(), carEntity.getDescricao());
    }

    public CarCollection toCarCollection(List<CarEntity> carEntities) {
        List<Car> cars = carEntities.stream()
                .map(this::toDomainObj)
                .collect(Collectors.toList());
        return new CarCollection(cars);
    }
}
