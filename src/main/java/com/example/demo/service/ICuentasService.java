package com.example.demo.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.dto.RespuestaSaldosDto;

public interface ICuentasService {

	ResponseEntity<RespuestaSaldosDto> consultaFondos(Long numCuenta);

}
