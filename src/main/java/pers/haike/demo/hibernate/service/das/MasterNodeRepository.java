package pers.haike.demo.hibernate.service.das;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pers.haike.demo.hibernate.entity.das.Master;

import javax.transaction.Transactional;

@Repository
public interface MasterNodeRepository extends JpaRepository<Master, String> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update node set status = ?2 where node_id = ?1", nativeQuery = true)
    int updateNodeStatus(String id, String status);
}
