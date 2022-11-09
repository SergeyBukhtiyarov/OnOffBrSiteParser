package com.example.onoffbrsiteparser;

import com.example.onoffbrsiteparser.service.RegionLoaderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RegionParser {
    @Autowired
    RegionLoaderService regionLoaderService;

    @Test
    public void parse() {
        regionLoaderService.loadRegions();

    }
}
