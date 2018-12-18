package pers.haike.demo.hibernate.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
@Data
public class Person2 {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private IdCard2 idCard2;

    private String name;
}