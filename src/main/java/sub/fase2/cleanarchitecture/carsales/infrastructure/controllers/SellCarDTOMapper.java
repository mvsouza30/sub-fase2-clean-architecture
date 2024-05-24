package sub.fase2.cleanarchitecture.carsales.infrastructure.controllers;

import sub.fase2.cleanarchitecture.carsales.domain.entity.Sell;

public class SellCarDTOMapper {
    CreateSellCarResponse toResponse(Sell sell){
        return new CreateSellCarResponse(sell.cpf(), sell.data(), sell.marca(), sell.modelo(), sell.cor(), sell.ano(), sell.preco(), sell.descricao(), sell.cod_vendas(), sell.status());
    }

    public Sell toSell(CreateSellCarRequest request){
        return new Sell(request.cpf(), request.data(), request.marca(), request.modelo(), request.cor(), request.ano(), request.preco(), request.descricao(), request.cod_vendas(), request.status());
    }
}
