package com.example.onoffbrsiteparser.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

// Класс Пуски и остановы по регионам. сайт СО -> ОРЭМ
//@Entity
@Data
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class OnOffHourly {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private long sub_rf_id;

    private String date;

    private String hour;

    private double on_count_all;              // Пуски всего, кол-во;

    private double on_value_all;              // Пуски всего, МВт;

    private double on_count_vsvgo;            // Пуски по оптимизации, кол-во;

    private double on_value_vsvgo;            // Пуски по оптимизации, МВт;

    private double on_count_vr;               // Пуски по уведомлениям, кол-во;

    private double on_value_vr;               // Пуски по уведомлениям, МВт;

    private double on_count_regime;           // Пуски режимные, кол-во;

    private double on_value_regime;           // Пуски режимные, МВт;

    private double off_count_all;             // Остановы всего, кол-во;

    private double off_value_all;             // Остановы всего, МВт;

    private double off_count_vsvgo;           // Остановы по оптимизации, кол-во;

    private double off_value_vsvgo;           // Остановы по оптимизации, МВт;

    private double off_count_vr;              // Остановы по уведомлениям, кол-во;

    private double off_value_vr;              // Остановы по уведомлениям, МВт;

    private double off_count_regime;          // Остановы режимные, кол-во;

    private double off_value_regime;          // Остановы режимные, МВт;


}
