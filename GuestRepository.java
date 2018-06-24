package com.example.demo;

import localhost._8080.webservice.Guest;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class GuestRepository {

    private static final Map<String, Guest> guests = new HashMap<>();

    @PostConstruct
    public void initData(){
        Guest joseph = new Guest();
        joseph.setName("Joseph");
        joseph.setPhoneNumber("0712345678");
        joseph.setEmail("joseph@gmail.com");
        joseph.setCheckIn("12/07/2018");
        joseph.setCheckOut("19/07/2018");

        guests.put(joseph.getName(), joseph);

        Guest jane = new Guest();
        joseph.setName("Jane");
        joseph.setPhoneNumber("0709876543");
        joseph.setEmail("jane@gmail.com");
        joseph.setCheckIn("12/08/2018");
        joseph.setCheckOut("19/08/2018");

        guests.put(jane.getName(), jane);

        Guest rose = new Guest();
        joseph.setName("Rose");
        joseph.setPhoneNumber("0745678909");
        joseph.setEmail("rose@gmail.com");
        joseph.setCheckIn("12/09/2018");
        joseph.setCheckOut("19/09/2018");

        guests.put(rose.getName(), rose);
    }

    public Guest findGuest(String name) {
        Assert.notNull(name, "The guest's name should be present");
        return guests.get(name);
    }

}
