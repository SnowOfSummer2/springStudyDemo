package com.betterchengpu;

import com.betterchengpu.IImpl.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class CDPlayer {
    private CompactDisc player;

   // @Autowired
    public CDPlayer(CompactDisc player){
        this.player=player;
    }

    public void  cdPlay()
    {
     this.player.play();
    }
}
