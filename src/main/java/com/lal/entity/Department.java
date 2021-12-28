package com.lal.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Department implements Serializable {


    private static final long serialVersionUID = 1295937018823493031L;

    private String id;

    private String name;

    private String tel;

}
