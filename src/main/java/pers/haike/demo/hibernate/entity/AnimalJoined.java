package pers.haike.demo.hibernate.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Inheritance(strategy= InheritanceType.JOINED)
public class AnimalJoined {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private boolean sex;
}
