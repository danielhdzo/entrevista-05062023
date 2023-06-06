package com.example.demo.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.dto.RespuestaTransfDto;
import com.example.demo.dto.TransferenciaDto;

public interface ITransferenciaService {

	ResponseEntity<RespuestaTransfDto> transferirFondos(TransferenciaDto datosTransferenciaDto);

}
