package pers.haike.demo.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import pers.haike.demo.hibernate.entity.das.Master;
import pers.haike.demo.hibernate.entity.das.Port;
import pers.haike.demo.hibernate.service.das.*;

import javax.transaction.Transactional;
import java.util.UUID;

@Slf4j
@Rollback(false)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDAS {


    @Autowired
    private ClusterRepository clusterRepository;

    @Autowired
    private MasterNodeRepository masterNodeRepository;

    @Autowired
    private ShardServerNodeRepository shardServerNodeRepository;

    @Autowired
    private VolumeRepository volumeRepository;

    @Autowired
    private SecurityGroupRepository securityGroupRepository;

    @Test
    @Transactional
    public void test1() {
        insertMaster();
        updateMaster();
    }

    @Transactional
    void insertMaster() {
        Master master = new Master();
        master.setNodeId("123");
        Port port = new Port();
        port.setPortId("123");
        port.setFixedIp("ip123");
        master.setPort(port);

        masterNodeRepository.save(master);
        log.info("{}", masterNodeRepository.getOne(master.getNodeId()).toString());
    }

    @Transactional
    void updateMaster() {
        Master master = masterNodeRepository.getOne("123");
        //如果把植入的对象设置为null，里面的所有值也被设置为null了
        master.setPort(null);
        masterNodeRepository.save(master);
        log.info("{}", masterNodeRepository.getOne(master.getNodeId()).toString());
    }

    @Test
    public void test2() {

    }

    @Transactional
    void insertCluster() {
        
    }


}
