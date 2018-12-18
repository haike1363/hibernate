package pers.haike.demo.hibernate.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Data
public class Person2 {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private IdCard2 idCard2;

    private String name;
}