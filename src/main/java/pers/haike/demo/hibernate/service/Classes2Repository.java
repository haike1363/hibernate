package pers.haike.demo.hibernate.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pers.haike.demo.hibernate.entity.Classes2;

@Repository
public interface Classes2Repository extends JpaRepository<Classes2, Long> {
}
