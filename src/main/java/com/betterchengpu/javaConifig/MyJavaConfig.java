package com.betterchengpu.javaConifig;

import com.betterchengpu.CDPlayer;
import com.betterchengpu.IImpl.CompactDisc;
import com.betterchengpu.IImpl.Encoreable;
import com.betterchengpu.bussiness.BlankDisc;
import com.betterchengpu.bussiness.MyEncoreable;
import com.betterchengpu.bussiness.SgtPeppers;
import com.betterchengpu.pojo.EncoreableIntroducer;
import com.betterchengpu.pojo.TrackCounter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(value = "com.betterchengpu")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import({DataBaseConfig.class,CacheConfig.class})
public class MyJavaConfig {
    /**
     * 装配CompactDisc對象
     *
     * @return 實例
     */
    @Bean(name = "blank")
    public CompactDisc compactDisc() {
        List<String> trackLst = new ArrayList<>();
        trackLst.add("zhou jun");
        trackLst.add("gui xiong");
        return new BlankDisc("Sgt. Peppers loneyly Hearts cllub Band", "cheng pu", trackLst);
    }

//    @Bean
//    public SgtPeppers sgtPeppers() {
//        return new SgtPeppers();
//    }
     @Bean
     public CDPlayer cdPlayer(){
      return new CDPlayer(compactDisc());
     }

//    @Bean
//   public TrackCounter trackCounter() {
//        return new TrackCounter();
//    }
}
