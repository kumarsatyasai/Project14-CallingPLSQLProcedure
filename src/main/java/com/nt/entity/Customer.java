package com.nt.entity;

import jakarta.persistence.Column;  
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "JPA_CUSTOMER")
public class Customer {
	
	@Id
	@Column(name = "CID")
	        
	// Gives Id values 1, 2, 52, 102, .... Default Generated is AUTO.
	//SEQUENCE, TABLE, IDENTITY.
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "gen1", sequenceName = "CNO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer cno;
	
	@NonNull   // required args constructor.
	@Column(name = "CNAME", length = 20)// default length is 255.
	private String name;
	
	@NonNull    // required args constructor.
	@Column(name = "CADD", length = 20)
	private String cadd;
	
	@NonNull     // required args constructor.
	@Column(name = "BILLAMT")
	private Float billAmt;
	
	

}
