package reto.mintic.ciclo4.Reto.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reto.mintic.ciclo4.Reto.Model.User;
import reto.mintic.ciclo4.Reto.Services.UserServices;

import java.util.List;
import java.util.Optional;


/**
 * @Author John Muñoz
 */
@RestController
@RequestMapping("api/user")
@CrossOrigin(origins ="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {

    /**
     * Objeto de la clase userServices
     */
    @Autowired
    private UserServices userServices;

    /**
     * Metodo Get para obtener todos los datos de los usuarios
     * @return lista de usuarios
     */
    @GetMapping("/all")
    public List<User> getUser(){
        return userServices.getAllUser();
    }

    /**
     * Metodo Post para el ingreso de datos para el usuario
     * @param user recibe objeto user
     * @return datos del usuario ingresado
     */

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User user(@RequestBody User user){
        return userServices.save(user);
    }

    /**
     * Metodo PUT para actualizar registro
     * @param user obtiene objeto User
     * @return datos actualizado
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public  User update(@RequestBody User user){
        return userServices.update(user);
    }

    /**
     * Metodo DELETE para eliminar registro
     * @param id recibe el id del usuario
     * @return registro usuario
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return userServices.deleteUser(id);
    }

    /**
     * Metodo GET para realizar consulta de validacion
     * @param email recibe el correo
     * @param password recibe la contrasena
     * @return datos del usuario no nulos
     */
    @GetMapping("/{email}/{password}")
    public User loginUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return userServices.loginUser(email, password);
    }

    /**
     * Metodo GET para verificar la existencia del usuario
     * @param email recibe correo
     * @return true o false si existe o no el usuario
     */
    @GetMapping("/emailexist/{email}")
    public boolean existEmail(@PathVariable("email") String email){
        return  userServices.existEmail(email);
    }

    /**
     * Metodo GET para traer a usuario por id
     * @param id Recibe id
     */
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") Integer id) {
        return userServices.getUser(id);
    }


}
