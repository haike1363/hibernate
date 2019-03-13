package pers.haike.demo.hibernate;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.haike.demo.hibernate.entity.Animal;
import pers.haike.demo.hibernate.entity.Bird;
import pers.haike.demo.hibernate.entity.Pig;
import pers.haike.demo.hibernate.service.AnimalRepository;
import pers.haike.demo.hibernate.service.BirdRepository;
import pers.haike.demo.hibernate.service.PigRepository;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationshipInhierarchyOneTable {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private PigRepository pigRepository;

    @Autowired
    private BirdRepository birdRepository;

    // 单表继承SINGLE_TABLE,推荐使用
    @Test
    public void test1Save() {
        Pig pig = new Pig();
        pig.setName("猪猪");
        pig.setSex(true);
        pig.setWeight(100);
        pigRepository.save(pig);

        Bird bird = new Bird();
        bird.setName("鸟鸟");
        bird.setSex(false);
        bird.setHeight(50);
        birdRepository.save(bird);
    }

    @Test
    public void test2Load() {
        Pig pig = pigRepository.findAll().get(0);
        System.out.println("pig.name=" + pig.getName());
        System.out.println("pig.weight=" + pig.getWeight());

        Bird bird = birdRepository.findAll().get(0);
        System.out.println("bird.name" + bird.getName());
        System.out.println("bird.height=" + bird.getHeight());

        //不会发出SQL，返回一个代理类
        Animal animal = animalRepository.findAll().get(0);
        //发出SQL语句，并且加载所有字段的数据(因为使用父类加载对象数据)
        System.out.println("animal.name=" + animal.getName());
        System.out.println("animal.sex=" + animal.isSex());


        //不会发出SQL语句(load默认支持延迟加载(lazy))，返回一个animal的代理对象(此代理类是继承Animal生成的，也就是说是Animal一个子类)
        animal = animalRepository.findAll().get(0);

        //因为在上面返回的是一个代理类(父类的一个子类)，所以animal不是Pig
        //通过instanceof是反应不出正直的对象类型的，因此load在默认情况下是不支持多态查询的。
        if (animal instanceof Pig) {
            System.out.println("是猪");
        } else {
            System.out.println("不是猪");//这就是结果
        }
        System.out.println("animal.name=" + animal.getName());
        System.out.println("animal.sex=" + animal.isSex());
    }
}
