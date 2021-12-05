package reto.mintic.ciclo4.Reto.Interface;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import reto.mintic.ciclo4.Reto.Model.Supplement;

import java.util.Optional;

public interface InterfaceSupplement extends MongoRepository<Supplement, String> {

    @Query("{reference:?0}")
    Optional<Supplement> findByReference(String reference);

}
