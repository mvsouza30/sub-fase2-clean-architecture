package sub.fase2.cleanarchitecture.carsales.infrastructure.controllers;

import sub.fase2.cleanarchitecture.carsales.domain.entity.Car;


public class CarDTOMapper {
    CreateCarResponse toResponse(Car car) {
        return new CreateCarResponse(car.marca(), car.modelo(), car.cor(), car.ano(), car.preco(), car.descricao());
    }

    public Car toCar(CreateCarRequest request) {
        return new Car(request.marca(), request.modelo(), request.cor(), request.ano(), request.preco(), request.descricao());
    }
}
