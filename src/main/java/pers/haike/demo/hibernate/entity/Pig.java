package pers.haike.demo.hibernate.entity;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorValue(value = "PIG")
public class Pig extends Animal {

    private int weight;
}
