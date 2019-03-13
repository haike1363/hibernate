package pers.haike.demo.hibernate.service.das;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pers.haike.demo.hibernate.entity.das.ShardServer;

import javax.transaction.Transactional;

@Repository
public interface ShardServerNodeRepository extends JpaRepository<ShardServer, String> {

    @Transactional
    @Modifying
    @Query(value = "update node set node.status = ?2 where node.node_id = ?1", nativeQuery = true)
    int updateNodeStatus(String id, String status);
}
