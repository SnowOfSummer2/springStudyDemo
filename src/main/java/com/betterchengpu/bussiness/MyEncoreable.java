package com.betterchengpu.bussiness;

import com.betterchengpu.IImpl.Encoreable;
import org.springframework.stereotype.Component;

@Component
public class MyEncoreable implements Encoreable {

    @Override
    public void performEncore() {
        System.out.println("This is proxy method");
    }
}
