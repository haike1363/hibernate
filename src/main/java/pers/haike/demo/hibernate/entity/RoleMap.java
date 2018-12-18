package pers.haike.demo.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Map;

@Entity
@Data
public class RoleMap {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany(mappedBy = "roleMapMap")
    @MapKey(name = "id")
    private Map<Integer, UserMap> userMapMap;
}
