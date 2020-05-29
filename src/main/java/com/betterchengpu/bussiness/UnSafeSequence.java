package com.betterchengpu.bussiness;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
public class UnSafeSequence {

    @GuardedBy("this")
    private int value;

    private AtomicInteger safeValue;

    public synchronized int getNext(){
        safeValue.incrementAndGet();
        return  value++;
    }
}
