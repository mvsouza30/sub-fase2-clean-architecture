package sub.fase2.cleanarchitecture.carsales.infrastructure.gateways;

import sub.fase2.cleanarchitecture.carsales.domain.entity.Car;
import sub.fase2.cleanarchitecture.carsales.infrastructure.persistence.CarEntity;

public class CarEntityMapper {
    CarEntity toEntity(Car carDomainObj) {
        return new CarEntity(carDomainObj.marca(), carDomainObj.modelo(), carDomainObj.cor(), carDomainObj.ano(), carDomainObj.preco());
    }

    Car toDomainObj(CarEntity carEntity) {
        return new Car(carEntity.getMarca(), carEntity.getModelo(), carEntity.getCor(), carEntity.getAno(), carEntity.getPreco());
    }
}
