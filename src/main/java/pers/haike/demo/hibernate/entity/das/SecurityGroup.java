package pers.haike.demo.hibernate.entity.das;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@ToString
public class SecurityGroup {

    @Id
    private String id;

    private Boolean isService;
}
