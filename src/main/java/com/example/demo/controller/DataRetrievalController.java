package com.example.demo.controller;

import com.example.demo.entity.Details;
import com.example.demo.service.DataRetrievalService;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;

@RestController
@RequestMapping("/data")
public class DataRetrievalController
{

    @Autowired
    DataRetrievalService dataRetrievalService;

    @GetMapping("/getDetails/")
    public List<Details> getStocks()
    {
        return dataRetrievalService.getDetailsData();
    }

    @GetMapping("/getTableData")
    public JSONArray getDataFromAnyTable(@RequestParam("tableName") String tableName)
    {
        return dataRetrievalService.retriveDataFromTable(tableName);
    }
}
