package pers.haike.demo.hibernate.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class Animal {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private boolean sex;
}
