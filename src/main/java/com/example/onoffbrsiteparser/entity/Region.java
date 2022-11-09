package com.example.onoffbrsiteparser.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Entity
@XmlRootElement(name = "id")
@XmlAccessorType(XmlAccessType.FIELD)
public class Region {
    @JsonAlias("$id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int m_Item1;
    private String m_Item2;
}
