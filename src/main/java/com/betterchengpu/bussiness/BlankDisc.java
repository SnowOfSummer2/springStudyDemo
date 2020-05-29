package com.betterchengpu.bussiness;

import com.betterchengpu.IImpl.CompactDisc;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlankDisc implements CompactDisc {

    /*
    标题
     */
    private String title;

    /*
       作者
     */
    private String artist;

    /*
      磁道列表
     */
    private List<String> tracks;

    public BlankDisc(){

    }

    public BlankDisc(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    @Override
    public void play() {
        System.out.println("playing " + title + " by " + artist);
        for (String track : this.tracks
                ) {
            System.out.println("-Tracks: " + track);
        }
    }
}
