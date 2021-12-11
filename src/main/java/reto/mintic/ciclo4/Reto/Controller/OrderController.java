package reto.mintic.ciclo4.Reto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reto.mintic.ciclo4.Reto.Model.Order;
import reto.mintic.ciclo4.Reto.Services.OrderServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class OrderController {

    @Autowired
    private OrderServices orderServices;

    @GetMapping("/all")
    public List<Order> getAllOrders(){
        return orderServices.getAllOrders();
    }

    @GetMapping("/{idOrder}")
    public Optional<Order> getOrder(@PathVariable("idOrder") Integer id){
        return orderServices.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        return orderServices.save(order);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return orderServices.update(order);
    }

    @DeleteMapping("/{idOrder}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("idOrder") Integer id){
        return orderServices.delete(id);
    }

    @GetMapping("/zona/{zone}")
    public List<Order> getOrderByZone(@PathVariable("zone") String zone){
        return orderServices.getOrderByZone(zone);
    }
}
