package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.RespuestaSaldosDto;
import com.example.demo.model.Account;
import com.example.demo.repository.IAccountRepository;
import com.example.demo.service.ICuentasService;

@Service
public class CuentasImpl implements ICuentasService {

	@Autowired
	private IAccountRepository repository;

	@Override
	@Transactional
	public ResponseEntity<RespuestaSaldosDto> consultaFondos(Long numCuenta) {
		System.out.println("CuentasImpl.consultaFondos()");
		String[] errors = {};

		Account cta = repository.consultaFondos(numCuenta);

		RespuestaSaldosDto respuestaSaldosDto = new RespuestaSaldosDto();
		respuestaSaldosDto.setErrors(errors);
		respuestaSaldosDto.setStatus("OK");
		respuestaSaldosDto.setAccount_balance(cta.getAmount());

		
		return ResponseEntity.status(HttpStatus.OK).body(respuestaSaldosDto);
	}

}
