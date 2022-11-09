package com.example.onoffbrsiteparser.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
//@Entity
@XmlRootElement(name = "DocumentElement")
@XmlAccessorType(XmlAccessType.FIELD)
public class OnOffDaily {
    @Id
    private long id;

    @OneToMany
    @XmlElement(name = "row")
    private List<OnOffHourly> onOffHourlyList;

}
