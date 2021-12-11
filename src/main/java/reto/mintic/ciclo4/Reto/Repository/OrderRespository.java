package reto.mintic.ciclo4.Reto.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto.mintic.ciclo4.Reto.Interface.InterfaceOrder;
import reto.mintic.ciclo4.Reto.Model.Order;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRespository {
        @Autowired
        private InterfaceOrder interfaceOrder;

        public List<Order> getAllOrders(){
            return interfaceOrder.findAll();
        }

        public Optional<Order> getOrder(Integer id){
            return interfaceOrder.findById(id);
        }

        public Order save(Order order){
            return interfaceOrder.save(order);
        }

        public void update(Order order){
            interfaceOrder.save(order);
        }

        public void delete(Order order){
            interfaceOrder.delete(order);
        }

        public List<Order> getOrderByZone(String zone){
            return interfaceOrder.findBySalesManZone(zone);
        }
}
