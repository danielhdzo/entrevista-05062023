package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.RespuestaTransfDto;
import com.example.demo.dto.TransferenciaDto;
import com.example.demo.model.Account;
import com.example.demo.repository.IAccountRepository;
import com.example.demo.service.ITransferenciaService;

@Service
public class TransferenciaImpl implements ITransferenciaService {

	@Autowired
	private IAccountRepository repository;

	/**
	 * Ejecuta una transferencia de fondos entre dos cuentas.
	 * 
	 * Business Rules - Accounts can’t have negative balance 
	 * - If the origin account doesn´t have enough funds to make the transfer an INSUFFICIENT-FUNDS error 
	 * - The only currency supported at this moment is USD 
	 * - The origin account must be charge with a tax corresponding to 2 % in case the amount of the transfer
	 * is greater than 1000 USD or 1% otherwise.
	 */
	@Transactional
	public ResponseEntity<RespuestaTransfDto> transferirFondos(TransferenciaDto datosTransferenciaDto) {
		System.out.println("TransferenciaImpl.transferirFondos()");
		String[] errors = {};
		Double taxCollected = null;
		HttpStatus statusResp = HttpStatus.CREATED;
		RespuestaTransfDto respuestaTransfDto = new RespuestaTransfDto();

		Account ctaOrigen = repository.consultaFondos(datosTransferenciaDto.getOrigin_account());
		Account ctaDestino = repository.consultaFondos(datosTransferenciaDto.getDestination_account());

		// Calcula los impuestos
		if (datosTransferenciaDto.getAmount() >= 1000.00) {
			// Carga el 2%
			taxCollected = datosTransferenciaDto.getAmount() * 0.02;
		} else {
			// Carga el 1%
			taxCollected = datosTransferenciaDto.getAmount() * 0.01;
		}

		Double montoTotalTrns = datosTransferenciaDto.getAmount() + taxCollected;

		// Valida si las cuentas origen y destino existen.
		if ((ctaOrigen != null && ctaDestino != null)
				// Valida que la cuenta origen tenga fondos suficientes
				&& (ctaOrigen.getAmount() >= montoTotalTrns)) {
			// Retira el dinero de la cuenta origen (incluidos os impuestos)
			repository.retiraFondos(datosTransferenciaDto.getOrigin_account(), montoTotalTrns);
			// Deposita el dinero a la cuenta destino
			repository.agregaFondos(datosTransferenciaDto.getDestination_account(), datosTransferenciaDto.getAmount());
			
			respuestaTransfDto.setErrors(errors);
			respuestaTransfDto.setStatus("OK");
			respuestaTransfDto.setTaxCollected(taxCollected);
		} else {
			taxCollected = 0.0;
			errors = null;
			respuestaTransfDto = new RespuestaTransfDto();
			respuestaTransfDto.setErrors(errors);
			respuestaTransfDto.setStatus("ERROR");
			respuestaTransfDto.setTaxCollected(taxCollected);
			
			statusResp = HttpStatus.CONFLICT;
		}

		return ResponseEntity.status(statusResp).body(respuestaTransfDto);
	}

}
