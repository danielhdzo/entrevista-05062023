package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {

	private Long numAccount;
	private Double amount;
	private String currency;

}
