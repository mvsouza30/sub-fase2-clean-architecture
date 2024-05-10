package sub.fase2.cleanarchitecture.carsales.infrastructure.controllers;

import org.springframework.web.bind.annotation.*;
import sub.fase2.cleanarchitecture.carsales.application.usecases.CreateCarUseCase;
import sub.fase2.cleanarchitecture.carsales.application.usecases.EditCarUseCase;
import sub.fase2.cleanarchitecture.carsales.domain.entity.Car;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("cars")
public class CarController {
    private CreateCarUseCase createCarUseCase;
    private final CarDTOMapper carDTOMapper;
    private EditCarUseCase editCarUseCase;

    public CarController(CreateCarUseCase createCarUseCase, CarDTOMapper carDTOMapper,
                         EditCarUseCase editCarUseCase) {
        this.createCarUseCase = createCarUseCase;
        this.carDTOMapper = carDTOMapper;
        this.editCarUseCase = editCarUseCase;
    }

    @Operation(summary = "Editar um carro", description = "Este endpoint permite editar um carro existente com base no ID.")
    @PutMapping("/{id}")
    CreateCarResponse edit(@PathVariable("id") Long carId, @RequestBody CreateCarRequest request) {
        Car updatedCar = carDTOMapper.toCar(request);
        Car car = editCarUseCase.editCar(carId, updatedCar);
        return carDTOMapper.toResponse(car);
    }
    @Operation(summary = "Criar um novo carro", description = "Este endpoint permite criar um novo registro de carro.")
    @PostMapping
    CreateCarResponse create(@RequestBody CreateCarRequest request) {
        Car carBusinessObj = carDTOMapper.toCar(request);
        Car car = createCarUseCase.createCar(carBusinessObj);
        return carDTOMapper.toResponse(car);
    }
}
