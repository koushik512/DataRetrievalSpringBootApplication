package com.example.demo.service;

import com.example.demo.dao.DataRetrievalDao;
import com.example.demo.entity.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.util.List;
@Service
public class DataRetrievalService
{

    @Autowired
    DataRetrievalDao dataRetrievalDao;

    static final String DB_URL = "jdbc:mysql://localhost/poc";
    static final String USER = "root";
    static final String PASS = "Root@1234";
    static final String QUERY = "SELECT * FROM ";
    public List<Details> getDetailsData()
    {
        return dataRetrievalDao.getDetailsData();
    }

    public JSONArray retriveDataFromTable(String tableName)
    {
        JSONArray jSONArray =  initializeDatabaseAndExecuteQuery(tableName);
        return jSONArray;
    }

    private JSONArray initializeDatabaseAndExecuteQuery(String tableName) {

        try {
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection established......");
            //Creating the Statement
            Statement stmt = con.createStatement();
            //Retrieving the records
            ResultSet rs = stmt.executeQuery(QUERY+tableName);
//            System.out.println("==>"+rs.getMetaData());
//            System.out.println("==>"+rs.getMetaData().getColumnCount());

            JSONArray array = new JSONArray();
            while(rs.next()) {
                JSONObject record = new JSONObject();
                //Inserting key-value pairs into the json object
                record.put(tableName+"_id", rs.getInt(tableName+"_id"));
                for(int i = 1; i < rs.getMetaData().getColumnCount()+1; i++)
                {
                    record.put(rs.getMetaData().getColumnName(i), rs.getString(rs.getMetaData().getColumnName(i)));
                }
                array.add(record);
            }
            System.out.print("Array-->"+ array);
            return array;
        }
        catch(Exception e){
            System.out.println("Could not able to connect to db" + e.getMessage());
        }
        return null;
    }
}
