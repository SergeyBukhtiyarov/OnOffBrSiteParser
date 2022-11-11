package com.example.onoffbrsiteparser.service;

import com.example.onoffbrsiteparser.entity.OnOffHourly;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OnOffLoaderService {

    public List<OnOffHourly> loadOnOff() {
        String url = "https://br.so-ups.ru/webapi/api/CommonInfo/OnOffSubRfVSVGO?priceZone[]=36&startDate=2022.11.10";
        ObjectMapper mapper = new ObjectMapper();
        WebClient webClient = WebClient.create(url);

        List<OnOffHourly> list = webClient.get()
                .retrieve()

                .bodyToMono(JsonNode.class)
                .map(s -> s.path(0))
                .map(s -> s.path("m_Item2"))
                .map(s -> {

                    try {
                        return mapper.readValue(s.traverse(), new TypeReference<List<OnOffHourly>>() {
                        });
                    } catch (IOException e) {
                        e.printStackTrace();

                        return new ArrayList<OnOffHourly>();
                    }
                })
                .block();

        return list;


    }


}
