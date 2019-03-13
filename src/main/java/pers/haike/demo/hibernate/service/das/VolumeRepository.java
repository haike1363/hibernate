package pers.haike.demo.hibernate.service.das;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pers.haike.demo.hibernate.entity.das.Volume;

@Repository
public interface VolumeRepository extends JpaRepository<Volume, String> {

}
