package pers.haike.demo.hibernate.entity.das;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = "SHARD_SERVER")
public class ShardServer extends Node {

    private Integer shardServerId;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<Volume> volumes;

    @Enumerated(EnumType.STRING)
    private UpdateType updateType;
}
