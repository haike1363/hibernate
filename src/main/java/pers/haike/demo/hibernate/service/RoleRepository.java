package pers.haike.demo.hibernate.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pers.haike.demo.hibernate.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
