package reto.mintic.ciclo4.Reto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto.mintic.ciclo4.Reto.Model.User;
import reto.mintic.ciclo4.Reto.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * @Author John Muñoz
 */
@Service
public class UserServices {
    /**
     * Objeto del userRespository
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * llama el metodo del objeto UserRepository para obtener todo los usuarios
     * @return retorna una lista con todos los usuarios
     */
    public List<User> getAllUser(){
        return userRepository.getAllUser();
    }

    /**
     * consulta a un usuario por id
     * @param id parametro del id de usuario
     * @return el usuario encontrado
     */
    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }

    /**
     * Metodo para guardar usuarios
     * @param user recibe como parametros el objeto usuario
     * @return validacion si se guardo
     */
    public User save(User user){
            if (user.getId() != null){
                Optional<User> revision=userRepository.getUser(user.getId());
                if (revision.isEmpty()){
                    return userRepository.save(user);
                }else{
                    return user;
                }
            }else {
                return user;
            }
    }

    /**
     * Metodo para actualizar usuarios
     * @param user recibe como parametros el objeto usuario
     * @return validacion si se actualizo
     */
    public User update(User user){
        if (user.getId()!= null){
            Optional<User> revision = userRepository.getUser(user.getId());
            if (!revision.isEmpty()){
                if (user.getIdentification() != null){
                    revision.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null){
                    revision.get().setName(user.getName());
                }
                if (user.getBirthtDay() != null){
                    revision.get().setBirthtDay(user.getBirthtDay());
                }

                if (user.getMonthBirthtDay() != null){
                    revision.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if (user.getAddress() != null){
                    revision.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null){
                    revision.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null){
                    revision.get().setEmail(user.getEmail());
                }
                if(user.getPassword() != null){
                    revision.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null){
                    revision.get().setZone(user.getZone());
                }
                if (user.getType() != null){
                    revision.get().setType(user.getType());
                }
                userRepository.update(revision.get());
                return revision.get();
            }else{
                return user;
            }
        }else{
            return user;
        }
    }

    /**
     * Metodo para eliminar usuarios
     * @param id recibe como parametros el id del usuario
     * @return verdadero o false si se pudo guardar
     */
    public boolean deleteUser(int id){
        Boolean aBoolean = getUser(id).map(user ->{
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    /**
     * Metodo para validar si existe un email
     * @param email recibe el email para verificar
     * @return validacion del email
     */
    public boolean existEmail(String email){
        return userRepository.existEmail(email);
    }

    /**
     * Metodo para validar el login o la combinacion email/password
     * @param email recibe el email del usuario
     * @param password recibe el password
     * @return retorna el usuario
     */
    public User loginUser(String email,String password){
        Optional<User> revision = userRepository.loginUser(email, password);
        if (revision.isEmpty()){
            return new User();
        }else{
            return revision.get();
        }
    }
}