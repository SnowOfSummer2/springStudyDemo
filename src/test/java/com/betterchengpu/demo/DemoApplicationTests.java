package com.betterchengpu.demo;

import com.betterchengpu.IImpl.CompactDisc;
import com.betterchengpu.IImpl.Encoreable;
import com.betterchengpu.IImpl.SpitterRepository;
import com.betterchengpu.Util.MyArrayList;
import com.betterchengpu.bussiness.MonitorVehicleTracker;
import com.betterchengpu.bussiness.MutablePoint;
import com.betterchengpu.bussiness.SgtPeppers;
import com.betterchengpu.javaConifig.MyJavaConfig;
import com.betterchengpu.model.TestTable;
import com.betterchengpu.pojo.TrackCounter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
//@ContextConfiguration(locations = {"classpath:static/spring/app-context.xml"})
@ContextConfiguration(classes = MyJavaConfig.class)
@SpringBootTest
public class DemoApplicationTests {

    @Resource(name = "blank")
    private CompactDisc compactDisc;

    @Autowired
    private SgtPeppers sgtPeppers;

    @Autowired
    private TrackCounter trackCounter;

    @Autowired
    private SpitterRepository jdbcSpitterRepository;

    @Test
    public void contextLoads() {
        compactDisc.play();
        compactDisc.play();
        compactDisc.play();
        compactDisc.play();
        sgtPeppers.play();

        Encoreable encoreable = (Encoreable) sgtPeppers;
        encoreable.performEncore();


        System.out.println(trackCounter.getCounts());
    }

    @Test
    public void TestDbOperation() {
        TestTable tbI = new TestTable();
        tbI.setKeyId("bbbbb");
        tbI.setA(2);
        tbI.setB("zhoujun");

        TestTable tb = jdbcSpitterRepository.addSpitter(tbI);
        System.out.println(tb.toString());

        tb = jdbcSpitterRepository.findOne("bbbbb");
        System.out.println(tb.toString());
    }

    @Test
    public void TrackerSafeTest() throws InterruptedException {
        MutablePoint pointA = new MutablePoint();
        pointA.x = 1;
        pointA.y = 1;

        MutablePoint pointB = new MutablePoint();
        pointB.x = 2;
        pointB.y = 2;

        Map <String, MutablePoint> map = new HashMap <>();
        map.put("A", pointA);
        map.put("B", pointB);

        MonitorVehicleTracker tracker = new MonitorVehicleTracker(map);

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Map <String, MutablePoint> mapResult = tracker.getLocations();

                    for (String id : mapResult.keySet()
                            ) {
                        System.out.println("id " + id + ",point: " + mapResult.get(id).x + " " + mapResult.get(id).y);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                tracker.setLocations("B", 2, 3);
            }
        });
    }

    @Test
    public void Java8Test() {
        MyArrayList <Integer> list = new MyArrayList <>();
        list.add(1);
        list.add(2);
        list.add(6);
        list.filter(a -> a > 1);
        list.forEach(System.out::println);
    }
}
