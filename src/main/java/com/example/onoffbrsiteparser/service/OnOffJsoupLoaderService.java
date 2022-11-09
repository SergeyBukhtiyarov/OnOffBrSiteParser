package com.example.onoffbrsiteparser.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OnOffJsoupLoaderService {

    public Connection.Response loadXMLFromBrSite(String date, int region) {

        Connection.Response response;
        try {

            response = Jsoup
                    .connect("https://br.so-ups.ru/webapi/Public/Export/Xml/OnOffCount." +
                            "aspx?date=" + date + "&priceZonesIds=" + region + "&notCheckedColumnsNames=&zone=1&IsSubRf=true")
                    .method(Connection.Method.GET)
                    .ignoreContentType(true)
                    .execute();
//            System.out.println(response.body());
            return response;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
