package pers.haike.demo.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.haike.demo.hibernate.entity.KeyEntity;
import pers.haike.demo.hibernate.entity.KeyEntity.PKey;
import pers.haike.demo.hibernate.service.KeyEntityRepository;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class KeyEntityUsage {

    @Autowired
    private KeyEntityRepository keyEntityRepository;


    @Test
    public void test1Save() {

        KeyEntity.PKey pKey = new PKey();
        pKey.setUserId(1L);
        pKey.setUserNname("user1");

        KeyEntity keyEntity = new KeyEntity();
        keyEntity.setKey(pKey);
        keyEntity.setName("uuid11");
        keyEntity.setAddress("aab");
        keyEntity.setEmail("aaa@qq.com");
        keyEntityRepository.save(keyEntity);
    }

    @Test
    public void test2Load() {
        KeyEntity keyEntity = keyEntityRepository.findAll().get(0);
        log.info(keyEntity.toString());

        keyEntity = keyEntityRepository.findByName("uuid11");
        log.info(keyEntity.toString());

        keyEntity = keyEntityRepository.findByAddressContains("ab").get(0);
        log.info(keyEntity.toString());

        keyEntity = keyEntityRepository.findByComputeID(0L).get(0);
        log.info(keyEntity.toString());
    }
}

