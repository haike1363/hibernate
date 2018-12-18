package pers.haike.demo.hibernate;


import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.haike.demo.hibernate.entity.AdminGroup;
import pers.haike.demo.hibernate.entity.User;
import pers.haike.demo.hibernate.service.AdminGroupRepository;
import pers.haike.demo.hibernate.service.UserRepository;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationshipMany2One {

    @Autowired
    private AdminGroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    // 多对一 单向
    @Test
    public void test1Save() {
        // 先存储多的对象
        AdminGroup group = new AdminGroup();
        group.setName("wjt276");
        groupRepository.save(group);

        User user1 = new User();
        user1.setName("菜10");
        user1.setGroup(group);//设置用户所属的组

        User user2 = new User();
        user2.setName("容祖儿");
        user2.setGroup(group);//设置用户所属的组

        //开始存储
        userRepository.save(user1);
        userRepository.save(user2);
    }

    @Test
    @Transactional
    public void test2Load() {
        User user = userRepository.findAll().get(0);
        log.info(user.toString());
    }
}
