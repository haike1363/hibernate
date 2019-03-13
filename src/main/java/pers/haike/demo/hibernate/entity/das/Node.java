package pers.haike.demo.hibernate.entity.das;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Node {

    @Id
    private String nodeId;

    @Embedded
    private Port port;
}
