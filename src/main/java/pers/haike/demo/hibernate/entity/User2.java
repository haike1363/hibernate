package pers.haike.demo.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
@Data
public class User2 {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany
    private Set<Role2> role2s;
}