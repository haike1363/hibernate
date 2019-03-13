package pers.haike.demo.hibernate.entity.das;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEvent {

    UpdateType updateType;
    Integer newShardServerCount;
}
