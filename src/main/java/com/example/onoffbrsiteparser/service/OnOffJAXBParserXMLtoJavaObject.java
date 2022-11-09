package com.example.onoffbrsiteparser.service;

import com.example.onoffbrsiteparser.entity.OnOffDaily;
import com.example.onoffbrsiteparser.exceptions.OnOffDailyNotLoadedException;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Service
public class OnOffJAXBParserXMLtoJavaObject {
    OnOffDaily onOffDaily;

    public OnOffDaily parse(File file) throws JAXBException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(OnOffDaily.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            onOffDaily = (OnOffDaily) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            throw new OnOffDailyNotLoadedException("not found region or bad date");
        }

        return onOffDaily;
    }
}

