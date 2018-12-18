package pers.haike.demo.hibernate.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Data;


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