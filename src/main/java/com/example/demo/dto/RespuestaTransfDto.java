package com.example.demo.dto;

import lombok.Data;

@Data
public class RespuestaTransfDto {

	private String status;
	private String[] errors;
	private Double taxCollected;

}
