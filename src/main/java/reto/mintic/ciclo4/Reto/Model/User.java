package reto.mintic.ciclo4.Reto.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import javax.persistence.*;
import java.io.Serializable;



/**
 * @Author John Muñoz
 * User model class
 */
@Entity
@Table(name = "user")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
//@Document(collection="users") ------> Mongo DB
public class User implements Serializable {
    /**
     * Database fields
     * Id is user identification
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * userEmail is email field
     */
    @NonNull
    @Column(name = "user_email",nullable = false, length = 50)
    //@Field(name="user_email")
    private String email;

    /**
     * userPassword is password field
     */
    @NonNull
    @Column(name = "user_password",nullable = false,length = 50)
    //@Field(name = "user_password")
    private String password;
    /**
     * userName is name field
     */
    @NonNull
    @Column(name = "user_name", nullable = false, length = 80)
    //@Field(name = "user_name")
    private String name;

}
