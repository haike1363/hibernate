package pers.haike.demo.hibernate.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@ToString(exclude = {"userListList"})
public class RoleList {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany(mappedBy = "roleListList")
    @OrderBy(value = "name asc")
    private List<UserList> userListList;
}
