package reto.mintic.ciclo4.Reto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto.mintic.ciclo4.Reto.Model.Order;
import reto.mintic.ciclo4.Reto.Repository.OrderRespository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServices {
    @Autowired
    private OrderRespository orderRespository;

    public List<Order> getAllOrders(){
        return orderRespository.getAllOrders();
    }

    public Optional<Order> getOrder(Integer id){
        return orderRespository.getOrder(id);
    }

    public Order save(Order order){
        if (order.getId() == null){
            return order;
        } else {
            return orderRespository.save(order);
        }
    }

    public Order update(Order order){
        if (order.getId() != null){
            Optional<Order> revision = orderRespository.getOrder(order.getId());
            if (!revision.isEmpty()){

                if (order.getId() != null){
                    revision.get().setId(order.getId());
                }

                if (order.getRegisterDay() != null){
                    revision.get().setRegisterDay(order.getRegisterDay());
                }

                if (order.getStatus() != null){
                    revision.get().setStatus(order.getStatus());
                }

                if(order.getSalesMan() != null){
                    revision.get().setSalesMan(order.getSalesMan());
                }

                if (order.getProducts() != null){
                    revision.get().setProducts(order.getProducts());
                }

                if (order.getQuantities() != null){
                    revision.get().setQuantities(order.getQuantities());
                }
                orderRespository.update(revision.get());
                return revision.get();
            }else{
                return order;
            }
        }else{
            return order;
        }
    }

    public boolean delete(Integer id){
        return getOrder(id).map(order -> {
            orderRespository.delete(order);
            return true;
        }).orElse(false);
    }

    public List<Order> getOrderByZone(String zone){
        return orderRespository.getOrderByZone(zone);
    }
}
