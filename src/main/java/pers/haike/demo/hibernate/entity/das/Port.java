package pers.haike.demo.hibernate.entity.das;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Port {
    private String portId;
    private String fixedIp;
}
