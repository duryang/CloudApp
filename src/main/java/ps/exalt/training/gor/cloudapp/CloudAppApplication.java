package ps.exalt.training.gor.cloudapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;
import org.springframework.stereotype.Controller;

@SpringBootApplication
public class CloudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudAppApplication.class, args);
	}

}
