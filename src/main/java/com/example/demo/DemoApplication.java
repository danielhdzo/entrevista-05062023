package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.memdb.MemoryDB;
import com.example.demo.model.Account;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		Account account1 = new Account(1111L, 511000.00, "USD");
		Account account2 = new Account(2222L, 50000.00, "USD");
		Account account3 = new Account(3333L, 100500.00, "USD");
		Account account4 = new Account(4444L, 9965500.00, "USD");

		MemoryDB.mapDataAccount.put(1111L, account1);
		MemoryDB.mapDataAccount.put(2222L, account2);
		MemoryDB.mapDataAccount.put(3333L, account3);
		MemoryDB.mapDataAccount.put(4444L, account4);

		SpringApplication.run(DemoApplication.class, args);
	}

}
