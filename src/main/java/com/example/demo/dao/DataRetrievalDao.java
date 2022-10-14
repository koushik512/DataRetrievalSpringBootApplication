package com.example.demo.dao;

import com.example.demo.entity.Details;
import com.example.demo.repository.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataRetrievalDao 
{

    @Autowired
    DetailsRepository repo;


    public List<Details> getDetailsData() {
        return repo.findAll();
    }
}
