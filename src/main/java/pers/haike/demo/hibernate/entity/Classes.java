package pers.haike.demo.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Classes {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "classes_id")
    private Set<Student> students;
}
