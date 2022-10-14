package com.example.demo.controller;

import com.example.demo.entity.Details;
import com.example.demo.service.DataRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class DataRetrievalController
{

    @Autowired
    DataRetrievalService dataRetrievalService;

    @GetMapping("/getDetails")
    public List<Details> getStocks()
    {
        return dataRetrievalService.getDetailsData();
    }
}
