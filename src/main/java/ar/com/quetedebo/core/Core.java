package ar.com.quetedebo.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Core extends Observable {

    private List <Wallet> wallets;
    private List <Debt> debts;

    public void pay (Wallet wallet, String destinationAddress){
        if (wallet.transfer(destinationAddress)) {
            debts.stream()
                    .filter(debt -> debt.getAddress().equals(destinationAddress))
                    .findFirst()
                    .ifPresent(debt -> debts.remove(debt));
            setChanged();
            notifyObservers("pay");
        }
    }
    public void addWallet(Wallet wallet){
        if (wallets.stream().noneMatch(wallet1 -> wallet1.getAddress().equals(wallet.getAddress()))) {
            wallets.add(wallet);
        }
        setChanged();
        notifyObservers("addWallet");
    }
    public List<Debt> getDebt(){
        return new ArrayList<Debt>(debts);
    }
    public List <Wallet> getWallets(){
        return new ArrayList<Wallet>(wallets);
    }
}