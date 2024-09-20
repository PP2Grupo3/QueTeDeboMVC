package ar.com.quetedebo.core;

public interface Wallet {
    public Boolean transfer(String destinationAddress);
    public String getAddress();
}
