package pers.haike.demo.hibernate.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Classes2 {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(mappedBy = "classes2")
    private Set<Student2> students;
}
