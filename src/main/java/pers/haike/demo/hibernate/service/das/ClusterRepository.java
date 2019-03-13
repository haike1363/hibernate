package pers.haike.demo.hibernate.service.das;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pers.haike.demo.hibernate.entity.das.Cluster;

import javax.transaction.Transactional;

@Repository
public interface ClusterRepository extends JpaRepository<Cluster, String> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update cluster set state = ?2 where id = ?1", nativeQuery = true)
    int updateState(String id, String state);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update cluster set status = ?2 where id = ?1", nativeQuery = true)
    int updateStatus(String id, String status);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update cluster set transient_status = ?2 where id = ?1", nativeQuery = true)
    int updateTransientStatus(String id, String status);

}
