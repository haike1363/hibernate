package pers.haike.demo.hibernate;


import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.haike.demo.hibernate.entity.Role2;
import pers.haike.demo.hibernate.entity.User2;
import pers.haike.demo.hibernate.service.Role2Repository;
import pers.haike.demo.hibernate.service.User2Repository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RelationshipMany2ManyDoubleSet {

    @Autowired
    private User2Repository userRepository;

    @Autowired
    private Role2Repository roleRepository;

    // 多对多 - 双向
    @Test
    public void test1Save() {
        Role2 r1 = new Role2();
        r1.setName("数据录入人员");
        roleRepository.save(r1);

        Role2 r2 = new Role2();
        r2.setName("商务主管");
        roleRepository.save(r2);

        Role2 r3 = new Role2();
        r3.setName("大区经理1");
        roleRepository.save(r3);

        User2 u1 = new User2();
        u1.setName("10");
        Set<Role2> u1Roles = new HashSet<>();
        u1Roles.add(r1);
        u1Roles.add(r2);
        u1.setRole2s(u1Roles);

        User2 u2 = new User2();
        u2.setName("祖儿");
        Set<Role2> u2Roles = new HashSet<>();
        u2Roles.add(r2);
        u2Roles.add(r3);
        u2.setRole2s(u2Roles);

        User2 u3 = new User2();
        u3.setName("成龙");
        Set<Role2> u3Roles = new HashSet<>();
        u3Roles.add(r1);
        u3Roles.add(r2);
        u3Roles.add(r3);
        u3.setRole2s(u3Roles);

        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);
    }

    @Test
    @Transactional
    public void test2Load() {
        User2 user = userRepository.findAll().get(0);
        System.out.println("user.name=" + user.getName());

        for(Role2 role : user.getRole2s()){
            System.out.println(role.getName());
        }

        Role2 role = roleRepository.findAll().get(0);
        System.out.println("user.name=" + role.getName());

        for(User2 user2 : role.getUser2s()){
            System.out.println(user2.getName());
        }
    }
}
