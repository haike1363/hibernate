package pers.haike.demo.hibernate.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Map;

@Entity
@Setter
@Getter
@ToString(exclude = {"userMapMap"})
public class RoleMap {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany(mappedBy = "roleMapMap")
    @MapKey(name = "id")
    private Map<Integer, UserMap> userMapMap;
}
