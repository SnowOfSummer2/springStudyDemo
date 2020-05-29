package com.betterchengpu.bussiness;

import com.betterchengpu.IImpl.CompactDisc;
import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {
    private String title="Sgt. Peppers's Lonely Hearts Club Band";
    private String artist="The Beatles";

    @Override
    public void play() {
        System.out.println("Playing "+ title + " by "+ artist);
    }
}
