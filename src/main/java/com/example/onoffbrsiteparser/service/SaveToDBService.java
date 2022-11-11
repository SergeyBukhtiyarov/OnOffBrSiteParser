package com.example.onoffbrsiteparser.service;

//import com.example.onoffbrsiteparser.entity.OnOffDaily;
import com.example.onoffbrsiteparser.entity.OnOffHourly;
import com.example.onoffbrsiteparser.entity.Region;
import com.example.onoffbrsiteparser.repository.OnOffHourlyRepository;
import com.example.onoffbrsiteparser.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveToDBService {
    @Autowired
    OnOffHourlyRepository onOffHourlyRepository;

    @Autowired
    RegionRepository regionRepository;



//    public void save(OnOffDaily onOffDaily) {
//        for (OnOffHourly onOffHourly: onOffDaily.getOnOffHourlyList()) {
//            onOffHourlyRepository.save(onOffHourly);
//        }
//    }

    public void save(List<OnOffHourly> onOffHourly) {
            onOffHourlyRepository.saveAll(onOffHourly);

    }

    public  void saveRegion(List<Region> regions){
        for (Region region: regions) {
            regionRepository.save(region);
        }
    }
}
