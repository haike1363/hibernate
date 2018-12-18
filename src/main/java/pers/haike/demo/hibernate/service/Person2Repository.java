package pers.haike.demo.hibernate.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pers.haike.demo.hibernate.entity.Person2;

@Repository
public interface Person2Repository extends JpaRepository<Person2, Long> {

}
