package com.example.practice_timezone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Time;
import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("/world-clock")
    public String getTimeByTimezone(ModelMap model, @RequestParam(name="city",required = false,defaultValue = "Asia/Ho_Chi_Minh")String city){
        //Lay ra thoi gian hien tai
        Date date = new Date() ;
        // Lay ra time zone hien tai
        TimeZone local = TimeZone.getDefault();
        // Lay ra time zone cua 1 thanh pho cu the
        TimeZone locale = TimeZone.getTimeZone(city);

        //Tinh thoi gian hien tai cua mot thanh pho cu the
        long localeTime = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        // Cai dat lai thoi gian cho bien date thanh thoi gian hien tai cua mot thanh pho cu the
        date.setTime(localeTime);
        //Chuyen du lieu va gui qua view
        model.addAttribute("city",city);
        model.addAttribute("date",date);
        return "index";
    }
}
