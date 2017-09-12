package com.alan.right.rate.domain.models;

import com.alan.right.rate.domain.constants.Genre;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author asmith
 */
@Entity
public class Game implements Serializable {
    
    @Id
    private Long Id;
    private String name;
    private Genre genre; 

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }
    
    
}
