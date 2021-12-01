package reto.mintic.ciclo4.Reto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto.mintic.ciclo4.Reto.Model.User;
import reto.mintic.ciclo4.Reto.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.getAllUser();
    }

    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }

    public User save(User user){
            if (user.getId() != null){
                Optional<User> revision=userRepository.getUser(user.getId());
                if (revision.isEmpty()){
                    return userRepository.save(user);
                }else{
                    return user;
                }
            }else {
                return userRepository.save(user);
            }
    }

    public User update(User user){
        if (user.getId()!= null){
            Optional<User> revision = userRepository.getUser(user.getId());
            if (!revision.isEmpty()){
                if (user.getEmail() != null){
                    revision.get().setEmail(user.getEmail());
                }
                if (user.getName() != null){
                    revision.get().setName(user.getName());
                }
                if(user.getPassword() != null){
                    revision.get().setPassword(user.getPassword());
                }
                userRepository.save(revision.get());
                return revision.get();
            }else{
                return user;
            }
        }else{
            return user;
        }
    }

    public boolean deleteUser(int id){
        Boolean aBoolean = getUser(id).map(user ->{
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public boolean existEmail(String email){
        return userRepository.existEmail(email);
    }

    public User loginUser(String email,String password){
        Optional<User> revision = userRepository.loginUser(email, password);
        if (revision.isEmpty()){
            return new User(email,password,"NO DEFINIDO");
        }else{
            return revision.get();
        }
    }
}