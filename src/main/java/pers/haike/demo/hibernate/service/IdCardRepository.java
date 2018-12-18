package pers.haike.demo.hibernate.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pers.haike.demo.hibernate.entity.IdCard;


@EnableJpaRepositories(basePackageClasses = IdCardRepository.class)
public interface IdCardRepository extends JpaRepository<IdCard, Long> {
    IdCard findByCardNo(String cardNo);
}
