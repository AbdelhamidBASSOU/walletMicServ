package balMicro.demo.resource;

import balMicro.demo.entity.Wallet;
import balMicro.demo.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WalletResource {
    private final WalletService walletService;

    @PostMapping("/add")
    public Wallet addWallet(@RequestBody Wallet wallet){
        return walletService.addWallet(wallet);
    }

    @PutMapping("/{wallet_id}")
    public Wallet updateWallet(@PathVariable String wallet_id, @RequestBody Wallet wallet){
        return walletService.updateWallet(wallet_id,wallet);}

    @GetMapping("/Wallets")
    public List<Wallet> getWallet(){
        return walletService.getAll();
    }
}
