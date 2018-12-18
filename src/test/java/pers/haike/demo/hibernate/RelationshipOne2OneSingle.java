package pers.haike.demo.hibernate;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.haike.demo.hibernate.entity.IdCard;
import pers.haike.demo.hibernate.entity.Person;
import pers.haike.demo.hibernate.service.IdCardRepository;
import pers.haike.demo.hibernate.service.PersonRepository;


@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class RelationshipOne2OneSingle {

    @Autowired
    private IdCardRepository idCardRepository;

    @Autowired
    private PersonRepository personRepository;

    // 唯一外键关联-单向(unilateralism)
    @Test
    public void test1Save() {
        // 必须先保存mapped对象
        IdCard idCard = new IdCard();
        idCard.setCardNo("888888");
        idCardRepository.save(idCard);

        Person person = new Person();
        person.setIdCard(idCard);
        person.setName("haike");
        personRepository.save(person);
    }

    @Test
    public void test2Load() {
        Person person = personRepository.findAll().get(0);
        log.info(person.toString());
    }
}
