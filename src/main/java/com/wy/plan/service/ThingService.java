package com.wy.plan.service;

import com.wy.plan.dao.ThingDao;
import com.wy.plan.pojo.Thing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author WangYao
 * @date 2021/3/2
 * @function
 */
@Service
public class ThingService {

    @Autowired
    ThingDao thingDao;

    public List<Thing> getAllThing(){
        return thingDao.getAllThing();
    }

    public List<Thing> getAllComplishThing(){
        List<Thing> list = new ArrayList<>();
        for(Thing i : thingDao.getAllThing()){
            if(i.getComplete())
                list.add(i);
        }
        return list;
    }

    public List<Thing> getAllUndoneThing(){
        List<Thing> list = new ArrayList<>();
        for(Thing i : thingDao.getAllThing()){
            if(!i.getComplete())
                list.add(i);
        }
        return list;
    }

    public void addThing(String context, Integer level){
        thingDao.addThing(new Thing(context,new Date(),level,false));
    }

    public void deleteThing(String thingUID){
        for(Thing thing : thingDao.getAllThing()){
            if(thing.getUid().equals(thingUID)){
                thingDao.delThing(thing);
                break;
            }
        }
    }

    public void completeThing(String thingUID){
        for(Thing thing : thingDao.getAllThing()){
            if(thing.getUid().equals(thingUID)){
                Thing newThing=thing.clone();
                newThing.setComplete(true);
                thingDao.changeThing(thing, newThing);
                break;
            }
        }
    }
}
