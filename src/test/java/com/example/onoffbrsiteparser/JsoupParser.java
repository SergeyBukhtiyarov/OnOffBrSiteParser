package com.example.onoffbrsiteparser;

import com.example.onoffbrsiteparser.entity.OnOffDaily;
import com.example.onoffbrsiteparser.entity.Region;
import com.example.onoffbrsiteparser.service.*;
import org.jsoup.Connection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.List;

@SpringBootTest
public class JsoupParser {


    @Autowired
    OnOffJsoupLoaderService onOffLoaderService;
    @Autowired
    TempFileService tempFileService;

    @Autowired
    OnOffJAXBParserXMLtoJavaObject onOffJAXBParserXMLtoJavaObject;

    @Autowired
    SaveToDBService saveToDBService;

    @Autowired
    RegionLoaderService regionLoaderService;

    @Test
    public void getXmlResponseFromWebsite() throws IOException, JAXBException {

        String date = "2022.01.10";
        int region = 36;

        Connection.Response response = onOffLoaderService.loadXMLFromBrSite(date, region);
        File file = tempFileService.createTempFile(response);
        OnOffDaily onOffDaily = onOffJAXBParserXMLtoJavaObject.parse(file);
        saveToDBService.save(onOffDaily);
        List<Region> regions = regionLoaderService.loadRegions();
        saveToDBService.saveRegion(regions);


    }
}
