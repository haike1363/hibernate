package pers.haike.demo.hibernate.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class IdCard {
    @Id
    @GeneratedValue
    private int id;

    private String cardNo;
}