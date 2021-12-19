package reto.mintic.ciclo4.Reto.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto.mintic.ciclo4.Reto.Interface.InterfaceUser;
import reto.mintic.ciclo4.Reto.Model.User;

import java.util.List;
import java.util.Optional;

/**
 * @Author John Muñoz
 */
@Repository
public class UserRepository {
    /**
     * Objeto de la clase interfaceUser
     */
    @Autowired
    private InterfaceUser interfaceUser;

    /**
     * Metodo para obtener todos los usuarios
     * @return retorna una lista de usuarios
     */
    public List<User> getAllUser(){
        return (List<User>) interfaceUser.findAll();
    }

    /**
     * Retorna el usuario buscado por el id
     * @param idUser obtiene el id del usuario
     * @return retorna al usuario
     */
    public Optional<User> getUser(int idUser){
        return interfaceUser.findById(idUser);
    }

    /**
     * Metodo para guardar usuario
     * @param user obtiene el objeto usuario
     * @return usuario
     */
    public User save(User user){
        return interfaceUser.save(user);
    }

    /**
     * Metodo para actualizar un usuario
     * @param user objeto usuario
     */
    public void update(User user){
        interfaceUser.save(user);
    }

    /**
     * Metodo par eliminar el usuario
     * @param user objeto usuario
     */
    public void delete(User user){
        interfaceUser.delete(user);
    }

    /**
     * Metodo para verificar la existencia de un email
     * @param email recibe el email del usuario
     * @return resultado si no esta vacio
     */
    public boolean existEmail(String email){
        Optional<User> revision = interfaceUser.findByEmail(email);
        return !revision.isEmpty();
    }

    /**
     * Metodo para verificar la combinacion email/password
     * @param email recibe email
     * @param password recibe passwor
     * @return retorna consulta
     */
    public Optional<User> loginUser(String email,String password){
        return interfaceUser.findByEmailAndPassword(email,password);
    }

    /**
     * Metodo para buscar por nombre y email
     * @param name recibe el nombre del usuario
     * @param email recibe el email del usuario
     * @return la consulta del correo y nombre
     */
    public Optional<User> getNameOrEmail(String name, String email){
        return interfaceUser.findByNameOrEmail(name,email);
    }

    /**
     * Metodo para consultar por el mes de cumpleaños
     * @param monthBirthDay recibe el mes de cumpleaños
     * @return la lista por mes de cumpleaños
     */
    public List<User> getMonthBirthDay(String monthBirthDay){
        return interfaceUser.findByMonthBirthtDay(monthBirthDay);
    }
}
