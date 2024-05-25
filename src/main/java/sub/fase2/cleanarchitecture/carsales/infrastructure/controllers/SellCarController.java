package sub.fase2.cleanarchitecture.carsales.infrastructure.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sub.fase2.cleanarchitecture.carsales.application.contracts.SellCollection;
import sub.fase2.cleanarchitecture.carsales.application.usecases.PaymentProcessingService;
import sub.fase2.cleanarchitecture.carsales.application.usecases.SellCarUseCase;
import sub.fase2.cleanarchitecture.carsales.domain.entity.Sell;
import sub.fase2.cleanarchitecture.carsales.infrastructure.persistence.SoldCarEntity;
import sub.fase2.cleanarchitecture.carsales.infrastructure.persistence.SoldCarRepository;

import java.util.List;


@RestController
@RequestMapping("sells")
public class SellCarController {
    private SellCarUseCase sellCarUseCase;
    private final SellCarDTOMapper sellCarDTOMapper;
    private final PaymentProcessingService paymentProcessingService;
    private SoldCarRepository soldCarRepository;

    public SellCarController(SellCarUseCase sellCarUseCase, SellCarDTOMapper sellCarDTOMapper, PaymentProcessingService paymentProcessingService, SoldCarRepository soldCarRepository){
        this.sellCarUseCase = sellCarUseCase;
        this.sellCarDTOMapper = sellCarDTOMapper;
        this.paymentProcessingService = paymentProcessingService;
        this.soldCarRepository = soldCarRepository;
    }

    @Operation(summary = "Sistema de Pré-vendas", description = "Vamos enviar os dados para análise da financeira.")
    @PostMapping("/Fichas")
    CreateSellCarResponse sellCar(@RequestBody CreateSellCarRequest request){
        Sell sellBusinessObj = sellCarDTOMapper.toSell(request);
        Sell sell = sellCarUseCase.createSell(sellBusinessObj);
        return sellCarDTOMapper.toResponse(sell);
    }

    @Operation(summary = "Listar carros vendidos", description = "Este endpoint permite listar todos os carros vendidos, ordenados por preço.")
    @GetMapping("/Vendas")
    public SellCollection getAllSoldCars() {
        return sellCarUseCase.getAllSoldCarsOrderedByPrice();
    }

    @Operation(summary = "Processa Pagamento", description = "Financeira recebe a proposta de compra/venda de veículos e confirma pagamento")
    @PostMapping("/Processa-Pagamentos")
    public ResponseEntity<String> processPayment(@RequestParam String codVendas) {
        String result = paymentProcessingService.processPayment(codVendas);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Aprovações.", description = "Histórico de vendas realizadas com sucesso.")
    @GetMapping("/Todas as vendas")
    public List<SoldCarEntity> getAllSoldCarsOrderedByPrice() {
        return soldCarRepository.findAll();
    }
}
