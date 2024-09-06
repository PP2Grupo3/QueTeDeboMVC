package org.example.core;
import java.util.Observable;

public class Core extends Observable {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
        setChanged();
        notifyObservers(data);
    }
}