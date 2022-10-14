package com.example.demo.service;

import com.example.demo.dao.DataRetrievalDao;
import com.example.demo.entity.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataRetrievalService
{

    @Autowired
    DataRetrievalDao dataRetrievalDao;
    public List<Details> getDetailsData()
    {
        return dataRetrievalDao.getDetailsData();
    }
}
