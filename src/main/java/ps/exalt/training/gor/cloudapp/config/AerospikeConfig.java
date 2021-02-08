package ps.exalt.training.gor.cloudapp.config;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.ClientPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.core.AerospikeTemplate;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableAerospikeRepositories(basePackages = "ps.exalt.training.gor.cloudapp.repositories")
public class AerospikeConfig {

//    @Bean
//    public AerospikeTemplate aerospikeTemplate() {
//        return new AerospikeTemplate(getClient(),
//                "test",
//                null,
//                null,
//                null,
//                null,
//                null);
//    }
    @Bean
    public AerospikeTemplate aerospikeTemplate() {
        return new AerospikeTemplate(getClient(), "test");
    }

    @Bean
    public AerospikeClient getClient() {
        ClientPolicy cPolicy = new ClientPolicy();
        cPolicy.failIfNotConnected = true;

        return new AerospikeClient(cPolicy,"172.28.128.3", 3000);
    }
}
