package pers.haike.demo.hibernate.service;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pers.haike.demo.hibernate.entity.KeyEntity;

public interface KeyEntityRepository extends JpaRepository<KeyEntity, KeyEntity.PKey> {

    @Query(value = "select * from key_entity where key_entity.user_id * 7 >= :id", nativeQuery = true)
    List<KeyEntity> findByComputeID(@Param(value = "id") Long id);

    List<KeyEntity> findByAddressContains(String address);

    KeyEntity findByName(String name);
}
