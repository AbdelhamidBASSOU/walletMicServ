package balMicro.demo.resource;

import balMicro.demo.entity.Wallet;
import balMicro.demo.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/Wallet/{walletId}")
    public Wallet getOne(@PathVariable String walletId){
        return walletService.getOne(walletId);
    }
    @GetMapping("/balance/{walletId}")
    public ResponseEntity<Double> checkBalance(@PathVariable String walletId) {
        Double balance = walletService.checkBalance(walletId);
        return ResponseEntity.ok(balance);
    }

    @PutMapping("/credit/{walletId}/{amount}")
    public ResponseEntity<Double> creditAmount(@PathVariable String walletId, @PathVariable Double amount) {
        Double newBalance = walletService.creditAmount(walletId, amount);
        return ResponseEntity.ok(newBalance);
    }

    @PutMapping("/debit/{walletId}/{amount}")
    public ResponseEntity<Double> debitAmount(@PathVariable String walletId, @PathVariable Double amount) {
        Double newBalance = walletService.debitAmount(walletId, amount);
        return ResponseEntity.ok(newBalance);
    }

}
