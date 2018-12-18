package pers.haike.demo.hibernate.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Student2 {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToOne
    private Classes2 classes2;
}
