package com.Producer.ProducerApp.domain;

import com.Producer.ProducerApp.DTOS.CustomerDTO;
import jakarta.persistence.*;

@Table(name = "customers")
@Entity(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String name;
    private String document;
    private Integer score;

    public Customer(){

    }

    public Customer(CustomerDTO data){

        this.name = data.name();
        this.document = data.document();
        this.score = data.score();

    }

    public Customer(Long id, String name, String document, Integer score) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
