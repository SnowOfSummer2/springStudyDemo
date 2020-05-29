package com.betterchengpu.pojo;

import com.betterchengpu.IImpl.Encoreable;
import com.betterchengpu.bussiness.MyEncoreable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EncoreableIntroducer {
    @DeclareParents(value = "com.betterchengpu.bussiness.*",defaultImpl = MyEncoreable.class)
    public static Encoreable encoreable;
}
