package com.laporrasm.orders;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    @Query("{'_id': ?0}")
    Order updateOrder(ObjectId orderId, int orderNumber, List<OrderItem> items);
}
