package pers.haike.demo.hibernate.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @Column(name = "classes_id")
    private Long classesId;
}
