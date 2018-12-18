package pers.haike.demo.hibernate.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pers.haike.demo.hibernate.entity.User2;

@Repository
public interface User2Repository extends JpaRepository<User2, Integer> {
}
