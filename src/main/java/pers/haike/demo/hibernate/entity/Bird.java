package pers.haike.demo.hibernate.entity;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorValue(value = "BIRD")
public class Bird extends Animal {
    private int height;
}
