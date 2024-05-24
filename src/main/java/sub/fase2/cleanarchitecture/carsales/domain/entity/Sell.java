package sub.fase2.cleanarchitecture.carsales.domain.entity;

public record Sell(String cpf, String data, String marca, String modelo, String cor, int ano, double preco, String descricao, String cod_vendas, String status) {}
