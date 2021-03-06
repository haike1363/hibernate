package pers.haike.demo.hibernate.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Setter
@Getter
@ToString(exclude = {"person2"}) // 在mappedBy的一端排除相互引用
public class IdCard2 {

    @Id
    @GeneratedValue
    private int id;

    private String cardNo;

    @OneToOne(mappedBy = "idCard2")
    private Person2 person2;
}