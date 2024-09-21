package ar.com.quetedebo.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Core extends Observable {

    private List <Wallet> wallets;
    private List <Debt> debts;

    public Core() {
        this.debts = new ArrayList<>();
        Debt debt1 = new Debt();
        debt1.setName("Tobias");
        debt1.setAmount(1000f);
        debt1.setAddress("0000043543500385345332");

        Debt debt2 = new Debt();
        debt2.setName("Maximo");
        debt2.setAmount(2500f);
        debt2.setAddress("000004354356645345332");

        Debt debt3 = new Debt();
        debt3.setName("Manuel");
        debt3.setAmount(3000f);
        debt3.setAddress("0000043843500345345332");

        Debt debt4 = new Debt();
        debt4.setName("Giselle");
        debt4.setAmount(8500f);
        debt4.setAddress("0000046543500345345332");

        debts.add(debt1);
        debts.add(debt2);
        debts.add(debt3);
        debts.add(debt4);
    }

    public void pay (Wallet wallet, String destinationAddress){
        if (wallet.transfer(destinationAddress) && debts.size() > 0) {
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