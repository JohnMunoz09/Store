package reto.mintic.ciclo4.Reto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reto.mintic.ciclo4.Reto.Model.Supplement;
import reto.mintic.ciclo4.Reto.Services.SupplementServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/supplements")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class SupplementController {

    @Autowired
    private SupplementServices supplementSer;

    @GetMapping("/all")
    public List<Supplement> getAllSupplement(){
        return supplementSer.getAllUser();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Supplement supplement(@RequestBody Supplement supplement){
        return supplementSer.save(supplement);
    }

    @GetMapping("/{reference}")
    public Optional<Supplement> getSupplement(@PathVariable("reference") String reference){
        return supplementSer.getSupplement(reference);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Supplement update(@RequestBody Supplement supplement){
        return supplementSer.update(supplement);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference){
        return supplementSer.deleteSupplement(reference);
    }


}
