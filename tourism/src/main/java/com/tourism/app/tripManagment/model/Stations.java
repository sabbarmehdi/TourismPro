package com.tourism.app.tripManagment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;


}
