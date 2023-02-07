package balMicro.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Wallet {


    @Id
    private String  id;

    private double balance;

    @Enumerated
    private Currency currency;

    private Long ownerId;

    private String transactionHistory;


}
