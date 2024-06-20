package com.nit.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
@Component
@Entity
@Data
@ConfigurationProperties(prefix = "hospital.patient")
public class Patient {

	@Id
	@SequenceGenerator(name = "gen",allocationSize = 1,initialValue = 1001)
	@GeneratedValue(generator = "gen",strategy = GenerationType.SEQUENCE )
	@Column(name="PID",length = 5)
	private Integer pId;
	@Column(name="P_NAME",length = 30)
	private String pName;
	@Column(name="PROBLEM",length = 30)
	private String problem;
	@Column(name = "BILL_AMT")
	private Double billAmt;
	@Column(name = "PHNO")
	private Long phno;
}
