package balMicro.demo.service.implementation;

import balMicro.demo.entity.Currency;
import balMicro.demo.entity.Wallet;
import balMicro.demo.repository.WalletRepository;
import balMicro.demo.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImplementation implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public List<Wallet> getAll() {
        return walletRepository.findAll();
    }

    public Wallet updateWallet(String id, Wallet wallet) {
        Wallet walletWithId= walletRepository.findById(id).orElse(null);
        if(walletWithId != null ){
            walletWithId.setBalance(wallet.getBalance());
            walletWithId.setCurrency(Currency.USD);
            walletWithId.setOwnerId(wallet.getOwnerId());
            walletWithId.setTransactionHistory(wallet.getTransactionHistory());
            return walletWithId;
        }else{
            throw new IllegalStateException("wallet cannot be found");
        }
    }

    public Wallet addWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }



}
