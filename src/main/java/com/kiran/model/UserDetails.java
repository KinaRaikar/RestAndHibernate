package com.kiran.model;

import javax.persistence.*;
import lombok.Setter;
import lombok.Getter;

@Entity
@Setter
@Getter
public class UserDetails {
	@Id
	private int id;

	private String name;
    
    @Embedded
    private Address address;
}
