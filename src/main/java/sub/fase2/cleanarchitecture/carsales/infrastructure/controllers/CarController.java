package sub.fase2.cleanarchitecture.carsales.infrastructure.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sub.fase2.cleanarchitecture.carsales.application.usecases.CreateCarUseCase;
import sub.fase2.cleanarchitecture.carsales.domain.entity.Car;

@RestController
@RequestMapping("cars")
public class CarController {
    private CreateCarUseCase createCarUseCase;
    private final CarDTOMapper carDTOMapper;

    public CarController(CreateCarUseCase createCarUseCase, CarDTOMapper carDTOMapper) {
        this.createCarUseCase = createCarUseCase;
        this.carDTOMapper = carDTOMapper;
    }

    @PostMapping
    CreateCarResponse create(@RequestBody CreateCarRequest request) {
        Car carBusinessObj = carDTOMapper.toCar(request);
        Car car = createCarUseCase.createCar(carBusinessObj);
        return carDTOMapper.toResponse(car);
    }
}
