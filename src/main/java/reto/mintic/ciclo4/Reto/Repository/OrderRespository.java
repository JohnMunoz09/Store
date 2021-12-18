package reto.mintic.ciclo4.Reto.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reto.mintic.ciclo4.Reto.Interface.InterfaceOrder;
import reto.mintic.ciclo4.Reto.Model.Order;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        public List<Order> getSalesManId(Integer id){
            return interfaceOrder.findBySalesManId(id);
        }

        public List<Order> getIdStatus(Integer id,String status){
            return interfaceOrder.findBySalesManIdAndStatus(id,status);
        }

    @Autowired
    private MongoTemplate mongoTemplate;
        public List<Order> getRegisterDayId(String registerDay, Integer id) {
            DateTimeFormatter dataTime = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Query query = new Query();
            Criteria dateCriteria = Criteria.where("registerDay")
                    .gte(LocalDate.parse(registerDay, dataTime).minusDays(1).atStartOfDay())
                    .lt(LocalDate.parse(registerDay, dataTime).plusDays(1).atStartOfDay())
                    .and("salesMan.id").is(id);

            query.addCriteria(dateCriteria);
            return mongoTemplate.find(query,Order.class);
        }
}
