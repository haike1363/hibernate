package pers.haike.demo.hibernate;


import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.haike.demo.hibernate.entity.Contact;
import pers.haike.demo.hibernate.entity.User;
import pers.haike.demo.hibernate.service.UserRepository;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationshipComponent {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void test() {
        User user= new User();
        user.setName("haike");

        Contact contact = new Contact();
        contact.setEmail("wjt276");
        contact.setAddress("aksdfj");
        contact.setZipCode("230051");
        contact.setContactTel("3464661");

        user.setContact(contact);
        userRepository.save(user);
    }
}
