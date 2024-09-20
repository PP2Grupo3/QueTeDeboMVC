package ar.com.quetedebo.core;

import java.util.List;

public interface DatabaseRepository {
    List<Wallet> findAllWallets();
    List<Debt> findAllDebts();
}
