package com.example.demo.dto;

import lombok.Data;

@Data
public class RespuestaSaldosDto {

	private String status;
	private String[] errors;
	private Double account_balance;

}
