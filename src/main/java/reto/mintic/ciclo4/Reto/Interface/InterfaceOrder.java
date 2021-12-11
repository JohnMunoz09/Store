package reto.mintic.ciclo4.Reto.Interface;

import org.springframework.data.mongodb.repository.MongoRepository;
import reto.mintic.ciclo4.Reto.Model.Order;

import java.util.List;

public interface InterfaceOrder extends MongoRepository<Order, Integer> {
    List<Order> findBySalesManZone(String zone);
}
