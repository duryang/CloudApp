package ps.exalt.training.gor.cloudapp.repositories;

import org.springframework.data.aerospike.repository.AerospikeRepository;
import org.springframework.stereotype.Repository;
import ps.exalt.training.gor.cloudapp.models.Application;

//@Repository
public interface ApplicationRepository extends AerospikeRepository<Application, Integer> {
}
