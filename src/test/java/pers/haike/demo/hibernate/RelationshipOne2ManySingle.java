package pers.haike.demo.hibernate;


import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import pers.haike.demo.hibernate.entity.Classes;
import pers.haike.demo.hibernate.entity.Student;
import pers.haike.demo.hibernate.service.ClassesRepository;
import pers.haike.demo.hibernate.service.StudentRepository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories
public class RelationshipOne2ManySingle {

    @Autowired
    private ClassesRepository classesRepository;

    @Autowired
    private StudentRepository studentRepository;

    //一对多 - 单向 在一端维护关系，更新时，会更新多的一端，不建议使用，
    //尽量使用一对多双向，由一的一端维护关系
    @Test
    public void test1Save() {
        //先存储多的对象
        Student student1 = new Student();
        student1.setName("10");
        studentRepository.save(student1);

        Student student2 = new Student();
        student2.setName("祖儿");
        studentRepository.save(student2);

        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);

        Classes classes = new Classes();
        classes.setName("wjt276");
        classes.setStudents(students);

        classesRepository.save(classes);
    }

    @Test
    @Transactional
    public void test2Load() {
        Classes classes = classesRepository.findAll().get(0);

        System.out.println("classes.name=" + classes.getName());
        Set<Student> students = classes.getStudents();
        for (Iterator<Student> iter = students.iterator(); iter.hasNext(); ) {
            Student student = iter.next();
            System.out.println(student.getName());
        }
    }
}
