package pers.haike.demo.hibernate.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
@Data
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private IdCard idCard;

    private String name;
}