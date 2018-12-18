package pers.haike.demo.hibernate.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class BirdJoined extends AnimalJoined {
    private int height;
}
