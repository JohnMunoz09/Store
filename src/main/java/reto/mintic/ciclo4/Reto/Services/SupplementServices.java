package reto.mintic.ciclo4.Reto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto.mintic.ciclo4.Reto.Model.Supplement;
import reto.mintic.ciclo4.Reto.Repository.SupplementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplementServices {

    @Autowired
    private SupplementRepository supplementR;

    public List<Supplement> getAllUser(){
        return supplementR.getAllSupplement();
    }

    public Optional<Supplement> getSupplement(String reference){
        return supplementR.getSupplement(reference);
    }

    public Supplement save(Supplement supplement){
        if (supplement.getReference() != null ){
            Optional<Supplement> revision = supplementR.getSupplement(supplement.getReference());
                if (revision.isEmpty()){
                    return supplementR.save(supplement);
                }else {
                    return supplement;
                }
        } else {
            return supplement;
        }
    }

    public Supplement update(Supplement supplement){
        if (supplement.getReference() != null){
            Optional<Supplement> revision = supplementR.getSupplement(supplement.getReference());
            if (!revision.isEmpty()){
                if (supplement.getBrand() != null){
                    revision.get().setBrand(supplement.getBrand());
                }
                if (supplement.getCategory() != null){
                    revision.get().setCategory(supplement.getCategory());
                }
                if (supplement.getObjetivo() != null){
                    revision.get().setObjetivo(supplement.getObjetivo());
                }
                if (supplement.getDescription() != null){
                    revision.get().setDescription(supplement.getDescription());
                }
                if (supplement.getPrice() != 0.0){
                    revision.get().setPrice(supplement.getPrice());
                }
                if (supplement.getQuantity() != 0){
                    revision.get().setQuantity(supplement.getQuantity());
                }
                if (supplement.getPhotography() != null){
                    revision.get().setPhotography(supplement.getPhotography());
                }
                revision.get().setAvailability(supplement.isAvailability());
                supplementR.update(revision.get());
                return revision.get();
            }else{
                return supplement;
            }
        }else {
            return supplement;
        }
    }

    public boolean deleteSupplement(String reference){
        Boolean aBoolean = getSupplement(reference).map(supplement -> {
            supplementR.delete(supplement);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

