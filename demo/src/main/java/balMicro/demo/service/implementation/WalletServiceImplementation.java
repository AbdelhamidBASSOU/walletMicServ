package balMicro.demo.service.implementation;

import balMicro.demo.entity.Currency;
import balMicro.demo.entity.Wallet;
import balMicro.demo.repository.WalletRepository;
import balMicro.demo.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletServiceImplementation implements WalletService {

    private final WalletRepository walletRepository;

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
        wallet.setCurrency(Currency.USD);
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet getOne(String walletId){
        return walletRepository.findById(walletId).orElseThrow(() -> new IllegalArgumentException("Invalid wallet ID"));
    }

    @Override
    public double checkBalance(String walletId) {
        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid wallet ID"));
        return wallet.getBalance();
    }

    @Override
    public double creditAmount(String walletId, double amount) {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow(() -> new IllegalArgumentException("Invalid wallet ID"));
        double newBalance = wallet.getBalance() + amount;
        wallet.setBalance(newBalance);
        walletRepository.save(wallet);
        return newBalance;
    }

    @Override
    public double debitAmount(String walletId, double amount) {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow(() -> new IllegalArgumentException("Invalid wallet ID"));
        double currentBalance = wallet.getBalance();
        if (currentBalance >= amount) {
            double newBalance = currentBalance - amount;
            wallet.setBalance(newBalance);
            walletRepository.save(wallet);
            return newBalance;
        } else {
            throw new IllegalStateException("Insufficient balance in wallet with id : " + walletId);
        }
    }
}
