package reto.mintic.ciclo4.Reto.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;

/**
 * @Author John Muñoz
 * @Version 1.0
 * Supplement model class
 */
//@Entity
@Data
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "supplements")
public class Supplement{
    /**
     * Database fields
     * reference is id
     */
    @Id
    @Field(name = "reference")
    private String reference;

    /**
     * Brand fields
     */
    //@NonNull
    @Field(name = "brand")
    private String brand;

    /**
     * Category fields
     */
    //@NonNull
    @Field(name = "category")
    private String category;
    /**
     * Objetivo fields
     */
    //@NonNull
    @Field(name = "objetivo")
    private String objetivo;


    /**
     * Description fields
     */
    //@NonNull
    @Field(name = "description")
    private String description;

    /**
     * Availability fields
     */
    //@NonNull
    @Field(name = "availability")
    private boolean availability = true;

    /**
     * Price fields
     */
    //@NonNull
    @Field(name = "price")
    private double price;

    /**
     * Quantity fields
     */
    //@NonNull
    @Field(name = "quantity")
    private int quantity;

    /**
     * Photography fields
     */
   // @NonNull
    @Field(name = "photography")
    private String photography;
}
