package com.kiran.model;

import javax.persistence.*;
import lombok.Setter;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class UserDetails {
	@Id
	private int id;

	private String name;
    
    //@Embedded
    //private Address address;

    @ElementCollection()
    @JoinTable(name = "user_address")
    private Set<Address> addresses = new HashSet<>();
}
