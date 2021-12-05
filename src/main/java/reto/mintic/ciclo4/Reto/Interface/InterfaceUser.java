package reto.mintic.ciclo4.Reto.Interface;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import reto.mintic.ciclo4.Reto.Model.User;

import java.util.Optional;
//public interface InterfaceUser extends MongoRepository<User, String>
public interface InterfaceUser extends MongoRepository<User, Integer> {

  @Query("{email:?0}")
  Optional<User> findByEmail(String email);
  @Query("{email:?0, password:?1}")
  Optional<User> findByEmailAndPassword(String email, String password);
  @Query("{name:?0,email:?1}")
  Optional<User> findByNameOrEmail(String name,String email);
}
