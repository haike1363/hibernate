package pers.haike.demo.hibernate.entity.das;


import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Cluster {

    @Id
    private String id;

    ///////////////////////////////////////////extra info
    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<Master> masters;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<ShardServer> shardServers;

    @Embedded
    private UpdateEvent updateEvent;
}
