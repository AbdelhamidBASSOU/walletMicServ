package balMicro.demo.repository;


import balMicro.demo.entity.Wallet;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends MongoRepository<Wallet,String> {

}
