package com.example.onoffbrsiteparser.repository;


import com.example.onoffbrsiteparser.entity.OnOffHourly;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnOffHourlyRepository extends JpaRepository<OnOffHourly,Long> {
}
