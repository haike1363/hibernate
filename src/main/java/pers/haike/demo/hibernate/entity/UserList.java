package pers.haike.demo.hibernate.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;


@Entity
@Data
public class UserList {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany
    private List<RoleList> roleListList;
}