package pers.haike.demo.hibernate;

import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.haike.demo.hibernate.entity.RoleList;
import pers.haike.demo.hibernate.entity.UserList;
import pers.haike.demo.hibernate.service.RoleListRepository;
import pers.haike.demo.hibernate.service.UserListRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RelationshipMany2ManyDoubleList {

    @Autowired
    private UserListRepository userRepository;

    @Autowired
    private RoleListRepository roleRepository;

    @Test
    public void test1Save() {
        RoleList r1 = new RoleList();
        r1.setName("数据录入人员");
        roleRepository.save(r1);

        RoleList r2 = new RoleList();
        r2.setName("商务主管");
        roleRepository.save(r2);


        UserList u1 = new UserList();
        u1.setName("10");
        List<RoleList> u1Roles = new ArrayList<>();
        u1Roles.add(r1);
        u1Roles.add(r2);
        u1.setRoleListList(u1Roles);
        userRepository.save(u1);

        UserList u2 = new UserList();
        u2.setName("祖儿");
        List<RoleList> u2Roles = new ArrayList<>();
        u2Roles.add(r1);
        u2.setRoleListList(u2Roles);
        userRepository.save(u2);
    }

    @Test
    @Transactional
    public void test2Load() {
        UserList user = userRepository.findAll().get(0);
        System.out.println("user.name=" + user.getName());

        for (RoleList role : user.getRoleListList()) {
            System.out.println(role.getName());
        }

        RoleList role = roleRepository.findAll().get(0);
        System.out.println("user.name=" + role.getName());

        for (UserList user2 : role.getUserListList()) {
            System.out.println(user2.getName());
        }
    }
}
