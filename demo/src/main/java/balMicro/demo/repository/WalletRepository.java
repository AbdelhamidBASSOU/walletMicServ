package balMicro.demo.repository;


import balMicro.demo.entity.Wallet;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends MongoRepository<Wallet,String> {
    @Override
    Optional<Wallet> findById(String Id);
}
