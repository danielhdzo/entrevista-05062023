package com.example.demo.repository.impl;

import org.springframework.stereotype.Component;

import com.example.demo.memdb.MemoryDB;
import com.example.demo.model.Account;
import com.example.demo.repository.IAccountRepository;

@Component
public class AccountRepositoryImpl implements IAccountRepository {

	@Override
	public Account consultaFondos(Long numAccount) {
		System.out.println("Consulta los Fondos de una Cuenta");
		return MemoryDB.mapDataAccount.get(numAccount);
	}

	@Override
	public boolean agregaFondos(Long numAccount, Double amount) {
		System.out.println("Agrega Fondos de una Cuenta");
		Account account = MemoryDB.mapDataAccount.get(numAccount);
		Double fondos = account.getAmount() + amount;
		account.setAmount(fondos);
		MemoryDB.mapDataAccount.put(numAccount, account);
		
		return false;
	}

	@Override
	public boolean retiraFondos(Long numAccount, Double amount) {
		System.out.println("Retira Fondos de una Cuenta");
		Account account = MemoryDB.mapDataAccount.get(numAccount);
		Double fondos = account.getAmount() - amount;
		
		// REGLA: No puede haber fondos negativos en la cuenta
		if (fondos < 0) {
			fondos = 0.0;
		}
		
		account.setAmount(fondos);
		MemoryDB.mapDataAccount.put(numAccount, account);

		return false;
	}

}
