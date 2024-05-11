package sub.fase2.cleanarchitecture.carsales.infrastructure.controllers;

public record CreateSellCarRequest(String cpf, String data, String marca, String modelo, String cor, int ano, double preco, String descricao) {
}
