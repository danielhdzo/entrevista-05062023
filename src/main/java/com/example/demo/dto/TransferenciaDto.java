package com.example.demo.dto;

import lombok.Data;

@Data
public class TransferenciaDto {

	private Double amount;
	private String currency;
	private Long origin_account;
	private Long destination_account;
	private String description;
	
}
