package com.betterchengpu.bussiness;


import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

@ThreadSafe
public class MonitorVehicleTracker {

    private final Map<String, MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) throws InterruptedException {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getLocations() throws InterruptedException {
        return deepCopy(this.locations);
    }

    public synchronized MutablePoint getLocation(String id) {
        MutablePoint loc = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }

    public synchronized void setLocations(String id, int x, int y) {
        MutablePoint loc = this.locations.get(id);
        if (loc == null) {
            throw new IllegalArgumentException("No such id: " + id);
        }

        loc.x = x;
        loc.y = y;
    }

    /**
     * 深拷贝，每个mutablePoint都是一个全新的引用
     *
     * @param map
     * @return
     */
    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> map) throws InterruptedException {
        Map<String, MutablePoint> result = new HashMap<String, MutablePoint>();
        for (String id : map.keySet()) {
            result.put(id, new MutablePoint(map.get(id)));
        }

        Thread.sleep(2000);
        return result;
    }
}
