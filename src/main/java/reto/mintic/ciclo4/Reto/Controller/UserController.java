package reto.mintic.ciclo4.Reto.Controller;

import org.hibernate.internal.util.xml.Origin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reto.mintic.ciclo4.Reto.Model.User;
import reto.mintic.ciclo4.Reto.Services.UserServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins ="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/all")
    public List<User> getUser(){
        return userServices.getAllUser();
    }


    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User user(@RequestBody User user){
        return userServices.save(user);
    }

    @GetMapping("/{email}/{password}")
    public User loginUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return userServices.loginUser(email, password);
    }

    @GetMapping("/{email}")
    public boolean existEmail(@PathVariable("email") String email){
        return  userServices.existEmail(email);
    }
}
