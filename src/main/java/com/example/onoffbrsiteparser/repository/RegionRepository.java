package com.example.onoffbrsiteparser.repository;


import com.example.onoffbrsiteparser.entity.OnOffHourly;
import com.example.onoffbrsiteparser.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region,Long> {
}
