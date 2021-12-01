package reto.mintic.ciclo4.Reto.Interface;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import reto.mintic.ciclo4.Reto.Model.User;

import java.util.Optional;
//public interface InterfaceUser extends MongoRepository<User, String>
public interface InterfaceUser extends JpaRepository<User, Integer> {

  //@Query("{email:?0}") ------> Mongo DB
    Optional<User> findByEmail(String email);
  // @Query("{email:?0, password:?1}") ---------> Mongo DB
    Optional<User> findByEmailAndPassword(String email, String password);
}
