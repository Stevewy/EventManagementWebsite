package com.wy.plan.dao;

import com.wy.plan.pojo.RedisUtil;
import com.wy.plan.pojo.Thing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author WangYao
 * @date 2021/3/2
 * @function
 */

@Repository
public class ThingDao {
    @Autowired
    RedisUtil redisUtil;

    List<Thing> allThings = new ArrayList<>();

    public List<Thing> getAllThing(){
        if(allThings.isEmpty()) {
            List<Object> list = redisUtil.lRange("things", 0, -1);
            for(Object o : list)
                allThings.add((Thing) o);
        }
        return allThings;
    }

    public void addThing(Thing thing){
        allThings.add(thing);
        redisUtil.lRightPush("things",thing);
    }

    public void delThing(Thing thing){
        allThings.remove(thing);
        redisUtil.lRemove("things",0, thing);
    }

    public void changeThing(Thing thing, Thing newThing){
        int i = allThings.indexOf(thing);
        allThings.remove(i);
        allThings.add(i,newThing);
        redisUtil.lSet("things", i, newThing);
    }
}
