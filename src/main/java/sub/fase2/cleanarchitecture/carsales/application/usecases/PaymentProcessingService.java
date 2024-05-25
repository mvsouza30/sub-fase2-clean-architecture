package sub.fase2.cleanarchitecture.carsales.application.usecases;

import org.springframework.stereotype.Service;
import sub.fase2.cleanarchitecture.carsales.infrastructure.persistence.*;

import java.util.Random;

@Service
public class PaymentProcessingService {

    private final SellCarRepository sellCarRepository;
    private final SoldCarRepository soldCarRepository;
    private final CarRepository carRepository;

    public PaymentProcessingService(SellCarRepository sellCarRepository, SoldCarRepository soldCarRepository, CarRepository carRepository) {
        this.sellCarRepository = sellCarRepository;
        this.soldCarRepository = soldCarRepository;
        this.carRepository = carRepository;
    }

    public String processPayment(String cod_vendas) {
        SellEntity sellEntity = sellCarRepository.findByCodVendas(cod_vendas);

        if (sellEntity == null) {
            return "Venda não encontrada para o código fornecido.";
        }

        boolean paymentApproved = new Random().nextBoolean();

        if (paymentApproved) {
            SoldCarEntity soldCarEntity = new SoldCarEntity(
                    null,
                    sellEntity.getCpf(),
                    sellEntity.getData(),
                    sellEntity.getMarca(),
                    sellEntity.getModelo(),
                    sellEntity.getCor(),
                    sellEntity.getAno(),
                    sellEntity.getPreco(),
                    sellEntity.getDescricao(),
                    sellEntity.getCod_vendas(),
                    sellEntity.getStatus()
            );
            soldCarRepository.save(soldCarEntity);
            sellCarRepository.delete(sellEntity);

            return "Pagamento aprovado. Venda concluída.";
        } else {
            CarEntity carEntity = new CarEntity(
                    sellEntity.getMarca(),
                    sellEntity.getModelo(),
                    sellEntity.getCor(),
                    sellEntity.getAno(),
                    sellEntity.getPreco(),
                    sellEntity.getDescricao()
            );
            carRepository.save(carEntity);
            sellCarRepository.delete(sellEntity);

            return "Pagamento não foi confirmado. A venda foi cancelada e o veículo está novamente disponível para venda.";
        }
    }
}
