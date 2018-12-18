package pers.haike.demo.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class RoleList {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany(mappedBy = "roleListList")
    @OrderBy(value = "name asc")
    private List<UserList> userListList;
}
