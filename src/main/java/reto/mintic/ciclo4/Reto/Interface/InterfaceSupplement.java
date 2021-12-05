package reto.mintic.ciclo4.Reto.Interface;

import org.springframework.data.mongodb.repository.MongoRepository;
import reto.mintic.ciclo4.Reto.Model.Supplement;


public interface InterfaceSupplement extends MongoRepository<Supplement, String> {

}
