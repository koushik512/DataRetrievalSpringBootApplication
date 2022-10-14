package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Details")
public class Details {


    @Id
    private Long detailsId;

    @NotNull
    private String name;

    @NotNull
    private String number;

    @NotNull
    private String city;

    @NotNull
    private String state;


}
