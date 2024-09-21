package ar.com.quetedebo.core;

public class Debt {
    private String address;
    private Float amount;
    private String name;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getName() {
        return this.name;
    }

    public Float getAmount() {
        return this.amount;
    }
}
