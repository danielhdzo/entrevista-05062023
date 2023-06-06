package com.example.demo.repository;

import com.example.demo.model.Account;

public interface IAccountRepository {

	Account consultaFondos(Long numAccount);

	boolean agregaFondos(Long numAccount, Double amount);

	boolean retiraFondos(Long numAccount, Double amount);

}
