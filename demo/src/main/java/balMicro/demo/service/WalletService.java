package balMicro.demo.service;

import balMicro.demo.entity.Wallet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WalletService {
    List<Wallet> getAll();

    Wallet addWallet(Wallet wallet);

    Wallet updateWallet(String id, Wallet wallet);
}
