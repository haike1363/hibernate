package pers.haike.demo.hibernate.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pers.haike.demo.hibernate.entity.Role2;

@Repository
public interface Role2Repository extends JpaRepository<Role2, Integer> {
}
