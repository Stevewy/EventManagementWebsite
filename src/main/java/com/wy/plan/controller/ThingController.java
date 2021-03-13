package com.wy.plan.controller;

import com.wy.plan.pojo.Thing;
import com.wy.plan.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author WangYao
 * @date 2021/3/2
 * @function
 */
@Controller
@RequestMapping("/thing")
public class ThingController {
    @Autowired
    ThingService thingService;

    @RequestMapping("/all")
    public String listAll(Model model){
        model.addAttribute("thingAll",thingService.getAllThing());
        return "thing/all";
    }

    @RequestMapping("/complete")
    public String listComplete(Model model){
        model.addAttribute("thingComplete",thingService.getAllComplishThing());
        return "thing/complete";
    }

    @RequestMapping("/undo")
    public String listUndo(Model model){
        model.addAttribute("thingUndo",thingService.getAllUndoneThing());
        return "thing/undo";
    }

    @RequestMapping("/add")
    public String add(){
        return "thing/add";
    }

    @RequestMapping("/addThing")
    public String addThing(String context, Integer level){
        thingService.addThing(context, level);
        return "thing/add";
    }

    @RequestMapping("/delete")
    public String delete(Model model){
        model.addAttribute("thingAll",thingService.getAllThing());
        return "thing/delete";
    }

    @RequestMapping("/deleteThing")
    public String deleteThing(String thingUID){
        thingService.deleteThing(thingUID);
        return "thing/delete";
    }

    @RequestMapping("/finish")
    public String finish(String thingUID){
        thingService.completeThing(thingUID);
        return "thing/all";
    }
}
