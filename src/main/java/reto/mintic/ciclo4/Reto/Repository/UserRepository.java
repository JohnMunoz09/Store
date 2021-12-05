package reto.mintic.ciclo4.Reto.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto.mintic.ciclo4.Reto.Interface.InterfaceUser;
import reto.mintic.ciclo4.Reto.Model.User;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private InterfaceUser interfaceUser;

    public List<User> getAllUser(){
        return (List<User>) interfaceUser.findAll();
    }

    public Optional<User> getUser(int id){
        return interfaceUser.findById(id);
    }

    public User save(User user){
        return interfaceUser.save(user);
    }

    public void update(User user){
        interfaceUser.save(user);
    }

    public void delete(User user){
        interfaceUser.delete(user);
    }

    public boolean existEmail(String email){
        Optional<User> revision = interfaceUser.findByEmail(email);
        return !revision.isEmpty();
    }

    public Optional<User> loginUser(String email,String password){
        return interfaceUser.findByEmailAndPassword(email,password);
    }

    public Optional<User> getNameOrEmail(String name, String email){
        return interfaceUser.findByNameOrEmail(name,email);
    }
}
