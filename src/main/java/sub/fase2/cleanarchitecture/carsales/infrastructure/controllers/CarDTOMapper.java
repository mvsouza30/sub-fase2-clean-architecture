package sub.fase2.cleanarchitecture.carsales.infrastructure.controllers;

import sub.fase2.cleanarchitecture.carsales.domain.entity.Car;
import sub.fase2.cleanarchitecture.carsales.domain.entity.Sale;

import java.time.LocalDateTime;

public class CarDTOMapper {
    CreateCarResponse toResponse(Car car) {
        return new CreateCarResponse(car.marca(), car.modelo(), car.cor(), car.ano(), car.preco(), car.descricao());
    }

    public Car toCar(CreateCarRequest request) {
        return new Car(request.marca(), request.modelo(), request.cor(), request.ano(), request.preco(), request.descricao());
    }

    public Sale toSale(SellCarRequest request) {
        // Gerar a data da venda automaticamente
        LocalDateTime saleDate = LocalDateTime.now();
        return new Sale(request.getCpf(), request.getCarId(), saleDate.toString(), request.getPaymentMethod(),
                request.getEntry(), request.getRemainingAmount(), request.getNumberOfInstallments());
    }

    public SellCarResponse toSellResponse(Sale sale) {
        String message = sale != null ? "Venda efetuada com sucesso" : "Falha ao efetuar a venda";
        return new SellCarResponse(message);
    }


}
