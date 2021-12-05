package reto.mintic.ciclo4.Reto.Model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * @Author John Muñoz
 * @Version 1.0
 * User model class
 */
//@Entity
//@Table(name = "user")
@Data
@AllArgsConstructor
//@RequiredArgsConstructor
@NoArgsConstructor
@Document(collection="users")
public class User implements Serializable {
    /**
     * Database fields
     * Id is user identification
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Field(name = "identification")
    private String identification;

    @Field(name = "name")
    private String name;

    @Field(name = "address")
    private String address;

    @Field(name = "cellPhone")
    private String cellPhone;

    @Field(name = "email")
    private String email;

    @Field(name = "password")
    private String password;

    @Field(name = "zone")
    private String zone;

    @Field(name = "type")
    private String type;

}
