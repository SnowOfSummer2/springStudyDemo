package com.betterchengpu.Util;

import com.betterchengpu.Util.impl.Predicate;

import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayList<E> extends ArrayList <E> {
    public void filter( Predicate <E> instance) {
        Iterator <E> ite = this.iterator();
        while (ite.hasNext()) {
            if (!instance.filt(ite.next())) {
                ite.remove();
            }
        }

    }
}
