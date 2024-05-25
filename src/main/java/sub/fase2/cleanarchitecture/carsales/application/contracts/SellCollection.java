package sub.fase2.cleanarchitecture.carsales.application.contracts;

import sub.fase2.cleanarchitecture.carsales.domain.entity.Sell;

import java.util.List;

public class SellCollection {

    private final List<Sell> sells;

    public SellCollection(List<Sell> sells) {
        this.sells = sells;
    }

    public List<Sell> getSells() {
        return sells;
    }
}
