package com.example.onoffbrsiteparser.service;

import com.example.onoffbrsiteparser.entity.Region;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionLoaderService {

    public List<Region> loadRegions() {

        String url = "https://br.so-ups.ru/webapi/api/dict/GetDictionaries";
        ObjectMapper mapper = new ObjectMapper();

        WebClient webClient =WebClient.create(url);
        List<Region> regions = webClient.get()//получаем данные
                .retrieve() //обрабатываем ответ
                .bodyToMono(JsonNode.class)//переносим тело ответа на реактивные тип Mono
                .map(s->s.path("regions"))//разбираем дерево до узла regions
                .map(s-> {

                    try {
                        return mapper.readValue(s.traverse(), new TypeReference<List<Region>>() {}); //перебираем ключи и помещаем в лист
                    } catch (IOException e) {
                        e.printStackTrace();
                        return new ArrayList<Region>();
                        }
                    })
                .block();
        System.out.println(regions);
        return regions;
    };



    }



