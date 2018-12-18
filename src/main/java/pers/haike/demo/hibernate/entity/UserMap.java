package pers.haike.demo.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Map;


@Entity
@Data
public class UserMap {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @MapKey(name = "id")
    private Map<Integer, RoleMap> roleMapMap;
}