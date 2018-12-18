package pers.haike.demo.hibernate.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class IdCard2 {
    @Id
    @GeneratedValue
    private int id;

    private String cardNo;

    @OneToOne(mappedBy = "idCard2")
    private Person2 person2;
}