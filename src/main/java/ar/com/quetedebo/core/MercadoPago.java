package ar.com.quetedebo.core;

public class MercadoPago implements Wallet{
    private String address;
    @Override
    public Boolean transfer(String destinationAddress) {
        return true;
    }

    @Override
    public String getAddress() {
        return this.address;
    }
}
