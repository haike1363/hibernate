package pers.haike.demo.hibernate.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pers.haike.demo.hibernate.entity.Person;

//@Repository
@EnableJpaRepositories(basePackageClasses = PersonRepository.class)
public interface PersonRepository extends JpaRepository<Person, Long> {

}
