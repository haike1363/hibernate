package pers.haike.demo.hibernate.entity.das;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = "MASTER")
public class Master extends Node {

    private Integer masterId;

}
