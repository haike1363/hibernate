package pers.haike.demo.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToOne
    private AdminGroup group;

    @Embedded
    private Contact contact;

    @ManyToMany
    private Set<Role> roles;
}