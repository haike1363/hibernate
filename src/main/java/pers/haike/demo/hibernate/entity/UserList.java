package pers.haike.demo.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class UserList {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<RoleList> roleListList;
}