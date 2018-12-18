package pers.haike.demo.hibernate;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.haike.demo.hibernate.entity.RoleList;
import pers.haike.demo.hibernate.entity.RoleMap;
import pers.haike.demo.hibernate.entity.UserList;
import pers.haike.demo.hibernate.entity.UserMap;
import pers.haike.demo.hibernate.service.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelationshipMany2ManyDoubleMap {
    @Autowired
    private UserMapRepository userRepository;

    @Autowired
    private RoleMapRepository roleRepository;

    @Test
    public void testSave() {
        RoleMap r1 = new RoleMap();
        r1.setName("数据录入人员");
        roleRepository.save(r1);

        RoleMap r2 = new RoleMap();
        r2.setName("商务主管");
        roleRepository.save(r2);

        UserMap u1 = new UserMap();
        u1.setName("10");
        Map<Integer, RoleMap> u1Roles = new HashMap<>();
        u1Roles.put(r1.getId(), r1);
        u1Roles.put(r2.getId(), r2);
        u1.setRoleMapMap(u1Roles);
        userRepository.save(u1);

        UserMap u2 = new UserMap();
        u2.setName("祖儿");
        Map<Integer, RoleMap> u2Roles = new HashMap<>();
        u2Roles.put(r1.getId(), r1);
        u2.setRoleMapMap(u2Roles);
        userRepository.save(u2);

        userRepository.flush();
    }

    @Test
    public void testLoad() {
        UserMap user = userRepository.findAll().get(0);
        System.out.println("user.name=" + user.getName());

        for (RoleMap role : user.getRoleMapMap().values()) {
            System.out.println(role.getName());
        }

        RoleMap role = roleRepository.findAll().get(0);
        System.out.println("user.name=" + role.getName());

        for (UserMap user2 : role.getUserMapMap().values()) {
            System.out.println(user2.getName());
        }
    }
}