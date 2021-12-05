package reto.mintic.ciclo4.Reto.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto.mintic.ciclo4.Reto.Interface.InterfaceSupplement;
import reto.mintic.ciclo4.Reto.Model.Supplement;

import java.util.List;
import java.util.Optional;


@Repository
public class SupplementRepository {


    @Autowired
    private InterfaceSupplement interfaceSupplement;

    public List<Supplement> getAllSupplement() {
        return (List<Supplement>) interfaceSupplement.findAll();
    }

    public Optional<Supplement> getSupplement(String reference) {
        return interfaceSupplement.findById(reference);
    }

    public Supplement save(Supplement supplement) {
        return interfaceSupplement.save(supplement);
    }

    public void update(Supplement supplement){
        interfaceSupplement.save(supplement);
    }
    public void delete(Supplement supplement) {
        interfaceSupplement.delete(supplement);
    }

}