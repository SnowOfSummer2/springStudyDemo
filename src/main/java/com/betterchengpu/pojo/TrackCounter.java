package com.betterchengpu.pojo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TrackCounter {

    /**
     * 计数
     */
    private Integer trackCount = 0;

    @Pointcut("execution(* com.betterchengpu.IImpl.CompactDisc.play())")
    public void play() {
    }

    @Before("play()")
    public void countTrack() {
        this.trackCount++;
    }

    public Integer getCounts() {
        return this.trackCount;
    }
}
