package pers.haike.demo.hibernate;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.haike.demo.hibernate.entity.Classes2;
import pers.haike.demo.hibernate.entity.Student2;
import pers.haike.demo.hibernate.service.Classes2Repository;
import pers.haike.demo.hibernate.service.Student2Repository;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.Set;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationshipOne2ManyDouble {

    @Autowired
    private Classes2Repository classesRepository;

    @Autowired
    private Student2Repository studentRepository;

    // 一对多 - 双向
    @Test
    public void test1Save() {
        // 在多端维护关系,效率高
        // 先保存一的一端
        Classes2 classes = new Classes2();
        classes.setName("wjt168");
        classesRepository.save(classes);

        Student2 student1 = new Student2();
        student1.setName("10");
        student1.setClasses2(classes);
        studentRepository.save(student1);

        Student2 student2 = new Student2();
        student2.setName("祖儿");
        student2.setClasses2(classes);
        studentRepository.save(student2);
    }

    @Test
    @Transactional
    public void test2Load() {
        Classes2 classes = classesRepository.findAll().get(0);

        System.out.println("classes.name=" + classes.getName());
        Set<Student2> students = classes.getStudents();
        for (Iterator<Student2> iter = students.iterator(); iter.hasNext(); ) {
            Student2 student = iter.next();
            System.out.println(student.getName());
        }
    }
}
