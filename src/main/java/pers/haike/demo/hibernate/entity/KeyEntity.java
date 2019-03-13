package pers.haike.demo.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(indexes = {
    // 索引，唯一约束加上名字
    @Index(name = "i_address", columnList = "address"),
    @Index(name = "i_email", columnList = "email"),
    @Index(name = "i_address_email", columnList = "address,email")
})
//@Table(name="t_token", indexes={@Index(name="token_strIndex", columnList="tokenStr"}
public class KeyEntity {

    @Data
    @Embeddable
    public static class PKey implements Serializable {

        private Long userId;
        private String userNname;
    }

    @Id
    private PKey key;

    @Column(unique = true)
    private String name;

    private String address;

    private String email;
}
