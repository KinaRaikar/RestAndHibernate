package com.kiran.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
@Getter
@Setter
public class Address {
    @Column (name="STATE")
    private String state;
    @Column (name="CITY")
    private String city;
    @Column (name="STREET")
    private String street;
    @Column (name="PIN_CODE")
    private String pinCode;
}