package sub.fase2.cleanarchitecture.carsales.infrastructure.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sub.fase2.cleanarchitecture.carsales.application.usecases.SellCarUseCase;
import sub.fase2.cleanarchitecture.carsales.domain.entity.Sell;

@RestController
@RequestMapping("sells")
public class SellCarController {
    private SellCarUseCase sellCarUseCase;
    private final SellCarDTOMapper sellCarDTOMapper;

    public SellCarController(SellCarUseCase sellCarUseCase, SellCarDTOMapper sellCarDTOMapper){
        this.sellCarUseCase = sellCarUseCase;
        this.sellCarDTOMapper = sellCarDTOMapper;
    }

    @Operation(summary = "Vender um carro", description = "Este endpoint permite vender um carro.")
    @PostMapping
    CreateSellCarResponse sellCar(@RequestBody CreateSellCarRequest request){
        Sell sellBusinessObj = sellCarDTOMapper.toSell(request);
        Sell sell = sellCarUseCase.createSell(sellBusinessObj);
        return sellCarDTOMapper.toResponse(sell);
    }
}
