package pers.haike.demo.hibernate;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.haike.demo.hibernate.entity.Role;
import pers.haike.demo.hibernate.entity.User;
import pers.haike.demo.hibernate.service.RoleRepository;
import pers.haike.demo.hibernate.service.UserRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationshipMany2ManySingle {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // 多对多 - 单向
    @Test
    public void test1Save() {
        Role r1 = new Role();
        r1.setName("数据录入人员");
        roleRepository.save(r1);

        Role r2 = new Role();
        r2.setName("商务主管");
        roleRepository.save(r2);

        Role r3 = new Role();
        r3.setName("大区经理");
        roleRepository.save(r3);

        User u1 = new User();
        u1.setName("10");
        Set<Role> u1Roles = new HashSet<>();
        u1Roles.add(r1);
        u1Roles.add(r2);
        u1.setRoles(u1Roles);

        User u2 = new User();
        u2.setName("祖儿");
        Set<Role> u2Roles = new HashSet<>();
        u2Roles.add(r2);
        u2Roles.add(r3);
        u2.setRoles(u2Roles);

        User u3 = new User();
        u3.setName("成龙");
        Set<Role> u3Roles = new HashSet<>();
        u3Roles.add(r1);
        u3Roles.add(r2);
        u3Roles.add(r3);
        u3.setRoles(u3Roles);

        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);

    }

    @Test
    @Transactional
    public void test2Load() {
        User user = userRepository.findAll().get(0);
        System.out.println("user.name=" + user.getName());

        for (Role role : user.getRoles()) {
            System.out.println(role.getName());
        }
    }
}
