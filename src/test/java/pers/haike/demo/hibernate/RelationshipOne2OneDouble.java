package pers.haike.demo.hibernate;


import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.haike.demo.hibernate.entity.IdCard2;
import pers.haike.demo.hibernate.entity.Person2;
import pers.haike.demo.hibernate.service.IdCard2Repository;
import pers.haike.demo.hibernate.service.Person2Repository;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationshipOne2OneDouble {

    @Autowired
    private IdCard2Repository idCard2Repository;

    @Autowired
    private Person2Repository person2Repository;

    // 唯一外键关联双向
    @Test
    public void test() {
        IdCard2 idCard2 = new IdCard2();
        idCard2.setCardNo("888888");

        Person2 person2 = new Person2();
        person2.setName("haike");

        idCard2Repository.save(idCard2);
        person2Repository.save(person2);

        idCard2 = idCard2Repository.findByCardNo("888888");
        log.info(idCard2.toString());

    }
}
