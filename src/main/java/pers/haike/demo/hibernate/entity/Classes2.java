package pers.haike.demo.hibernate.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString(exclude = {"students"}) // 在mappedBy的一端排除相互引用
public class Classes2 {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(mappedBy = "classes2")
    private Set<Student2> students;
}
