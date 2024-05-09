package sub.fase2.cleanarchitecture.carsales.domain.entity;

public class Sale {
    private final String cpf;
    private final Long carId;
    private final String saleDate;
    private final String paymentMethod;
    private final double entry;
    private final double remainingAmount;
    private final int numberOfInstallments;

    public Sale(String cpf, Long carId, String saleDate, String paymentMethod, double entry, double remainingAmount, int numberOfInstallments) {
        this.cpf = cpf;
        this.carId = carId;
        this.saleDate = saleDate;
        this.paymentMethod = paymentMethod;
        this.entry = entry;
        this.remainingAmount = remainingAmount;
        this.numberOfInstallments = numberOfInstallments;
    }

    public String getCpf() {
        return cpf;
    }

    public Long getCarId() {
        return carId;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getEntry() {
        return entry;
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }

    public int getNumberOfInstallments() {
        return numberOfInstallments;
    }
}
