package com.example.onoffbrsiteparser;

//import com.example.onoffbrsiteparser.entity.OnOffDaily;

import com.example.onoffbrsiteparser.entity.OnOffHourly;
import com.example.onoffbrsiteparser.entity.Region;
import com.example.onoffbrsiteparser.service.OnOffLoaderService;
import com.example.onoffbrsiteparser.service.RegionLoaderService;
import com.example.onoffbrsiteparser.service.SaveToDBService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@SpringBootTest
public class JsoupParser {


    @Autowired
    OnOffLoaderService onOffLoaderService;
    @Autowired
    SaveToDBService saveToDBService;

    @Autowired
    RegionLoaderService regionLoaderService;

    @Test
    public void getXmlResponseFromWebsite() throws IOException, JAXBException {

        String date = "2022.01.10";
        int region = 36;


        List<OnOffHourly> onOffHourlyList = onOffLoaderService.loadOnOff();
        saveToDBService.save(onOffHourlyList);
        List<Region> regions = regionLoaderService.loadRegions();
        saveToDBService.saveRegion(regions);


    }
}
