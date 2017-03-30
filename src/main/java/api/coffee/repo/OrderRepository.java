package api.coffee.repo;

import api.coffee.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.UUID;


public interface OrderRepository extends MongoRepository<Order, UUID>{

}
