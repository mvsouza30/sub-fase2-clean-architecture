package sub.fase2.cleanarchitecture.carsales.infrastructure.controllers;

public record SaleRequest(String cpf, Long carId, String paymentMethod, int numberOfInstallments) {
}
