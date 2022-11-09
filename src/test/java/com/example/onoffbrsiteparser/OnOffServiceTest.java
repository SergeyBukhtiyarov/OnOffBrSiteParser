package com.example.onoffbrsiteparser;

import com.example.onoffbrsiteparser.entity.OnOffDaily;
import com.example.onoffbrsiteparser.repository.OnOffHourlyRepository;
import com.example.onoffbrsiteparser.service.OnOffService;
import com.example.onoffbrsiteparser.service.SaveToDBService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.JAXBException;

@SpringBootTest
public class OnOffServiceTest {
    @Autowired
    OnOffService onOffService;

    @Autowired
    SaveToDBService saveToDBService;



    @Test
    public void getOnOffDaily() throws JAXBException {
        String date = "2022.01.10";
        int region = 36;

        OnOffDaily onOffDaily=onOffService.getOnOffDaily(date, region);
        System.out.println(onOffDaily);
        saveToDBService.save(onOffDaily);


    }
}
