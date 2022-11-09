package com.example.onoffbrsiteparser.service;

import com.example.onoffbrsiteparser.entity.OnOffDaily;
import com.example.onoffbrsiteparser.repository.OnOffHourlyRepository;
import org.jsoup.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.File;

@Service
public class OnOffService {

    @Autowired
    OnOffJsoupLoaderService onOffJsoupLoaderService;

    @Autowired
    TempFileService tempFileService;

    @Autowired
    OnOffJAXBParserXMLtoJavaObject onOffJAXBParserXMLtoJavaObject;

    @Autowired
    OnOffHourlyRepository onOffHourlyRepository;

    public OnOffDaily getOnOffDaily(String date, int region) throws JAXBException {

        Connection.Response response = onOffJsoupLoaderService.loadXMLFromBrSite(date, region);
        File file = tempFileService.createTempFile(response);
        OnOffDaily onOffDaily = onOffJAXBParserXMLtoJavaObject.parse(file);


        return onOffDaily;
    }
}




