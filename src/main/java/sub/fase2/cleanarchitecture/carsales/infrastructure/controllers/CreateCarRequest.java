package sub.fase2.cleanarchitecture.carsales.infrastructure.controllers;

public record CreateCarRequest (String marca, String modelo, String cor, int ano, double preco, String descricao){
}
