package sub.fase2.cleanarchitecture.carsales.infrastructure.controllers;

public class SellCarResponse {
    private String message;

    public SellCarResponse() {
    }

    public SellCarResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
