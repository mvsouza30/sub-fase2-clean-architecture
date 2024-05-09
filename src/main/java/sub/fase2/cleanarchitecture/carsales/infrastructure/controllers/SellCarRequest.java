package sub.fase2.cleanarchitecture.carsales.infrastructure.controllers;

public class SellCarRequest {
    private String cpf;
    private Long carId;
    private String paymentMethod;
    private int numberOfInstallments;
    private double entry;
    private double remainingAmount;

    public SellCarRequest() {
    }

    public SellCarRequest(String cpf, Long carId, String paymentMethod, int numberOfInstallments, double entry, double remainingAmount) {
        this.cpf = cpf;
        this.carId = carId;
        this.paymentMethod = paymentMethod;
        this.numberOfInstallments = numberOfInstallments;
        this.entry = entry;
        this.remainingAmount = remainingAmount;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(int numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

    public double getEntry(){
        return entry;
    }

    public void setEntry(double entry){
        this.entry = entry;
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(){
        this.remainingAmount = remainingAmount;
    }

}
