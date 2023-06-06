package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RespuestaTransfDto;
import com.example.demo.dto.TransferenciaDto;
import com.example.demo.service.ITransferenciaService;

@RestController
@RequestMapping("api/v1/transferencia")
public class TranferenciasController {
	
	@Autowired
	private ITransferenciaService service;

	@PostMapping()
	public ResponseEntity<RespuestaTransfDto> tranferencia(@RequestBody TransferenciaDto datosTransferenciaDto) {
		return service.transferirFondos(datosTransferenciaDto);
	}

}
