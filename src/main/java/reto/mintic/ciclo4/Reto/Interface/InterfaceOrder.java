package reto.mintic.ciclo4.Reto.Interface;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import reto.mintic.ciclo4.Reto.Model.Order;

import java.util.List;

public interface InterfaceOrder extends MongoRepository<Order, Integer> {
    @Query("{zone:?0}")
    List<Order> findBySalesManZone(String zone);
}
