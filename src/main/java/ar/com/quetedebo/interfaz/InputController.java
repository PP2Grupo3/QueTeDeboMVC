package ar.com.quetedebo.interfaz;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import ar.com.quetedebo.core.Core;
import ar.com.quetedebo.core.Debt;
import ar.com.quetedebo.core.Wallet;

public class InputController implements Observer {
    private Core core;
    private GastosView view;

    public InputController(final Core core, GastosView view) {
        this.core = core;
        this.view = view;
        this.core.addObserver(this);
    }
    public void pay (Wallet wallet, String destinationAddress, Float amount){
        core.pay(wallet, destinationAddress);
    }
    public void addWallet(Wallet wallet){
        core.addWallet(wallet);
    }
    public List<Debt> getDebts(){
        return core.getDebt();
    }
    public List <Wallet> getWallets(){
        return core.getWallets();
    }

    @Override
    public void update(Observable o, Object arg) {
       System.out.println(arg);
    }
}