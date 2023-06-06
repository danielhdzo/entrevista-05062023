package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RespuestaSaldosDto;
import com.example.demo.service.ICuentasService;

@RestController
@RequestMapping("api/v1/cuentas")
public class CuentasController {

	@Autowired
	private ICuentasService service;

	@GetMapping("/fondos/{numCuenta}")
	public ResponseEntity<RespuestaSaldosDto> consultaSaldo(@PathVariable Long numCuenta) {
		return service.consultaFondos(numCuenta);
	}

}
