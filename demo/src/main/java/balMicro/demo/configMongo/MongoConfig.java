package balMicro.demo.configMongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoConfig {

        @Bean
        public MongoClient mongoClient() {
            return MongoClients.create("mongodb://localhost:27017/wallet");
        }


        @Bean
        public MongoTemplate mongoTemplate(MongoClient mongoClient) {
            return new MongoTemplate(mongoClient, "wallet");
        }
    }

